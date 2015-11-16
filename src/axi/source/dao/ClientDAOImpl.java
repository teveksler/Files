package axi.source.dao;

import axi.source.domain.Client;

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
 * DAO to manage Client entities.
 * 
 */
@Repository("ClientDAO")
@Transactional
public class ClientDAOImpl extends AbstractJpaDao<Client> implements ClientDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Client.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_connector
	 *
	 */
	@PersistenceContext(unitName = "mysql_connector")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ClientDAOImpl
	 *
	 */
	public ClientDAOImpl() {
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
	 * JPQL Query - findClientByClientComment
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientComment(String clientComment) throws DataAccessException {

		return findClientByClientComment(clientComment, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientComment
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientComment(String clientComment, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientComment", startResult, maxRows, clientComment);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientCity
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientCity(String clientCity) throws DataAccessException {

		return findClientByClientCity(clientCity, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientCity(String clientCity, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientCity", startResult, maxRows, clientCity);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientCityContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientCityContaining(String clientCity) throws DataAccessException {

		return findClientByClientCityContaining(clientCity, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientCityContaining(String clientCity, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientCityContaining", startResult, maxRows, clientCity);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientAddress
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientAddress(String clientAddress) throws DataAccessException {

		return findClientByClientAddress(clientAddress, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientAddress(String clientAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientAddress", startResult, maxRows, clientAddress);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */
	@Transactional
	public Client findClientByClientId(Integer clientId) throws DataAccessException {

		return findClientByClientId(clientId, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */

	@Transactional
	public Client findClientByClientId(Integer clientId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findClientByClientId", startResult, maxRows, clientId);
			return (axi.source.domain.Client) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findClientByClientAddressContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientAddressContaining(String clientAddress) throws DataAccessException {

		return findClientByClientAddressContaining(clientAddress, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientAddressContaining(String clientAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientAddressContaining", startResult, maxRows, clientAddress);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllClients
	 *
	 */
	@Transactional
	public Set<Client> findAllClients() throws DataAccessException {

		return findAllClients(-1, -1);
	}

	/**
	 * JPQL Query - findAllClients
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findAllClients(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllClients", startResult, maxRows);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */
	@Transactional
	public Client findClientByPrimaryKey(Integer clientId) throws DataAccessException {

		return findClientByPrimaryKey(clientId, -1, -1);
	}

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */

	@Transactional
	public Client findClientByPrimaryKey(Integer clientId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findClientByPrimaryKey", startResult, maxRows, clientId);
			return (axi.source.domain.Client) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findClientByClientCommentContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientCommentContaining(String clientComment) throws DataAccessException {

		return findClientByClientCommentContaining(clientComment, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientCommentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientCommentContaining(String clientComment, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientCommentContaining", startResult, maxRows, clientComment);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientTypeContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientTypeContaining(String clientType) throws DataAccessException {

		return findClientByClientTypeContaining(clientType, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientTypeContaining(String clientType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientTypeContaining", startResult, maxRows, clientType);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByPostalCodeContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByPostalCodeContaining(String postalCode) throws DataAccessException {

		return findClientByPostalCodeContaining(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findClientByPostalCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByPostalCodeContaining", startResult, maxRows, postalCode);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientEmailContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientEmailContaining(String clientEmail) throws DataAccessException {

		return findClientByClientEmailContaining(clientEmail, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientEmailContaining(String clientEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientEmailContaining", startResult, maxRows, clientEmail);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientEmail
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientEmail(String clientEmail) throws DataAccessException {

		return findClientByClientEmail(clientEmail, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientEmail(String clientEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientEmail", startResult, maxRows, clientEmail);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientName(String clientName) throws DataAccessException {

		return findClientByClientName(clientName, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientName(String clientName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientName", startResult, maxRows, clientName);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientType
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientType(String clientType) throws DataAccessException {

		return findClientByClientType(clientType, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientType(String clientType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientType", startResult, maxRows, clientType);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientExt
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientExt(Integer clientExt) throws DataAccessException {

		return findClientByClientExt(clientExt, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientExt
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientExt(Integer clientExt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientExt", startResult, maxRows, clientExt);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByPostalCode
	 *
	 */
	@Transactional
	public Set<Client> findClientByPostalCode(String postalCode) throws DataAccessException {

		return findClientByPostalCode(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findClientByPostalCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByPostalCode(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByPostalCode", startResult, maxRows, postalCode);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientNameContaining(String clientName) throws DataAccessException {

		return findClientByClientNameContaining(clientName, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientNameContaining(String clientName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientNameContaining", startResult, maxRows, clientName);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * JPQL Query - findClientByClientPhoneNum
	 *
	 */
	@Transactional
	public Set<Client> findClientByClientPhoneNum(Integer clientPhoneNum) throws DataAccessException {

		return findClientByClientPhoneNum(clientPhoneNum, -1, -1);
	}

	/**
	 * JPQL Query - findClientByClientPhoneNum
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Client> findClientByClientPhoneNum(Integer clientPhoneNum, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findClientByClientPhoneNum", startResult, maxRows, clientPhoneNum);
		return new LinkedHashSet<Client>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Client entity) {
		return true;
	}
}
