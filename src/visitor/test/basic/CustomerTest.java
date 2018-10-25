package visitor.test.basic;

import visitor.basic.Customer;
import visitor.basic.PersonalCustomer;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
     * Method: serviceRequest()
     */
    @Test
    public void testServiceRequest() throws Exception {
//TODO: Test goes here...
        customer.serviceRequest();
    }

} 
