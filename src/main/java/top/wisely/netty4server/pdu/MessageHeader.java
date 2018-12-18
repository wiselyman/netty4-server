package top.wisely.netty4server.pdu;

import io.netty.buffer.ByteBuf;
import lombok.Data;

@Data
public class MessageHeader {

    private byte startChar;

    private int address;

    private short opCode;


    public MessageHeader(){}

    public MessageHeader(ByteBuf byteBuf){
//        byteBuf.readShort(); // 因为使用了0XCC的分隔符，下一个包会带上上一个包的校验码，下一个包需要丢弃上一个包2个字节的校验码
        this.startChar = byteBuf.readByte();
        this.address = byteBuf.readShort();
        this.opCode = byteBuf.readByte();
    }
    //aa bb bb 00 70 6c 75 74 6f 63 6c 69 65 6e 74 cc dd dd aa bb bb 00 70 6c 75 74 6f 63 6c 69 65 6e 74 cc dd dd
}
