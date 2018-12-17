package top.wisely.camelnetty4server;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.netty.tcp.TcpServer;
import top.wisely.camelnetty4server.codec.NovaDecoder;
import top.wisely.camelnetty4server.codec.NovaEncoder;
import top.wisely.camelnetty4server.handler.NovaHandler;

@SpringBootApplication
public class CamelNetty4ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelNetty4ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner novaServerRunner(NovaDecoder decoder, NovaEncoder encoder){

		return p -> {
			TcpServer.create()
					.host("0.0.0.0").handle((in,out) -> {
						in.receive()
							.asByteArray()
							.subscribe();
						return Flux.never();

					})
					.doOnConnection(c -> c.addHandler("delimiter", new DelimiterBasedFrameDecoder(4096, Unpooled.copiedBuffer(Unpooled.buffer(1).writeByte(0xCC).array())))
							.addHandler("encoder" , new NovaEncoder())
							.addHandler("decoder" , new NovaDecoder())
							.addHandler("nova",new NovaHandler())
					)
					.port(9999).bindNow();
		};
	}



}

