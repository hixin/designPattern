package visitor.optimize;
public class ServiceRequestVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        System.out.println("企业提出服务请求");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        System.out.println("个人提出服务请求");
    }
}
