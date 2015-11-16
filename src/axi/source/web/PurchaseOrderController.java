package axi.source.web;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;

import axi.source.service.PurchaseOrderService;

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
 * Spring MVC controller that handles CRUD requests for PurchaseOrder entities
 * 
 */

@Controller("PurchaseOrderController")
public class PurchaseOrderController {

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
	 * Entry point to show all PurchaseOrder entities
	 * 
	 */
	public String indexPurchaseOrder() {
		return "redirect:/indexPurchaseOrder";
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@RequestMapping("/deletePurchaseOrderInventories")
	public ModelAndView deletePurchaseOrderInventories(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer related_inventories_inventoryId) {
		ModelAndView mav = new ModelAndView();

		PurchaseOrder purchaseorder = purchaseOrderService.deletePurchaseOrderInventories(purchaseorder_purchaseOrderId, related_inventories_inventoryId);

		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("purchaseorder", purchaseorder);
		mav.setViewName("purchaseorder/viewPurchaseOrder.jsp");

		return mav;
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePurchaseOrderClients")
	public ModelAndView confirmDeletePurchaseOrderClients(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer related_clients_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client", clientDAO.findClientByPrimaryKey(related_clients_clientId));
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.setViewName("purchaseorder/clients/deleteClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Inventory entity
	 * 
	 */
	@RequestMapping("/editPurchaseOrderInventories")
	public ModelAndView editPurchaseOrderInventories(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventories_inventoryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("inventory", inventory);
		mav.setViewName("purchaseorder/inventories/editInventories.jsp");

		return mav;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deletePurchaseOrderClients")
	public ModelAndView deletePurchaseOrderClients(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer related_clients_clientId) {
		ModelAndView mav = new ModelAndView();

		PurchaseOrder purchaseorder = purchaseOrderService.deletePurchaseOrderClients(purchaseorder_purchaseOrderId, related_clients_clientId);

		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("purchaseorder", purchaseorder);
		mav.setViewName("purchaseorder/viewPurchaseOrder.jsp");

		return mav;
	}

	/**
	 * Select an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/selectPurchaseOrder")
	public ModelAndView selectPurchaseOrder(@RequestParam Integer purchaseOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderIdKey));
		mav.setViewName("purchaseorder/viewPurchaseOrder.jsp");

		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/savePurchaseOrderClients")
	public ModelAndView savePurchaseOrderClients(@RequestParam Integer purchaseorder_purchaseOrderId, @ModelAttribute Client clients) {
		PurchaseOrder parent_purchaseorder = purchaseOrderService.savePurchaseOrderClients(purchaseorder_purchaseOrderId, clients);

		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("purchaseorder", parent_purchaseorder);
		mav.setViewName("purchaseorder/viewPurchaseOrder.jsp");

		return mav;
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectPurchaseOrderClients")
	public ModelAndView selectPurchaseOrderClients(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer clients_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(clients_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("client", client);
		mav.setViewName("purchaseorder/clients/viewClients.jsp");

		return mav;
	}

	/**
	 * Create a new Inventory entity
	 * 
	 */
	@RequestMapping("/newPurchaseOrderInventories")
	public ModelAndView newPurchaseOrderInventories(@RequestParam Integer purchaseorder_purchaseOrderId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("inventory", new Inventory());
		mav.addObject("newFlag", true);
		mav.setViewName("purchaseorder/inventories/editInventories.jsp");

		return mav;
	}

	/**
	 * Show all Inventory entities by PurchaseOrder
	 * 
	 */
	@RequestMapping("/listPurchaseOrderInventories")
	public ModelAndView listPurchaseOrderInventories(@RequestParam Integer purchaseOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderIdKey));
		mav.setViewName("purchaseorder/inventories/listInventories.jsp");

		return mav;
	}

	/**
	 * Select the PurchaseOrder entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePurchaseOrder")
	public ModelAndView confirmDeletePurchaseOrder(@RequestParam Integer purchaseOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderIdKey));
		mav.setViewName("purchaseorder/deletePurchaseOrder.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/purchaseorderController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all PurchaseOrder entities
	 * 
	 */
	@RequestMapping("/indexPurchaseOrder")
	public ModelAndView listPurchaseOrders() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorders", purchaseOrderService.loadPurchaseOrders());

		mav.setViewName("purchaseorder/listPurchaseOrders.jsp");

		return mav;
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@RequestMapping("/savePurchaseOrderInventories")
	public ModelAndView savePurchaseOrderInventories(@RequestParam Integer purchaseorder_purchaseOrderId, @ModelAttribute Inventory inventories) {
		PurchaseOrder parent_purchaseorder = purchaseOrderService.savePurchaseOrderInventories(purchaseorder_purchaseOrderId, inventories);

		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("purchaseorder", parent_purchaseorder);
		mav.setViewName("purchaseorder/viewPurchaseOrder.jsp");

		return mav;
	}

	/**
	 * Select the child Inventory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePurchaseOrderInventories")
	public ModelAndView confirmDeletePurchaseOrderInventories(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer related_inventories_inventoryId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("inventory", inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId));
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.setViewName("purchaseorder/inventories/deleteInventories.jsp");

		return mav;
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editPurchaseOrderClients")
	public ModelAndView editPurchaseOrderClients(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer clients_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(clients_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("client", client);
		mav.setViewName("purchaseorder/clients/editClients.jsp");

		return mav;
	}

	/**
	 * Edit an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/editPurchaseOrder")
	public ModelAndView editPurchaseOrder(@RequestParam Integer purchaseOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderIdKey));
		mav.setViewName("purchaseorder/editPurchaseOrder.jsp");

		return mav;
	}

	/**
	 * Create a new PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/newPurchaseOrder")
	public ModelAndView newPurchaseOrder() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", new PurchaseOrder());
		mav.addObject("newFlag", true);
		mav.setViewName("purchaseorder/editPurchaseOrder.jsp");

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
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newPurchaseOrderClients")
	public ModelAndView newPurchaseOrderClients(@RequestParam Integer purchaseorder_purchaseOrderId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("purchaseorder/clients/editClients.jsp");

		return mav;
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/savePurchaseOrder")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseorder) {
		purchaseOrderService.savePurchaseOrder(purchaseorder);
		return "forward:/indexPurchaseOrder";
	}

	/**
	 * Show all Client entities by PurchaseOrder
	 * 
	 */
	@RequestMapping("/listPurchaseOrderClients")
	public ModelAndView listPurchaseOrderClients(@RequestParam Integer purchaseOrderIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("purchaseorder", purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderIdKey));
		mav.setViewName("purchaseorder/clients/listClients.jsp");

		return mav;
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@RequestMapping("/deletePurchaseOrder")
	public String deletePurchaseOrder(@RequestParam Integer purchaseOrderIdKey) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderIdKey);
		purchaseOrderService.deletePurchaseOrder(purchaseorder);
		return "forward:/indexPurchaseOrder";
	}

	/**
	 * View an existing Inventory entity
	 * 
	 */
	@RequestMapping("/selectPurchaseOrderInventories")
	public ModelAndView selectPurchaseOrderInventories(@RequestParam Integer purchaseorder_purchaseOrderId, @RequestParam Integer inventories_inventoryId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventories_inventoryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("purchaseorder_purchaseOrderId", purchaseorder_purchaseOrderId);
		mav.addObject("inventory", inventory);
		mav.setViewName("purchaseorder/inventories/viewInventories.jsp");

		return mav;
	}
}