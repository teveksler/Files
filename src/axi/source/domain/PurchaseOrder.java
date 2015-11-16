package axi.source.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Set;

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
		@NamedQuery(name = "findAllPurchaseOrders", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder"),
		@NamedQuery(name = "findPurchaseOrderByPrimaryKey", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderId = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderAddress", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderAddress = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderAddressContaining", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderAddress like ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderCreatedDate", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderCreatedDate = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderCreatedDateAfter", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderCreatedDate > ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderCreatedDateBefore", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderCreatedDate < ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderExpectedDate", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderExpectedDate = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderExpectedDateAfter", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderExpectedDate > ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderExpectedDateBefore", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderExpectedDate < ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderId", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderId = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderRecievedDate", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderRecievedDate = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderRecievedDateAfter", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderRecievedDate > ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderRecievedDateBefore", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderRecievedDate < ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderStatus", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderStatus = ?1"),
		@NamedQuery(name = "findPurchaseOrderByPurchaseOrderStatusContaining", query = "select myPurchaseOrder from PurchaseOrder myPurchaseOrder where myPurchaseOrder.purchaseOrderStatus like ?1") })
@Table(catalog = "hibernatedb", name = "purchase_order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "AXI_Final_Prototype/axi/source/domain", name = "PurchaseOrder")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "purchase_order_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	Integer purchaseOrderId;
	/**
	 */

	@Column(name = "purchase_order_address", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String purchaseOrderAddress;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_order_created_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar purchaseOrderCreatedDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_order_expected_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar purchaseOrderExpectedDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_order_recieved_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar purchaseOrderRecievedDate;
	/**
	 */

	@Column(name = "purchase_order_status", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String purchaseOrderStatus;

	/**
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(catalog = "hibernatedb", name = "purchase_order_client", joinColumns = { @JoinColumn(name = "purchase_order_client_purchase_order_id", referencedColumnName = "purchase_order_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "purchase_order_client_id", referencedColumnName = "client_id", nullable = false, updatable = false) })
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.Client> clients;
	/**
	 */
	@ManyToMany(mappedBy = "purchaseOrders", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.Inventory> inventories;

	/**
	 */
	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	/**
	 */
	public Integer getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	/**
	 */
	public void setPurchaseOrderAddress(String purchaseOrderAddress) {
		this.purchaseOrderAddress = purchaseOrderAddress;
	}

	/**
	 */
	public String getPurchaseOrderAddress() {
		return this.purchaseOrderAddress;
	}

	/**
	 */
	public void setPurchaseOrderCreatedDate(Calendar purchaseOrderCreatedDate) {
		this.purchaseOrderCreatedDate = purchaseOrderCreatedDate;
	}

	/**
	 */
	public Calendar getPurchaseOrderCreatedDate() {
		return this.purchaseOrderCreatedDate;
	}

	/**
	 */
	public void setPurchaseOrderExpectedDate(Calendar purchaseOrderExpectedDate) {
		this.purchaseOrderExpectedDate = purchaseOrderExpectedDate;
	}

	/**
	 */
	public Calendar getPurchaseOrderExpectedDate() {
		return this.purchaseOrderExpectedDate;
	}

	/**
	 */
	public void setPurchaseOrderRecievedDate(Calendar purchaseOrderRecievedDate) {
		this.purchaseOrderRecievedDate = purchaseOrderRecievedDate;
	}

	/**
	 */
	public Calendar getPurchaseOrderRecievedDate() {
		return this.purchaseOrderRecievedDate;
	}

	/**
	 */
	public void setPurchaseOrderStatus(String purchaseOrderStatus) {
		this.purchaseOrderStatus = purchaseOrderStatus;
	}

	/**
	 */
	public String getPurchaseOrderStatus() {
		return this.purchaseOrderStatus;
	}

	/**
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 */
	@JsonIgnore
	public Set<Client> getClients() {
		if (clients == null) {
			clients = new java.util.LinkedHashSet<axi.source.domain.Client>();
		}
		return clients;
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
	public PurchaseOrder() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(PurchaseOrder that) {
		setPurchaseOrderId(that.getPurchaseOrderId());
		setPurchaseOrderAddress(that.getPurchaseOrderAddress());
		setPurchaseOrderCreatedDate(that.getPurchaseOrderCreatedDate());
		setPurchaseOrderExpectedDate(that.getPurchaseOrderExpectedDate());
		setPurchaseOrderRecievedDate(that.getPurchaseOrderRecievedDate());
		setPurchaseOrderStatus(that.getPurchaseOrderStatus());
		setClients(new java.util.LinkedHashSet<axi.source.domain.Client>(that.getClients()));
		setInventories(new java.util.LinkedHashSet<axi.source.domain.Inventory>(that.getInventories()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("purchaseOrderId=[").append(purchaseOrderId).append("] ");
		buffer.append("purchaseOrderAddress=[").append(purchaseOrderAddress).append("] ");
		buffer.append("purchaseOrderCreatedDate=[").append(purchaseOrderCreatedDate).append("] ");
		buffer.append("purchaseOrderExpectedDate=[").append(purchaseOrderExpectedDate).append("] ");
		buffer.append("purchaseOrderRecievedDate=[").append(purchaseOrderRecievedDate).append("] ");
		buffer.append("purchaseOrderStatus=[").append(purchaseOrderStatus).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((purchaseOrderId == null) ? 0 : purchaseOrderId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PurchaseOrder))
			return false;
		PurchaseOrder equalCheck = (PurchaseOrder) obj;
		if ((purchaseOrderId == null && equalCheck.purchaseOrderId != null) || (purchaseOrderId != null && equalCheck.purchaseOrderId == null))
			return false;
		if (purchaseOrderId != null && !purchaseOrderId.equals(equalCheck.purchaseOrderId))
			return false;
		return true;
	}
}
