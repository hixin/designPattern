package test.bridge.optimize;

import bridge.optimize.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * AbstractMessage Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 25, 2018</pre>
 */
public class AbstractMessageTest {
    MessageImplementor implementor;
    AbstractMessage abstractMessage1;
    AbstractMessage abstractMessage2;

    @Before
    public void before() throws Exception {
        implementor = new MessageMobile();
        abstractMessage1 = new CommonMessage(implementor);
        abstractMessage2 = new SpecialUrgencyMessage(implementor);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sendMessage(String message, String toUser)
     */
    @Test
    public void testSendMessage() throws Exception {
//TODO: Test goes here...
        abstractMessage1.sendMessage("请喝一杯茶","小李");
        abstractMessage2.sendMessage("请喝一杯茶","小李");
    }

} 
