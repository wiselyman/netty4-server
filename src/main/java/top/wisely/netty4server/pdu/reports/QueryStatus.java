package top.wisely.netty4server.pdu.reports;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wisely.netty4server.pdu.MessageBody;

@Data
@NoArgsConstructor
public class QueryStatus extends MessageBody {
    private int year;

    private int month;

    private int date;

    private int hour;

    private int minute;

    private int second;

    private int gateStatus;

    private int screenPower;

    private int openCloseScreenStatus;

    private int temperatureSymbol;

    private int temperature;

    private int bright;

    private int brightCtrl;

    private int brightLevel;

    public QueryStatus(ByteBuf buf) {
        this.year = buf.readUnsignedShortLE();
        this.month = buf.readUnsignedByte();
        this.date = buf.readUnsignedByte();
        this.hour = buf.readUnsignedByte();
        this.minute = buf.readUnsignedByte();
        this.second = buf.readUnsignedByte();
        this.gateStatus = buf.readUnsignedByte();
        this.screenPower = buf.readUnsignedByte();
        this.openCloseScreenStatus = buf.readUnsignedByte();
        this.temperatureSymbol = buf.readUnsignedByte();
        this.temperature = buf.readUnsignedByte();
        buf.readUnsignedMediumLE();
        this.bright = buf.readUnsignedByte();
        this.brightCtrl = buf.readUnsignedByte();
        this.brightLevel = buf.readUnsignedByte();
    }


}
