## 背景

发送提示消息的功能:
- 消息分类:  普通消息, 加急消息, 特急消息
- 处理方式不同
- 发送方式不同: 邮件, 系统内短消息, 手机短消息

```
public interface Message {

    /**  发送消息
     * @param message   要发送的消息内容
     * @param toUser    消息发送的目的人员
     */
    public void send(String message, String toUser);
}

/**
 * 以站内消息的方式发送普通消息
 */
public class CommonMessageSMS implements Message{
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内短消息的方式, 发送消息 message: " +message + "给" + toUser );
    }
}

/**
 * 以站内消息的方式发送普通消息
 */
public class CommonMessageSMS implements Message{
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内短消息的方式, 发送消息 message: " +message + "给" + toUser );
    }
}

---

public interface UrgencyMessage  extends Message{


    /**
     * @param messageId  被监控消息的编号
     * @return  包含监控到的数据对象
     */
    public Object watch(String messageId);
}

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

```

## 问题

- 每增加一种消息, 必须实现两种处理方式
- 每增加一种新的消息发送方式, 需要各个消息去实现
- 如果m代表消息种类, n代表消息发送方式, 则需要定义的类为 m*n, 虽然不用修改已有代码, 但新增的类很多

## 问题根因
消息的抽象和实现混杂在一起(具体的消息继承抽象消息时,却实现了发送方式),导致一个纬度的变化会引起另一个纬度的变化


## 解决方案

桥接模式:  
> 将抽象部分与它的实现部分分离, 使它们都可以独立的变化


本例 
- 抽象部分: 各个消息类型所对应的功能
- 实现部分: 各种发送消息的方式


## 实现方式

```
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


/**
 * 实现部分的接口
 */
public interface MessageImplementor {
    /**  发送消息
     * @param message   要发送的消息内容
     * @param toUser    消息发送的目的人员
     */
    public void send(String message, String toUser);
}


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


/**
 * 以手机短消息的方式发送消息
 */
public class MessageMobile  implements MessageImplementor{
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用手机短消息的方式, 发送消息 message: " +message + "给" + toUser );
    }
}
```

## 测试
```
MessageImplementor implementor = new MessageMobile();
AbstractMessage abstractMessage1 = new CommonMessage(implementor);
AbstractMessage abstractMessage2 = new SpecialUrgencyMessage(implementor);
abstractMessage1.sendMessage("请喝一杯茶","小李");
abstractMessage2.sendMessage("请喝一杯茶","小李");
}
```

## 效果

- 每增加一种消息, 只需要继承抽象部分定义的接口AbstractMessage
- 每增加一种实现方式, 只需要继承实现部分
- 
- 类的数量变成m+n
## 总结

本质: **分离抽象和实现**  

- 桥接模式中的桥接是单向的, 只能是抽象部分的对象去使用具体实现部分的对象, 不能反过来
- 谁是抽象消息和具体发送消息之间的桥? 
---

抽象部分持有的实现部分的接口对象, 抽象部分通过这个桥就可以调用到实现部分的功能啦