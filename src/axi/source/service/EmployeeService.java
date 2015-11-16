package axi.source.service;

import axi.source.domain.Employee;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Employee entities
 * 
 */
public interface EmployeeService {

	/**
	 * Save an existing Employee entity
	 * 
	 */
	public void saveEmployee(Employee employee);

	/**
	 * Return all Employee entity
	 * 
	 */
	public List<Employee> findAllEmployees(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Employee entity
	 * 
	 */
	public Integer countEmployees();

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	public Employee saveEmployeeWorkOrders(Integer employeeId, WorkOrder related_workorders);

	/**
	 */
	public Employee findEmployeeByPrimaryKey(Integer employeeId_1);

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	public void deleteEmployee(Employee employee_1);

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	public Employee deleteEmployeeWorkOrders(Integer employee_employeeId, Integer related_workorders_workOrderId);

	/**
	 * Load an existing Employee entity
	 * 
	 */
	public Set<Employee> loadEmployees();
}