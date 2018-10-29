package decorator.optimize;

import java.util.Date;

/**
 * 组件对象的接口, 可以给这些对象动态地添加职责
 */
public abstract class Component {

    public abstract double calcPrize(String user, Date begin, Date end);
}
