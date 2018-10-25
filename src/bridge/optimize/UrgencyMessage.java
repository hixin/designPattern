package bridge.optimize;

public class UrgencyMessage  extends AbstractMessage{
    /**
     * 构造方法, 传入实现部分的对象
     *
     * @param impl
     */
    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急: " + message;
        super.sendMessage(message, toUser);
    }


    /**
     * 拓展自己的新功能: 监控某消息的处理过程
     * @param messageId
     * @return
     */
    public Object watch(String messageId) {
        return null;
    }
}
