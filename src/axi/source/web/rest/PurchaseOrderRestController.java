package axi.source.web.rest;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;

import axi.source.service.PurchaseOrderService;

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
 * Spring Rest controller that handles CRUD requests for PurchaseOrder entities
 * 
 */

@Controller("PurchaseOrderRestController")
public class PurchaseOrderRestController {

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
	 * Service injected by Spring that provides CRUD operations for PurchaseOrder entities
	 * 
	 */
	@Autowired
	private PurchaseOrderService purchaseOrderService;

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder", method = RequestMethod.PUT)
	@ResponseBody
	public PurchaseOrder savePurchaseOrder(@RequestBody PurchaseOrder purchaseorder) {
		purchaseOrderService.savePurchaseOrder(purchaseorder);
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder.getPurchaseOrderId());
	}

	/**
	 * Show all Client entities by PurchaseOrder
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getPurchaseOrderClients(@PathVariable Integer purchaseorder_purchaseOrderId) {
		return new java.util.ArrayList<Client>(purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder_purchaseOrderId).getClients());
	}

	/**
	 * Create a new PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder", method = RequestMethod.POST)
	@ResponseBody
	public PurchaseOrder newPurchaseOrder(@RequestBody PurchaseOrder purchaseorder) {
		purchaseOrderService.savePurchaseOrder(purchaseorder);
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder.getPurchaseOrderId());
	}

	/**
	 * View an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories/{inventory_inventoryId}", method = RequestMethod.GET)
	@ResponseBody
	public Inventory loadPurchaseOrderInventories(@PathVariable Integer purchaseorder_purchaseOrderId, @PathVariable Integer related_inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId, -1, -1);

		return inventory;
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePurchaseOrder(@PathVariable Integer purchaseorder_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder_purchaseOrderId);
		purchaseOrderService.deletePurchaseOrder(purchaseorder);
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients/{client_clientId}", method = RequestMethod.GET)
	@ResponseBody
	public Client loadPurchaseOrderClients(@PathVariable Integer purchaseorder_purchaseOrderId, @PathVariable Integer related_clients_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(related_clients_clientId, -1, -1);

		return client;
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories", method = RequestMethod.POST)
	@ResponseBody
	public Inventory newPurchaseOrderInventories(@PathVariable Integer purchaseorder_purchaseOrderId, @RequestBody Inventory inventory) {
		purchaseOrderService.savePurchaseOrderInventories(purchaseorder_purchaseOrderId, inventory);
		return inventoryDAO.findInventoryByPrimaryKey(inventory.getInventoryId());
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories", method = RequestMethod.PUT)
	@ResponseBody
	public Inventory savePurchaseOrderInventories(@PathVariable Integer purchaseorder_purchaseOrderId, @RequestBody Inventory inventories) {
		purchaseOrderService.savePurchaseOrderInventories(purchaseorder_purchaseOrderId, inventories);
		return inventoryDAO.findInventoryByPrimaryKey(inventories.getInventoryId());
	}

	/**
	 * Show all PurchaseOrder entities
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder", method = RequestMethod.GET)
	@ResponseBody
	public List<PurchaseOrder> listPurchaseOrders() {
		return new java.util.ArrayList<PurchaseOrder>(purchaseOrderService.loadPurchaseOrders());
	}

	/**
	 * Select an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public PurchaseOrder loadPurchaseOrder(@PathVariable Integer purchaseorder_purchaseOrderId) {
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder_purchaseOrderId);
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories/{inventory_inventoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePurchaseOrderInventories(@PathVariable Integer purchaseorder_purchaseOrderId, @PathVariable Integer related_inventories_inventoryId) {
		purchaseOrderService.deletePurchaseOrderInventories(purchaseorder_purchaseOrderId, related_inventories_inventoryId);
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients", method = RequestMethod.POST)
	@ResponseBody
	public Client newPurchaseOrderClients(@PathVariable Integer purchaseorder_purchaseOrderId, @RequestBody Client client) {
		purchaseOrderService.savePurchaseOrderClients(purchaseorder_purchaseOrderId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients/{client_clientId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePurchaseOrderClients(@PathVariable Integer purchaseorder_purchaseOrderId, @PathVariable Integer related_clients_clientId) {
		purchaseOrderService.deletePurchaseOrderClients(purchaseorder_purchaseOrderId, related_clients_clientId);
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
	 * Show all Inventory entities by PurchaseOrder
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/inventories", method = RequestMethod.GET)
	@ResponseBody
	public List<Inventory> getPurchaseOrderInventories(@PathVariable Integer purchaseorder_purchaseOrderId) {
		return new java.util.ArrayList<Inventory>(purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder_purchaseOrderId).getInventories());
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/PurchaseOrder/{purchaseorder_purchaseOrderId}/clients", method = RequestMethod.PUT)
	@ResponseBody
	public Client savePurchaseOrderClients(@PathVariable Integer purchaseorder_purchaseOrderId, @RequestBody Client clients) {
		purchaseOrderService.savePurchaseOrderClients(purchaseorder_purchaseOrderId, clients);
		return clientDAO.findClientByPrimaryKey(clients.getClientId());
	}
}