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
 * Unit test for the <code>InventoryRestController</code> controller.
 *
 * @see axi.source.web.rest.InventoryRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class InventoryRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Inventoryinventory_inventoryIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostInventoryinventory_inventoryIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutInventoryinventory_inventoryIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdclientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteInventoryinventory_inventoryIdclientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdclientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryIdclientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdpurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryIdpurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/purchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdpurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostInventoryinventory_inventoryIdpurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/purchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdpurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutInventoryinventory_inventoryIdpurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/purchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdpurchaseOrderspurchaseorder_purchaseOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteInventoryinventory_inventoryIdpurchaseOrderspurchaseorder_purchaseOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/purchaseOrders/{purchaseorder_purchaseOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdpurchaseOrderspurchaseorder_purchaseOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryIdpurchaseOrderspurchaseorder_purchaseOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/purchaseOrders/{purchaseorder_purchaseOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostInventoryinventory_inventoryIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutInventoryinventory_inventoryIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdworkOrdersworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteInventoryinventory_inventoryIdworkOrdersworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/workOrders/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryIdworkOrdersworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryIdworkOrdersworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}/workOrders/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetInventoryinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostInventory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Inventoryinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteInventoryinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Inventory/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InventoryRestController controller = (InventoryRestController) context.getBean("InventoryRestController");

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