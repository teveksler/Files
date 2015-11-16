package axi.source.service;

import axi.source.dao.ClientDAO;
import axi.source.dao.QuoteDAO;

import axi.source.domain.Client;
import axi.source.domain.Quote;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Quote entities
 * 
 */

@Service("QuoteService")
@Transactional
public class QuoteServiceImpl implements QuoteService {

	/**
	 * DAO injected by Spring that manages Client entities
	 * 
	 */
	@Autowired
	private ClientDAO clientDAO;

	/**
	 * DAO injected by Spring that manages Quote entities
	 * 
	 */
	@Autowired
	private QuoteDAO quoteDAO;

	/**
	 * Instantiates a new QuoteServiceImpl.
	 *
	 */
	public QuoteServiceImpl() {
	}

	/**
	 * Load an existing Quote entity
	 * 
	 */
	@Transactional
	public Set<Quote> loadQuotes() {
		return quoteDAO.findAllQuotes();
	}

	/**
	 * Save an existing Quote entity
	 * 
	 */
	@Transactional
	public void saveQuote(Quote quote) {
		Quote existingQuote = quoteDAO.findQuoteByPrimaryKey(quote.getQuoteId());

		if (existingQuote != null) {
			if (existingQuote != quote) {
				existingQuote.setQuoteId(quote.getQuoteId());
				existingQuote.setQuotePdf(quote.getQuotePdf());
				existingQuote.setQuoteDate(quote.getQuoteDate());
			}
			quote = quoteDAO.store(existingQuote);
		} else {
			quote = quoteDAO.store(quote);
		}
		quoteDAO.flush();
	}

	/**
	 */
	@Transactional
	public Quote findQuoteByPrimaryKey(Integer quoteId) {
		return quoteDAO.findQuoteByPrimaryKey(quoteId);
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@Transactional
	public Quote deleteQuoteClient(Integer quote_quoteId, Integer related_client_clientId) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(quote_quoteId, -1, -1);
		Client related_client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);
		quote.setClient(null);
		related_client.getQuotes().remove(quote);
		quote = quoteDAO.store(quote);
		quoteDAO.flush();
		related_client = clientDAO.store(related_client);
		clientDAO.flush();
		clientDAO.remove(related_client);
		clientDAO.flush();
		return quote;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@Transactional
	public Quote saveQuoteClient(Integer quoteId, Client related_client) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(quoteId, -1, -1);
		Client existingclient = clientDAO.findClientByPrimaryKey(related_client.getClientId());

		// copy into the existing record to preserve existing relationships
		if (existingclient != null) {
			existingclient.setClientId(related_client.getClientId());
			existingclient.setClientType(related_client.getClientType());
			existingclient.setClientName(related_client.getClientName());
			existingclient.setClientPhoneNum(related_client.getClientPhoneNum());
			existingclient.setClientExt(related_client.getClientExt());
			existingclient.setClientEmail(related_client.getClientEmail());
			existingclient.setClientAddress(related_client.getClientAddress());
			existingclient.setClientCity(related_client.getClientCity());
			existingclient.setPostalCode(related_client.getPostalCode());
			existingclient.setClientComment(related_client.getClientComment());
			related_client = existingclient;
		} else {
			related_client = clientDAO.store(related_client);
			clientDAO.flush();
		}
		quote.setClient(related_client);
		related_client.getQuotes().add(quote);
		quote = quoteDAO.store(quote);
		quoteDAO.flush();
		related_client = clientDAO.store(related_client);
		clientDAO.flush();
		return quote;
	}

	/**
	 * Return all Quote entity
	 * 
	 */
	@Transactional
	public List<Quote> findAllQuotes(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Quote>(quoteDAO.findAllQuotes(startResult, maxRows));
	}

	/**
	 * Return a count of all Quote entity
	 * 
	 */
	@Transactional
	public Integer countQuotes() {
		return ((Long) quoteDAO.createQuerySingleResult("select count(o) from Quote o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	@Transactional
	public void deleteQuote(Quote quote) {
		quoteDAO.remove(quote);
		quoteDAO.flush();
	}
}
