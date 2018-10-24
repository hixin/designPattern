package visitor.basic;

public class EnterpriseCustomer extends Customer{
    @Override
    public void serviceRequest() {
        System.out.println(this.getClass().getSimpleName() + " 企业提出服务请求");
    }
}
