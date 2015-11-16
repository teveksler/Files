package axi.source.dao;

import axi.source.domain.Quote;

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
 * DAO to manage Quote entities.
 * 
 */
@Repository("QuoteDAO")
@Transactional
public class QuoteDAOImpl extends AbstractJpaDao<Quote> implements QuoteDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Quote.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_connector
	 *
	 */
	@PersistenceContext(unitName = "mysql_connector")
	private EntityManager entityManager;

	/**
	 * Instantiates a new QuoteDAOImpl
	 *
	 */
	public QuoteDAOImpl() {
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
	 * JPQL Query - findAllQuotes
	 *
	 */
	@Transactional
	public Set<Quote> findAllQuotes() throws DataAccessException {

		return findAllQuotes(-1, -1);
	}

	/**
	 * JPQL Query - findAllQuotes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Quote> findAllQuotes(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllQuotes", startResult, maxRows);
		return new LinkedHashSet<Quote>(query.getResultList());
	}

	/**
	 * JPQL Query - findQuoteByQuoteDate
	 *
	 */
	@Transactional
	public Set<Quote> findQuoteByQuoteDate(java.util.Calendar quoteDate) throws DataAccessException {

		return findQuoteByQuoteDate(quoteDate, -1, -1);
	}

	/**
	 * JPQL Query - findQuoteByQuoteDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Quote> findQuoteByQuoteDate(java.util.Calendar quoteDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findQuoteByQuoteDate", startResult, maxRows, quoteDate);
		return new LinkedHashSet<Quote>(query.getResultList());
	}

	/**
	 * JPQL Query - findQuoteByQuoteId
	 *
	 */
	@Transactional
	public Quote findQuoteByQuoteId(Integer quoteId) throws DataAccessException {

		return findQuoteByQuoteId(quoteId, -1, -1);
	}

	/**
	 * JPQL Query - findQuoteByQuoteId
	 *
	 */

	@Transactional
	public Quote findQuoteByQuoteId(Integer quoteId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findQuoteByQuoteId", startResult, maxRows, quoteId);
			return (axi.source.domain.Quote) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findQuoteByQuoteDateAfter
	 *
	 */
	@Transactional
	public Set<Quote> findQuoteByQuoteDateAfter(java.util.Calendar quoteDate) throws DataAccessException {

		return findQuoteByQuoteDateAfter(quoteDate, -1, -1);
	}

	/**
	 * JPQL Query - findQuoteByQuoteDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Quote> findQuoteByQuoteDateAfter(java.util.Calendar quoteDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findQuoteByQuoteDateAfter", startResult, maxRows, quoteDate);
		return new LinkedHashSet<Quote>(query.getResultList());
	}

	/**
	 * JPQL Query - findQuoteByQuoteDateBefore
	 *
	 */
	@Transactional
	public Set<Quote> findQuoteByQuoteDateBefore(java.util.Calendar quoteDate) throws DataAccessException {

		return findQuoteByQuoteDateBefore(quoteDate, -1, -1);
	}

	/**
	 * JPQL Query - findQuoteByQuoteDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Quote> findQuoteByQuoteDateBefore(java.util.Calendar quoteDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findQuoteByQuoteDateBefore", startResult, maxRows, quoteDate);
		return new LinkedHashSet<Quote>(query.getResultList());
	}

	/**
	 * JPQL Query - findQuoteByPrimaryKey
	 *
	 */
	@Transactional
	public Quote findQuoteByPrimaryKey(Integer quoteId) throws DataAccessException {

		return findQuoteByPrimaryKey(quoteId, -1, -1);
	}

	/**
	 * JPQL Query - findQuoteByPrimaryKey
	 *
	 */

	@Transactional
	public Quote findQuoteByPrimaryKey(Integer quoteId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findQuoteByPrimaryKey", startResult, maxRows, quoteId);
			return (axi.source.domain.Quote) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Quote entity) {
		return true;
	}
}
