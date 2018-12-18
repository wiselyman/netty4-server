package top.wisely.netty4server.pdu.reports;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import top.wisely.netty4server.pdu.MessageBody;

@Data
@Slf4j
public class HeartBeat extends MessageBody {

    private String novaCode;

    public HeartBeat(ByteBuf byteBuf) {
        byte[] novaCodeBytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(novaCodeBytes);
        this.setNovaCode(new String(novaCodeBytes));
        log.info("-------------" + this.novaCode);

    }

}
