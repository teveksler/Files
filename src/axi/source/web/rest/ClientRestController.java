package axi.source.web.rest;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;
import axi.source.dao.QuoteDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.Quote;
import axi.source.domain.WorkOrder;

import axi.source.service.ClientService;

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
 * Spring Rest controller that handles CRUD requests for Client entities
 * 
 */

@Controller("ClientRestController")
public class ClientRestController {

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
	 * DAO injected by Spring that manages Quote entities
	 * 
	 */
	@Autowired
	private QuoteDAO quoteDAO;

	/**
	 * DAO injected by Spring that manages WorkOrder entities
	 * 
	 */
	@Autowired
	private WorkOrderDAO workOrderDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Client entities
	 * 
	 */
	@Autowired
	private ClientService clientService;

	/**
	 * View an existing Quote entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/quotes/{quote_quoteId}", method = RequestMethod.GET)
	@ResponseBody
	public Quote loadClientQuotes(@PathVariable Integer client_clientId, @PathVariable Integer related_quotes_quoteId) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(related_quotes_quoteId, -1, -1);

		return quote;
	}

	/**
	 * Create a new PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/purchaseOrders", method = RequestMethod.POST)
	@ResponseBody
	public PurchaseOrder newClientPurchaseOrders(@PathVariable Integer client_clientId, @RequestBody PurchaseOrder purchaseorder) {
		clientService.saveClientPurchaseOrders(client_clientId, purchaseorder);
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder.getPurchaseOrderId());
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/workOrders", method = RequestMethod.POST)
	@ResponseBody
	public WorkOrder newClientWorkOrders(@PathVariable Integer client_clientId, @RequestBody WorkOrder workorder) {
		clientService.saveClientWorkOrders(client_clientId, workorder);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorder.getWorkOrderId());
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
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/purchaseOrders/{purchaseorder_purchaseOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClientPurchaseOrders(@PathVariable Integer client_clientId, @PathVariable Integer related_purchaseorders_purchaseOrderId) {
		clientService.deleteClientPurchaseOrders(client_clientId, related_purchaseorders_purchaseOrderId);
	}

	/**
	 * Select an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}", method = RequestMethod.GET)
	@ResponseBody
	public Client loadClient(@PathVariable Integer client_clientId) {
		return clientDAO.findClientByPrimaryKey(client_clientId);
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/inventories", method = RequestMethod.PUT)
	@ResponseBody
	public Inventory saveClientInventories(@PathVariable Integer client_clientId, @RequestBody Inventory inventories) {
		clientService.saveClientInventories(client_clientId, inventories);
		return inventoryDAO.findInventoryByPrimaryKey(inventories.getInventoryId());
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Client", method = RequestMethod.PUT)
	@ResponseBody
	public Client saveClient(@RequestBody Client client) {
		clientService.saveClient(client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * View an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/workOrders/{workorder_workOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public WorkOrder loadClientWorkOrders(@PathVariable Integer client_clientId, @PathVariable Integer related_workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId, -1, -1);

		return workorder;
	}

	/**
	 * Show all WorkOrder entities by Client
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/workOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<WorkOrder> getClientWorkOrders(@PathVariable Integer client_clientId) {
		return new java.util.ArrayList<WorkOrder>(clientDAO.findClientByPrimaryKey(client_clientId).getWorkOrders());
	}

	/**
	 * Show all Quote entities by Client
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/quotes", method = RequestMethod.GET)
	@ResponseBody
	public List<Quote> getClientQuotes(@PathVariable Integer client_clientId) {
		return new java.util.ArrayList<Quote>(clientDAO.findClientByPrimaryKey(client_clientId).getQuotes());
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/purchaseOrders", method = RequestMethod.PUT)
	@ResponseBody
	public PurchaseOrder saveClientPurchaseOrders(@PathVariable Integer client_clientId, @RequestBody PurchaseOrder purchaseorders) {
		clientService.saveClientPurchaseOrders(client_clientId, purchaseorders);
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorders.getPurchaseOrderId());
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/inventories/{inventory_inventoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClientInventories(@PathVariable Integer client_clientId, @PathVariable Integer related_inventories_inventoryId) {
		clientService.deleteClientInventories(client_clientId, related_inventories_inventoryId);
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/workOrders", method = RequestMethod.PUT)
	@ResponseBody
	public WorkOrder saveClientWorkOrders(@PathVariable Integer client_clientId, @RequestBody WorkOrder workorders) {
		clientService.saveClientWorkOrders(client_clientId, workorders);
		return workOrderDAO.findWorkOrderByPrimaryKey(workorders.getWorkOrderId());
	}

	/**
	 * Show all Client entities
	 * 
	 */
	@RequestMapping(value = "/Client", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> listClients() {
		return new java.util.ArrayList<Client>(clientService.loadClients());
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/workOrders/{workorder_workOrderId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClientWorkOrders(@PathVariable Integer client_clientId, @PathVariable Integer related_workorders_workOrderId) {
		clientService.deleteClientWorkOrders(client_clientId, related_workorders_workOrderId);
	}

	/**
	 * Create a new Quote entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/quotes", method = RequestMethod.POST)
	@ResponseBody
	public Quote newClientQuotes(@PathVariable Integer client_clientId, @RequestBody Quote quote) {
		clientService.saveClientQuotes(client_clientId, quote);
		return quoteDAO.findQuoteByPrimaryKey(quote.getQuoteId());
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/inventories", method = RequestMethod.POST)
	@ResponseBody
	public Inventory newClientInventories(@PathVariable Integer client_clientId, @RequestBody Inventory inventory) {
		clientService.saveClientInventories(client_clientId, inventory);
		return inventoryDAO.findInventoryByPrimaryKey(inventory.getInventoryId());
	}

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/quotes/{quote_quoteId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClientQuotes(@PathVariable Integer client_clientId, @PathVariable Integer related_quotes_quoteId) {
		clientService.deleteClientQuotes(client_clientId, related_quotes_quoteId);
	}

	/**
	 * View an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/purchaseOrders/{purchaseorder_purchaseOrderId}", method = RequestMethod.GET)
	@ResponseBody
	public PurchaseOrder loadClientPurchaseOrders(@PathVariable Integer client_clientId, @PathVariable Integer related_purchaseorders_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders_purchaseOrderId, -1, -1);

		return purchaseorder;
	}

	/**
	 * View an existing Inventory entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/inventories/{inventory_inventoryId}", method = RequestMethod.GET)
	@ResponseBody
	public Inventory loadClientInventories(@PathVariable Integer client_clientId, @PathVariable Integer related_inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId, -1, -1);

		return inventory;
	}

	/**
	 * Save an existing Quote entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/quotes", method = RequestMethod.PUT)
	@ResponseBody
	public Quote saveClientQuotes(@PathVariable Integer client_clientId, @RequestBody Quote quotes) {
		clientService.saveClientQuotes(client_clientId, quotes);
		return quoteDAO.findQuoteByPrimaryKey(quotes.getQuoteId());
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClient(@PathVariable Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId);
		clientService.deleteClient(client);
	}

	/**
	 * Show all Inventory entities by Client
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/inventories", method = RequestMethod.GET)
	@ResponseBody
	public List<Inventory> getClientInventories(@PathVariable Integer client_clientId) {
		return new java.util.ArrayList<Inventory>(clientDAO.findClientByPrimaryKey(client_clientId).getInventories());
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping(value = "/Client", method = RequestMethod.POST)
	@ResponseBody
	public Client newClient(@RequestBody Client client) {
		clientService.saveClient(client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Show all PurchaseOrder entities by Client
	 * 
	 */
	@RequestMapping(value = "/Client/{client_clientId}/purchaseOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<PurchaseOrder> getClientPurchaseOrders(@PathVariable Integer client_clientId) {
		return new java.util.ArrayList<PurchaseOrder>(clientDAO.findClientByPrimaryKey(client_clientId).getPurchaseOrders());
	}
}