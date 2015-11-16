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
 * Unit test for the <code>ClientRestController</code> controller.
 *
 * @see axi.source.web.rest.ClientRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class ClientRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Clientclient_clientIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostClientclient_clientIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdworkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutClientclient_clientIdworkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/workOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdworkOrdersworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteClientclient_clientIdworkOrdersworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/workOrders/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdworkOrdersworkorder_workOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdworkOrdersworkorder_workOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/workOrders/{workorder_workOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostClientclient_clientIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdinventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutClientclient_clientIdinventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/inventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdinventoriesinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteClientclient_clientIdinventoriesinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/inventories/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdinventoriesinventory_inventoryId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdinventoriesinventory_inventoryId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/inventories/{inventory_inventoryId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdpurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdpurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/purchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdpurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostClientclient_clientIdpurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/purchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdpurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutClientclient_clientIdpurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/purchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdpurchaseOrderspurchaseorder_purchaseOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteClientclient_clientIdpurchaseOrderspurchaseorder_purchaseOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/purchaseOrders/{purchaseorder_purchaseOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdpurchaseOrderspurchaseorder_purchaseOrderId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdpurchaseOrderspurchaseorder_purchaseOrderId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/purchaseOrders/{purchaseorder_purchaseOrderId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdquotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdquotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/quotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdquotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostClientclient_clientIdquotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/quotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdquotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutClientclient_clientIdquotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/quotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdquotesquote_quoteId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteClientclient_clientIdquotesquote_quoteId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/quotes/{quote_quoteId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientIdquotesquote_quoteId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientIdquotesquote_quoteId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}/quotes/{quote_quoteId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Client()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetClientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Client()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Client()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Clientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteClientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientRestController controller = (ClientRestController) context.getBean("ClientRestController");

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