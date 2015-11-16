package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Employee;
import axi.source.domain.Inventory;
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
public class WorkOrderServiceTest {

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected WorkOrderService service;

	/**
	 * Instantiates a new WorkOrderServiceTest.
	 *
	 */
	public WorkOrderServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Test
	public void deleteWorkOrder() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkOrder 
		WorkOrder workorder = new axi.source.domain.WorkOrder();
		service.deleteWorkOrder(workorder);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Employee entity
	 * 
	 */
	@Test
	public void deleteWorkOrderEmployees() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkOrderEmployees 
		Integer workorder_workOrderId = 0;
		Integer related_employees_employeeId = 0;
		service.deleteWorkOrderEmployees(workorder_workOrderId, related_employees_employeeId);
	}

	/**
	 * Operation Unit Test
	 * Load an existing WorkOrder entity
	 * 
	 */
	@Test
	public void loadWorkOrders() {
		service.loadWorkOrders();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Client entity
	 * 
	 */
	@Test
	public void deleteWorkOrderClient() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkOrderClient 
		Integer workorder_workOrderId_1 = 0;
		Integer related_client_clientId = 0;
		service.deleteWorkOrderClient(workorder_workOrderId_1, related_client_clientId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Test
	public void saveWorkOrder() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkOrder 
		WorkOrder workorder_1 = new axi.source.domain.WorkOrder();
		service.saveWorkOrder(workorder_1);
	}

	/**
	 * Operation Unit Test
	 * Return all WorkOrder entity
	 * 
	 */
	@Test
	public void findAllWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: findAllWorkOrders 
		Integer startResult = 0;
		Integer maxRows = 0;
		service.findAllWorkOrders(startResult, maxRows);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Inventory entity
	 * 
	 */
	@Test
	public void deleteWorkOrderInventories() {
		// TODO: JUnit - Populate test inputs for operation: deleteWorkOrderInventories 
		Integer workorder_workOrderId_2 = 0;
		Integer related_inventories_inventoryId = 0;
		service.deleteWorkOrderInventories(workorder_workOrderId_2, related_inventories_inventoryId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Client entity
	 * 
	 */
	@Test
	public void saveWorkOrderClient() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkOrderClient 
		Integer workOrderId = 0;
		Client related_client = new axi.source.domain.Client();
		service.saveWorkOrderClient(workOrderId, related_client);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findWorkOrderByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findWorkOrderByPrimaryKey 
		Integer workOrderId_1 = 0;
		service.findWorkOrderByPrimaryKey(workOrderId_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all WorkOrder entity
	 * 
	 */
	@Test
	public void countWorkOrders() {
		service.countWorkOrders();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Employee entity
	 * 
	 */
	@Test
	public void saveWorkOrderEmployees() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkOrderEmployees 
		Integer workOrderId_2 = 0;
		Employee related_employees = new axi.source.domain.Employee();
		service.saveWorkOrderEmployees(workOrderId_2, related_employees);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Inventory entity
	 * 
	 */
	@Test
	public void saveWorkOrderInventories() {
		// TODO: JUnit - Populate test inputs for operation: saveWorkOrderInventories 
		Integer workOrderId_3 = 0;
		Inventory related_inventories = new axi.source.domain.Inventory();
		service.saveWorkOrderInventories(workOrderId_3, related_inventories);
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
