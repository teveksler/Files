package axi.source.service;

import axi.source.domain.Client;
import axi.source.domain.Quote;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
@Transactional
public class QuoteServiceTest {

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected QuoteService service;

	/**
	 * Instantiates a new QuoteServiceTest.
	 *
	 */
	public QuoteServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Quote entity
	 * 
	 */
	@Test
	public void loadQuotes() {
		service.loadQuotes();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Quote entity
	 * 
	 */
	@Test
	public void saveQuote() {
		// TODO: JUnit - Populate test inputs for operation: saveQuote 
		Quote quote = new axi.source.domain.Quote();
		service.saveQuote(quote);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findQuoteByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findQuoteByPrimaryKey 
		Integer quoteId = 0;
		service.findQuoteByPrimaryKey(quoteId);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Client entity
	 * 
	 */
	@Test
	public void deleteQuoteClient() {
		// TODO: JUnit - Populate test inputs for operation: deleteQuoteClient 
		Integer quote_quoteId = 0;
		Integer related_client_clientId = 0;
		service.deleteQuoteClient(quote_quoteId, related_client_clientId);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Client entity
	 * 
	 */
	@Test
	public void saveQuoteClient() {
		// TODO: JUnit - Populate test inputs for operation: saveQuoteClient 
		Integer quoteId_1 = 0;
		Client related_client = new axi.source.domain.Client();
		service.saveQuoteClient(quoteId_1, related_client);
	}

	/**
	 * Operation Unit Test
	 * Return all Quote entity
	 * 
	 */
	@Test
	public void findAllQuotes() {
		// TODO: JUnit - Populate test inputs for operation: findAllQuotes 
		Integer startResult = 0;
		Integer maxRows = 0;
		service.findAllQuotes(startResult, maxRows);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Quote entity
	 * 
	 */
	@Test
	public void countQuotes() {
		service.countQuotes();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Quote entity
	 * 
	 */
	@Test
	public void deleteQuote() {
		// TODO: JUnit - Populate test inputs for operation: deleteQuote 
		Quote quote_1 = new axi.source.domain.Quote();
		service.deleteQuote(quote_1);
	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
