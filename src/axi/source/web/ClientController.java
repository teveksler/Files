package axi.source.web;

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
 * Spring MVC controller that handles CRUD requests for Client entities
 * 
 */

@Controller("ClientController")
public class ClientController {

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
	@RequestMapping("/selectClientQuotes")
	public ModelAndView selectClientQuotes(@RequestParam Integer client_clientId, @RequestParam Integer quotes_quoteId) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(quotes_quoteId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("quote", quote);
		mav.setViewName("client/quotes/viewQuotes.jsp");

		return mav;
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newClient")
	public ModelAndView newClient() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("client/editClient.jsp");

		return mav;
	}

	/**
	 * Show all Inventory entities by Client
	 * 
	 */
	@RequestMapping("/listClientInventories")
	public ModelAndView listClientInventories(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/inventories/listInventories.jsp");

		return mav;
	}

	/**
	 * Show all WorkOrder entities by Client
	 * 
	 */
	@RequestMapping("/listClientWorkOrders")
	public ModelAndView listClientWorkOrders(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/workorders/listWorkOrders.jsp");

		return mav;
	}

	/**
	 * View an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/selectClientPurchaseOrders")
	public ModelAndView selectClientPurchaseOrders(@RequestParam Integer client_clientId, @RequestParam Integer purchaseorders_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorders_purchaseOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("purchaseorder", purchaseorder);
		mav.setViewName("client/purchaseorders/viewPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Select the child PurchaseOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientPurchaseOrders")
	public ModelAndView confirmDeleteClientPurchaseOrders(@RequestParam Integer client_clientId, @RequestParam Integer related_purchaseorders_purchaseOrderId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders_purchaseOrderId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/purchaseorders/deletePurchaseOrders.jsp");

		return mav;
	}

	/**
	 * View an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/selectClientWorkOrders")
	public ModelAndView selectClientWorkOrders(@RequestParam Integer client_clientId, @RequestParam Integer workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorders_workOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("workorder", workorder);
		mav.setViewName("client/workorders/viewWorkOrders.jsp");

		return mav;
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/deleteClientWorkOrders")
	public ModelAndView deleteClientWorkOrders(@RequestParam Integer client_clientId, @RequestParam Integer related_workorders_workOrderId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientWorkOrders(client_clientId, related_workorders_workOrderId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select the Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClient")
	public ModelAndView confirmDeleteClient(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/deleteClient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Inventory entity
	 * 
	 */
	@RequestMapping("/editClientInventories")
	public ModelAndView editClientInventories(@RequestParam Integer client_clientId, @RequestParam Integer inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventories_inventoryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("inventory", inventory);
		mav.setViewName("client/inventories/editInventories.jsp");

		return mav;
	}

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	@RequestMapping("/deleteClientQuotes")
	public ModelAndView deleteClientQuotes(@RequestParam Integer client_clientId, @RequestParam Integer related_quotes_quoteId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientQuotes(client_clientId, related_quotes_quoteId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Create a new Quote entity
	 * 
	 */
	@RequestMapping("/newClientQuotes")
	public ModelAndView newClientQuotes(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("quote", new Quote());
		mav.addObject("newFlag", true);
		mav.setViewName("client/quotes/editQuotes.jsp");

		return mav;
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/saveClientPurchaseOrders")
	public ModelAndView saveClientPurchaseOrders(@RequestParam Integer client_clientId, @ModelAttribute PurchaseOrder purchaseorders) {
		Client parent_client = clientService.saveClientPurchaseOrders(client_clientId, purchaseorders);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Select the child Quote entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientQuotes")
	public ModelAndView confirmDeleteClientQuotes(@RequestParam Integer client_clientId, @RequestParam Integer related_quotes_quoteId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("quote", quoteDAO.findQuoteByPrimaryKey(related_quotes_quoteId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/quotes/deleteQuotes.jsp");

		return mav;
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping("/newClientInventories")
	public ModelAndView newClientInventories(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("inventory", new Inventory());
		mav.addObject("newFlag", true);
		mav.setViewName("client/inventories/editInventories.jsp");

		return mav;
	}

	/**
	 * Show all PurchaseOrder entities by Client
	 * 
	 */
	@RequestMapping("/listClientPurchaseOrders")
	public ModelAndView listClientPurchaseOrders(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/purchaseorders/listPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Show all Client entities
	 * 
	 */
	@RequestMapping("/indexClient")
	public ModelAndView listClients() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("clients", clientService.loadClients());

		mav.setViewName("client/listClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/editClientWorkOrders")
	public ModelAndView editClientWorkOrders(@RequestParam Integer client_clientId, @RequestParam Integer workorders_workOrderId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorders_workOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("workorder", workorder);
		mav.setViewName("client/workorders/editWorkOrders.jsp");

		return mav;
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/deleteClientPurchaseOrders")
	public ModelAndView deleteClientPurchaseOrders(@RequestParam Integer client_clientId, @RequestParam Integer related_purchaseorders_purchaseOrderId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientPurchaseOrders(client_clientId, related_purchaseorders_purchaseOrderId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/clientController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Entry point to show all Client entities
	 * 
	 */
	public String indexClient() {
		return "redirect:/indexClient";
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
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deleteClient")
	public String deleteClient(@RequestParam Integer clientIdKey) {
		Client client = clientDAO.findClientByPrimaryKey(clientIdKey);
		clientService.deleteClient(client);
		return "forward:/indexClient";
	}

	/**
	 * Save an existing Quote entity
	 * 
	 */
	@RequestMapping("/saveClientQuotes")
	public ModelAndView saveClientQuotes(@RequestParam Integer client_clientId, @ModelAttribute Quote quotes) {
		Client parent_client = clientService.saveClientQuotes(client_clientId, quotes);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveClient")
	public String saveClient(@ModelAttribute Client client) {
		clientService.saveClient(client);
		return "forward:/indexClient";
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editClient")
	public ModelAndView editClient(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/editClient.jsp");

		return mav;
	}

	/**
	 * Select an existing Client entity
	 * 
	 */
	@RequestMapping("/selectClient")
	public ModelAndView selectClient(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Edit an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/editClientPurchaseOrders")
	public ModelAndView editClientPurchaseOrders(@RequestParam Integer client_clientId, @RequestParam Integer purchaseorders_purchaseOrderId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorders_purchaseOrderId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("purchaseorder", purchaseorder);
		mav.setViewName("client/purchaseorders/editPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Select the child Inventory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientInventories")
	public ModelAndView confirmDeleteClientInventories(@RequestParam Integer client_clientId, @RequestParam Integer related_inventories_inventoryId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/inventories/deleteInventories.jsp");

		return mav;
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@RequestMapping("/saveClientWorkOrders")
	public ModelAndView saveClientWorkOrders(@RequestParam Integer client_clientId, @ModelAttribute WorkOrder workorders) {
		Client parent_client = clientService.saveClientWorkOrders(client_clientId, workorders);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * View an existing Inventory entity
	 * 
	 */
	@RequestMapping("/selectClientInventories")
	public ModelAndView selectClientInventories(@RequestParam Integer client_clientId, @RequestParam Integer inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventories_inventoryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("inventory", inventory);
		mav.setViewName("client/inventories/viewInventories.jsp");

		return mav;
	}

	/**
	 * Create a new WorkOrder entity
	 * 
	 */
	@RequestMapping("/newClientWorkOrders")
	public ModelAndView newClientWorkOrders(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("workorder", new WorkOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("client/workorders/editWorkOrders.jsp");

		return mav;
	}

	/**
	 * Show all Quote entities by Client
	 * 
	 */
	@RequestMapping("/listClientQuotes")
	public ModelAndView listClientQuotes(@RequestParam Integer clientIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(clientIdKey));
		mav.setViewName("client/quotes/listQuotes.jsp");

		return mav;
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping("/deleteClientInventories")
	public ModelAndView deleteClientInventories(@RequestParam Integer client_clientId, @RequestParam Integer related_inventories_inventoryId) {
		ModelAndView mav = new ModelAndView();

		Client client = clientService.deleteClientInventories(client_clientId, related_inventories_inventoryId);

		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping("/saveClientInventories")
	public ModelAndView saveClientInventories(@RequestParam Integer client_clientId, @ModelAttribute Inventory inventories) {
		Client parent_client = clientService.saveClientInventories(client_clientId, inventories);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("client", parent_client);
		mav.setViewName("client/viewClient.jsp");

		return mav;
	}

	/**
	 * Create a new PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/newClientPurchaseOrders")
	public ModelAndView newClientPurchaseOrders(@RequestParam Integer client_clientId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("purchaseorder", new PurchaseOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("client/purchaseorders/editPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Select the child WorkOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteClientWorkOrders")
	public ModelAndView confirmDeleteClientWorkOrders(@RequestParam Integer client_clientId, @RequestParam Integer related_workorders_workOrderId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("workorder", workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId));
		mav.addObject("client_clientId", client_clientId);
		mav.setViewName("client/workorders/deleteWorkOrders.jsp");

		return mav;
	}

	/**
	 * Edit an existing Quote entity
	 * 
	 */
	@RequestMapping("/editClientQuotes")
	public ModelAndView editClientQuotes(@RequestParam Integer client_clientId, @RequestParam Integer quotes_quoteId) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(quotes_quoteId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("client_clientId", client_clientId);
		mav.addObject("quote", quote);
		mav.setViewName("client/quotes/editQuotes.jsp");

		return mav;
	}
}