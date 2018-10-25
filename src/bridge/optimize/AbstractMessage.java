package bridge.optimize;

/**
 * 抽象部分定义的接口
 */
public abstract class AbstractMessage {

    /**
     * 持有一个实现部分的对象
     */
    protected MessageImplementor impl;

    /**
     * 构造方法, 传入实现部分的对象
     * @param impl
     */
    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }


    /**
     * 发送消息, 转调实习部分的方法
     * @param message
     * @param toUser
     */
    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }
}
