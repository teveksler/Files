package axi.source.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

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
		@NamedQuery(name = "findAllClients", query = "select myClient from Client myClient"),
		@NamedQuery(name = "findClientByClientAddress", query = "select myClient from Client myClient where myClient.clientAddress = ?1"),
		@NamedQuery(name = "findClientByClientAddressContaining", query = "select myClient from Client myClient where myClient.clientAddress like ?1"),
		@NamedQuery(name = "findClientByClientCity", query = "select myClient from Client myClient where myClient.clientCity = ?1"),
		@NamedQuery(name = "findClientByClientCityContaining", query = "select myClient from Client myClient where myClient.clientCity like ?1"),
		@NamedQuery(name = "findClientByClientComment", query = "select myClient from Client myClient where myClient.clientComment = ?1"),
		@NamedQuery(name = "findClientByClientCommentContaining", query = "select myClient from Client myClient where myClient.clientComment like ?1"),
		@NamedQuery(name = "findClientByClientEmail", query = "select myClient from Client myClient where myClient.clientEmail = ?1"),
		@NamedQuery(name = "findClientByClientEmailContaining", query = "select myClient from Client myClient where myClient.clientEmail like ?1"),
		@NamedQuery(name = "findClientByClientExt", query = "select myClient from Client myClient where myClient.clientExt = ?1"),
		@NamedQuery(name = "findClientByClientId", query = "select myClient from Client myClient where myClient.clientId = ?1"),
		@NamedQuery(name = "findClientByClientName", query = "select myClient from Client myClient where myClient.clientName = ?1"),
		@NamedQuery(name = "findClientByClientNameContaining", query = "select myClient from Client myClient where myClient.clientName like ?1"),
		@NamedQuery(name = "findClientByClientPhoneNum", query = "select myClient from Client myClient where myClient.clientPhoneNum = ?1"),
		@NamedQuery(name = "findClientByClientType", query = "select myClient from Client myClient where myClient.clientType = ?1"),
		@NamedQuery(name = "findClientByClientTypeContaining", query = "select myClient from Client myClient where myClient.clientType like ?1"),
		@NamedQuery(name = "findClientByPostalCode", query = "select myClient from Client myClient where myClient.postalCode = ?1"),
		@NamedQuery(name = "findClientByPostalCodeContaining", query = "select myClient from Client myClient where myClient.postalCode like ?1"),
		@NamedQuery(name = "findClientByPrimaryKey", query = "select myClient from Client myClient where myClient.clientId = ?1") })
