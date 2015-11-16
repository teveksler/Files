package axi.source.web.rest;

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
 * Unit test for the <code>WorkOrderRestController</code> controller.
 *
 * @see axi.source.web.rest.WorkOrderRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class WorkOrderRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkOrderworkorder_workOrderIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkOrderworkorder_workOrderIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdclientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkOrderworkorder_workOrderIdclientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdclientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderIdclientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdemployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderIdemployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/employees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdemployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkOrderworkorder_workOrderIdemployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/employees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdemployees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkOrderworkorder_workOrderIdemployees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/employees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdemployeesemployee_employeeId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkOrderworkorder_workOrderIdemployeesemployee_employeeId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/employees/{employee_employeeId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdemployeesemployee_employeeId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderIdemployeesemployee_employeeId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/employees/{employee_employeeId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkOrderworkorder_workOrderIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkOrderworkorder_workOrderIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdinventoriesinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkOrderworkorder_workOrderIdinventoriesinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/inventories/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderIdinventoriesinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderIdinventoriesinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}/inventories/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetWorkOrderworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostWorkOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>WorkOrderworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteWorkOrderworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/WorkOrder/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		WorkOrderRestController controller = (WorkOrderRestController) context.getBean("WorkOrderRestController");

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