package axi.source.dao;

import axi.source.domain.WorkOrder;

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
 * DAO to manage WorkOrder entities.
 * 
 */
@Repository("WorkOrderDAO")
@Transactional
public class WorkOrderDAOImpl extends AbstractJpaDao<WorkOrder> implements
		WorkOrderDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { WorkOrder.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_connector
	 *
	 */
	@PersistenceContext(unitName = "mysql_connector")
	private EntityManager entityManager;

	/**
	 * Instantiates a new WorkOrderDAOImpl
	 *
	 */
	public WorkOrderDAOImpl() {
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
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOn
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOn(java.util.Calendar workOrderCreatedOn) throws DataAccessException {

		return findWorkOrderByWorkOrderCreatedOn(workOrderCreatedOn, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOn(java.util.Calendar workOrderCreatedOn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderCreatedOn", startResult, maxRows, workOrderCreatedOn);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllWorkOrders
	 *
	 */
	@Transactional
	public Set<WorkOrder> findAllWorkOrders() throws DataAccessException {

		return findAllWorkOrders(-1, -1);
	}

	/**
	 * JPQL Query - findAllWorkOrders
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findAllWorkOrders(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllWorkOrders", startResult, maxRows);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateBefore
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateBefore(java.util.Calendar workOrderEndDate) throws DataAccessException {

		return findWorkOrderByWorkOrderEndDateBefore(workOrderEndDate, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateBefore(java.util.Calendar workOrderEndDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderEndDateBefore", startResult, maxRows, workOrderEndDate);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDate
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDate(java.util.Calendar workOrderEndDate) throws DataAccessException {

		return findWorkOrderByWorkOrderEndDate(workOrderEndDate, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDate(java.util.Calendar workOrderEndDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderEndDate", startResult, maxRows, workOrderEndDate);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateBefore
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateBefore(java.util.Calendar workOrderExpectedEndDate) throws DataAccessException {

		return findWorkOrderByWorkOrderExpectedEndDateBefore(workOrderExpectedEndDate, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateBefore(java.util.Calendar workOrderExpectedEndDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderExpectedEndDateBefore", startResult, maxRows, workOrderExpectedEndDate);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnAfter
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnAfter(java.util.Calendar workOrderCreatedOn) throws DataAccessException {

		return findWorkOrderByWorkOrderCreatedOnAfter(workOrderCreatedOn, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnAfter(java.util.Calendar workOrderCreatedOn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderCreatedOnAfter", startResult, maxRows, workOrderCreatedOn);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddressContaining
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderAddressContaining(String workOrderAddress) throws DataAccessException {

		return findWorkOrderByWorkOrderAddressContaining(workOrderAddress, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderAddressContaining(String workOrderAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderAddressContaining", startResult, maxRows, workOrderAddress);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatus
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderStatus(String workOrderStatus) throws DataAccessException {

		return findWorkOrderByWorkOrderStatus(workOrderStatus, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderStatus(String workOrderStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderStatus", startResult, maxRows, workOrderStatus);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateAfter
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateAfter(java.util.Calendar workOrderExpectedEndDate) throws DataAccessException {

		return findWorkOrderByWorkOrderExpectedEndDateAfter(workOrderExpectedEndDate, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDateAfter(java.util.Calendar workOrderExpectedEndDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderExpectedEndDateAfter", startResult, maxRows, workOrderExpectedEndDate);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScope
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderScope(String workOrderScope) throws DataAccessException {

		return findWorkOrderByWorkOrderScope(workOrderScope, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScope
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderScope(String workOrderScope, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderScope", startResult, maxRows, workOrderScope);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScopeContaining
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderScopeContaining(String workOrderScope) throws DataAccessException {

		return findWorkOrderByWorkOrderScopeContaining(workOrderScope, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderScopeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderScopeContaining(String workOrderScope, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderScopeContaining", startResult, maxRows, workOrderScope);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnBefore
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnBefore(java.util.Calendar workOrderCreatedOn) throws DataAccessException {

		return findWorkOrderByWorkOrderCreatedOnBefore(workOrderCreatedOn, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderCreatedOnBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderCreatedOnBefore(java.util.Calendar workOrderCreatedOn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderCreatedOnBefore", startResult, maxRows, workOrderCreatedOn);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddress
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderAddress(String workOrderAddress) throws DataAccessException {

		return findWorkOrderByWorkOrderAddress(workOrderAddress, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderAddress(String workOrderAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderAddress", startResult, maxRows, workOrderAddress);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDate
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDate(java.util.Calendar workOrderExpectedEndDate) throws DataAccessException {

		return findWorkOrderByWorkOrderExpectedEndDate(workOrderExpectedEndDate, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderExpectedEndDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderExpectedEndDate(java.util.Calendar workOrderExpectedEndDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderExpectedEndDate", startResult, maxRows, workOrderExpectedEndDate);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderId
	 *
	 */
	@Transactional
	public WorkOrder findWorkOrderByWorkOrderId(Integer workOrderId) throws DataAccessException {

		return findWorkOrderByWorkOrderId(workOrderId, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderId
	 *
	 */

	@Transactional
	public WorkOrder findWorkOrderByWorkOrderId(Integer workOrderId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findWorkOrderByWorkOrderId", startResult, maxRows, workOrderId);
			return (axi.source.domain.WorkOrder) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateAfter
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateAfter(java.util.Calendar workOrderEndDate) throws DataAccessException {

		return findWorkOrderByWorkOrderEndDateAfter(workOrderEndDate, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderEndDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderEndDateAfter(java.util.Calendar workOrderEndDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderEndDateAfter", startResult, maxRows, workOrderEndDate);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkOrderByPrimaryKey
	 *
	 */
	@Transactional
	public WorkOrder findWorkOrderByPrimaryKey(Integer workOrderId) throws DataAccessException {

		return findWorkOrderByPrimaryKey(workOrderId, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByPrimaryKey
	 *
	 */

	@Transactional
	public WorkOrder findWorkOrderByPrimaryKey(Integer workOrderId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findWorkOrderByPrimaryKey", startResult, maxRows, workOrderId);
			return (axi.source.domain.WorkOrder) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatusContaining
	 *
	 */
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderStatusContaining(String workOrderStatus) throws DataAccessException {

		return findWorkOrderByWorkOrderStatusContaining(workOrderStatus, -1, -1);
	}

	/**
	 * JPQL Query - findWorkOrderByWorkOrderStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<WorkOrder> findWorkOrderByWorkOrderStatusContaining(String workOrderStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findWorkOrderByWorkOrderStatusContaining", startResult, maxRows, workOrderStatus);
		return new LinkedHashSet<WorkOrder>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(WorkOrder entity) {
		return true;
	}
}
