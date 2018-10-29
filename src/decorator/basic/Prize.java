package decorator.basic;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 每个人的当月业务奖金 = 当月销售额 * 3%
 * 每个人的累计奖金 = 总的回款额 * 0.1%
 * 团队奖金 = 团队总销售额 * 1%
 */
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
