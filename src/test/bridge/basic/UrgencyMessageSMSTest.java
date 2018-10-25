package test.bridge.basic;

import bridge.basic.Message;
import bridge.basic.UrgencyMessageSMS;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UrgencyMessageSMS Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 25, 2018</pre>
 */
public class UrgencyMessageSMSTest {
    Message message = new UrgencyMessageSMS();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: watch(String messageId)
     */
    @Test
    public void testWatch() throws Exception {
//TODO: Test goes here... 
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
