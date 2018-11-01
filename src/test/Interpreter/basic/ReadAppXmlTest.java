package test.Interpreter.basic; 

import Interpreter.basic.ReadAppXml;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ReadAppXml Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 1, 2018</pre> 
* @version 1.0 
*/ 
public class ReadAppXmlTest {
    ReadAppXml readAppXml;

@Before
public void before() throws Exception {
    readAppXml = new ReadAppXml();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: read(String filePathName) 
* 
*/ 
@Test
public void testRead() throws Exception { 
//TODO: Test goes here...
    readAppXml.read("/home/sain/code/personal/java/designPattern/designPattern1/src/Interpreter/spring.xml");
} 


} 
