package visitor.optimize;

public class PersonalCustomer extends Customer {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPersonalCustomer(this);
    }
}