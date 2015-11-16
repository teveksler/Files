package axi.source.web;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.WorkOrder;

import axi.source.service.InventoryService;

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
 * Spring MVC controller that handles CRUD requests for Inventory entities
 * 
 */

@Controller("InventoryController")
public class InventoryController {

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

	/**
	 * DAO injected by Spring that manages Inventory entities
	 * 
	 */
	@Autowired
	private InventoryDAO inventoryDAO;

	/**
	 * DAO injected by Spring that manages PurchaseOrder entities
	 * 
	 */
	@Autowired
	private PurchaseOrderDAO purchaseOrderDAO;

	/**
	 * DAO injected by Spring that manages WorkOrder entities
	 * 
	 */
	@Autowired
	private WorkOrderDAO workOrderDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Inventory entities
	 * 
	 */
	@Autowired
	private InventoryService inventoryService;

	/**
	 * Select the child PurchaseOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInventoryPurchaseOrders")
	public ModelAndView confirmDeleteInventoryPurchaseOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer related_purchaseorders_purchaseOrderId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders_purchaseOrderId));
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.setViewName("inventory/purchaseorders/deletePurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping("/newInventory")
	public ModelAndView newInventory() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", new Inventory());
		mav.addObject("newFlag", true);
		mav.setViewName("inventory/editInventory.jsp");

		return mav;
	}

	/**
	 * Select the Inventory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInventory")
	public ModelAndView confirmDeleteInventory(@RequestParam Integer inventoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey));
		mav.setViewName("inventory/deleteInventory.jsp");

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
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editInventoryClient")
	public ModelAndView editInventoryClient(@RequestParam Integer inventory_inventoryId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("client", client);
		mav.setViewName("inventory/client/editClient.jsp");

		return mav;
	}

	/**
	 * Show all WorkOrder entities by Inventory
	 * 
	 */
	@RequestMapping("/listInventoryWorkOrders")
	public ModelAndView listInventoryWorkOrders(@RequestParam Integer inventoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey));
		mav.setViewName("inventory/workorders/listWorkOrders.jsp");

		return mav;
	}

	/**
	 * Select the child WorkOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInventoryWorkOrders")
	public ModelAndView confirmDeleteInventoryWorkOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer related_workorders_workOrderId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId));
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.setViewName("inventory/workorders/deleteWorkOrders.jsp");

		return mav;
	}

	/**
	 * Select an existing Inventory entity
	 * 
	 */
	@RequestMapping("/selectInventory")
	public ModelAndView selectInventory(@RequestParam Integer inventoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey));
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping("/deleteInventory")
	public String deleteInventory(@RequestParam Integer inventoryIdKey) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey);
		inventoryService.deleteInventory(inventory);
		return "forward:/indexInventory";
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping("/saveInventory")
	public String saveInventory(@ModelAttribute Inventory inventory) {
		inventoryService.saveInventory(inventory);
		return "forward:/indexInventory";
	}

	/**
	 * Entry point to show all Inventory entities
	 * 
	 */
	public String indexInventory() {
		return "redirect:/indexInventory";
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deleteInventoryClient")
	public ModelAndView deleteInventoryClient(@RequestParam Integer inventory_inventoryId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		Inventory inventory = inventoryService.deleteInventoryClient(inventory_inventoryId, related_client_clientId);

		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("inventory", inventory);
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * Show all Inventory entities
	 * 
	 */
	@RequestMapping("/indexInventory")
	public ModelAndView listInventorys() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventorys", inventoryService.loadInventorys());

		mav.setViewName("inventory/listInventorys.jsp");

		return mav;
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/saveInventoryPurchaseOrders")
	public ModelAndView saveInventoryPurchaseOrders(@RequestParam Integer inventory_inventoryId, @ModelAttribute PurchaseOrder purchaseorders) {
		Inventory parent_inventory = inventoryService.saveInventoryPurchaseOrders(inventory_inventoryId, purchaseorders);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("inventory", parent_inventory);
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping("/newInventoryWorkOrders")
	public ModelAndView newInventoryWorkOrders(@RequestParam Integer inventory_inventoryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("workorder", new WorkOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("inventory/workorders/editWorkOrders.jsp");

		return mav;
	}

	/**
	 * Show all Client entities by Inventory
	 * 
	 */
	@RequestMapping("/listInventoryClient")
	public ModelAndView listInventoryClient(@RequestParam Integer inventoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey));
		mav.setViewName("inventory/client/listClient.jsp");

		return mav;
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteInventoryClient")
	public ModelAndView confirmDeleteInventoryClient(@RequestParam Integer inventory_inventoryId, @RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(related_client_clientId));
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.setViewName("inventory/client/deleteClient.jsp");

		return mav;
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/saveInventoryWorkOrders")
	public ModelAndView saveInventoryWorkOrders(@RequestParam Integer inventory_inventoryId, @ModelAttribute WorkOrder workorders) {
		Inventory parent_inventory = inventoryService.saveInventoryWorkOrders(inventory_inventoryId, workorders);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("inventory", parent_inventory);
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * Edit an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/editInventoryPurchaseOrders")
	public ModelAndView editInventoryPurchaseOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer purchaseorders_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorders_purchaseOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("purchaseorder", purchaseorder);
		mav.setViewName("inventory/purchaseorders/editPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Edit an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/editInventoryWorkOrders")
	public ModelAndView editInventoryWorkOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorders_workOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("workorder", workorder);
		mav.setViewName("inventory/workorders/editWorkOrders.jsp");

		return mav;
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newInventoryClient")
	public ModelAndView newInventoryClient(@RequestParam Integer inventory_inventoryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("inventory/client/editClient.jsp");

		return mav;
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectInventoryClient")
	public ModelAndView selectInventoryClient(@RequestParam Integer inventory_inventoryId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("client", client);
		mav.setViewName("inventory/client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveInventoryClient")
	public ModelAndView saveInventoryClient(@RequestParam Integer inventory_inventoryId, @ModelAttribute Client client) {
		Inventory parent_inventory = inventoryService.saveInventoryClient(inventory_inventoryId, client);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("inventory", parent_inventory);
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * View an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/selectInventoryWorkOrders")
	public ModelAndView selectInventoryWorkOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorders_workOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("workorder", workorder);
		mav.setViewName("inventory/workorders/viewWorkOrders.jsp");

		return mav;
	}

	/**
	 * Show all PurchaseOrder entities by Inventory
	 * 
	 */
	@RequestMapping("/listInventoryPurchaseOrders")
	public ModelAndView listInventoryPurchaseOrders(@RequestParam Integer inventoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey));
		mav.setViewName("inventory/purchaseorders/listPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * View an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/selectInventoryPurchaseOrders")
	public ModelAndView selectInventoryPurchaseOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer purchaseorders_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorders_purchaseOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("purchaseorder", purchaseorder);
		mav.setViewName("inventory/purchaseorders/viewPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Create a new PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/newInventoryPurchaseOrders")
	public ModelAndView newInventoryPurchaseOrders(@RequestParam Integer inventory_inventoryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("purchaseorder", new PurchaseOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("inventory/purchaseorders/editPurchaseOrders.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/inventoryController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/deleteInventoryPurchaseOrders")
	public ModelAndView deleteInventoryPurchaseOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer related_purchaseorders_purchaseOrderId) {
		ModelAndView mav = new ModelAndView();

		Inventory inventory = inventoryService.deleteInventoryPurchaseOrders(inventory_inventoryId, related_purchaseorders_purchaseOrderId);

		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("inventory", inventory);
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/deleteInventoryWorkOrders")
	public ModelAndView deleteInventoryWorkOrders(@RequestParam Integer inventory_inventoryId, @RequestParam Integer related_workorders_workOrderId) {
		ModelAndView mav = new ModelAndView();

		Inventory inventory = inventoryService.deleteInventoryWorkOrders(inventory_inventoryId, related_workorders_workOrderId);

		mav.addObject("inventory_inventoryId", inventory_inventoryId);
		mav.addObject("inventory", inventory);
		mav.setViewName("inventory/viewInventory.jsp");

		return mav;
	}

	/**
	 * Edit an existing Inventory entity
	 * 
	 */
	@RequestMapping("/editInventory")
	public ModelAndView editInventory(@RequestParam Integer inventoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(inventoryIdKey));
		mav.setViewName("inventory/editInventory.jsp");

		return mav;
	}
}