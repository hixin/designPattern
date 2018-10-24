package visitor.test.optimize;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import visitor.optimize.*;

/**
 * Customer Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 24, 2018</pre>
 */
public class CustomerTest {
    Customer customer;

    @Before
    public void before() throws Exception {
        customer = new PersonalCustomer();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: accept(Visitor visitor)
     */
    @Test
    public void testAccept() throws Exception {
//TODO: Test goes here...
        Visitor visitor1 = new WorthAnalyzeVisitor();
        Visitor visitor2 = new ServiceRequestVisitor();
        customer.accept(visitor1);
        customer.accept(visitor2);
    }


} 
