package top.wisely.netty4server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.wisely.netty4server.constant.OpCodeResponse;
import top.wisely.netty4server.pdu.Message;
import top.wisely.netty4server.pdu.MessageBody;
import top.wisely.netty4server.pdu.MessageHeader;
import top.wisely.netty4server.pdu.reports.HeartBeat;
import top.wisely.netty4server.pdu.reports.QueryStatus;
import top.wisely.netty4server.pdu.reports.ScreenShot;
import top.wisely.netty4server.util.EscapeUtils;

import java.util.List;

@Component
@ChannelHandler.Sharable
@Slf4j
public class NovaDecoder extends MessageToMessageDecoder<ByteBuf> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        ByteBuf buffer = ctx.alloc().buffer();
        EscapeUtils.unescape(in, buffer);
        MessageHeader messageHeader = new MessageHeader(buffer);
        MessageBody messageBody = new MessageBody();
        switch (messageHeader.getOpCode()) {
            case OpCodeResponse.HEARTBEAT_RESP:
                messageBody = new HeartBeat(buffer);
                break;

            case OpCodeResponse.QUERY_DEVICE_STATUS_RESP:
                messageBody = new QueryStatus(buffer);
                break;

            case OpCodeResponse.SCREENSHOT_RESP:
                messageBody = new ScreenShot(buffer);
                break;

            case OpCodeResponse.FILE_NAME_SEND_RESP:
                break;

            case OpCodeResponse.FILE_CONTENT_SEND_RESP:
                break;
        }
       out.add(new Message(messageHeader, messageBody));

    }


}
