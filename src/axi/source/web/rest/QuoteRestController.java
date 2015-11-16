package axi.source.web.rest;

import axi.source.dao.ClientDAO;
import axi.source.dao.QuoteDAO;

import axi.source.domain.Client;
import axi.source.domain.Quote;

import axi.source.service.QuoteService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Quote entities
 * 
 */

@Controller("QuoteRestController")
public class QuoteRestController {

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
	 * Service injected by Spring that provides CRUD operations for Quote entities
	 * 
	 */
	@Autowired
	private QuoteService quoteService;

	/**
	 * Show all Quote entities
	 * 
	 */
	@RequestMapping(value = "/Quote", method = RequestMethod.GET)
	@ResponseBody
	public List<Quote> listQuotes() {
		return new java.util.ArrayList<Quote>(quoteService.loadQuotes());
	}

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuote(@PathVariable Integer quote_quoteId) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(quote_quoteId);
		quoteService.deleteQuote(quote);
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}/client", method = RequestMethod.POST)
	@ResponseBody
	public Client newQuoteClient(@PathVariable Integer quote_quoteId, @RequestBody Client client) {
		quoteService.saveQuoteClient(quote_quoteId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Select an existing Quote entity
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}", method = RequestMethod.GET)
	@ResponseBody
	public Quote loadQuote(@PathVariable Integer quote_quoteId) {
		return quoteDAO.findQuoteByPrimaryKey(quote_quoteId);
	}

	/**
	 * Get Client entity by Quote
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}/client", method = RequestMethod.GET)
	@ResponseBody
	public Client getQuoteClient(@PathVariable Integer quote_quoteId) {
		return quoteDAO.findQuoteByPrimaryKey(quote_quoteId).getClient();
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}/client/{client_clientId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuoteClient(@PathVariable Integer quote_quoteId, @PathVariable Integer related_client_clientId) {
		quoteService.deleteQuoteClient(quote_quoteId, related_client_clientId);
	}

	/**
	 * Save an existing Quote entity
	 * 
	 */
	@RequestMapping(value = "/Quote", method = RequestMethod.PUT)
	@ResponseBody
	public Quote saveQuote(@RequestBody Quote quote) {
		quoteService.saveQuote(quote);
		return quoteDAO.findQuoteByPrimaryKey(quote.getQuoteId());
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}/client/{client_clientId}", method = RequestMethod.GET)
	@ResponseBody
	public Client loadQuoteClient(@PathVariable Integer quote_quoteId, @PathVariable Integer related_client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(related_client_clientId, -1, -1);

		return client;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping(value = "/Quote/{quote_quoteId}/client", method = RequestMethod.PUT)
	@ResponseBody
	public Client saveQuoteClient(@PathVariable Integer quote_quoteId, @RequestBody Client client) {
		quoteService.saveQuoteClient(quote_quoteId, client);
		return clientDAO.findClientByPrimaryKey(client.getClientId());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Create a new Quote entity
	 * 
	 */
	@RequestMapping(value = "/Quote", method = RequestMethod.POST)
	@ResponseBody
	public Quote newQuote(@RequestBody Quote quote) {
		quoteService.saveQuote(quote);
		return quoteDAO.findQuoteByPrimaryKey(quote.getQuoteId());
	}
}