package axi.source.service;

import axi.source.dao.ClientDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.PurchaseOrderDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Inventory entities
 * 
 */

@Service("InventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

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
	 * Instantiates a new InventoryServiceImpl.
	 *
	 */
	public InventoryServiceImpl() {
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public Inventory deleteInventoryClient(Integer inventory_inventoryId, Integer related_client_clientId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId, -1, -1);
		Client related_client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		inventory.setClient(null);
		related_client.getInventories().remove(inventory);
		inventory = inventoryDAO.store(inventory);
		inventoryDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		clientDAO.remove(related_client);
		clientDAO.flush();

		return inventory;
	}

	/**
	 * Return a count of all Inventory entity
	 * 
	 */
	@Transactional
	public Integer countInventorys() {
		return ((Long) inventoryDAO.createQuerySingleResult("select count(o) from Inventory o").getSingleResult()).intValue();
	}

	/**
	 * Return all Inventory entity
	 * 
	 */
	@Transactional
	public List<Inventory> findAllInventorys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Inventory>(inventoryDAO.findAllInventorys(startResult, maxRows));
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Inventory saveInventoryClient(Integer inventoryId, Client related_client) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventoryId, -1, -1);
		Client existingclient = clientDAO.findClientByPrimaryKey(related_client.getClientId());

		// copy into the existing record to preserve existing relationships
		if (existingclient != null) {
			existingclient.setClientId(related_client.getClientId());
			existingclient.setClientType(related_client.getClientType());
			existingclient.setClientName(related_client.getClientName());
			existingclient.setClientPhoneNum(related_client.getClientPhoneNum());
			existingclient.setClientExt(related_client.getClientExt());
			existingclient.setClientEmail(related_client.getClientEmail());
			existingclient.setClientAddress(related_client.getClientAddress());
			existingclient.setClientCity(related_client.getClientCity());
			existingclient.setPostalCode(related_client.getPostalCode());
			existingclient.setClientComment(related_client.getClientComment());
			related_client = existingclient;
		} else {
			related_client = clientDAO.store(related_client);
			clientDAO.flush();
		}

		inventory.setClient(related_client);
		related_client.getInventories().add(inventory);
		inventory = inventoryDAO.store(inventory);
		inventoryDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		return inventory;
	}

	/**
	 */
	@Transactional
	public Inventory findInventoryByPrimaryKey(Integer inventoryId) {
		return inventoryDAO.findInventoryByPrimaryKey(inventoryId);
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public Inventory saveInventoryPurchaseOrders(Integer inventoryId, PurchaseOrder related_purchaseorders) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventoryId, -1, -1);
		PurchaseOrder existingpurchaseOrders = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders.getPurchaseOrderId());

		// copy into the existing record to preserve existing relationships
		if (existingpurchaseOrders != null) {
			existingpurchaseOrders.setPurchaseOrderId(related_purchaseorders.getPurchaseOrderId());
			existingpurchaseOrders.setPurchaseOrderAddress(related_purchaseorders.getPurchaseOrderAddress());
			existingpurchaseOrders.setPurchaseOrderCreatedDate(related_purchaseorders.getPurchaseOrderCreatedDate());
			existingpurchaseOrders.setPurchaseOrderExpectedDate(related_purchaseorders.getPurchaseOrderExpectedDate());
			existingpurchaseOrders.setPurchaseOrderRecievedDate(related_purchaseorders.getPurchaseOrderRecievedDate());
			existingpurchaseOrders.setPurchaseOrderStatus(related_purchaseorders.getPurchaseOrderStatus());
			related_purchaseorders = existingpurchaseOrders;
		} else {
			related_purchaseorders = purchaseOrderDAO.store(related_purchaseorders);
			purchaseOrderDAO.flush();
		}

		inventory.getPurchaseOrders().add(related_purchaseorders);
		related_purchaseorders.getInventories().add(inventory);
		inventory = inventoryDAO.store(inventory);
		inventoryDAO.flush();

		related_purchaseorders = purchaseOrderDAO.store(related_purchaseorders);
		purchaseOrderDAO.flush();

		return inventory;
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@Transactional
	public void deleteInventory(Inventory inventory) {
		inventoryDAO.remove(inventory);
		inventoryDAO.flush();
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Inventory deleteInventoryWorkOrders(Integer inventory_inventoryId, Integer related_workorders_workOrderId) {
		WorkOrder related_workorders = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId, -1, -1);

		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId, -1, -1);

		related_workorders.getInventories().remove(inventory);
		inventory.getWorkOrders().remove(related_workorders);

		workOrderDAO.remove(related_workorders);
		workOrderDAO.flush();

		return inventory;
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@Transactional
	public void saveInventory(Inventory inventory) {
		Inventory existingInventory = inventoryDAO.findInventoryByPrimaryKey(inventory.getInventoryId());

		if (existingInventory != null) {
			if (existingInventory != inventory) {
				existingInventory.setInventoryId(inventory.getInventoryId());
				existingInventory.setInventoryProductName(inventory.getInventoryProductName());
				existingInventory.setInventoryName(inventory.getInventoryName());
				existingInventory.setInventoryPrice(inventory.getInventoryPrice());
				existingInventory.setInventoryStockLevel(inventory.getInventoryStockLevel());
				existingInventory.setInventoryUnit(inventory.getInventoryUnit());
				existingInventory.setInventoryLowThreshold(inventory.getInventoryLowThreshold());
				existingInventory.setInventoryLocation(inventory.getInventoryLocation());
			}
			inventory = inventoryDAO.store(existingInventory);
		} else {
			inventory = inventoryDAO.store(inventory);
		}
		inventoryDAO.flush();
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Inventory saveInventoryWorkOrders(Integer inventoryId, WorkOrder related_workorders) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventoryId, -1, -1);
		WorkOrder existingworkOrders = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders.getWorkOrderId());

		// copy into the existing record to preserve existing relationships
		if (existingworkOrders != null) {
			existingworkOrders.setWorkOrderId(related_workorders.getWorkOrderId());
			existingworkOrders.setWorkOrderScope(related_workorders.getWorkOrderScope());
			existingworkOrders.setWorkOrderAddress(related_workorders.getWorkOrderAddress());
			existingworkOrders.setWorkOrderCreatedOn(related_workorders.getWorkOrderCreatedOn());
			existingworkOrders.setWorkOrderExpectedEndDate(related_workorders.getWorkOrderExpectedEndDate());
			existingworkOrders.setWorkOrderEndDate(related_workorders.getWorkOrderEndDate());
			existingworkOrders.setWorkOrderStatus(related_workorders.getWorkOrderStatus());
			related_workorders = existingworkOrders;
		} else {
			related_workorders = workOrderDAO.store(related_workorders);
			workOrderDAO.flush();
		}

		related_workorders.getInventories().add(inventory);
		inventory.getWorkOrders().add(related_workorders);
		related_workorders = workOrderDAO.store(related_workorders);
		workOrderDAO.flush();

		inventory = inventoryDAO.store(inventory);
		inventoryDAO.flush();

		return inventory;
	}

	/**
	 * Load an existing Inventory entity
	 * 
	 */
	@Transactional
	public Set<Inventory> loadInventorys() {
		return inventoryDAO.findAllInventorys();
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public Inventory deleteInventoryPurchaseOrders(Integer inventory_inventoryId, Integer related_purchaseorders_purchaseOrderId) {
		Inventory inventory = inventoryDAO.findInventoryByPrimaryKey(inventory_inventoryId, -1, -1);
		PurchaseOrder related_purchaseorders = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders_purchaseOrderId, -1, -1);

		inventory.getPurchaseOrders().remove(related_purchaseorders);
		related_purchaseorders.getInventories().remove(inventory);
		inventory = inventoryDAO.store(inventory);
		inventoryDAO.flush();

		related_purchaseorders = purchaseOrderDAO.store(related_purchaseorders);
		purchaseOrderDAO.flush();

		purchaseOrderDAO.remove(related_purchaseorders);
		purchaseOrderDAO.flush();

		return inventory;
	}
}
