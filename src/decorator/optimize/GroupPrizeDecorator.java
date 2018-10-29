package decorator.optimize;

import decorator.basic.Prize;

import java.util.Date;

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
