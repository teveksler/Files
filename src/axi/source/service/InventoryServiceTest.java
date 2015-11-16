package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.WorkOrder;

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
public class InventoryServiceTest {

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected InventoryService service;

	/**
	 * Instantiates a new InventoryServiceTest.
	 *
	 */
	public InventoryServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Client entity
	 * 
	 */
	@Test
	public void deleteInventoryClient() {
		// TODO: JUnit - Populate test inputs for operation: deleteInventoryClient 
		Integer inventory_inventoryId = 0;
		Integer related_client_clientId = 0;
		service.deleteInventoryClient(inventory_inventoryId, related_client_clientId);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Inventory entity
	 * 
	 */
	@Test
	public void countInventorys() {
		service.countInventorys();
	}

	/**
	 * Operation Unit Test
	 * Return all Inventory entity
	 * 
	 */
	@Test
	public void findAllInventorys() {
		// TODO: JUnit - Populate test inputs for operation: findAllInventorys 
		Integer startResult = 0;
		Integer maxRows = 0;
		service.findAllInventorys(startResult, maxRows);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Client entity
	 * 
	 */
	@Test
	public void saveInventoryClient() {
		// TODO: JUnit - Populate test inputs for operation: saveInventoryClient 
		Integer inventoryId = 0;
		Client related_client = new axi.source.domain.Client();
		service.saveInventoryClient(inventoryId, related_client);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findInventoryByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findInventoryByPrimaryKey 
		Integer inventoryId_1 = 0;
		service.findInventoryByPrimaryKey(inventoryId_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void saveInventoryPurchaseOrders() {
		// TODO: JUnit - Populate test inputs for operation: saveInventoryPurchaseOrders 
		Integer inventoryId_2 = 0;
		PurchaseOrder related_purchaseorders = new axi.source.domain.PurchaseOrder();
		service.saveInventoryPurchaseOrders(inventoryId_2, related_purchaseorders);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Inventory entity
	 * 
	 */
	@Test
	public void deleteInventory() {
		// TODO: JUnit - Populate test inputs for operation: deleteInventory 
		Inventory inventory = new axi.source.domain.Inventory();
		service.deleteInventory(inventory);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Test
	public void deleteInventoryWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: deleteInventoryWorkOrders 
		Integer inventory_inventoryId_1 = 0;
		Integer related_workorders_workOrderId = 0;
		service.deleteInventoryWorkOrders(inventory_inventoryId_1, related_workorders_workOrderId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Inventory entity
	 * 
	 */
	@Test
	public void saveInventory() {
		// TODO: JUnit - Populate test inputs for operation: saveInventory 
		Inventory inventory_1 = new axi.source.domain.Inventory();
		service.saveInventory(inventory_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Test
	public void saveInventoryWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: saveInventoryWorkOrders 
		Integer inventoryId_3 = 0;
		WorkOrder related_workorders = new axi.source.domain.WorkOrder();
		service.saveInventoryWorkOrders(inventoryId_3, related_workorders);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Inventory entity
	 * 
	 */
	@Test
	public void loadInventorys() {
		service.loadInventorys();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void deleteInventoryPurchaseOrders() {
		// TODO: JUnit - Populate test inputs for operation: deleteInventoryPurchaseOrders 
		Integer inventory_inventoryId_2 = 0;
		Integer related_purchaseorders_purchaseOrderId = 0;
		service.deleteInventoryPurchaseOrders(inventory_inventoryId_2, related_purchaseorders_purchaseOrderId);
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
