package bridge.optimize;

/**
 * 普通消息的实现
 */
public class CommonMessage extends AbstractMessage{
    /**
     * 构造方法, 传入实现部分的对象
     *
     * @param impl
     */
    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        //对于普通消息, 什么都不干, 直接调用父类的方法把消息发送出去
        super.sendMessage(message, toUser);
    }
}
