package axi.source.web;

import axi.source.dao.ClientDAO;
import axi.source.dao.QuoteDAO;

import axi.source.domain.Client;
import axi.source.domain.Quote;

import axi.source.service.QuoteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Quote entities
 * 
 */

@Controller("QuoteController")
public class QuoteController {

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
	 * Service injected by Spring that provides CRUD operations for Quote
	 * entities
	 * 
	 */
	@Autowired
	private QuoteService quoteService;

	/**
	 * Select an existing Quote entity
	 * 
	 */
	@RequestMapping("/selectQuote")
	public ModelAndView selectQuote(@RequestParam Integer quoteIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("quote", quoteDAO.findQuoteByPrimaryKey(quoteIdKey));
		mav.setViewName("quote/viewQuote.jsp");

		return mav;
	}

	/**
	 * Create a new Quote entity
	 * 
	 */
	@RequestMapping("/newQuote")
	public ModelAndView newQuote() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("quote", new Quote());
		mav.addObject("newFlag", true);
		mav.setViewName("quote/editQuote.jsp");
		return mav;
	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveQuoteClient")
	public ModelAndView saveQuoteClient(@RequestParam Integer quote_quoteId,
			@ModelAttribute Client client) {
		Quote parent_quote = quoteService
				.saveQuoteClient(quote_quoteId, client);

		ModelAndView mav = new ModelAndView();
		mav.addObject("quote_quoteId", quote_quoteId);
		mav.addObject("quote", parent_quote);
		mav.setViewName("quote/viewQuote.jsp");

		return mav;
	}

	/**
	 * Delete an existing Quote entity
	 * 
	 */
	@RequestMapping("/deleteQuote")
	public String deleteQuote(@RequestParam Integer quoteIdKey) {
		Quote quote = quoteDAO.findQuoteByPrimaryKey(quoteIdKey);
		quoteService.deleteQuote(quote);
		return "forward:/indexQuote";
	}

	/**
	 * Select the Quote entity for display allowing the user to confirm that
	 * they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteQuote")
	public ModelAndView confirmDeleteQuote(@RequestParam Integer quoteIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("quote", quoteDAO.findQuoteByPrimaryKey(quoteIdKey));
		mav.setViewName("quote/deleteQuote.jsp");

		return mav;
	}

	/**
	 * Save an existing Quote entity
	 * 
	 */
	@RequestMapping("/saveQuote")
	public String saveQuote(@ModelAttribute Quote quote) {
		quoteService.saveQuote(quote);
		return "forward:/indexQuote";
	}

	/**
	 * View an existing Client entity
	 * 
	 */
	@RequestMapping("/selectQuoteClient")
	public ModelAndView selectQuoteClient(@RequestParam Integer quote_quoteId,
			@RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1,
				-1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("quote_quoteId", quote_quoteId);
		mav.addObject("client", client);
		mav.setViewName("quote/client/viewClient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Client entity
	 * 
	 */
	@RequestMapping("/deleteQuoteClient")
	public ModelAndView deleteQuoteClient(@RequestParam Integer quote_quoteId,
			@RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();
		Quote quote = quoteService.deleteQuoteClient(quote_quoteId,
				related_client_clientId);
		mav.addObject("quote_quoteId", quote_quoteId);
		mav.addObject("quote", quote);
		mav.setViewName("quote/viewQuote.jsp");

		return mav;
	}

	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editQuoteClient")
	public ModelAndView editQuoteClient(@RequestParam Integer quote_quoteId,
			@RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1,
				-1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("quote_quoteId", quote_quoteId);
		mav.addObject("client", client);
		mav.setViewName("quote/client/editClient.jsp");

		return mav;
	}

	/**
	 * Show all Client entities by Quote
	 * 
	 */
	@RequestMapping("/listQuoteClient")
	public ModelAndView listQuoteClient(@RequestParam Integer quoteIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("quote", quoteDAO.findQuoteByPrimaryKey(quoteIdKey));
		mav.setViewName("quote/client/listClient.jsp");

		return mav;
	}

	/**
	 * Create a new Client entity
	 * 
	 */
	@RequestMapping("/newQuoteClient")
	public ModelAndView newQuoteClient(@RequestParam Integer quote_quoteId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("quote_quoteId", quote_quoteId);
		mav.addObject("client", new Client());
		mav.addObject("newFlag", true);
		mav.setViewName("quote/client/editClient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Quote entity
	 * 
	 */
	@RequestMapping("/editQuote")
	public ModelAndView editQuote(@RequestParam Integer quoteIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("quote", quoteDAO.findQuoteByPrimaryKey(quoteIdKey));
		mav.setViewName("quote/editQuote.jsp");

		return mav;
	}

	/**
	 * Show all Quote entities
	 * 
	 */
	@RequestMapping("/indexQuote")
	public ModelAndView listQuotes() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("quotes", quoteService.loadQuotes());

		mav.setViewName("quote/listQuotes.jsp");

		return mav;
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register
																				// static
																				// property
																				// editors.
		binder.registerCustomEditor(java.util.Calendar.class,
				new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(
				byte[].class,
				new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class,
				new org.skyway.spring.util.databinding.EnhancedBooleanEditor(
						false));
		binder.registerCustomEditor(Boolean.class,
				new org.skyway.spring.util.databinding.EnhancedBooleanEditor(
						true));
		binder.registerCustomEditor(java.math.BigDecimal.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class,
				new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class,
				new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Long.class, true));
		binder.registerCustomEditor(Double.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Double.class, true));
	}

	/**
	 */
	@RequestMapping("/quoteController/binary.action")
	public ModelAndView streamBinary(
			@ModelAttribute HttpServletRequest request,
			@ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Entry point to show all Quote entities
	 * 
	 */
	public String indexQuote() {
		return "redirect:/indexQuote";
	}

	/**
	 * Select the child Client entity for display allowing the user to confirm
	 * that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteQuoteClient")
	public ModelAndView confirmDeleteQuoteClient(
			@RequestParam Integer quote_quoteId,
			@RequestParam Integer related_client_clientId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("client",
				clientDAO.findClientByPrimaryKey(related_client_clientId));
		mav.addObject("quote_quoteId", quote_quoteId);
		mav.setViewName("quote/client/deleteClient.jsp");

		return mav;
	}
}