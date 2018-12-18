package top.wisely.netty4server.protocol;

import io.netty.buffer.Unpooled;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HeartBeatCommand extends NovaCommand  {
    private int time;

    public HeartBeatCommand(int time) {
        super();
        this.setOpCode((byte)0X00);
    }

    @Override
    public byte[] getData() {
        return Unpooled.buffer(4).writeIntLE((int) (new Date().getTime() / 1000)).array();
    }
}
