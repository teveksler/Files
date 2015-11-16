package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Employee;
import axi.source.domain.Inventory;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for WorkOrder entities
 * 
 */
public interface WorkOrderService {

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	public void deleteWorkOrder(WorkOrder workorder);

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	public WorkOrder deleteWorkOrderEmployees(Integer workorder_workOrderId, Integer related_employees_employeeId);

	/**
	 * Load an existing WorkOrder entity
	 * 
	 */
	public Set<WorkOrder> loadWorkOrders();

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public WorkOrder deleteWorkOrderClient(Integer workorder_workOrderId_1, Integer related_client_clientId);

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	public void saveWorkOrder(WorkOrder workorder_1);

	/**
	 * Return all WorkOrder entity
	 * 
	 */
	public List<WorkOrder> findAllWorkOrders(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	public WorkOrder deleteWorkOrderInventories(Integer workorder_workOrderId_2, Integer related_inventories_inventoryId);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public WorkOrder saveWorkOrderClient(Integer workOrderId, Client related_client);

	/**
	 */
	public WorkOrder findWorkOrderByPrimaryKey(Integer workOrderId_1);

	/**
	 * Return a count of all WorkOrder entity
	 * 
	 */
	public Integer countWorkOrders();

	/**
	 * Save an existing Employee entity
	 * 
	 */
	public WorkOrder saveWorkOrderEmployees(Integer workOrderId_2, Employee related_employees);

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	public WorkOrder saveWorkOrderInventories(Integer workOrderId_3, Inventory related_inventories);
}