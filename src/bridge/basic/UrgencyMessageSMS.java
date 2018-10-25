package bridge.basic;

public class UrgencyMessageSMS implements UrgencyMessage{
    @Override
    public Object watch(String messageId) {
        return null;
    }

    @Override
    public void send(String message, String toUser) {
        message = "加急: " + message;
        System.out.println("使用站内短消息的方式, 发送消息 message: " +message + "给" + toUser );
    }
}
