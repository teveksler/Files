package axi.source.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllQuotes", query = "select myQuote from Quote myQuote"),
		@NamedQuery(name = "findQuoteByPrimaryKey", query = "select myQuote from Quote myQuote where myQuote.quoteId = ?1"),
		@NamedQuery(name = "findQuoteByQuoteDate", query = "select myQuote from Quote myQuote where myQuote.quoteDate = ?1"),
		@NamedQuery(name = "findQuoteByQuoteDateAfter", query = "select myQuote from Quote myQuote where myQuote.quoteDate > ?1"),
		@NamedQuery(name = "findQuoteByQuoteDateBefore", query = "select myQuote from Quote myQuote where myQuote.quoteDate < ?1"),
		@NamedQuery(name = "findQuoteByQuoteId", query = "select myQuote from Quote myQuote where myQuote.quoteId = ?1") })
@Table(catalog = "hibernatedb", name = "quote")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "AXI_Final_Prototype/axi/source/domain", name = "Quote")
public class Quote implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "quote_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	Integer quoteId;
	/**
	 */

	@Column(name = "quote_pdf", nullable = false, columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] quotePdf;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "quote_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar quoteDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "quote_client_id", referencedColumnName = "client_id") })
	@XmlTransient
	Client client;

	/**
	 */
	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	/**
	 */
	public Integer getQuoteId() {
		return this.quoteId;
	}

	/**
	 */
	public void setQuotePdf(byte[] quotePdf) {
		this.quotePdf = quotePdf;
	}

	/**
	 */
	public byte[] getQuotePdf() {
		return this.quotePdf;
	}

	/**
	 */
	public void setQuoteDate(Calendar quoteDate) {
		this.quoteDate = quoteDate;
	}

	/**
	 */
	public Calendar getQuoteDate() {
		return this.quoteDate;
	}

	/**
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 */
	@JsonIgnore
	public Client getClient() {
		return client;
	}

	/**
	 */
	public Quote() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Quote that) {
		setQuoteId(that.getQuoteId());
		setQuotePdf(that.getQuotePdf());
		setQuoteDate(that.getQuoteDate());
		setClient(that.getClient());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("quoteId=[").append(quoteId).append("] ");
		buffer.append("quotePdf=[").append(quotePdf).append("] ");
		buffer.append("quoteDate=[").append(quoteDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((quoteId == null) ? 0 : quoteId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Quote))
			return false;
		Quote equalCheck = (Quote) obj;
		if ((quoteId == null && equalCheck.quoteId != null) || (quoteId != null && equalCheck.quoteId == null))
			return false;
		if (quoteId != null && !quoteId.equals(equalCheck.quoteId))
			return false;
		return true;
	}
}
