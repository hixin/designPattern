package ChainOfResponsibility.optimize;

public class GeneralManager extends Handler{
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee >= 1000) {
            if ("小李".equals(user)) {
                str = "总经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                str = "总经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }

        } else {
            // 如果diazo后继的处理对象, 继续传递
            if (this.successor != null) {
                return successor.handleFeeRequest(user, fee);
            }
        }

        return str;
    }

}
