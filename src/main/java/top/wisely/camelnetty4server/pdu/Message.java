package top.wisely.camelnetty4server.pdu;

import lombok.Data;

@Data
public class Message {
    private MessageHeader messageHeader; // 消息头
    private MessageBody messageBody; // 消息体

    public Message(MessageHeader messageHeader){
        this.messageHeader = messageHeader;
    }

    public Message(MessageHeader messageHeader, MessageBody messageBody){
        this.messageHeader = messageHeader;
        this.messageBody = messageBody;
    }
}

