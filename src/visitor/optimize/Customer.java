package visitor.optimize;

public abstract class Customer {
    private String customeId;
    private String name;

    public abstract void accept(Visitor visitor);

}
