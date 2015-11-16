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
 * Unit test for the <code>InventoryController</code> controller.
 *
 * @see axi.source.web.InventoryController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class InventoryControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInventoryClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInventoryClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInventoryClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInventoryPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInventoryPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInventoryPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInventoryWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInventoryWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInventoryWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>inventoryControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetinventoryControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/inventoryController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryController controller = (InventoryController) context.getBean("InventoryController");

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