package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
@Transactional
public class PurchaseOrderServiceTest {

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected PurchaseOrderService service;

	/**
	 * Instantiates a new PurchaseOrderServiceTest.
	 *
	 */
	public PurchaseOrderServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Inventory entity
	 * 
	 */
	@Test
	public void deletePurchaseOrderInventories() {
		// TODO: JUnit - Populate test inputs for operation: deletePurchaseOrderInventories 
		Integer purchaseorder_purchaseOrderId = 0;
		Integer related_inventories_inventoryId = 0;
		service.deletePurchaseOrderInventories(purchaseorder_purchaseOrderId, related_inventories_inventoryId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void savePurchaseOrder() {
		// TODO: JUnit - Populate test inputs for operation: savePurchaseOrder 
		PurchaseOrder purchaseorder = new axi.source.domain.PurchaseOrder();
		service.savePurchaseOrder(purchaseorder);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all PurchaseOrder entity
	 * 
	 */
	@Test
	public void countPurchaseOrders() {
		service.countPurchaseOrders();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Client entity
	 * 
	 */
	@Test
	public void deletePurchaseOrderClients() {
		// TODO: JUnit - Populate test inputs for operation: deletePurchaseOrderClients 
		Integer purchaseorder_purchaseOrderId_1 = 0;
		Integer related_clients_clientId = 0;
		service.deletePurchaseOrderClients(purchaseorder_purchaseOrderId_1, related_clients_clientId);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findPurchaseOrderByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findPurchaseOrderByPrimaryKey 
		Integer purchaseOrderId = 0;
		service.findPurchaseOrderByPrimaryKey(purchaseOrderId);
	}

	/**
	 * Operation Unit Test
	 * Load an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void loadPurchaseOrders() {
		service.loadPurchaseOrders();
	}

	/**
	 * Operation Unit Test
	 * Return all PurchaseOrder entity
	 * 
	 */
	@Test
	public void findAllPurchaseOrders() {
		// TODO: JUnit - Populate test inputs for operation: findAllPurchaseOrders 
		Integer startResult = 0;
		Integer maxRows = 0;
		service.findAllPurchaseOrders(startResult, maxRows);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void deletePurchaseOrder() {
		// TODO: JUnit - Populate test inputs for operation: deletePurchaseOrder 
		PurchaseOrder purchaseorder_1 = new axi.source.domain.PurchaseOrder();
		service.deletePurchaseOrder(purchaseorder_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Inventory entity
	 * 
	 */
	@Test
	public void savePurchaseOrderInventories() {
		// TODO: JUnit - Populate test inputs for operation: savePurchaseOrderInventories 
		Integer purchaseOrderId_1 = 0;
		Inventory related_inventories = new axi.source.domain.Inventory();
		service.savePurchaseOrderInventories(purchaseOrderId_1, related_inventories);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Client entity
	 * 
	 */
	@Test
	public void savePurchaseOrderClients() {
		// TODO: JUnit - Populate test inputs for operation: savePurchaseOrderClients 
		Integer purchaseOrderId_2 = 0;
		Client related_clients = new axi.source.domain.Client();
		service.savePurchaseOrderClients(purchaseOrderId_2, related_clients);
	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
