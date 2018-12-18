package top.wisely.netty4server.protocol;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.Getter;
import lombok.Setter;
import top.wisely.netty4server.util.ChecksumUtils;
import top.wisely.netty4server.util.EscapeUtils;

import java.nio.ByteBuffer;

@Getter
@Setter
public abstract class NovaCommand {
    public static final short BEGIN = 0XAA;

    public static final short END = 0xCC;

    public static final short ESCAPE= 0XEE;

    //起始符
    private short begin = BEGIN;

    //设备地址
    private int address;

    //指令码
    private short opCode;

    //结束符
    private short end = END;

    //crc校验
    private int crc;

    public abstract byte[] getData();


    public void write(ByteBuf out){
        writeBegin(out);
        byte[] escapedBytes = writeBody(out);
        writeEnd(out);
        writeCheck(out , escapedBytes);

    }

    public void writeBegin(ByteBuf out){
        out.writeByte(this.getBegin());

    }
    public  byte[] writeBody(ByteBuf out){
        byte[] addressBytes = ByteBuffer.allocate(2).putInt(this.getAddress()).array();
        byte[] opCodeBytes = ByteBuffer.allocate(1).putInt(this.getOpCode()).array();
        byte[] dataBytes = this.getData();

        ByteBuffer tobeEscapeBytes = ByteBuffer.wrap(addressBytes).put(opCodeBytes).put(dataBytes);
        byte[] escapedBytes = EscapeUtils.escape(tobeEscapeBytes.array());
        out.writeBytes(escapedBytes);
        return escapedBytes;

    }

    public void writeEnd(ByteBuf out){
        out.writeByte(this.getEnd());
    }
    public  void writeCheck(ByteBuf out , byte[] escapedBytes){
        byte[] beginBytes = Unpooled.buffer(1).writeByte(this.getBegin()).array();
        byte[] endBytes = Unpooled.buffer(1).writeByte(this.getEnd()).array();
        out.writeShortLE(this.calcCRC(beginBytes,escapedBytes,endBytes));

    }


    private int calcCRC(byte[] begin , byte[] escapse , byte[] end){
        return ChecksumUtils.calcCRC(ByteBuffer.wrap(begin).put(escapse).put(end).array());
    }

}
