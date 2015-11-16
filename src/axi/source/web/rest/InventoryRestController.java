package axi.source.web.rest;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.WorkOrder;

import axi.source.service.InventoryService;

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
 * Spring Rest controller that handles CRUD requests for Inventory entities
 * 
 */

@Controller("InventoryRestController")
public class InventoryRestController {

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
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/client/{client_clientId}", method = RequestMethod.GET)
	@ResponseBody
	public Client loadInventoryClient(@PathVariable Integer inventory_inventoryId, @PathVariable Integer related_client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		return client;
	}

	/**
	 * Create a new PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/purchaseOrders", method = RequestMethod.POST)
	@ResponseBody
	public PurchaseOrder newInventoryPurchaseOrders(@PathVariable Integer inventory_inventoryId, @RequestBody PurchaseOrder purchaseorder) {
		inventoryService.saveInventoryPurchaseOrders(inventory_inventoryId, purchaseorder);
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder.getPurchaseOrderId());
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/purchaseOrders/{purchaseorder_purchaseOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteInventoryPurchaseOrders(@PathVariable Integer inventory_inventoryId, @PathVariable Integer related_purchaseorders_purchaseOrderId) {
		inventoryService.deleteInventoryPurchaseOrders(inventory_inventoryId, related_purchaseorders_purchaseOrderId);
	}

	/**
	 * Select an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}", method = RequestMethod.GET)
	@ResponseBody
	public Inventory loadInventory(@PathVariable Integer inventory_inventoryId) {
		return inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId);
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/client", method = RequestMethod.POST)
	@ResponseBody
	public Client newInventoryClient(@PathVariable Integer inventory_inventoryId, @RequestBody Client client) {
		inventoryService.saveInventoryClient(inventory_inventoryId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * View an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/purchaseOrders/{purchaseorder_purchaseOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public PurchaseOrder loadInventoryPurchaseOrders(@PathVariable Integer inventory_inventoryId, @PathVariable Integer related_purchaseorders_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders_purchaseOrderId, -1, -1);

		return purchaseorder;
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/workOrders", method = RequestMethod.POST)
	@ResponseBody
	public WorkOrder newInventoryWorkOrders(@PathVariable Integer inventory_inventoryId, @RequestBody WorkOrder workorder) {
		inventoryService.saveInventoryWorkOrders(inventory_inventoryId, workorder);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder.getWorkOrderId());
	}

	/**
	 * Show all WorkOrder entities by Inventory
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/workOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<WorkOrder> getInventoryWorkOrders(@PathVariable Integer inventory_inventoryId) {
		return new java.util.ArrayList<WorkOrder>(inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId).getWorkOrders());
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/workOrders", method = RequestMethod.PUT)
	@ResponseBody
	public WorkOrder saveInventoryWorkOrders(@PathVariable Integer inventory_inventoryId, @RequestBody WorkOrder workorders) {
		inventoryService.saveInventoryWorkOrders(inventory_inventoryId, workorders);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorders.getWorkOrderId());
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/workOrders/{workorder_workOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteInventoryWorkOrders(@PathVariable Integer inventory_inventoryId, @PathVariable Integer related_workorders_workOrderId) {
		inventoryService.deleteInventoryWorkOrders(inventory_inventoryId, related_workorders_workOrderId);
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/purchaseOrders", method = RequestMethod.PUT)
	@ResponseBody
	public PurchaseOrder saveInventoryPurchaseOrders(@PathVariable Integer inventory_inventoryId, @RequestBody PurchaseOrder purchaseorders) {
		inventoryService.saveInventoryPurchaseOrders(inventory_inventoryId, purchaseorders);
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorders.getPurchaseOrderId());
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
	 * Show all Inventory entities
	 * 
	 */
	@RequestMapping(value = "/Inventory", method = RequestMethod.GET)
	@ResponseBody
	public List<Inventory> listInventorys() {
		return new java.util.ArrayList<Inventory>(inventoryService.loadInventorys());
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/client/{client_clientId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteInventoryClient(@PathVariable Integer inventory_inventoryId, @PathVariable Integer related_client_clientId) {
		inventoryService.deleteInventoryClient(inventory_inventoryId, related_client_clientId);
	}

	/**
	 * Get Client entity by Inventory
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/client", method = RequestMethod.GET)
	@ResponseBody
	public Client getInventoryClient(@PathVariable Integer inventory_inventoryId) {
		return inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId).getClient();
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteInventory(@PathVariable Integer inventory_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId);
		inventoryService.deleteInventory(inventory);
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Inventory", method = RequestMethod.PUT)
	@ResponseBody
	public Inventory saveInventory(@RequestBody Inventory inventory) {
		inventoryService.saveInventory(inventory);
		return inventoryDAO.findInventoryByPrimaryKey(inventory.getInventoryId());
	}

	/**
	 * View an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/workOrders/{workorder_workOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public WorkOrder loadInventoryWorkOrders(@PathVariable Integer inventory_inventoryId, @PathVariable Integer related_workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId, -1, -1);

		return workorder;
	}

	/**
	 * Show all PurchaseOrder entities by Inventory
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/purchaseOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<PurchaseOrder> getInventoryPurchaseOrders(@PathVariable Integer inventory_inventoryId) {
		return new java.util.ArrayList<PurchaseOrder>(inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId).getPurchaseOrders());
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Inventory/{inventory_inventoryId}/client", method = RequestMethod.PUT)
	@ResponseBody
	public Client saveInventoryClient(@PathVariable Integer inventory_inventoryId, @RequestBody Client client) {
		inventoryService.saveInventoryClient(inventory_inventoryId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Inventory", method = RequestMethod.POST)
	@ResponseBody
	public Inventory newInventory(@RequestBody Inventory inventory) {
		inventoryService.saveInventory(inventory);
		return inventoryDAO.findInventoryByPrimaryKey(inventory.getInventoryId());
	}
}