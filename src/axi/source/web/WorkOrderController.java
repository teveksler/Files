package axi.source.web;

import axi.source.dao.ClientDAO;
import axi.source.dao.EmployeeDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Employee;
import axi.source.domain.Inventory;
import axi.source.domain.WorkOrder;

import axi.source.service.WorkOrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for WorkOrder entities
 * 
 */

@Controller("WorkOrderController")
public class WorkOrderController {

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
	 * Show all WorkOrder entities
	 * 
	 */
	@RequestMapping("/indexWorkOrder")
	public ModelAndView listWorkOrders() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorders", workOrderService.loadWorkOrders());

		mav.setViewName("workorder/listWorkOrders.jsp");

		return mav;
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping("/newWorkOrder")
	public ModelAndView newWorkOrder() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", new WorkOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("workorder/editWorkOrder.jsp");

		return mav;
	}

	/**
	 * Select the child Inventory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkOrderInventories")
	public ModelAndView confirmDeleteWorkOrderInventories(@RequestParam Integer workorder_workOrderId, @RequestParam Integer related_inventories_inventoryId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId));
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.setViewName("workorder/inventories/deleteInventories.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveWorkOrderClient")
	public ModelAndView saveWorkOrderClient(@RequestParam Integer workorder_workOrderId, @ModelAttribute Client client) {
		WorkOrder parent_workorder = workOrderService.saveWorkOrderClient(workorder_workOrderId, client);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("workorder", parent_workorder);
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
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
	 * Edit an existing Inventory entity
	 * 
	 */
	@RequestMapping("/editWorkOrderInventories")
	public ModelAndView editWorkOrderInventories(@RequestParam Integer workorder_workOrderId, @RequestParam Integer inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventories_inventoryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("inventory", inventory);
		mav.setViewName("workorder/inventories/editInventories.jsp");

		return mav;
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping("/saveWorkOrderInventories")
	public ModelAndView saveWorkOrderInventories(@RequestParam Integer workorder_workOrderId, @ModelAttribute Inventory inventories) {
		WorkOrder parent_workorder = workOrderService.saveWorkOrderInventories(workorder_workOrderId, inventories);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("workorder", parent_workorder);
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping("/newWorkOrderInventories")
	public ModelAndView newWorkOrderInventories(@RequestParam Integer workorder_workOrderId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("inventory", new Inventory());
		mav.addObject("newFlag", true);
		mav.setViewName("workorder/inventories/editInventories.jsp");

		return mav;
	}

	/**
	 * Save an existing Employee entity
	 * 
	 */
	@RequestMapping("/saveWorkOrderEmployees")
	public ModelAndView saveWorkOrderEmployees(@RequestParam Integer workorder_workOrderId, @ModelAttribute Employee employees) {
		WorkOrder parent_workorder = workOrderService.saveWorkOrderEmployees(workorder_workOrderId, employees);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("workorder", parent_workorder);
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
	}

	/**
	 * Select the WorkOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkOrder")
	public ModelAndView confirmDeleteWorkOrder(@RequestParam Integer workOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey));
		mav.setViewName("workorder/deleteWorkOrder.jsp");

		return mav;
	}

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	@RequestMapping("/deleteWorkOrderEmployees")
	public ModelAndView deleteWorkOrderEmployees(@RequestParam Integer workorder_workOrderId, @RequestParam Integer related_employees_employeeId) {
		ModelAndView mav = new ModelAndView();

		WorkOrder workorder = workOrderService.deleteWorkOrderEmployees(workorder_workOrderId, related_employees_employeeId);

		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("workorder", workorder);
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
	}

	/**
	 * Edit an existing Employee entity
	 * 
	 */
	@RequestMapping("/editWorkOrderEmployees")
	public ModelAndView editWorkOrderEmployees(@RequestParam Integer workorder_workOrderId, @RequestParam Integer employees_employeeId) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(employees_employeeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("employee", employee);
		mav.setViewName("workorder/employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * View an existing Employee entity
	 * 
	 */
	@RequestMapping("/selectWorkOrderEmployees")
	public ModelAndView selectWorkOrderEmployees(@RequestParam Integer workorder_workOrderId, @RequestParam Integer employees_employeeId) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(employees_employeeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("employee", employee);
		mav.setViewName("workorder/employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deleteWorkOrderClient")
	public ModelAndView deleteWorkOrderClient(@RequestParam Integer workorder_workOrderId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		WorkOrder workorder = workOrderService.deleteWorkOrderClient(workorder_workOrderId, related_client_clientId);

		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("workorder", workorder);
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
	}

	/**
	 * Show all Employee entities by WorkOrder
	 * 
	 */
	@RequestMapping("/listWorkOrderEmployees")
	public ModelAndView listWorkOrderEmployees(@RequestParam Integer workOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey));
		mav.setViewName("workorder/employees/listEmployees.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/workorderController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newWorkOrderClient")
	public ModelAndView newWorkOrderClient(@RequestParam Integer workorder_workOrderId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("workorder/client/editClient.jsp");

		return mav;
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectWorkOrderClient")
	public ModelAndView selectWorkOrderClient(@RequestParam Integer workorder_workOrderId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("client", client);
		mav.setViewName("workorder/client/viewClient.jsp");

		return mav;
	}

	/**
	 * Entry point to show all WorkOrder entities
	 * 
	 */
	public String indexWorkOrder() {
		return "redirect:/indexWorkOrder";
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editWorkOrderClient")
	public ModelAndView editWorkOrderClient(@RequestParam Integer workorder_workOrderId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("client", client);
		mav.setViewName("workorder/client/editClient.jsp");

		return mav;
	}

	/**
	 * Create a new Employee entity
	 * 
	 */
	@RequestMapping("/newWorkOrderEmployees")
	public ModelAndView newWorkOrderEmployees(@RequestParam Integer workorder_workOrderId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("employee", new Employee());
		mav.addObject("newFlag", true);
		mav.setViewName("workorder/employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * Select the child Employee entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkOrderEmployees")
	public ModelAndView confirmDeleteWorkOrderEmployees(@RequestParam Integer workorder_workOrderId, @RequestParam Integer related_employees_employeeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employee", employeeDAO.findEmployeeByPrimaryKey(related_employees_employeeId));
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.setViewName("workorder/employees/deleteEmployees.jsp");

		return mav;
	}

	/**
	 * Select an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/selectWorkOrder")
	public ModelAndView selectWorkOrder(@RequestParam Integer workOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey));
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteWorkOrderClient")
	public ModelAndView confirmDeleteWorkOrderClient(@RequestParam Integer workorder_workOrderId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(related_client_clientId));
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.setViewName("workorder/client/deleteClient.jsp");

		return mav;
	}

	/**
	 * Show all Inventory entities by WorkOrder
	 * 
	 */
	@RequestMapping("/listWorkOrderInventories")
	public ModelAndView listWorkOrderInventories(@RequestParam Integer workOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey));
		mav.setViewName("workorder/inventories/listInventories.jsp");

		return mav;
	}

	/**
	 * Edit an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/editWorkOrder")
	public ModelAndView editWorkOrder(@RequestParam Integer workOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey));
		mav.setViewName("workorder/editWorkOrder.jsp");

		return mav;
	}

	/**
	 * Show all Client entities by WorkOrder
	 * 
	 */
	@RequestMapping("/listWorkOrderClient")
	public ModelAndView listWorkOrderClient(@RequestParam Integer workOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey));
		mav.setViewName("workorder/client/listClient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping("/deleteWorkOrderInventories")
	public ModelAndView deleteWorkOrderInventories(@RequestParam Integer workorder_workOrderId, @RequestParam Integer related_inventories_inventoryId) {
		ModelAndView mav = new ModelAndView();

		WorkOrder workorder = workOrderService.deleteWorkOrderInventories(workorder_workOrderId, related_inventories_inventoryId);

		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("workorder", workorder);
		mav.setViewName("workorder/viewWorkOrder.jsp");

		return mav;
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/saveWorkOrder")
	public String saveWorkOrder(@ModelAttribute WorkOrder workorder) {
		workOrderService.saveWorkOrder(workorder);
		return "forward:/indexWorkOrder";
	}

	/**
	 * View an existing Inventory entity
	 * 
	 */
	@RequestMapping("/selectWorkOrderInventories")
	public ModelAndView selectWorkOrderInventories(@RequestParam Integer workorder_workOrderId, @RequestParam Integer inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventories_inventoryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("workorder_workOrderId", workorder_workOrderId);
		mav.addObject("inventory", inventory);
		mav.setViewName("workorder/inventories/viewInventories.jsp");

		return mav;
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/deleteWorkOrder")
	public String deleteWorkOrder(@RequestParam Integer workOrderIdKey) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workOrderIdKey);
		workOrderService.deleteWorkOrder(workorder);
		return "forward:/indexWorkOrder";
	}
}