package top.wisely.camelnetty4server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.stereotype.Component;
import top.wisely.camelnetty4server.protocol.NovaCommand;



@Component
public class NovaEncoder extends MessageToByteEncoder<NovaCommand> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, NovaCommand cmd, ByteBuf out) throws Exception {
        cmd.write(out);
    }







}
