package axi.source.dao;

import axi.source.domain.Inventory;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Inventory entities.
 * 
 */
public interface InventoryDAO extends JpaDao<Inventory> {

	/**
	 * JPQL Query - findInventoryByInventoryNameContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryNameContaining(String inventoryName) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryNameContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryNameContaining(String inventoryName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryLocation
	 *
	 */
	public Set<Inventory> findInventoryByInventoryLocation(String inventoryLocation) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryLocation
	 *
	 */
	public Set<Inventory> findInventoryByInventoryLocation(String inventoryLocation, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllInventorys
	 *
	 */
	public Set<Inventory> findAllInventorys() throws DataAccessException;

	/**
	 * JPQL Query - findAllInventorys
	 *
	 */
	public Set<Inventory> findAllInventorys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryProductName
	 *
	 */
	public Set<Inventory> findInventoryByInventoryProductName(String inventoryProductName) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryProductName
	 *
	 */
	public Set<Inventory> findInventoryByInventoryProductName(String inventoryProductName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByPrimaryKey
	 *
	 */
	public Inventory findInventoryByPrimaryKey(Integer inventoryId) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByPrimaryKey
	 *
	 */
	public Inventory findInventoryByPrimaryKey(Integer inventoryId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryUnit
	 *
	 */
	public Set<Inventory> findInventoryByInventoryUnit(String inventoryUnit) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryUnit
	 *
	 */
	public Set<Inventory> findInventoryByInventoryUnit(String inventoryUnit, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryId
	 *
	 */
	public Inventory findInventoryByInventoryId(Integer inventoryId_1) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryId
	 *
	 */
	public Inventory findInventoryByInventoryId(Integer inventoryId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryStockLevel
	 *
	 */
	public Set<Inventory> findInventoryByInventoryStockLevel(Integer inventoryStockLevel) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryStockLevel
	 *
	 */
	public Set<Inventory> findInventoryByInventoryStockLevel(Integer inventoryStockLevel, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryPrice
	 *
	 */
	public Set<Inventory> findInventoryByInventoryPrice(java.math.BigDecimal inventoryPrice) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryPrice
	 *
	 */
	public Set<Inventory> findInventoryByInventoryPrice(BigDecimal inventoryPrice, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryProductNameContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryProductNameContaining(String inventoryProductName_1) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryProductNameContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryProductNameContaining(String inventoryProductName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryName
	 *
	 */
	public Set<Inventory> findInventoryByInventoryName(String inventoryName_1) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryName
	 *
	 */
	public Set<Inventory> findInventoryByInventoryName(String inventoryName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryLowThreshold
	 *
	 */
	public Set<Inventory> findInventoryByInventoryLowThreshold(Integer inventoryLowThreshold) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryLowThreshold
	 *
	 */
	public Set<Inventory> findInventoryByInventoryLowThreshold(Integer inventoryLowThreshold, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryUnitContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryUnitContaining(String inventoryUnit_1) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryUnitContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryUnitContaining(String inventoryUnit_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryLocationContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryLocationContaining(String inventoryLocation_1) throws DataAccessException;

	/**
	 * JPQL Query - findInventoryByInventoryLocationContaining
	 *
	 */
	public Set<Inventory> findInventoryByInventoryLocationContaining(String inventoryLocation_1, int startResult, int maxRows) throws DataAccessException;

}