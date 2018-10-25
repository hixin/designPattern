package bridge.basic;

public class UrgencyMessageEmail implements UrgencyMessage{
    @Override
    public Object watch(String messageId) {
        return null;
    }

    @Override
    public void send(String message, String toUser) {
        message = "加急: " + message;
        System.out.println("使用Email的方式发送消息 message: " +message + "给" + toUser );
    }
}
