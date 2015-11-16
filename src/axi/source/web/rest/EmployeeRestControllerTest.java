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
 * Unit test for the <code>EmployeeRestController</code> controller.
 *
 * @see axi.source.web.rest.EmployeeRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class EmployeeRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Employeeemployee_employeeIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetEmployeeemployee_employeeIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employeeemployee_employeeIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostEmployeeemployee_employeeIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employeeemployee_employeeIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutEmployeeemployee_employeeIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employeeemployee_employeeIdworkOrdersworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteEmployeeemployee_employeeIdworkOrdersworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}/workOrders/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employeeemployee_employeeIdworkOrdersworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetEmployeeemployee_employeeIdworkOrdersworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}/workOrders/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employeeemployee_employeeId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetEmployeeemployee_employeeId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Employeeemployee_employeeId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteEmployeeemployee_employeeId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Employee/{employee_employeeId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeRestController controller = (EmployeeRestController) context.getBean("EmployeeRestController");

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