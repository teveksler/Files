package axi.source.dao;

import axi.source.domain.Quote;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Quote entities.
 * 
 */
public interface QuoteDAO extends JpaDao<Quote> {

	/**
	 * JPQL Query - findAllQuotes
	 *
	 */
	public Set<Quote> findAllQuotes() throws DataAccessException;

	/**
	 * JPQL Query - findAllQuotes
	 *
	 */
	public Set<Quote> findAllQuotes(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteDate
	 *
	 */
	public Set<Quote> findQuoteByQuoteDate(java.util.Calendar quoteDate) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteDate
	 *
	 */
	public Set<Quote> findQuoteByQuoteDate(Calendar quoteDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteId
	 *
	 */
	public Quote findQuoteByQuoteId(Integer quoteId) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteId
	 *
	 */
	public Quote findQuoteByQuoteId(Integer quoteId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteDateAfter
	 *
	 */
	public Set<Quote> findQuoteByQuoteDateAfter(java.util.Calendar quoteDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteDateAfter
	 *
	 */
	public Set<Quote> findQuoteByQuoteDateAfter(Calendar quoteDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteDateBefore
	 *
	 */
	public Set<Quote> findQuoteByQuoteDateBefore(java.util.Calendar quoteDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByQuoteDateBefore
	 *
	 */
	public Set<Quote> findQuoteByQuoteDateBefore(Calendar quoteDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByPrimaryKey
	 *
	 */
	public Quote findQuoteByPrimaryKey(Integer quoteId_1) throws DataAccessException;

	/**
	 * JPQL Query - findQuoteByPrimaryKey
	 *
	 */
	public Quote findQuoteByPrimaryKey(Integer quoteId_1, int startResult, int maxRows) throws DataAccessException;

}