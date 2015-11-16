package axi.source.service;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for PurchaseOrder entities
 * 
 */

@Service("PurchaseOrderService")
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

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
	 * Instantiates a new PurchaseOrderServiceImpl.
	 *
	 */
	public PurchaseOrderServiceImpl() {
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@Transactional
	public PurchaseOrder deletePurchaseOrderInventories(Integer purchaseorder_purchaseOrderId, Integer related_inventories_inventoryId) {
		Inventory related_inventories = inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId, -1, -1);

		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder_purchaseOrderId, -1, -1);

		related_inventories.getPurchaseOrders().remove(purchaseorder);
		purchaseorder.getInventories().remove(related_inventories);

		inventoryDAO.remove(related_inventories);
		inventoryDAO.flush();

		return purchaseorder;
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public void savePurchaseOrder(PurchaseOrder purchaseorder) {
		PurchaseOrder existingPurchaseOrder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder.getPurchaseOrderId());

		if (existingPurchaseOrder != null) {
			if (existingPurchaseOrder != purchaseorder) {
				existingPurchaseOrder.setPurchaseOrderId(purchaseorder.getPurchaseOrderId());
				existingPurchaseOrder.setPurchaseOrderAddress(purchaseorder.getPurchaseOrderAddress());
				existingPurchaseOrder.setPurchaseOrderCreatedDate(purchaseorder.getPurchaseOrderCreatedDate());
				existingPurchaseOrder.setPurchaseOrderExpectedDate(purchaseorder.getPurchaseOrderExpectedDate());
				existingPurchaseOrder.setPurchaseOrderRecievedDate(purchaseorder.getPurchaseOrderRecievedDate());
				existingPurchaseOrder.setPurchaseOrderStatus(purchaseorder.getPurchaseOrderStatus());
			}
			purchaseorder = purchaseOrderDAO.store(existingPurchaseOrder);
		} else {
			purchaseorder = purchaseOrderDAO.store(purchaseorder);
		}
		purchaseOrderDAO.flush();
	}

	/**
	 * Return a count of all PurchaseOrder entity
	 * 
	 */
	@Transactional
	public Integer countPurchaseOrders() {
		return ((Long) purchaseOrderDAO.createQuerySingleResult("select count(o) from PurchaseOrder o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public PurchaseOrder deletePurchaseOrderClients(Integer purchaseorder_purchaseOrderId, Integer related_clients_clientId) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseorder_purchaseOrderId, -1, -1);
		Client related_clients = clientDAO.findClientByPrimaryKey(related_clients_clientId, -1, -1);

		purchaseorder.getClients().remove(related_clients);
		related_clients.getPurchaseOrders().remove(purchaseorder);
		purchaseorder = purchaseOrderDAO.store(purchaseorder);
		purchaseOrderDAO.flush();

		related_clients = clientDAO.store(related_clients);
		clientDAO.flush();

		clientDAO.remove(related_clients);
		clientDAO.flush();

		return purchaseorder;
	}

	/**
	 */
	@Transactional
	public PurchaseOrder findPurchaseOrderByPrimaryKey(Integer purchaseOrderId) {
		return purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderId);
	}

	/**
	 * Load an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public Set<PurchaseOrder> loadPurchaseOrders() {
		return purchaseOrderDAO.findAllPurchaseOrders();
	}

	/**
	 * Return all PurchaseOrder entity
	 * 
	 */
	@Transactional
	public List<PurchaseOrder> findAllPurchaseOrders(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<PurchaseOrder>(purchaseOrderDAO.findAllPurchaseOrders(startResult, maxRows));
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public void deletePurchaseOrder(PurchaseOrder purchaseorder) {
		purchaseOrderDAO.remove(purchaseorder);
		purchaseOrderDAO.flush();
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@Transactional
	public PurchaseOrder savePurchaseOrderInventories(Integer purchaseOrderId, Inventory related_inventories) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderId, -1, -1);
		Inventory existinginventories = inventoryDAO.findInventoryByPrimaryKey(related_inventories.getInventoryId());

		// copy into the existing record to preserve existing relationships
		if (existinginventories != null) {
			existinginventories.setInventoryId(related_inventories.getInventoryId());
			existinginventories.setInventoryProductName(related_inventories.getInventoryProductName());
			existinginventories.setInventoryName(related_inventories.getInventoryName());
			existinginventories.setInventoryPrice(related_inventories.getInventoryPrice());
			existinginventories.setInventoryStockLevel(related_inventories.getInventoryStockLevel());
			existinginventories.setInventoryUnit(related_inventories.getInventoryUnit());
			existinginventories.setInventoryLowThreshold(related_inventories.getInventoryLowThreshold());
			existinginventories.setInventoryLocation(related_inventories.getInventoryLocation());
			related_inventories = existinginventories;
		} else {
			related_inventories = inventoryDAO.store(related_inventories);
			inventoryDAO.flush();
		}

		related_inventories.getPurchaseOrders().add(purchaseorder);
		purchaseorder.getInventories().add(related_inventories);
		related_inventories = inventoryDAO.store(related_inventories);
		inventoryDAO.flush();

		purchaseorder = purchaseOrderDAO.store(purchaseorder);
		purchaseOrderDAO.flush();

		return purchaseorder;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public PurchaseOrder savePurchaseOrderClients(Integer purchaseOrderId, Client related_clients) {
		PurchaseOrder purchaseorder = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(purchaseOrderId, -1, -1);
		Client existingclients = clientDAO.findClientByPrimaryKey(related_clients.getClientId());

		// copy into the existing record to preserve existing relationships
		if (existingclients != null) {
			existingclients.setClientId(related_clients.getClientId());
			existingclients.setClientType(related_clients.getClientType());
			existingclients.setClientName(related_clients.getClientName());
			existingclients.setClientPhoneNum(related_clients.getClientPhoneNum());
			existingclients.setClientExt(related_clients.getClientExt());
			existingclients.setClientEmail(related_clients.getClientEmail());
			existingclients.setClientAddress(related_clients.getClientAddress());
			existingclients.setClientCity(related_clients.getClientCity());
			existingclients.setPostalCode(related_clients.getPostalCode());
			existingclients.setClientComment(related_clients.getClientComment());
			related_clients = existingclients;
		} else {
			related_clients = clientDAO.store(related_clients);
			clientDAO.flush();
		}

		purchaseorder.getClients().add(related_clients);
		related_clients.getPurchaseOrders().add(purchaseorder);
		purchaseorder = purchaseOrderDAO.store(purchaseorder);
		purchaseOrderDAO.flush();

		related_clients = clientDAO.store(related_clients);
		clientDAO.flush();

		return purchaseorder;
	}
}
