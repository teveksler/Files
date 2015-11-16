package axi.source.dao;

import axi.source.domain.WorkOrder;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage WorkOrder entities.
 * 
 */
public interface WorkOrderDAO extends JpaDao<WorkOrder> {

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOn
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOn(java.util.Calendar workOrderCreatedOn) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOn
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOn(Calendar workOrderCreatedOn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllWorkOrders
	 *
	 */
	public Set<WorkOrder> findAllWorkOrders() throws DataAccessException;

	/**
	 * JPQL Query - findAllWorkOrders
	 *
	 */
	public Set<WorkOrder> findAllWorkOrders(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateBefore
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateBefore(java.util.Calendar workOrderEndDate) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateBefore
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateBefore(Calendar workOrderEndDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDate
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDate(java.util.Calendar workOrderEndDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDate
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDate(Calendar workOrderEndDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateBefore
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateBefore(java.util.Calendar workOrderExpectedEndDate) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateBefore
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateBefore(Calendar workOrderExpectedEndDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnAfter
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnAfter(java.util.Calendar workOrderCreatedOn_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnAfter
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnAfter(Calendar workOrderCreatedOn_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddressContaining
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderAddressContaining(String workOrderAddress) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddressContaining
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderAddressContaining(String workOrderAddress, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatus
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderStatus(String workOrderStatus) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatus
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderStatus(String workOrderStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateAfter
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateAfter(java.util.Calendar workOrderExpectedEndDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateAfter
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateAfter(Calendar workOrderExpectedEndDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScope
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderScope(String workOrderScope) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScope
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderScope(String workOrderScope, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScopeContaining
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderScopeContaining(String workOrderScope_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScopeContaining
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderScopeContaining(String workOrderScope_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnBefore
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnBefore(java.util.Calendar workOrderCreatedOn_2) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnBefore
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnBefore(Calendar workOrderCreatedOn_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddress
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderAddress(String workOrderAddress_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddress
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderAddress(String workOrderAddress_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDate
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDate(java.util.Calendar workOrderExpectedEndDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDate
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDate(Calendar workOrderExpectedEndDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderId
	 *
	 */
	public WorkOrder findWorkOrderByWorkOrderId(Integer workOrderId) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderId
	 *
	 */
	public WorkOrder findWorkOrderByWorkOrderId(Integer workOrderId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateAfter
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateAfter(java.util.Calendar workOrderEndDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateAfter
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateAfter(Calendar workOrderEndDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByPrimaryKey
	 *
	 */
	public WorkOrder findWorkOrderByPrimaryKey(Integer workOrderId_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByPrimaryKey
	 *
	 */
	public WorkOrder findWorkOrderByPrimaryKey(Integer workOrderId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatusContaining
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderStatusContaining(String workOrderStatus_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatusContaining
	 *
	 */
	public Set<WorkOrder> findWorkOrderByWorkOrderStatusContaining(String workOrderStatus_1, int startResult, int maxRows) throws DataAccessException;

}