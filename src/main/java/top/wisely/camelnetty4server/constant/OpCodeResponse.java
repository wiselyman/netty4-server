package top.wisely.camelnetty4server.constant;

public class OpCodeResponse {
    public static final byte HEARTBEAT_RESP = (byte)0X00;
    public static final byte QUERY_DEVICE_STATUS = (byte)0X01;
    public static final byte QUERY_DEVICE_STATUS_RESP = (byte)0X02;
    public static final byte TEST_CONTROL = (byte)0X03;
    public static final byte TEST_CONTROL_RESP = (byte)0X04;
    public static final byte OPEN_CLOSE_SCREEN = (byte)0X05;
    public static final byte OPEN_CLOSE_SCREEN_RESP = (byte)0X06;
    public static final byte BRIGHT_CONTROL = (byte)0X07;
    public static final byte DATE_SET = (byte)0X09;
    public static final byte REBOOT = (byte)0X0D;
    public static final byte REBOOT_RESP = (byte)0X0E;
    public static final byte FILE_NAME_SEND = (byte)0X11;
    public static final byte FILE_NAME_SEND_RESP = (byte)0X12;
    public static final byte FILE_CONTENT_SEND = (byte)0X13;
    public static final byte FILE_CONTENT_SEND_RESP = (byte)0XF9;
    public static final byte ENVIRONMENT_SET = (byte)0X15;
    public static final byte BRIGHT_PARAM_CONTROL = (byte)0X17;
    public static final byte BASIC_PARAM_SET = (byte)0X19;
    public static final byte UPDATE_SCREEN_CONTENT = (byte)0X1B;
    public static final byte RESTORE_INIT = (byte)0X21;
    public static final byte VERSION_QUERY = (byte)0X23;
    public static final byte VERSION_QUERY_RESP = (byte)0X24;
    public static final byte BASIC_PARAM_QUERY = (byte)0X27;
    public static final byte ENVIRONMENT_QUERY = (byte)0X29;
    public static final byte BRIGHT_QUERY = (byte)0X2B;
    public static final byte CURRENT_PLAY_QUERY = (byte)0X2D;
    public static final byte TEMP_THRESHOLD = (byte)0XF5;
    public static final byte AUTH = (byte)0X70;
    public static final byte FILE_CLEAR = (byte)0X7C;
    public static final byte CTR_CARD_NAME = (byte)0X7E;
    public static final byte TIMER_OPEN_CLOSE_SCREEN = (byte)0X84;
    public static final byte SCREENSHOT = (byte)0X80;
    public static final byte SCREENSHOT_RESP = (byte)0X81;
    public static final byte PART_UPDATE = (byte)0X88;
    public static final byte PART_UPDATE_RESP = (byte)0X89;

}
