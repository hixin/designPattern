package ChainOfResponsibility.optimize;

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
