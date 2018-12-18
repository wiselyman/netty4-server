package top.wisely.netty4server.util;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;

public class ChannelUtil {

    public static Map<String, ChannelHandlerContext> channelHashBiMap = new HashMap();

    public static ChannelHandlerContext getCtx(String deviceId){
        return channelHashBiMap.get(deviceId);
    }

}
