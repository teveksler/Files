package axi.source.web.rest;

import axi.source.dao.EmployeeDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Employee;
import axi.source.domain.WorkOrder;

import axi.source.service.EmployeeService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Employee entities
 * 
 */

@Controller("EmployeeRestController")
public class EmployeeRestController {

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
	 * Service injected by Spring that provides CRUD operations for Employee entities
	 * 
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}/workOrders/{workorder_workOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEmployeeWorkOrders(@PathVariable Integer employee_employeeId, @PathVariable Integer related_workorders_workOrderId) {
		employeeService.deleteEmployeeWorkOrders(employee_employeeId, related_workorders_workOrderId);
	}

	/**
	 * Show all WorkOrder entities by Employee
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}/workOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<WorkOrder> getEmployeeWorkOrders(@PathVariable Integer employee_employeeId) {
		return new java.util.ArrayList<WorkOrder>(employeeDAO.findEmployeeByPrimaryKey(employee_employeeId).getWorkOrders());
	}

	/**
	 * Show all Employee entities
	 * 
	 */
	@RequestMapping(value = "/Employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmployees() {
		return new java.util.ArrayList<Employee>(employeeService.loadEmployees());
	}

	/**
	 * Save an existing Employee entity
	 * 
	 */
	@RequestMapping(value = "/Employee", method = RequestMethod.PUT)
	@ResponseBody
	public Employee saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employeeDAO.findEmployeeByPrimaryKey(employee.getEmployeeId());
	}

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEmployee(@PathVariable Integer employee_employeeId) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(employee_employeeId);
		employeeService.deleteEmployee(employee);
	}

	/**
	 * View an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}/workOrders/{workorder_workOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public WorkOrder loadEmployeeWorkOrders(@PathVariable Integer employee_employeeId, @PathVariable Integer related_workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId, -1, -1);

		return workorder;
	}

	/**
	 * Create a new Employee entity
	 * 
	 */
	@RequestMapping(value = "/Employee", method = RequestMethod.POST)
	@ResponseBody
	public Employee newEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employeeDAO.findEmployeeByPrimaryKey(employee.getEmployeeId());
	}

	/**
	 * Select an existing Employee entity
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Employee loadEmployee(@PathVariable Integer employee_employeeId) {
		return employeeDAO.findEmployeeByPrimaryKey(employee_employeeId);
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}/workOrders", method = RequestMethod.POST)
	@ResponseBody
	public WorkOrder newEmployeeWorkOrders(@PathVariable Integer employee_employeeId, @RequestBody WorkOrder workorder) {
		employeeService.saveEmployeeWorkOrders(employee_employeeId, workorder);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder.getWorkOrderId());
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Employee/{employee_employeeId}/workOrders", method = RequestMethod.PUT)
	@ResponseBody
	public WorkOrder saveEmployeeWorkOrders(@PathVariable Integer employee_employeeId, @RequestBody WorkOrder workorders) {
		employeeService.saveEmployeeWorkOrders(employee_employeeId, workorders);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorders.getWorkOrderId());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}
}