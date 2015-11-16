package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.Quote;
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
public class ClientServiceTest {

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected ClientService service;

	/**
	 * Instantiates a new ClientServiceTest.
	 *
	 */
	public ClientServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Inventory entity
	 * 
	 */
	@Test
	public void deleteClientInventories() {
		// TODO: JUnit - Populate test inputs for operation: deleteClientInventories 
		Integer client_clientId = 0;
		Integer related_inventories_inventoryId = 0;
		service.deleteClientInventories(client_clientId, related_inventories_inventoryId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Inventory entity
	 * 
	 */
	@Test
	public void saveClientInventories() {
		// TODO: JUnit - Populate test inputs for operation: saveClientInventories 
		Integer clientId = 0;
		Inventory related_inventories = new axi.source.domain.Inventory();
		service.saveClientInventories(clientId, related_inventories);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void deleteClientPurchaseOrders() {
		// TODO: JUnit - Populate test inputs for operation: deleteClientPurchaseOrders 
		Integer client_clientId_1 = 0;
		Integer related_purchaseorders_purchaseOrderId = 0;
		service.deleteClientPurchaseOrders(client_clientId_1, related_purchaseorders_purchaseOrderId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Client entity
	 * 
	 */
	@Test
	public void saveClient() {
		// TODO: JUnit - Populate test inputs for operation: saveClient 
		Client client = new axi.source.domain.Client();
		service.saveClient(client);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Client entity
	 * 
	 */
	@Test
	public void loadClients() {
		service.loadClients();
	}

	/**
	 * Operation Unit Test
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@Test
	public void saveClientPurchaseOrders() {
		// TODO: JUnit - Populate test inputs for operation: saveClientPurchaseOrders 
		Integer clientId_1 = 0;
		PurchaseOrder related_purchaseorders = new axi.source.domain.PurchaseOrder();
		service.saveClientPurchaseOrders(clientId_1, related_purchaseorders);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Quote entity
	 * 
	 */
	@Test
	public void deleteClientQuotes() {
		// TODO: JUnit - Populate test inputs for operation: deleteClientQuotes 
		Integer client_clientId_2 = 0;
		Integer related_quotes_quoteId = 0;
		service.deleteClientQuotes(client_clientId_2, related_quotes_quoteId);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Client entity
	 * 
	 */
	@Test
	public void deleteClient() {
		// TODO: JUnit - Populate test inputs for operation: deleteClient 
		Client client_1 = new axi.source.domain.Client();
		service.deleteClient(client_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Quote entity
	 * 
	 */
	@Test
	public void saveClientQuotes() {
		// TODO: JUnit - Populate test inputs for operation: saveClientQuotes 
		Integer clientId_2 = 0;
		Quote related_quotes = new axi.source.domain.Quote();
		service.saveClientQuotes(clientId_2, related_quotes);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Client entity
	 * 
	 */
	@Test
	public void countClients() {
		service.countClients();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Test
	public void deleteClientWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: deleteClientWorkOrders 
		Integer client_clientId_3 = 0;
		Integer related_workorders_workOrderId = 0;
		service.deleteClientWorkOrders(client_clientId_3, related_workorders_workOrderId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Test
	public void saveClientWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: saveClientWorkOrders 
		Integer clientId_3 = 0;
		WorkOrder related_workorders = new axi.source.domain.WorkOrder();
		service.saveClientWorkOrders(clientId_3, related_workorders);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findClientByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findClientByPrimaryKey 
		Integer clientId_4 = 0;
		service.findClientByPrimaryKey(clientId_4);
	}

	/**
	 * Operation Unit Test
	 * Return all Client entity
	 * 
	 */
	@Test
	public void findAllClients() {
		// TODO: JUnit - Populate test inputs for operation: findAllClients 
		Integer startResult = 0;
		Integer maxRows = 0;
		service.findAllClients(startResult, maxRows);
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
