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
 * Unit test for the <code>EmployeeController</code> controller.
 *
 * @see axi.source.web.EmployeeController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class EmployeeControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listEmployeeWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistEmployeeWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listEmployeeWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteEmployee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteEmployee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteEmployee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>employeeControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetemployeeControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/employeeController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		EmployeeController controller = (EmployeeController) context.getBean("EmployeeController");

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