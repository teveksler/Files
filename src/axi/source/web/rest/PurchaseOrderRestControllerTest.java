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
 * Unit test for the <code>PurchaseOrderRestController</code> controller.
 *
 * @see axi.source.web.rest.PurchaseOrderRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class PurchaseOrderRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdclients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPurchaseOrderpurchaseorder_purchaseOrderIdclients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdclients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPurchaseOrderpurchaseorder_purchaseOrderIdclients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdclients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPurchaseOrderpurchaseorder_purchaseOrderIdclients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdclientsclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePurchaseOrderpurchaseorder_purchaseOrderIdclientsclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdclientsclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPurchaseOrderpurchaseorder_purchaseOrderIdclientsclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPurchaseOrderpurchaseorder_purchaseOrderIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPurchaseOrderpurchaseorder_purchaseOrderIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPurchaseOrderpurchaseorder_purchaseOrderIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdinventoriesinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePurchaseOrderpurchaseorder_purchaseOrderIdinventoriesinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderIdinventoriesinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPurchaseOrderpurchaseorder_purchaseOrderIdinventoriesinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetPurchaseOrderpurchaseorder_purchaseOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>PurchaseOrderpurchaseorder_purchaseOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeletePurchaseOrderpurchaseorder_purchaseOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/PurchaseOrder/{purchaseorder_purchaseOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderRestController controller = (PurchaseOrderRestController) context.getBean("PurchaseOrderRestController");

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