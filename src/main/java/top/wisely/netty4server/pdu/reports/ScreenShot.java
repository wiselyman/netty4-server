package top.wisely.netty4server.pdu.reports;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wisely.netty4server.pdu.MessageBody;

@NoArgsConstructor
@Data
public class ScreenShot extends MessageBody {
    private byte[] screenBytes;

    public ScreenShot(ByteBuf byteBuf) {
        byteBuf.readShort();
        byte[] readBytes = new byte[byteBuf.readableBytes() - 3];
        byteBuf.readBytes(readBytes);
        this.setScreenBytes(readBytes);
    }
}
