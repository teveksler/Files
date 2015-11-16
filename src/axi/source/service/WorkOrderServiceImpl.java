package axi.source.service;

import axi.source.dao.ClientDAO;
import axi.source.dao.EmployeeDAO;
import axi.source.dao.InventoryDAO;
import axi.source.dao.WorkOrderDAO;

import axi.source.domain.Client;
import axi.source.domain.Employee;
import axi.source.domain.Inventory;
import axi.source.domain.WorkOrder;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for WorkOrder entities
 * 
 */

@Service("WorkOrderService")
@Transactional
public class WorkOrderServiceImpl implements WorkOrderService {

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

	/**
	 * DAO injected by Spring that manages Employee entities
	 * 
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * DAO injected by Spring that manages Inventory entities
	 * 
	 */
	@Autowired
	private InventoryDAO inventoryDAO;

	/**
	 * DAO injected by Spring that manages WorkOrder entities
	 * 
	 */
	@Autowired
	private WorkOrderDAO workOrderDAO;

	/**
	 * Instantiates a new WorkOrderServiceImpl.
	 *
	 */
	public WorkOrderServiceImpl() {
	}

	/**
	 * Delete an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public void deleteWorkOrder(WorkOrder workorder) {
		workOrderDAO.remove(workorder);
		workOrderDAO.flush();
	}

	/**
	 * Delete an existing Employee entity
	 * 
	 */
	@Transactional
	public WorkOrder deleteWorkOrderEmployees(Integer workorder_workOrderId, Integer related_employees_employeeId) {
		Employee related_employees = employeeDAO.findEmployeeByPrimaryKey(related_employees_employeeId, -1, -1);

		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId, -1, -1);

		related_employees.getWorkOrders().remove(workorder);
		workorder.getEmployees().remove(related_employees);

		employeeDAO.remove(related_employees);
		employeeDAO.flush();

		return workorder;
	}

	/**
	 * Load an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public Set<WorkOrder> loadWorkOrders() {
		return workOrderDAO.findAllWorkOrders();
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public WorkOrder deleteWorkOrderClient(Integer workorder_workOrderId, Integer related_client_clientId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId, -1, -1);
		Client related_client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		workorder.setClient(null);
		related_client.getWorkOrders().remove(workorder);
		workorder = workOrderDAO.store(workorder);
		workOrderDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		clientDAO.remove(related_client);
		clientDAO.flush();

		return workorder;
	}

	/**
	 * Save an existing WorkOrder entity
	 * 
	 */
	@Transactional
	public void saveWorkOrder(WorkOrder workorder) {
		WorkOrder existingWorkOrder = workOrderDAO.findWorkOrderByPrimaryKey(workorder.getWorkOrderId());

		if (existingWorkOrder != null) {
			if (existingWorkOrder != workorder) {
				existingWorkOrder.setWorkOrderId(workorder.getWorkOrderId());
				existingWorkOrder.setWorkOrderScope(workorder.getWorkOrderScope());
				existingWorkOrder.setWorkOrderAddress(workorder.getWorkOrderAddress());
				existingWorkOrder.setWorkOrderCreatedOn(workorder.getWorkOrderCreatedOn());
				existingWorkOrder.setWorkOrderExpectedEndDate(workorder.getWorkOrderExpectedEndDate());
				existingWorkOrder.setWorkOrderEndDate(workorder.getWorkOrderEndDate());
				existingWorkOrder.setWorkOrderStatus(workorder.getWorkOrderStatus());
			}
			workorder = workOrderDAO.store(existingWorkOrder);
		} else {
			workorder = workOrderDAO.store(workorder);
		}
		workOrderDAO.flush();
	}

	/**
	 * Return all WorkOrder entity
	 * 
	 */
	@Transactional
	public List<WorkOrder> findAllWorkOrders(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<WorkOrder>(workOrderDAO.findAllWorkOrders(startResult, maxRows));
	}

	/**
	 * Delete an existing Inventory entity
	 * 
	 */
	@Transactional
	public WorkOrder deleteWorkOrderInventories(Integer workorder_workOrderId, Integer related_inventories_inventoryId) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workorder_workOrderId, -1, -1);
		Inventory related_inventories = inventoryDAO.findInventoryByPrimaryKey(related_inventories_inventoryId, -1, -1);

		workorder.getInventories().remove(related_inventories);
		related_inventories.getWorkOrders().remove(workorder);
		workorder = workOrderDAO.store(workorder);
		workOrderDAO.flush();

		related_inventories = inventoryDAO.store(related_inventories);
		inventoryDAO.flush();

		inventoryDAO.remove(related_inventories);
		inventoryDAO.flush();

		return workorder;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public WorkOrder saveWorkOrderClient(Integer workOrderId, Client related_client) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workOrderId, -1, -1);
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

		workorder.setClient(related_client);
		related_client.getWorkOrders().add(workorder);
		workorder = workOrderDAO.store(workorder);
		workOrderDAO.flush();

		related_client = clientDAO.store(related_client);
		clientDAO.flush();

		return workorder;
	}

	/**
	 */
	@Transactional
	public WorkOrder findWorkOrderByPrimaryKey(Integer workOrderId) {
		return workOrderDAO.findWorkOrderByPrimaryKey(workOrderId);
	}

	/**
	 * Return a count of all WorkOrder entity
	 * 
	 */
	@Transactional
	public Integer countWorkOrders() {
		return ((Long) workOrderDAO.createQuerySingleResult("select count(o) from WorkOrder o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Employee entity
	 * 
	 */
	@Transactional
	public WorkOrder saveWorkOrderEmployees(Integer workOrderId, Employee related_employees) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workOrderId, -1, -1);
		Employee existingemployees = employeeDAO.findEmployeeByPrimaryKey(related_employees.getEmployeeId());

		// copy into the existing record to preserve existing relationships
		if (existingemployees != null) {
			existingemployees.setEmployeeId(related_employees.getEmployeeId());
			existingemployees.setEmployeeName(related_employees.getEmployeeName());
			existingemployees.setEmployeePhoneNum(related_employees.getEmployeePhoneNum());
			existingemployees.setEmployeeEmail(related_employees.getEmployeeEmail());
			existingemployees.setEmployeeComment(related_employees.getEmployeeComment());
			related_employees = existingemployees;
		} else {
			related_employees = employeeDAO.store(related_employees);
			employeeDAO.flush();
		}

		related_employees.getWorkOrders().add(workorder);
		workorder.getEmployees().add(related_employees);
		related_employees = employeeDAO.store(related_employees);
		employeeDAO.flush();

		workorder = workOrderDAO.store(workorder);
		workOrderDAO.flush();

		return workorder;
	}

	/**
	 * Save an existing Inventory entity
	 * 
	 */
	@Transactional
	public WorkOrder saveWorkOrderInventories(Integer workOrderId, Inventory related_inventories) {
		WorkOrder workorder = workOrderDAO.findWorkOrderByPrimaryKey(workOrderId, -1, -1);
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

		workorder.getInventories().add(related_inventories);
		related_inventories.getWorkOrders().add(workorder);
		workorder = workOrderDAO.store(workorder);
		workOrderDAO.flush();

		related_inventories = inventoryDAO.store(related_inventories);
		inventoryDAO.flush();

		return workorder;
	}
}
