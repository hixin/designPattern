package test.ChainOfResponsibility.basic; 

import ChainOfResponsibility.basic.FeeRequest;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* FeeRequest Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 26, 2018</pre> 
* @version 1.0 
*/ 
public class FeeRequestTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: requestToProjectManager(String user, double fee) 
* 
*/ 
@Test
public void testRequestToProjectManager() throws Exception { 
//TODO: Test goes here...

    FeeRequest request = new FeeRequest();
    String ret1 = request.requestToProjectManager("小李", 300);
    System.out.println("the ret =" + ret1);
    String ret2 = request.requestToProjectManager("小李", 800);
    System.out.println("the ret =" + ret2);
    String ret3 = request.requestToProjectManager("小李", 1200);
    System.out.println("the ret =" + ret3);

} 


/** 
* 
* Method: projectHandle(String user, double fee) 
* 
*/ 
@Test
public void testProjectHandle() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FeeRequest.getClass().getMethod("projectHandle", String.class, double.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: depManagerHandle(String user, double fee) 
* 
*/ 
@Test
public void testDepManagerHandle() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FeeRequest.getClass().getMethod("depManagerHandle", String.class, double.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: generalManagerHandle(String user, double fee) 
* 
*/ 
@Test
public void testGeneralManagerHandle() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FeeRequest.getClass().getMethod("generalManagerHandle", String.class, double.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
