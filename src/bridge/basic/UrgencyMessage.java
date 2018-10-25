package bridge.basic;

public interface UrgencyMessage  extends Message{


    /**
     * @param messageId  被监控消息的编号
     * @return  包含监控到的数据对象
     */
    public Object watch(String messageId);
}
