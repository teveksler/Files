package axi.source.dao;

import axi.source.domain.PurchaseOrder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage PurchaseOrder entities.
 * 
 */
@Repository("PurchaseOrderDAO")
@Transactional
public class PurchaseOrderDAOImpl extends AbstractJpaDao<PurchaseOrder>
		implements PurchaseOrderDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { PurchaseOrder.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_connector
	 *
	 */
	@PersistenceContext(unitName = "mysql_connector")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PurchaseOrderDAOImpl
	 *
	 */
	public PurchaseOrderDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateBefore
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateBefore(java.util.Calendar purchaseOrderExpectedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderExpectedDateBefore(purchaseOrderExpectedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateBefore(java.util.Calendar purchaseOrderExpectedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderExpectedDateBefore", startResult, maxRows, purchaseOrderExpectedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDate
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDate(java.util.Calendar purchaseOrderRecievedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderRecievedDate(purchaseOrderRecievedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDate(java.util.Calendar purchaseOrderRecievedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderRecievedDate", startResult, maxRows, purchaseOrderRecievedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatus
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatus(String purchaseOrderStatus) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderStatus(purchaseOrderStatus, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatus(String purchaseOrderStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderStatus", startResult, maxRows, purchaseOrderStatus);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPurchaseOrders
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findAllPurchaseOrders() throws DataAccessException {

		return findAllPurchaseOrders(-1, -1);
	}

	/**
	 * JPQL Query - findAllPurchaseOrders
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findAllPurchaseOrders(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPurchaseOrders", startResult, maxRows);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderId
	 *
	 */
	@Transactional
	public PurchaseOrder findPurchaseOrderByPurchaseOrderId(Integer purchaseOrderId) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderId(purchaseOrderId, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderId
	 *
	 */

	@Transactional
	public PurchaseOrder findPurchaseOrderByPurchaseOrderId(Integer purchaseOrderId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderId", startResult, maxRows, purchaseOrderId);
			return (axi.source.domain.PurchaseOrder) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPurchaseOrderByPrimaryKey
	 *
	 */
	@Transactional
	public PurchaseOrder findPurchaseOrderByPrimaryKey(Integer purchaseOrderId) throws DataAccessException {

		return findPurchaseOrderByPrimaryKey(purchaseOrderId, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPrimaryKey
	 *
	 */

	@Transactional
	public PurchaseOrder findPurchaseOrderByPrimaryKey(Integer purchaseOrderId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPurchaseOrderByPrimaryKey", startResult, maxRows, purchaseOrderId);
			return (axi.source.domain.PurchaseOrder) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatusContaining
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatusContaining(String purchaseOrderStatus) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderStatusContaining(purchaseOrderStatus, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderStatusContaining(String purchaseOrderStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderStatusContaining", startResult, maxRows, purchaseOrderStatus);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDate
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDate(java.util.Calendar purchaseOrderCreatedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderCreatedDate(purchaseOrderCreatedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDate(java.util.Calendar purchaseOrderCreatedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderCreatedDate", startResult, maxRows, purchaseOrderCreatedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateBefore
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateBefore(java.util.Calendar purchaseOrderCreatedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderCreatedDateBefore(purchaseOrderCreatedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateBefore(java.util.Calendar purchaseOrderCreatedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderCreatedDateBefore", startResult, maxRows, purchaseOrderCreatedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddress
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddress(String purchaseOrderAddress) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderAddress(purchaseOrderAddress, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddress(String purchaseOrderAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderAddress", startResult, maxRows, purchaseOrderAddress);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateAfter
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateAfter(java.util.Calendar purchaseOrderCreatedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderCreatedDateAfter(purchaseOrderCreatedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderCreatedDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderCreatedDateAfter(java.util.Calendar purchaseOrderCreatedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderCreatedDateAfter", startResult, maxRows, purchaseOrderCreatedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateBefore
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateBefore(java.util.Calendar purchaseOrderRecievedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderRecievedDateBefore(purchaseOrderRecievedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateBefore(java.util.Calendar purchaseOrderRecievedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderRecievedDateBefore", startResult, maxRows, purchaseOrderRecievedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDate
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDate(java.util.Calendar purchaseOrderExpectedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderExpectedDate(purchaseOrderExpectedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDate(java.util.Calendar purchaseOrderExpectedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderExpectedDate", startResult, maxRows, purchaseOrderExpectedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddressContaining
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddressContaining(String purchaseOrderAddress) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderAddressContaining(purchaseOrderAddress, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderAddressContaining(String purchaseOrderAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderAddressContaining", startResult, maxRows, purchaseOrderAddress);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateAfter
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateAfter(java.util.Calendar purchaseOrderRecievedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderRecievedDateAfter(purchaseOrderRecievedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderRecievedDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderRecievedDateAfter(java.util.Calendar purchaseOrderRecievedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderRecievedDateAfter", startResult, maxRows, purchaseOrderRecievedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateAfter
	 *
	 */
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateAfter(java.util.Calendar purchaseOrderExpectedDate) throws DataAccessException {

		return findPurchaseOrderByPurchaseOrderExpectedDateAfter(purchaseOrderExpectedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPurchaseOrderByPurchaseOrderExpectedDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PurchaseOrder> findPurchaseOrderByPurchaseOrderExpectedDateAfter(java.util.Calendar purchaseOrderExpectedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPurchaseOrderByPurchaseOrderExpectedDateAfter", startResult, maxRows, purchaseOrderExpectedDate);
		return new LinkedHashSet<PurchaseOrder>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(PurchaseOrder entity) {
		return true;
	}
}
