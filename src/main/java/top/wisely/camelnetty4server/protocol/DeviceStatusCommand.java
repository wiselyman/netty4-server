package top.wisely.camelnetty4server.protocol;

import io.netty.buffer.Unpooled;

public class DeviceStatusCommand extends NovaCommand {
    public DeviceStatusCommand() {
        super();
        this.setOpCode((byte)0X00);
    }


    @Override
    public byte[] getData() {
        return Unpooled.EMPTY_BUFFER.array();
    }
}
