package bridge.optimize;

/**
 * 特急消息
 */
public class SpecialUrgencyMessage extends AbstractMessage{
    /**
     * 构造方法, 传入实现部分的对象
     *
     * @param impl
     */
    public SpecialUrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    public  void hurry(String messageId) {
        //TODO  执行催促的业务, 发出催促的消息
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急: " + message;
        super.sendMessage(message, toUser);
    }
}
