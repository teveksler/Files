package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Inventory;
import axi.source.domain.PurchaseOrder;
import axi.source.domain.Quote;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Client entities
 * 
 */
public interface ClientService {

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	public Client deleteClientInventories(Integer client_clientId, Integer related_inventories_inventoryId);

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	public Client saveClientInventories(Integer clientId, Inventory related_inventories);

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	public Client deleteClientPurchaseOrders(Integer client_clientId_1, Integer related_purchaseorders_purchaseOrderId);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public void saveClient(Client client);

	/**
	 * Load an existing Client entity
	 * 
	 */
	public Set<Client> loadClients();

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	public Client saveClientPurchaseOrders(Integer clientId_1, PurchaseOrder related_purchaseorders);

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	public Client deleteClientQuotes(Integer client_clientId_2, Integer related_quotes_quoteId);

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public void deleteClient(Client client_1);

	/**
	 * Save an existing Quote entity
	 * 
	 */
	public Client saveClientQuotes(Integer clientId_2, Quote related_quotes);

	/**
	 * Return a count of all Client entity
	 * 
	 */
	public Integer countClients();

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	public Client deleteClientWorkOrders(Integer client_clientId_3, Integer related_workorders_workOrderId);

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	public Client saveClientWorkOrders(Integer clientId_3, WorkOrder related_workorders);

	/**
	 */
	public Client findClientByPrimaryKey(Integer clientId_4);

	/**
	 * Return all Client entity
	 * 
	 */
	public List<Client> findAllClients(Integer startResult, Integer maxRows);
}