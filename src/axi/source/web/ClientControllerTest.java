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
 * Unit test for the <code>ClientController</code> controller.
 *
 * @see axi.source.web.ClientController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class ClientControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientWorkOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientWorkOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientWorkOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientPurchaseOrders()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientPurchaseOrders() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientPurchaseOrders");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientQuotes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientQuotes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientQuotes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>clientControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetclientControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/clientController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

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