## 背景
简单的奖金计算体系
 * 每个人的当月业务奖金 = 当月销售额 * 3%
 * 每个人的累计奖金 = 总的回款额 * 0.1%
 * 团队奖金 = 团队总销售额 * 1%
 
```
public class Prize {
    public static Map<String, Double> mapMonthSaleMoney = new HashMap<String, Double>();
    static {
        mapMonthSaleMoney.put("张三", 10000.0);
        mapMonthSaleMoney.put("李四", 20000.0);
        mapMonthSaleMoney.put("王五", 30000.0);
    }

    public double calcPrize(String user, Date begin, Date end) {
        double prize = 0.0;
        // 计算当月业务奖金
        prize = monthPrize(user, begin, end);

        // 计算累计奖金
        prize += sumPrize(user, begin, end);

        if (isManager(user)) {
            prize += groupPrize(user, begin, end);
        }

        return prize;
    }

    private double monthPrize(String user, Date begin, Date end) {
        double prize = mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金" + prize);
        return prize;
    }

    public double sumPrize(String user, Date begin, Date end) {
        double prize = 100000 * 0.001;
        System.out.println(user+"累计奖金"+prize);
        return prize;
    }

    private boolean isManager(String user)
    {
        if("王五".equals(user)) {
            return true;
        }

        return false;
    }


    public double groupPrize(String user, Date begin, Date end) {
        double group = 0.0;
        for(double d : mapMonthSaleMoney.values()) {
            group  += d;
        }

        double prize = group * 0.01;
        System.out.println(user + "当月团队业务奖金" + prize);
        return prize;
    }
}


测试:

 = p.calcPrize("张三", null, null);
    System.out.println("=======张三应得奖金: " + zs );

    double ls = p.calcPrize("李四", null, null);
    System.out.println("=======李四应得奖金: " + ls );

    double ww = p.calcPrize("王五", null, null);
    System.out.println("=======王五应得奖金: " + ww );
```

问题:
>实习逻辑很简单, 每种奖金作为一个方法, 形参传入一个人, 实现不同的人计算方式不同.

- 奖金的计算方式经常发生变化

## 问题抽象

设计一个计算奖金的对象,需要能够灵活的给它增加和减少功能, 还需要能够动态的组合功能.


## 装饰者模式
- 定义抽象类,实现与被装饰对象相同的接口
- 在具体实现类中,转调被装饰的对象, 在转调的前后添加新的功能, 从而实现给被装饰对象增加功能


被装饰对象接口:
```
/**
 * 组件对象的接口, 可以给这些对象动态地添加职责
 */
public abstract class Component {

    public abstract double calcPrize(String user, Date begin, Date end);
}

具体化被装饰对象
public class ConcreteComponent extends  Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return 0;
    }
}
```

装饰器抽象类:
```
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
```

装饰器的具体实现对象, 基本上一条计算规则,对应一个装饰对象

```
public class MonthPrizeDecorator extends Decorator {
    public MonthPrizeDecorator(Component c) {
        super(c);
    }


    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double prize = Prize.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金" + prize);
        return money + prize;
    }
}


public class SumPrizeDecorator extends Decorator {
    public SumPrizeDecorator(Component c) {
        super(c);
    }


    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);

        double  prize = 1000000 * 0.001;
        System.out.println(user+"累计奖金" + prize);
        return money + prize;
    }
}


public class GroupPrizeDecorator extends Decorator {
    public GroupPrizeDecorator(Component c) {
        super(c);
    }

    public double calcPrize(String user, Date  begin, Date end) {
        //1: 先获取前面运算出来的奖金
        double money = super.calcPrize(user, begin, end);

        double group = 0.0;
        for (double d : Prize.mapMonthSaleMoney.values()) {
            group += d;
        }

        double prize = group * 0.01;
        System.out.println(user+ "当月团队业务奖"+prize);
        return money + prize;
    }
}

```

使用:
```
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
```

依次调用装饰器, 是一个递归调用的过程,  直至调到最后的裸妆对象ConcreteComponent


## 引申
AOP: 面向方面编程
实现主从换位,原本主动调用的功能模块,变成了被动等待, 甚至在毫不知情的情况下被织入很多新功能

装饰模式也能做到给原始业务透明地增加新功能

- 继承原始业务的接口, 定义出抽象类装饰器
- 创建业务对象时, 组合装饰器

最终的业务对象功能扩充了, 类似一个功能丰富的子类, 但并没有发生继承

## 本质 
动态组合

- 基于对象组合,而不是对象继承的方式来扩展和复用功能



