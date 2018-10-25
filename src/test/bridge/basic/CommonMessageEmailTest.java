package test.bridge.basic;

import bridge.basic.CommonMessageEmail;
import bridge.basic.Message;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * CommonMessageEmail Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 25, 2018</pre>
 */
public class CommonMessageEmailTest {
    Message message = new CommonMessageEmail();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: send(String message, String toUser)
     */
    @Test
    public void testSend() throws Exception {
//TODO: Test goes here...
        message.send("hello", "Bob");
    }


} 
