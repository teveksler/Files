package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Inventory entities
 * 
 */
public interface InventoryService {

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public Inventory deleteInventoryClient(Integer inventory_inventoryId, Integer related_client_clientId);

	/**
	 * Return a count of all Inventory entity
	 * 
	 */
	public Integer countInventorys();

	/**
	 * Return all Inventory entity
	 * 
	 */
	public List<Inventory> findAllInventorys(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Inventory saveInventoryClient(Integer inventoryId, Client related_client);

	/**
	 */
	public Inventory findInventoryByPrimaryKey(Integer inventoryId_1);

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	public Inventory saveInventoryPurchaseOrders(Integer inventoryId_2, PurchaseOrder related_purchaseorders);

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	public void deleteInventory(Inventory inventory);

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	public Inventory deleteInventoryWorkOrders(Integer inventory_inventoryId_1, Integer related_workorders_workOrderId);

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	public void saveInventory(Inventory inventory_1);

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	public Inventory saveInventoryWorkOrders(Integer inventoryId_3, WorkOrder related_workorders);

	/**
	 * Load an existing Inventory entity
	 * 
	 */
	public Set<Inventory> loadInventorys();

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	public Inventory deleteInventoryPurchaseOrders(Integer inventory_inventoryId_2, Integer related_purchaseorders_purchaseOrderId);
}