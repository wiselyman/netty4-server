package top.wisely.netty4server.util;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import org.apache.commons.lang3.ArrayUtils;
import top.wisely.netty4server.protocol.NovaCommand;

import java.util.ArrayList;
import java.util.List;

public class EscapeUtils {
    public static byte[] escape(byte[] data){
        List<Byte> escapedByteCollection = new ArrayList<>();
        for(byte oneByte : data){
            if(UnsignedUtils.getUnsignedByte(oneByte) == NovaCommand.BEGIN){
                escapeBegin(escapedByteCollection);
            } else if(UnsignedUtils.getUnsignedByte(oneByte) == NovaCommand.END){
                escapeEnd(escapedByteCollection);
            } else if(UnsignedUtils.getUnsignedByte(oneByte) == NovaCommand.ESCAPE){
                escapeEscape(escapedByteCollection);
            } else {
                escapedByteCollection.add(oneByte);
            }
        }
        return escapeBytes(escapedByteCollection);

    }
    private static void escapeBegin(List<Byte> escapedByteCollection){
        escapedByteCollection.add((byte) 0XEE);
        escapedByteCollection.add((byte) 0X0A);
    }
    private static void escapeEnd(List<Byte> escapedByteCollection){
        escapedByteCollection.add((byte) 0XEE);
        escapedByteCollection.add((byte) 0X0C);
    }
    private static void escapeEscape(List<Byte> escapedByteCollection){
        escapedByteCollection.add((byte) 0XEE);
        escapedByteCollection.add((byte) 0X0C);
    }
    private static byte[] escapeBytes(List<Byte> escapedByteCollection){
        Byte[] bytes = escapedByteCollection.toArray(new Byte[escapedByteCollection.size()]);
        return ArrayUtils.toPrimitive(bytes);
    }


    public static void unescape(ByteBuf in, ByteBuf out){
        // 构造还原转义字符之后的ByteBuf对象
        in.forEachByte(new ByteProcessor() {
            byte lastValue = 0;
            @Override
            public boolean process(byte value) throws Exception {
                // 0x7d+0x01转换为0x7d,0x7d+0x02转换为0x7e
                if (lastValue == 0xEE) {
                    if (value == 0x0A) {
                        out.writeByte(0xAA);
                    } else if (value == 0x0C) {
                        out.writeByte(0xCC);
                    } else if (value == 0X0E){
                        out.writeByte(0xEE);
                    } else {
                        out.writeByte(lastValue);
                        if(value != 0xEE) {
                            out.writeByte(value);
                        }
                    }
                } else {
                    if (value != 0xEE) {
                        out.writeByte(value);
                    }
                }
                lastValue = value;
                return true;
            }
        });
    }
}

