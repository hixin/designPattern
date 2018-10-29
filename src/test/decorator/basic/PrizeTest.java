package test.decorator.basic; 

import decorator.basic.Prize;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Prize Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 29, 2018</pre> 
* @version 1.0 
*/ 
public class PrizeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: calcPrize(String user, Date begin, Date end) 
* 
*/ 
@Test
public void testCalcPrize() throws Exception { 
//TODO: Test goes here...
    Prize p = new Prize();
    double zs = p.calcPrize("张三", null, null);
    System.out.println("=======张三应得奖金: " + zs );

    double ls = p.calcPrize("李四", null, null);
    System.out.println("=======李四应得奖金: " + ls );

    double ww = p.calcPrize("王五", null, null);
    System.out.println("=======王五应得奖金: " + ww );
}

/** 
* 
* Method: sumPrize(String user, Date begin, Date end) 
* 
*/ 
@Test
public void testSumPrize() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: groupPrize(String user, Date begin, Date end) 
* 
*/ 
@Test
public void testGroupPrize() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: monthPrize(String user, Date begin, Date end) 
* 
*/ 
@Test
public void testMonthPrize() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Prize.getClass().getMethod("monthPrize", String.class, Date.class, Date.class); 
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
* Method: isManager(String user) 
* 
*/ 
@Test
public void testIsManager() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Prize.getClass().getMethod("isManager", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
