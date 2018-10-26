## 背景
申请聚餐费用问题, 通常的思路就是根据申请费用的多少, 让不同的领导来进行处理就可以实现了.
```
package ChainOfResponsibility.basic;

public class FeeRequest {

    public String requestToProjectManager(String user, double fee) {
        String str = "";
        if (fee < 500) {
            // 项目经理的权限比较小, 只能在500 以内
            str = this.projectHandle(user, fee);
        } else if (fee < 1000) {
            //部门经理的权限只能在10000内
            str = this.depManagerHandle(user, fee);
        } else if (fee >= 1000) {
            //总经理的权限很大, 只要请求到了这里, 他都可以处理
            str = this.generalManagerHandle(user, fee);
        }
        return str;
    }


    /**
     * 项目经理审批费用申请
     * @param user
     * @param fee
     * @return
     */
    private String projectHandle(String user, double fee) {
        String str = "";
        if ("小李".equals(user)) {
            str = "项目经理同意" + user + "聚餐费用" + fee + "元的请求";
        } else {
            str = "项目经理不同意" + user + "聚餐费用" + fee + "元的请求";
        }

        return str;
    }


    /**
     * 部门经理审批费用申请
     * @param user
     * @param fee
     * @return
     */
    private String depManagerHandle(String user, double fee) {
        String str = "";
        if ("小李".equals(user)) {
            str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
        } else {
            str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
        }

        return str;
    }


    /**
     * 总经理审批费用申请
     * @param user
     * @param fee
     * @return
     */
    private String generalManagerHandle(String user, double fee) {
        String str = "";
        if ("小李".equals(user)) {
            str = "总经理同意" + user + "聚餐费用" + fee + "元的请求";
        } else {
            str = "总经理不同意" + user + "聚餐费用" + fee + "元的请求";
        }

        return str;
    }
}


使用:
FeeRequest request = new FeeRequest();
String ret1 = request.requestToProjectManager("小李", 300);
System.out.println("the ret =" + ret1);
String ret2 = request.requestToProjectManager("小李", 800);
System.out.println("the ret =" + ret2);
String ret3 = request.requestToProjectManager("小李", 1200);
System.out.println("the ret =" + ret3);
```

## 存在问题
- 聚餐申请费用的处理流程可能是变动的
- 各个环节的处理业务也可能是变动的
- 不论有何变动, 基本上 


## 问题抽象

客户端发出一个请求, 会有很多对象都可以来处理这个请求, 而且不同对象的处理逻辑是不一样的, 对客户端而言, 无所谓谁来处理, 反正有对象处理就可以啦

## 解决方案
使用责任链模式, 使多个对象都有机会处理请求, 从而避免请求的发送者
和接受者之间的耦合关系, 将这些对象连成一条链, 并沿着这条链传递该请求, 指导有一个对象处理它为止

## 实现步骤
- 定义职责的抽象类
```
/**
 * 职责对象的接口, 所有职责的外观
 */
public abstract class Handler {

    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;


    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract String handleFeeRequest(String user, double fee);
}
```
- 实现各自的职责, 一个职责对象实现一个环节的处理功能
```
public class ProjectManager extends Handler{
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee < 500) {
            if ("小李".equals(user)) {
                str = "项目经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                str = "项目经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }

        } else {
            // 超过500, 继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleFeeRequest(user, fee);
            }
        }

        return str;
    }
}
-----
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

```

使用:
```
Handler h1 = new GeneralManager();
Handler h2 = new DepManager();
Handler h3 = new ProjectManager();
h3.setSuccessor(h2);
h2.setSuccessor(h1);

String ret1 = h3.handleFeeRequest("小李", 300);
System.out.println("the ret =" + ret1);

String ret2 = h3.handleFeeRequest("小李", 800);
System.out.println("the ret =" + ret2);

String ret3 = h3.handleFeeRequest("小李", 1200);
System.out.println("the ret =" + ret3);
```

## 本质
分离职责, 动态组合
请求对象和处理对象的解耦

## 待思考

Handler中如果增加新的业务功能要如何处理?

JAVA编程很强调面向接口编程, 如果新增一种业务, 就去修改接口, 很显然这绝对不是个好方法

简单做法:
- 定义通用的请求对象, 封装请求传递的参数
-  定义通用的调用方法, 不区分具体业务, 通用的请求对象会有一个业务的标记
-  新业务下放到具体的职责对象中实现