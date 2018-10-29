package test.decorator.optimize;

import decorator.optimize.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Component Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 29, 2018</pre>
 */
public class ComponentTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: calcPrize(String user, Date begin, Date end)
     */
    @Test
    public void testCalcPrize() throws Exception {
//TODO: Test goes here...

        //先创建计算基本奖金的类, 这也是被装饰的对象
        Component c1 = new ConcreteComponent();

        //然后对计算的基本奖金进行装饰, 这里要组合各个装饰说明, 各个装饰之间最好不要有先后顺序的限制

        Decorator d1 = new MonthPrizeDecorator(c1);
        Decorator d2 = new SumPrizeDecorator(d1);

        double zs = d2.calcPrize("张三", null, null);
        System.out.println("=======张三应得奖金: " + zs );

        double ls = d2.calcPrize("李四", null, null);
        System.out.println("=======李四应得奖金: " + ls );

        //如果是业务经理, 还需要一个计算团队的奖金计算
        Decorator d3 = new GroupPrizeDecorator(d2);
        double ww = d3.calcPrize("王五", null, null);
        System.out.println("=======王五应得奖金: " + ww );
    }


} 
