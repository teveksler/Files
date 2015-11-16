package axi.source.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.math.BigDecimal;
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
		@NamedQuery(name = "findAllInventorys", query = "select myInventory from Inventory myInventory"),
		@NamedQuery(name = "findInventoryByInventoryId", query = "select myInventory from Inventory myInventory where myInventory.inventoryId = ?1"),
		@NamedQuery(name = "findInventoryByInventoryLocation", query = "select myInventory from Inventory myInventory where myInventory.inventoryLocation = ?1"),
		@NamedQuery(name = "findInventoryByInventoryLocationContaining", query = "select myInventory from Inventory myInventory where myInventory.inventoryLocation like ?1"),
		@NamedQuery(name = "findInventoryByInventoryLowThreshold", query = "select myInventory from Inventory myInventory where myInventory.inventoryLowThreshold = ?1"),
		@NamedQuery(name = "findInventoryByInventoryName", query = "select myInventory from Inventory myInventory where myInventory.inventoryName = ?1"),
		@NamedQuery(name = "findInventoryByInventoryNameContaining", query = "select myInventory from Inventory myInventory where myInventory.inventoryName like ?1"),
		@NamedQuery(name = "findInventoryByInventoryPrice", query = "select myInventory from Inventory myInventory where myInventory.inventoryPrice = ?1"),
		@NamedQuery(name = "findInventoryByInventoryProductName", query = "select myInventory from Inventory myInventory where myInventory.inventoryProductName = ?1"),
		@NamedQuery(name = "findInventoryByInventoryProductNameContaining", query = "select myInventory from Inventory myInventory where myInventory.inventoryProductName like ?1"),
		@NamedQuery(name = "findInventoryByInventoryStockLevel", query = "select myInventory from Inventory myInventory where myInventory.inventoryStockLevel = ?1"),
		@NamedQuery(name = "findInventoryByInventoryUnit", query = "select myInventory from Inventory myInventory where myInventory.inventoryUnit = ?1"),
		@NamedQuery(name = "findInventoryByInventoryUnitContaining", query = "select myInventory from Inventory myInventory where myInventory.inventoryUnit like ?1"),
		@NamedQuery(name = "findInventoryByPrimaryKey", query = "select myInventory from Inventory myInventory where myInventory.inventoryId = ?1") })
@Table(catalog = "hibernatedb", name = "inventory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "AXI_Final_Prototype/axi/source/domain", name = "Inventory")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "inventory_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	Integer inventoryId;
	/**
	 */

	@Column(name = "inventory_product_name", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String inventoryProductName;
	/**
	 */

	@Column(name = "inventory_name", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String inventoryName;
	/**
	 */

	@Column(name = "inventory_price", precision = 22, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal inventoryPrice;
	/**
	 */

	@Column(name = "inventory_stock_level", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer inventoryStockLevel;
	/**
	 */

	@Column(name = "inventory_unit", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String inventoryUnit;
	/**
	 */

	@Column(name = "inventory_low_threshold", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer inventoryLowThreshold;
	/**
	 */

	@Column(name = "inventory_location", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String inventoryLocation;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "inventory_client_id", referencedColumnName = "client_id") })
	@XmlTransient
	Client client;
	/**
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(catalog = "hibernatedb", name = "purchase_order_inventory", joinColumns = { @JoinColumn(name = "purchase_order_inventory_id", referencedColumnName = "inventory_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "purchase_order_inventory_purchase_order_id", referencedColumnName = "purchase_order_id", nullable = false, updatable = false) })
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.PurchaseOrder> purchaseOrders;
	/**
	 */
	@ManyToMany(mappedBy = "inventories", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.WorkOrder> workOrders;

	/**
	 */
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 */
	public Integer getInventoryId() {
		return this.inventoryId;
	}

	/**
	 */
	public void setInventoryProductName(String inventoryProductName) {
		this.inventoryProductName = inventoryProductName;
	}

	/**
	 */
	public String getInventoryProductName() {
		return this.inventoryProductName;
	}

	/**
	 */
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	/**
	 */
	public String getInventoryName() {
		return this.inventoryName;
	}

	/**
	 */
	public void setInventoryPrice(BigDecimal inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}

	/**
	 */
	public BigDecimal getInventoryPrice() {
		return this.inventoryPrice;
	}

	/**
	 */
	public void setInventoryStockLevel(Integer inventoryStockLevel) {
		this.inventoryStockLevel = inventoryStockLevel;
	}

	/**
	 */
	public Integer getInventoryStockLevel() {
		return this.inventoryStockLevel;
	}

	/**
	 */
	public void setInventoryUnit(String inventoryUnit) {
		this.inventoryUnit = inventoryUnit;
	}

	/**
	 */
	public String getInventoryUnit() {
		return this.inventoryUnit;
	}

	/**
	 */
	public void setInventoryLowThreshold(Integer inventoryLowThreshold) {
		this.inventoryLowThreshold = inventoryLowThreshold;
	}

	/**
	 */
	public Integer getInventoryLowThreshold() {
		return this.inventoryLowThreshold;
	}

	/**
	 */
	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}

	/**
	 */
	public String getInventoryLocation() {
		return this.inventoryLocation;
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
	public Inventory() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Inventory that) {
		setInventoryId(that.getInventoryId());
		setInventoryProductName(that.getInventoryProductName());
		setInventoryName(that.getInventoryName());
		setInventoryPrice(that.getInventoryPrice());
		setInventoryStockLevel(that.getInventoryStockLevel());
		setInventoryUnit(that.getInventoryUnit());
		setInventoryLowThreshold(that.getInventoryLowThreshold());
		setInventoryLocation(that.getInventoryLocation());
		setClient(that.getClient());
		setPurchaseOrders(new java.util.LinkedHashSet<axi.source.domain.PurchaseOrder>(that.getPurchaseOrders()));
		setWorkOrders(new java.util.LinkedHashSet<axi.source.domain.WorkOrder>(that.getWorkOrders()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("inventoryId=[").append(inventoryId).append("] ");
		buffer.append("inventoryProductName=[").append(inventoryProductName).append("] ");
		buffer.append("inventoryName=[").append(inventoryName).append("] ");
		buffer.append("inventoryPrice=[").append(inventoryPrice).append("] ");
		buffer.append("inventoryStockLevel=[").append(inventoryStockLevel).append("] ");
		buffer.append("inventoryUnit=[").append(inventoryUnit).append("] ");
		buffer.append("inventoryLowThreshold=[").append(inventoryLowThreshold).append("] ");
		buffer.append("inventoryLocation=[").append(inventoryLocation).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Inventory))
			return false;
		Inventory equalCheck = (Inventory) obj;
		if ((inventoryId == null && equalCheck.inventoryId != null) || (inventoryId != null && equalCheck.inventoryId == null))
			return false;
		if (inventoryId != null && !inventoryId.equals(equalCheck.inventoryId))
			return false;
		return true;
	}
}
