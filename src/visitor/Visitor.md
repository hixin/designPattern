## 背景

```
public abstract class Customer {
    private String customeId;
    private String name;
    
    public abstract void serviceRequest();

}


public class EnterpriseCustomer extends Customer{
    @Override
    public void serviceRequest() {
        System.out.println(this.getClass().getName() + "企业提出服务请求");
    }
}


public class PersonalCustomer extends Customer {
    @Override
    public void serviceRequest() {
        System.out.println(this.getClass().getSimpleName()+ "个人客户提出服务请求");
    }
}
```

问题:  
增加新的功能要同时修改子类父类,比较麻烦,**==有没有办法"再不改变已有类的情况下, 就为已有类添加新的功能"?==**
## 访问者模式

### 结构

两个类层次:  
- 对应元素类层次
- 访问者的类层次

### 实现方式
- 先定义访问者接口
- 然后把每种业务实现为一个访问者的对象

```
public interface Visitor {

    public void visitEnterpriseCustomer(EnterpriseCustomer ec);

    public void visitPersonalCustomer(PersonalCustomer pc);
}

public abstract class Customer {
    private String customeId;
    private String name;
    
    public abstract void accept(Visitor visitor);

}


public class PersonalCustomer extends Customer {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPersonalCustomer(this);
    }
}
```

## 用法

在访问者模式中, 要给对象结构增加新的功能,只需要把新的功能实现为访问者,调用的时候使用这个访问者对象来访问对象结构
```
 Visitor visitor1 = new WorthAnalyzeVisitor();
        Visitor visitor2 = new ServiceRequestVisitor();
        customer.accept(visitor1);
        customer.accept(visitor2);
```