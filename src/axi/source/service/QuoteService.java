package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Quote;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Quote entities
 * 
 */
public interface QuoteService {

	/**
	 * Load an existing Quote entity
	 * 
	 */
	public Set<Quote> loadQuotes();

	/**
	 * Save an existing Quote entity
	 * 
	 */
	public void saveQuote(Quote quote);

	/**
	 */
	public Quote findQuoteByPrimaryKey(Integer quoteId);

	/**
	 * Delete an existing Client entity
	 * 
	 */
	public Quote deleteQuoteClient(Integer quote_quoteId, Integer related_client_clientId);

	/**
	 * Save an existing Client entity
	 * 
	 */
	public Quote saveQuoteClient(Integer quoteId_1, Client related_client);

	/**
	 * Return all Quote entity
	 * 
	 */
	public List<Quote> findAllQuotes(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Quote entity
	 * 
	 */
	public Integer countQuotes();

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	public void deleteQuote(Quote quote_1);
}