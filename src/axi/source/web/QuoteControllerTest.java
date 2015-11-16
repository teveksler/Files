package axi.source.web;

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
 * Unit test for the <code>QuoteController</code> controller.
 *
 * @see axi.source.web.QuoteController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/AXI_Final_Prototype-security-context.xml",
		"file:./src/AXI_Final_Prototype-service-context.xml",
		"file:./src/AXI_Final_Prototype-dao-context.xml",
		"file:./src/AXI_Final_Prototype-web-context.xml" })
public class QuoteControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listQuoteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistQuoteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listQuoteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteQuote()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteQuote() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteQuote");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>quoteControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetquoteControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/quoteController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QuoteController controller = (QuoteController) context.getBean("QuoteController");

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