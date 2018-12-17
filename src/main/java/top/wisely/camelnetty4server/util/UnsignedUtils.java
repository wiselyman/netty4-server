package top.wisely.camelnetty4server.util;

public class UnsignedUtils {
    /**
     *  java byte (1 byte == 8 bit) (-2^7~2^7-1 : -128~127) to unsigned short(0~2^8-1 : 0~255))
     * @param data
     * @return
     */
    public static int getUnsignedByte (byte data){
        return data&0x0FF;
    }


    /**
     * 将data字节型数据转换为0~65535 (0xFFFF 即 WORD)
     * @param data
     * @return
     */
    public static int getUnsignedByte (short data){
        return data&0x0FFFF;
    }

    /**
     * 将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
     * @param data
     * @return
     */
    public static long getUnsignedInt(int data){
        return data&0x0FFFFFFFFl;
    }
}
