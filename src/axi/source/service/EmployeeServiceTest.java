package axi.source.service;

import axi.source.domain.Employee;
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
public class EmployeeServiceTest {

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected EmployeeService service;

	/**
	 * Instantiates a new EmployeeServiceTest.
	 *
	 */
	public EmployeeServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Employee entity
	 * 
	 */
	@Test
	public void saveEmployee() {
		// TODO: JUnit - Populate test inputs for operation: saveEmployee 
		Employee employee = new axi.source.domain.Employee();
		service.saveEmployee(employee);
	}

	/**
	 * Operation Unit Test
	 * Return all Employee entity
	 * 
	 */
	@Test
	public void findAllEmployees() {
		// TODO: JUnit - Populate test inputs for operation: findAllEmployees 
		Integer startResult = 0;
		Integer maxRows = 0;
		service.findAllEmployees(startResult, maxRows);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Employee entity
	 * 
	 */
	@Test
	public void countEmployees() {
		service.countEmployees();
	}

	/**
	 * Operation Unit Test
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Test
	public void saveEmployeeWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: saveEmployeeWorkOrders 
		Integer employeeId = 0;
		WorkOrder related_workorders = new axi.source.domain.WorkOrder();
		service.saveEmployeeWorkOrders(employeeId, related_workorders);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findEmployeeByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findEmployeeByPrimaryKey 
		Integer employeeId_1 = 0;
		service.findEmployeeByPrimaryKey(employeeId_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Employee entity
	 * 
	 */
	@Test
	public void deleteEmployee() {
		// TODO: JUnit - Populate test inputs for operation: deleteEmployee 
		Employee employee_1 = new axi.source.domain.Employee();
		service.deleteEmployee(employee_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Test
	public void deleteEmployeeWorkOrders() {
		// TODO: JUnit - Populate test inputs for operation: deleteEmployeeWorkOrders 
		Integer employee_employeeId = 0;
		Integer related_workorders_workOrderId = 0;
		service.deleteEmployeeWorkOrders(employee_employeeId, related_workorders_workOrderId);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Employee entity
	 * 
	 */
	@Test
	public void loadEmployees() {
		service.loadEmployees();
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
