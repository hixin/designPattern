package bridge.optimize;

public class MessageEmail implements MessageImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用Email的方式发送消息 message: " +message + "给" + toUser );
    }
}
