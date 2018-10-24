package visitor.basic;

public class PersonalCustomer extends Customer {

    @Override
    public void serviceRequest() {
        System.out.println(this.getClass().getSimpleName() + " 个人客户提出服务请求");
    }
}