@Table(catalog = "hibernatedb", name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "AXI_Final_Prototype/axi/source/domain", name = "Client")
@XmlRootElement(namespace = "AXI_Final_Prototype/axi/source/domain")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "client_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	Integer clientId;
	/**
	 */

	@Column(name = "client_type", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientType;
	/**
	 */

	@Column(name = "client_name", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientName;
	/**
	 */

	@Column(name = "client_phone_num")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Long clientPhoneNum;
	/**
	 */

	@Column(name = "client_ext")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer clientExt;
	/**
	 */

	@Column(name = "client_email", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientEmail;
	/**
	 */

	@Column(name = "client_address")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientAddress;
	/**
	 */

	@Column(name = "client_city", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientCity;
	/**
	 */

	@Column(name = "postal_code", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String postalCode;
	/**
	 */

	@Column(name = "client_comment")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String clientComment;

	/**
	 */
	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.WorkOrder> workOrders;
	/**
	 */
	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.Inventory> inventories;
	/**
	 */
	@ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.PurchaseOrder> purchaseOrders;
	/**
	 */
	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.Quote> quotes;

	/**
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 */
	public Integer getClientId() {
		return this.clientId;
	}

	/**
	 */
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	/**
	 */
	public String getClientType() {
		return this.clientType;
	}

	/**
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 */
	public String getClientName() {
		return this.clientName;
	}

	/**
	 */
	public void setClientPhoneNum(Long clientPhoneNum) {
		this.clientPhoneNum = clientPhoneNum;
	}

	/**
	 */
	public Long getClientPhoneNum() {
		return this.clientPhoneNum;
	}

	/**
	 */
	public void setClientExt(Integer clientExt) {
		this.clientExt = clientExt;
	}

	/**
	 */
	public Integer getClientExt() {
		return this.clientExt;
	}

	/**
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 */
	public String getClientEmail() {
		return this.clientEmail;
	}

	/**
	 */
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	/**
	 */
	public String getClientAddress() {
		return this.clientAddress;
	}

	/**
	 */
	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	/**
	 */
	public String getClientCity() {
		return this.clientCity;
	}

	/**
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 */
	public void setClientComment(String clientComment) {
		this.clientComment = clientComment;
	}

	/**
	 */
	public String getClientComment() {
		return this.clientComment;
	}

	/**
	 */
	public void setWorkOrders(Set<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}

	/**
	 */
	@JsonIgnore
	public Set<WorkOrder> getWorkOrders() {
		if (workOrders == null) {
			workOrders = new java.util.LinkedHashSet<axi.source.domain.WorkOrder>();
		}
		return workOrders;
	}

	/**
	 */
	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	/**
	 */
	@JsonIgnore
	public Set<Inventory> getInventories() {
		if (inventories == null) {
			inventories = new java.util.LinkedHashSet<axi.source.domain.Inventory>();
		}
		return inventories;
	}

	/**
	 */
	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	/**
	 */
	@JsonIgnore
	public Set<PurchaseOrder> getPurchaseOrders() {
		if (purchaseOrders == null) {
			purchaseOrders = new java.util.LinkedHashSet<axi.source.domain.PurchaseOrder>();
		}
		return purchaseOrders;
	}

	/**
	 */
	public void setQuotes(Set<Quote> quotes) {
		this.quotes = quotes;
	}

	/**
	 */
	@JsonIgnore
	public Set<Quote> getQuotes() {
		if (quotes == null) {
			quotes = new java.util.LinkedHashSet<axi.source.domain.Quote>();
		}
		return quotes;
	}

	/**
	 */
	public Client() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Client that) {
		setClientId(that.getClientId());
		setClientType(that.getClientType());
		setClientName(that.getClientName());
		setClientPhoneNum(that.getClientPhoneNum());
		setClientExt(that.getClientExt());
		setClientEmail(that.getClientEmail());
		setClientAddress(that.getClientAddress());
		setClientCity(that.getClientCity());
		setPostalCode(that.getPostalCode());
		setClientComment(that.getClientComment());
		setWorkOrders(new java.util.LinkedHashSet<axi.source.domain.WorkOrder>(that.getWorkOrders()));
		setInventories(new java.util.LinkedHashSet<axi.source.domain.Inventory>(that.getInventories()));
		setPurchaseOrders(new java.util.LinkedHashSet<axi.source.domain.PurchaseOrder>(that.getPurchaseOrders()));
		setQuotes(new java.util.LinkedHashSet<axi.source.domain.Quote>(that.getQuotes()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("clientId=[").append(clientId).append("] ");
		buffer.append("clientType=[").append(clientType).append("] ");
		buffer.append("clientName=[").append(clientName).append("] ");
		buffer.append("clientPhoneNum=[").append(clientPhoneNum).append("] ");
		buffer.append("clientExt=[").append(clientExt).append("] ");
		buffer.append("clientEmail=[").append(clientEmail).append("] ");
		buffer.append("clientAddress=[").append(clientAddress).append("] ");
		buffer.append("clientCity=[").append(clientCity).append("] ");
		buffer.append("postalCode=[").append(postalCode).append("] ");
		buffer.append("clientComment=[").append(clientComment).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((clientId == null) ? 0 : clientId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Client))
			return false;
		Client equalCheck = (Client) obj;
		if ((clientId == null && equalCheck.clientId != null) || (clientId != null && equalCheck.clientId == null))
			return false;
		if (clientId != null && !clientId.equals(equalCheck.clientId))
			return false;
		return true;
	}
}
