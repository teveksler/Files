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
 * Unit test for the <code>PurchaseOrderController</code> controller.
 *
 * @see axi.source.web.PurchaseOrderController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class PurchaseOrderControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editPurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPurchaseOrderClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPurchaseOrderClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPurchaseOrderClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPurchaseOrderInventories()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPurchaseOrderInventories() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPurchaseOrderInventories");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexPurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexPurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePurchaseOrder()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePurchaseOrder() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePurchaseOrder");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>purchaseorderControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetpurchaseorderControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/purchaseorderController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PurchaseOrderController controller = (PurchaseOrderController) context.getBean("PurchaseOrderController");

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