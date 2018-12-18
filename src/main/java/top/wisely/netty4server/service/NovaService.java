package top.wisely.netty4server.service;

import io.netty.channel.ChannelHandlerContext;
import top.wisely.netty4server.protocol.DeviceStatusCommand;
import top.wisely.netty4server.protocol.NovaCommand;
import top.wisely.netty4server.util.ChannelUtil;

public class NovaService {

    public void sendQueryDeviceStatusCmd(String deviceId) {
        ChannelHandlerContext ctx = ChannelUtil.getCtx(deviceId);
        NovaCommand protocol = new DeviceStatusCommand();
        ctx.writeAndFlush(protocol);
    }

}
