package axi.source.web;

import axi.source.dao.EmployeeDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Employee;
import axi.source.domain.WorkOrder;

import axi.source.service.EmployeeService;

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
 * Spring MVC controller that handles CRUD requests for Employee entities
 * 
 */

@Controller("EmployeeController")
public class EmployeeController {

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
	 * Show all WorkOrder entities by Employee
	 * 
	 */
	@RequestMapping("/listEmployeeWorkOrders")
	public ModelAndView listEmployeeWorkOrders(@RequestParam Integer employeeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employee", employeeDAO.findEmployeeByPrimaryKey(employeeIdKey));
		mav.setViewName("employee/workorders/listWorkOrders.jsp");

		return mav;
	}

	/**
	 * Select the child WorkOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployeeWorkOrders")
	public ModelAndView confirmDeleteEmployeeWorkOrders(@RequestParam Integer employee_employeeId, @RequestParam Integer related_workorders_workOrderId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId));
		mav.addObject("employee_employeeId", employee_employeeId);
		mav.setViewName("employee/workorders/deleteWorkOrders.jsp");

		return mav;
	}

	/**
	 * View an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/selectEmployeeWorkOrders")
	public ModelAndView selectEmployeeWorkOrders(@RequestParam Integer employee_employeeId, @RequestParam Integer workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorders_workOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employee_employeeId", employee_employeeId);
		mav.addObject("workorder", workorder);
		mav.setViewName("employee/workorders/viewWorkOrders.jsp");

		return mav;
	}

	/**
	 * Create a new Employee entity
	 * 
	 */
	@RequestMapping("/newEmployee")
	public ModelAndView newEmployee() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employee", new Employee());
		mav.addObject("newFlag", true);
		mav.setViewName("employee/editEmployee.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Employee entities
	 * 
	 */
	public String indexEmployee() {
		return "redirect:/indexEmployee";
	}

	/**
	 * Save an existing Employee entity
	 * 
	 */
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "forward:/indexEmployee";
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/saveEmployeeWorkOrders")
	public ModelAndView saveEmployeeWorkOrders(@RequestParam Integer employee_employeeId, @ModelAttribute WorkOrder workorders) {
		Employee parent_employee = employeeService.saveEmployeeWorkOrders(employee_employeeId, workorders);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employee_employeeId", employee_employeeId);
		mav.addObject("employee", parent_employee);
		mav.setViewName("employee/viewEmployee.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/employeeController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select the Employee entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployee")
	public ModelAndView confirmDeleteEmployee(@RequestParam Integer employeeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employee", employeeDAO.findEmployeeByPrimaryKey(employeeIdKey));
		mav.setViewName("employee/deleteEmployee.jsp");

		return mav;
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping("/newEmployeeWorkOrders")
	public ModelAndView newEmployeeWorkOrders(@RequestParam Integer employee_employeeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee_employeeId", employee_employeeId);
		mav.addObject("workorder", new WorkOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("employee/workorders/editWorkOrders.jsp");

		return mav;
	}

	/**
	 * Show all Employee entities
	 * 
	 */
	@RequestMapping("/indexEmployee")
	public ModelAndView listEmployees() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeeService.loadEmployees());

		mav.setViewName("employee/listEmployees.jsp");

		return mav;
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/deleteEmployeeWorkOrders")
	public ModelAndView deleteEmployeeWorkOrders(@RequestParam Integer employee_employeeId, @RequestParam Integer related_workorders_workOrderId) {
		ModelAndView mav = new ModelAndView();

		Employee employee = employeeService.deleteEmployeeWorkOrders(employee_employeeId, related_workorders_workOrderId);

		mav.addObject("employee_employeeId", employee_employeeId);
		mav.addObject("employee", employee);
		mav.setViewName("employee/viewEmployee.jsp");

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
	 * Select an existing Employee entity
	 * 
	 */
	@RequestMapping("/selectEmployee")
	public ModelAndView selectEmployee(@RequestParam Integer employeeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employee", employeeDAO.findEmployeeByPrimaryKey(employeeIdKey));
		mav.setViewName("employee/viewEmployee.jsp");

		return mav;
	}

	/**
	 * Edit an existing Employee entity
	 * 
	 */
	@RequestMapping("/editEmployee")
	public ModelAndView editEmployee(@RequestParam Integer employeeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employee", employeeDAO.findEmployeeByPrimaryKey(employeeIdKey));
		mav.setViewName("employee/editEmployee.jsp");

		return mav;
	}

	/**
	 * Edit an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/editEmployeeWorkOrders")
	public ModelAndView editEmployeeWorkOrders(@RequestParam Integer employee_employeeId, @RequestParam Integer workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorders_workOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employee_employeeId", employee_employeeId);
		mav.addObject("workorder", workorder);
		mav.setViewName("employee/workorders/editWorkOrders.jsp");

		return mav;
	}

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer employeeIdKey) {
		Employee employee = employeeDAO.findEmployeeByPrimaryKey(employeeIdKey);
		employeeService.deleteEmployee(employee);
		return "forward:/indexEmployee";
	}
}