package axi.source.dao;

import axi.source.domain.Inventory;

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
 * DAO to manage Inventory entities.
 * 
 */
@Repository("InventoryDAO")
@Transactional
public class InventoryDAOImpl extends AbstractJpaDao<Inventory> implements
		InventoryDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Inventory.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_connector
	 *
	 */
	@PersistenceContext(unitName = "mysql_connector")
	private EntityManager entityManager;

	/**
	 * Instantiates a new InventoryDAOImpl
	 *
	 */
	public InventoryDAOImpl() {
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
	 * JPQL Query - findInventoryByInventoryNameContaining
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryNameContaining(String inventoryName) throws DataAccessException {

		return findInventoryByInventoryNameContaining(inventoryName, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryNameContaining(String inventoryName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryNameContaining", startResult, maxRows, inventoryName);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryLocation
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryLocation(String inventoryLocation) throws DataAccessException {

		return findInventoryByInventoryLocation(inventoryLocation, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryLocation
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryLocation(String inventoryLocation, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryLocation", startResult, maxRows, inventoryLocation);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllInventorys
	 *
	 */
	@Transactional
	public Set<Inventory> findAllInventorys() throws DataAccessException {

		return findAllInventorys(-1, -1);
	}

	/**
	 * JPQL Query - findAllInventorys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findAllInventorys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllInventorys", startResult, maxRows);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryProductName
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryProductName(String inventoryProductName) throws DataAccessException {

		return findInventoryByInventoryProductName(inventoryProductName, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryProductName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryProductName(String inventoryProductName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryProductName", startResult, maxRows, inventoryProductName);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByPrimaryKey
	 *
	 */
	@Transactional
	public Inventory findInventoryByPrimaryKey(Integer inventoryId) throws DataAccessException {

		return findInventoryByPrimaryKey(inventoryId, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByPrimaryKey
	 *
	 */

	@Transactional
	public Inventory findInventoryByPrimaryKey(Integer inventoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findInventoryByPrimaryKey", startResult, maxRows, inventoryId);
			return (axi.source.domain.Inventory) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findInventoryByInventoryUnit
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryUnit(String inventoryUnit) throws DataAccessException {

		return findInventoryByInventoryUnit(inventoryUnit, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryUnit
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryUnit(String inventoryUnit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryUnit", startResult, maxRows, inventoryUnit);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryId
	 *
	 */
	@Transactional
	public Inventory findInventoryByInventoryId(Integer inventoryId) throws DataAccessException {

		return findInventoryByInventoryId(inventoryId, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryId
	 *
	 */

	@Transactional
	public Inventory findInventoryByInventoryId(Integer inventoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findInventoryByInventoryId", startResult, maxRows, inventoryId);
			return (axi.source.domain.Inventory) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findInventoryByInventoryStockLevel
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryStockLevel(Integer inventoryStockLevel) throws DataAccessException {

		return findInventoryByInventoryStockLevel(inventoryStockLevel, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryStockLevel
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryStockLevel(Integer inventoryStockLevel, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryStockLevel", startResult, maxRows, inventoryStockLevel);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryPrice
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryPrice(java.math.BigDecimal inventoryPrice) throws DataAccessException {

		return findInventoryByInventoryPrice(inventoryPrice, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryPrice
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryPrice(java.math.BigDecimal inventoryPrice, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryPrice", startResult, maxRows, inventoryPrice);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryProductNameContaining
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryProductNameContaining(String inventoryProductName) throws DataAccessException {

		return findInventoryByInventoryProductNameContaining(inventoryProductName, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryProductNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryProductNameContaining(String inventoryProductName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryProductNameContaining", startResult, maxRows, inventoryProductName);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryName
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryName(String inventoryName) throws DataAccessException {

		return findInventoryByInventoryName(inventoryName, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryName(String inventoryName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryName", startResult, maxRows, inventoryName);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryLowThreshold
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryLowThreshold(Integer inventoryLowThreshold) throws DataAccessException {

		return findInventoryByInventoryLowThreshold(inventoryLowThreshold, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryLowThreshold
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryLowThreshold(Integer inventoryLowThreshold, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryLowThreshold", startResult, maxRows, inventoryLowThreshold);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryUnitContaining
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryUnitContaining(String inventoryUnit) throws DataAccessException {

		return findInventoryByInventoryUnitContaining(inventoryUnit, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryUnitContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryUnitContaining(String inventoryUnit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryUnitContaining", startResult, maxRows, inventoryUnit);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * JPQL Query - findInventoryByInventoryLocationContaining
	 *
	 */
	@Transactional
	public Set<Inventory> findInventoryByInventoryLocationContaining(String inventoryLocation) throws DataAccessException {

		return findInventoryByInventoryLocationContaining(inventoryLocation, -1, -1);
	}

	/**
	 * JPQL Query - findInventoryByInventoryLocationContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Inventory> findInventoryByInventoryLocationContaining(String inventoryLocation, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findInventoryByInventoryLocationContaining", startResult, maxRows, inventoryLocation);
		return new LinkedHashSet<Inventory>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Inventory entity) {
		return true;
	}
}
