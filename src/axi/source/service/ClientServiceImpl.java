package axi.source.service;

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

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Client entities
 * 
 */

@Service("ClientService")
@Transactional
public class ClientServiceImpl implements ClientService {

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
	 * Instantiates a new ClientServiceImpl.
	 *
	 */
	public ClientServiceImpl() {
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@Transactional
	public Client deleteClientInventories(Integer client_clientId, Integer related_inventories_inventoryId) {
		Inventory related_inventories = inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_inventories.setClient(null);
		client.getInventories().remove(related_inventories);

		inventoryDAO.remove(related_inventories);
		inventoryDAO.flush();

		return client;
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@Transactional
	public Client saveClientInventories(Integer clientId, Inventory related_inventories) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
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

		related_inventories.setClient(client);
		client.getInventories().add(related_inventories);
		related_inventories = inventoryDAO.store(related_inventories);
		inventoryDAO.flush();

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 * Delete an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public Client deleteClientPurchaseOrders(Integer client_clientId, Integer related_purchaseorders_purchaseOrderId) {
		PurchaseOrder related_purchaseorders = purchaseOrderDAO.findPurchaseOrderByPrimaryKey(related_purchaseorders_purchaseOrderId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_purchaseorders.getClients().remove(client);
		client.getPurchaseOrders().remove(related_purchaseorders);

		purchaseOrderDAO.remove(related_purchaseorders);
		purchaseOrderDAO.flush();

		return client;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public void saveClient(Client client) {
		Client existingClient = clientDAO.findClientByPrimaryKey(client.getClientId());

		if (existingClient != null) {
			if (existingClient != client) {
				existingClient.setClientId(client.getClientId());
				existingClient.setClientType(client.getClientType());
				existingClient.setClientName(client.getClientName());
				existingClient.setClientPhoneNum(client.getClientPhoneNum());
				existingClient.setClientExt(client.getClientExt());
				existingClient.setClientEmail(client.getClientEmail());
				existingClient.setClientAddress(client.getClientAddress());
				existingClient.setClientCity(client.getClientCity());
				existingClient.setPostalCode(client.getPostalCode());
				existingClient.setClientComment(client.getClientComment());
			}
			client = clientDAO.store(existingClient);
		} else {
			client = clientDAO.store(client);
		}
		clientDAO.flush();
	}

	/**
	 * Load an existing Client entity
	 * 
	 */
	@Transactional
	public Set<Client> loadClients() {
		return clientDAO.findAllClients();
	}

	/**
	 * Save an existing PurchaseOrder entity
	 * 
	 */
	@Transactional
	public Client saveClientPurchaseOrders(Integer clientId, PurchaseOrder related_purchaseorders) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
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

		related_purchaseorders.getClients().add(client);
		client.getPurchaseOrders().add(related_purchaseorders);
		related_purchaseorders = purchaseOrderDAO.store(related_purchaseorders);
		purchaseOrderDAO.flush();

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	@Transactional
	public Client deleteClientQuotes(Integer client_clientId, Integer related_quotes_quoteId) {
		Quote related_quotes = quoteDAO.findQuoteByPrimaryKey(related_quotes_quoteId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_quotes.setClient(null);
		client.getQuotes().remove(related_quotes);

		quoteDAO.remove(related_quotes);
		quoteDAO.flush();

		return client;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public void deleteClient(Client client) {
		clientDAO.remove(client);
		clientDAO.flush();
	}

	/**
	 * Save an existing Quote entity
	 * 
	 */
	@Transactional
	public Client saveClientQuotes(Integer clientId, Quote related_quotes) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
		Quote existingquotes = quoteDAO.findQuoteByPrimaryKey(related_quotes.getQuoteId());

		// copy into the existing record to preserve existing relationships
		if (existingquotes != null) {
			existingquotes.setQuoteId(related_quotes.getQuoteId());
			existingquotes.setQuotePdf(related_quotes.getQuotePdf());
			existingquotes.setQuoteDate(related_quotes.getQuoteDate());
			related_quotes = existingquotes;
		} else {
			related_quotes = quoteDAO.store(related_quotes);
			quoteDAO.flush();
		}

		related_quotes.setClient(client);
		client.getQuotes().add(related_quotes);
		related_quotes = quoteDAO.store(related_quotes);
		quoteDAO.flush();

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 * Return a count of all Client entity
	 * 
	 */
	@Transactional
	public Integer countClients() {
		return ((Long) clientDAO.createQuerySingleResult("select count(o) from Client o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Client deleteClientWorkOrders(Integer client_clientId, Integer related_workorders_workOrderId) {
		WorkOrder related_workorders = workOrderDAO.findWorkOrderByPrimaryKey(related_workorders_workOrderId, -1, -1);

		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		related_workorders.setClient(null);
		client.getWorkOrders().remove(related_workorders);

		workOrderDAO.remove(related_workorders);
		workOrderDAO.flush();

		return client;
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Client saveClientWorkOrders(Integer clientId, WorkOrder related_workorders) {
		Client client = clientDAO.findClientByPrimaryKey(clientId, -1, -1);
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

		related_workorders.setClient(client);
		client.getWorkOrders().add(related_workorders);
		related_workorders = workOrderDAO.store(related_workorders);
		workOrderDAO.flush();

		client = clientDAO.store(client);
		clientDAO.flush();

		return client;
	}

	/**
	 */
	@Transactional
	public Client findClientByPrimaryKey(Integer clientId) {
		return clientDAO.findClientByPrimaryKey(clientId);
	}

	/**
	 * Return all Client entity
	 * 
	 */
	@Transactional
	public List<Client> findAllClients(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Client>(clientDAO.findAllClients(startResult, maxRows));
	}
}
