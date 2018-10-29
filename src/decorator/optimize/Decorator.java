package decorator.optimize;

import java.util.Date;

/**
 * 装饰类的接口, 需要和被装饰的对象实现同样的接口
 */
public abstract class Decorator extends Component{
    protected Component c;

    public Decorator(Component c) {
        this.c = c;
    }

    public double calcPrize(String user, Date begin, Date end) {
        return c.calcPrize(user, begin, end);
    }
}
