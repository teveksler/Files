package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for PurchaseOrder entities
 * 
 */
public interface PurchaseOrderService {

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	public PurchaseOrder deletePurchaseOrderInventories(Integer purchaseorder_purchaseOrderId, Integer related_inventories_inventoryId);

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	public void savePurchaseOrder(PurchaseOrder purchaseorder);

	/**
	 * Return a count of all PurchaseOrder entity
	 * 
	 */
	public Integer countPurchaseOrders();

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public PurchaseOrder deletePurchaseOrderClients(Integer purchaseorder_purchaseOrderId_1, Integer related_clients_clientId);

	/**
	 */
	public PurchaseOrder findPurchaseOrderByPrimaryKey(Integer purchaseOrderId);

	/**
	 * Load an existing PurchaseOrder entity
	 * 
	 */
	public Set<PurchaseOrder> loadPurchaseOrders();

	/**
	 * Return all PurchaseOrder entity
	 * 
	 */
	public List<PurchaseOrder> findAllPurchaseOrders(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	public void deletePurchaseOrder(PurchaseOrder purchaseorder_1);

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	public PurchaseOrder savePurchaseOrderInventories(Integer purchaseOrderId_1, Inventory related_inventories);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public PurchaseOrder savePurchaseOrderClients(Integer purchaseOrderId_2, Client related_clients);
}