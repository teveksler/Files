package axi.source.service;

import axi.source.dao.EmployeeDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Employee;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Employee entities
 * 
 */

@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * DAO injected by Spring that manages Employee entities
	 * 
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * DAO injected by Spring that manages WorkOrder entities
	 * 
	 */
	@Autowired
	private WorkOrderDAO workOrderDAO;

	/**
	 * Instantiates a new EmployeeServiceImpl.
	 *
	 */
	public EmployeeServiceImpl() {
	}

	/**
	 * Save an existing Employee entity
	 * 
	 */
	@Transactional
	public void saveEmployee(Employee employee) {
		Employee existingEmployee = employeeDAO.findEmployeeByPrimaryKey(employee.getEmployeeId());

		if (existingEmployee != null) {
			if (existingEmployee != employee) {
				existingEmployee.setEmployeeId(employee.getEmployeeId());
				existingEmployee.setEmployeeName(employee.getEmployeeName());
				existingEmployee.setEmployeePhoneNum(employee.getEmployeePhoneNum());
				existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
				existingEmployee.setEmployeeComment(employee.getEmployeeComment());
			}
			employee = employeeDAO.store(existingEmployee);
		} else {
			employee = employeeDAO.store(employee);
		}
		employeeDAO.flush();
	}

	/**
	 * Return all Employee entity
	 * 
	 */
	@Transactional
	public List<Employee> findAllEmployees(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Employee>(employeeDAO.findAllEmployees(startResult, maxRows));
	}

	/**
	 * Return a count of all Employee entity
	 * 
	 */
	@Transactional
	public Integer countEmployees() {
		return ((Long) employeeDAO.createQuerySingleResult("select count(o) from Employee o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Employee saveEmployeeWorkOrders(Integer employeeId, WorkOrder related_workorders) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(employeeId, -1, -1);
		WorkOrder existingworkOrders = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders.getWorkOrderId());

		// copy into the existing record to preserve existing relationships
		if (existingworkOrders != null) {
			existingworkOrders.setWorkOrderId(related_workorders.getWorkOrderId());
			existingworkOrders.setWorkOrderScope(related_workorders.getWorkOrderScope());
			existingworkOrders.setWorkOrderAddress(related_workorders.getWorkOrderAddress());
			existingworkOrders.setWorkOrderCreatedOn(related_workorders.getWorkOrderCreatedOn());
			existingworkOrders.setWorkOrderExpectedEndDate(related_workorders.getWorkOrderExpectedEndDate());
			existingworkOrders.setWorkOrderEndDate(related_workorders.getWorkOrderEndDate());
			existingworkOrders.setWorkOrderStatus(related_workorders.getWorkOrderStatus());
			related_workorders = existingworkOrders;
		} else {
			related_workorders = workOrderDAO.store(related_workorders);
			workOrderDAO.flush();
		}

		employee.getWorkOrders().add(related_workorders);
		related_workorders.getEmployees().add(employee);
		employee = employeeDAO.store(employee);
		employeeDAO.flush();

		related_workorders = workOrderDAO.store(related_workorders);
		workOrderDAO.flush();

		return employee;
	}

	/**
	 */
	@Transactional
	public Employee findEmployeeByPrimaryKey(Integer employeeId) {
		return employeeDAO.findEmployeeByPrimaryKey(employeeId);
	}

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeDAO.remove(employee);
		employeeDAO.flush();
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Employee deleteEmployeeWorkOrders(Integer employee_employeeId, Integer related_workorders_workOrderId) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(employee_employeeId, -1, -1);
		WorkOrder related_workorders = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId, -1, -1);

		employee.getWorkOrders().remove(related_workorders);
		related_workorders.getEmployees().remove(employee);
		employee = employeeDAO.store(employee);
		employeeDAO.flush();

		related_workorders = workOrderDAO.store(related_workorders);
		workOrderDAO.flush();

		workOrderDAO.remove(related_workorders);
		workOrderDAO.flush();

		return employee;
	}

	/**
	 * Load an existing Employee entity
	 * 
	 */
	@Transactional
	public Set<Employee> loadEmployees() {
		return employeeDAO.findAllEmployees();
	}
}
