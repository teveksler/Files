package axi.source.web;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Unit test for the <code>WorkOrderController</code> controller.
 *
 * @see axi.source.web.WorkOrderController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class WorkOrderControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkOrderClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkOrderClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkOrderClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkOrderEmployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkOrderEmployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkOrderEmployees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listWorkOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistWorkOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listWorkOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteWorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteWorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>workorderControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetworkorderControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/workorderController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderController controller = (WorkOrderController) context.getBean("WorkOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Returns a mock HttpServletRequest object.
	 *
	 */
	private MockHttpServletRequest getMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
		return request;
	}

	/**
	 * Returns a mock HttpServletResponse object.
	 *
	 */
	private MockHttpServletResponse getMockHttpServletResponse() {
		return new MockHttpServletResponse();
	}
}