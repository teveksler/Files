package axi.source.web.rest;

import axi.source.dao.ClientDAO;
import axi.source.dao.EmployeeDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Employee;
import axi.source.domain.Inventory;
import axi.source.domain.WorkOrder;

import axi.source.service.WorkOrderService;

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
 * Spring Rest controller that handles CRUD requests for WorkOrder entities
 * 
 */

@Controller("WorkOrderRestController")
public class WorkOrderRestController {

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

	/**
	 * DAO injected by Spring that manages Employee entities
	 * 
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * DAO injected by Spring that manages Inventory entities
	 * 
	 */
	@Autowired
	private InventoryDAO inventoryDAO;

	/**
	 * DAO injected by Spring that manages WorkOrder entities
	 * 
	 */
	@Autowired
	private WorkOrderDAO workOrderDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for WorkOrder entities
	 * 
	 */
	@Autowired
	private WorkOrderService workOrderService;

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkOrder(@PathVariable Integer workorder_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId);
		workOrderService.deleteWorkOrder(workorder);
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/client", method = RequestMethod.PUT)
	@ResponseBody
	public Client saveWorkOrderClient(@PathVariable Integer workorder_workOrderId, @RequestBody Client client) {
		workOrderService.saveWorkOrderClient(workorder_workOrderId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Save an existing Employee entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/employees", method = RequestMethod.PUT)
	@ResponseBody
	public Employee saveWorkOrderEmployees(@PathVariable Integer workorder_workOrderId, @RequestBody Employee employees) {
		workOrderService.saveWorkOrderEmployees(workorder_workOrderId, employees);
		return employeeDAO.findEmployeeByPrimaryKey(employees.getEmployeeId());
	}

	/**
	 * Select an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public WorkOrder loadWorkOrder(@PathVariable Integer workorder_workOrderId) {
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId);
	}

	/**
	 * Show all WorkOrder entities
	 * 
	 */
	@RequestMapping(value = "/WorkOrder", method = RequestMethod.GET)
	@ResponseBody
	public List<WorkOrder> listWorkOrders() {
		return new java.util.ArrayList<WorkOrder>(workOrderService.loadWorkOrders());
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder", method = RequestMethod.PUT)
	@ResponseBody
	public WorkOrder saveWorkOrder(@RequestBody WorkOrder workorder) {
		workOrderService.saveWorkOrder(workorder);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder.getWorkOrderId());
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/client/{client_clientId}", method = RequestMethod.GET)
	@ResponseBody
	public Client loadWorkOrderClient(@PathVariable Integer workorder_workOrderId, @PathVariable Integer related_client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		return client;
	}

	/**
	 * View an existing Employee entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/employees/{employee_employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Employee loadWorkOrderEmployees(@PathVariable Integer workorder_workOrderId, @PathVariable Integer related_employees_employeeId) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(related_employees_employeeId, -1, -1);

		return employee;
	}

	/**
	 * Create a new Employee entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/employees", method = RequestMethod.POST)
	@ResponseBody
	public Employee newWorkOrderEmployees(@PathVariable Integer workorder_workOrderId, @RequestBody Employee employee) {
		workOrderService.saveWorkOrderEmployees(workorder_workOrderId, employee);
		return employeeDAO.findEmployeeByPrimaryKey(employee.getEmployeeId());
	}

	/**
	 * Show all Inventory entities by WorkOrder
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/inventories", method = RequestMethod.GET)
	@ResponseBody
	public List<Inventory> getWorkOrderInventories(@PathVariable Integer workorder_workOrderId) {
		return new java.util.ArrayList<Inventory>(workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId).getInventories());
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/client/{client_clientId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkOrderClient(@PathVariable Integer workorder_workOrderId, @PathVariable Integer related_client_clientId) {
		workOrderService.deleteWorkOrderClient(workorder_workOrderId, related_client_clientId);
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/inventories/{inventory_inventoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkOrderInventories(@PathVariable Integer workorder_workOrderId, @PathVariable Integer related_inventories_inventoryId) {
		workOrderService.deleteWorkOrderInventories(workorder_workOrderId, related_inventories_inventoryId);
	}

	/**
	 * View an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/inventories/{inventory_inventoryId}", method = RequestMethod.GET)
	@ResponseBody
	public Inventory loadWorkOrderInventories(@PathVariable Integer workorder_workOrderId, @PathVariable Integer related_inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId, -1, -1);

		return inventory;
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

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/client", method = RequestMethod.POST)
	@ResponseBody
	public Client newWorkOrderClient(@PathVariable Integer workorder_workOrderId, @RequestBody Client client) {
		workOrderService.saveWorkOrderClient(workorder_workOrderId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Get Client entity by WorkOrder
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/client", method = RequestMethod.GET)
	@ResponseBody
	public Client getWorkOrderClient(@PathVariable Integer workorder_workOrderId) {
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId).getClient();
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder", method = RequestMethod.POST)
	@ResponseBody
	public WorkOrder newWorkOrder(@RequestBody WorkOrder workorder) {
		workOrderService.saveWorkOrder(workorder);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder.getWorkOrderId());
	}

	/**
	 * Show all Employee entities by WorkOrder
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getWorkOrderEmployees(@PathVariable Integer workorder_workOrderId) {
		return new java.util.ArrayList<Employee>(workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId).getEmployees());
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/inventories", method = RequestMethod.POST)
	@ResponseBody
	public Inventory newWorkOrderInventories(@PathVariable Integer workorder_workOrderId, @RequestBody Inventory inventory) {
		workOrderService.saveWorkOrderInventories(workorder_workOrderId, inventory);
		return inventoryDAO.findInventoryByPrimaryKey(inventory.getInventoryId());
	}

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/employees/{employee_employeeId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWorkOrderEmployees(@PathVariable Integer workorder_workOrderId, @PathVariable Integer related_employees_employeeId) {
		workOrderService.deleteWorkOrderEmployees(workorder_workOrderId, related_employees_employeeId);
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/WorkOrder/{workorder_workOrderId}/inventories", method = RequestMethod.PUT)
	@ResponseBody
	public Inventory saveWorkOrderInventories(@PathVariable Integer workorder_workOrderId, @RequestBody Inventory inventories) {
		workOrderService.saveWorkOrderInventories(workorder_workOrderId, inventories);
		return inventoryDAO.findInventoryByPrimaryKey(inventories.getInventoryId());
	}
}