package test.ChainOfResponsibility.optimize; 

import ChainOfResponsibility.basic.FeeRequest;
import ChainOfResponsibility.optimize.DepManager;
import ChainOfResponsibility.optimize.GeneralManager;
import ChainOfResponsibility.optimize.Handler;
import ChainOfResponsibility.optimize.ProjectManager;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Handler Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 26, 2018</pre> 
* @version 1.0 
*/ 
public class HandlerTest {
    Handler h1;
    Handler h2;
    Handler h3;

@Before
public void before() throws Exception {
    h1 = new GeneralManager();
    h2 = new DepManager();
    h3 = new ProjectManager();
    h3.setSuccessor(h2);
    h2.setSuccessor(h1);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setSuccessor(Handler successor) 
* 
*/ 
@Test
public void testSetSuccessor() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: handleFeeRequest(String user, double fee) 
* 
*/ 
@Test
public void testHandleFeeRequest() throws Exception { 
//TODO: Test goes here...
    String ret1 = h3.handleFeeRequest("小李", 300);
    System.out.println("the ret =" + ret1);

    String ret2 = h3.handleFeeRequest("小李", 800);
    System.out.println("the ret =" + ret2);

    String ret3 = h3.handleFeeRequest("小李", 1200);
    System.out.println("the ret =" + ret3);
} 


} 
