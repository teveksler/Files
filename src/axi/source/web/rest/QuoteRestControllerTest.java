package axi.source.web.rest;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Unit test for the <code>QuoteRestController</code> controller.
 *
 * @see axi.source.web.rest.QuoteRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class QuoteRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Quotequote_quoteIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetQuotequote_quoteIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quotequote_quoteIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostQuotequote_quoteIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quotequote_quoteIdclient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutQuotequote_quoteIdclient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}/client");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quotequote_quoteIdclientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteQuotequote_quoteIdclientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}/client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quotequote_quoteIdclientclient_clientId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetQuotequote_quoteIdclientclient_clientId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}/client/{client_clientId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quotequote_quoteId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetQuotequote_quoteId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Quotequote_quoteId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteQuotequote_quoteId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Quote/{quote_quoteId}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteRestController controller = (QuoteRestController) context.getBean("QuoteRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Returns a mock HttpServletRequest object.
	 *
	 */
	private MockHttpServletRequest getMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
		return request;
	}

	/**
	 * Returns a mock HttpServletResponse object.
	 *
	 */
	private MockHttpServletResponse getMockHttpServletResponse() {
		return new MockHttpServletResponse();
	}
}