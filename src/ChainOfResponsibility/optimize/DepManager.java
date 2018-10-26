package ChainOfResponsibility.optimize;

public class DepManager extends Handler{
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee < 1000) {
            if ("小李".equals(user)) {
                str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }

        } else {
            // 超过100, 继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleFeeRequest(user, fee);
            }
        }

        return str;
    }
}
