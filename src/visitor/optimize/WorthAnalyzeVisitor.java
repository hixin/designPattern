package visitor.optimize;

public class WorthAnalyzeVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        System.out.println("现在对企业客户进行价值分析");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        System.out.println("现在对个人客户进行价值分析");
    }
}

