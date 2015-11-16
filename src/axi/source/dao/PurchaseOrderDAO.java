package axi.source.dao;

import axi.source.domain.PurchaseOrder;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage PurchaseOrder entities.
 * 
 */
public interface PurchaseOrderDAO extends JpaDao<PurchaseOrder> {

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateBefore
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateBefore(java.util.Calendar purchaseOrderExpectedDate) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateBefore
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateBefore(Calendar purchaseOrderExpectedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDate
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDate(java.util.Calendar purchaseOrderRecievedDate) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDate
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDate(Calendar purchaseOrderRecievedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatus
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatus(String purchaseOrderStatus) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatus
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatus(String purchaseOrderStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPurchaseOrders
	 *
	 */
	public Set<PurchaseOrder> findAllPurchaseOrders() throws DataAccessException;

	/**
	 * JPQL Query - findAllPurchaseOrders
	 *
	 */
	public Set<PurchaseOrder> findAllPurchaseOrders(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderId
	 *
	 */
	public PurchaseOrder findPurchaseOrderByPurchaseOrderId(Integer purchaseOrderId) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderId
	 *
	 */
	public PurchaseOrder findPurchaseOrderByPurchaseOrderId(Integer purchaseOrderId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPrimaryKey
	 *
	 */
	public PurchaseOrder findPurchaseOrderByPrimaryKey(Integer purchaseOrderId_1) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPrimaryKey
	 *
	 */
	public PurchaseOrder findPurchaseOrderByPrimaryKey(Integer purchaseOrderId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatusContaining
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatusContaining(String purchaseOrderStatus_1) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatusContaining
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatusContaining(String purchaseOrderStatus_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDate
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDate(java.util.Calendar purchaseOrderCreatedDate) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDate
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDate(Calendar purchaseOrderCreatedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateBefore
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateBefore(java.util.Calendar purchaseOrderCreatedDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateBefore
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateBefore(Calendar purchaseOrderCreatedDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddress
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddress(String purchaseOrderAddress) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddress
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddress(String purchaseOrderAddress, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateAfter
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateAfter(java.util.Calendar purchaseOrderCreatedDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateAfter
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateAfter(Calendar purchaseOrderCreatedDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateBefore
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateBefore(java.util.Calendar purchaseOrderRecievedDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateBefore
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateBefore(Calendar purchaseOrderRecievedDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDate
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDate(java.util.Calendar purchaseOrderExpectedDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDate
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDate(Calendar purchaseOrderExpectedDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddressContaining
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddressContaining(String purchaseOrderAddress_1) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddressContaining
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddressContaining(String purchaseOrderAddress_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateAfter
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateAfter(java.util.Calendar purchaseOrderRecievedDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateAfter
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateAfter(Calendar purchaseOrderRecievedDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateAfter
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateAfter(java.util.Calendar purchaseOrderExpectedDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateAfter
	 *
	 */
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateAfter(Calendar purchaseOrderExpectedDate_2, int startResult, int maxRows) throws DataAccessException;

}