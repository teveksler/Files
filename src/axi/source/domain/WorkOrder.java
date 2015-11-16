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
		@NamedQuery(name = "findAllWorkOrders", query = "select myWorkOrder from WorkOrder myWorkOrder"),
		@NamedQuery(name = "findWorkOrderByPrimaryKey", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderId = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderAddress", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderAddress = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderAddressContaining", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderAddress like ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderCreatedOn", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderCreatedOn = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderCreatedOnAfter", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderCreatedOn > ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderCreatedOnBefore", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderCreatedOn < ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderEndDate", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderEndDate = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderEndDateAfter", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderEndDate > ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderEndDateBefore", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderEndDate < ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderExpectedEndDate", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderExpectedEndDate = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderExpectedEndDateAfter", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderExpectedEndDate > ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderExpectedEndDateBefore", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderExpectedEndDate < ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderId", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderId = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderScope", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderScope = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderScopeContaining", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderScope like ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderStatus", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderStatus = ?1"),
		@NamedQuery(name = "findWorkOrderByWorkOrderStatusContaining", query = "select myWorkOrder from WorkOrder myWorkOrder where myWorkOrder.workOrderStatus like ?1") })
@Table(catalog = "hibernatedb", name = "work_order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "AXI_Final_Prototype/axi/source/domain", name = "WorkOrder")
public class WorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "work_order_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	Integer workOrderId;
	/**
	 */

	@Column(name = "work_order_scope")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String workOrderScope;
	/**
	 */

	@Column(name = "work_order_address")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String workOrderAddress;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "work_order_created_on", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar workOrderCreatedOn;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "work_order_expected_end_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar workOrderExpectedEndDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "work_order_end_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar workOrderEndDate;
	/**
	 */

	@Column(name = "work_order_status", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String workOrderStatus;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "work_order_client_id", referencedColumnName = "client_id") })
	@XmlTransient
	Client client;
	/**
	 */
	@ManyToMany(mappedBy = "workOrders", fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.Employee> employees;
	/**
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(catalog = "hibernatedb", name = "work_order_inventory", joinColumns = { @JoinColumn(name = "work_order_inventory_work_order_id", referencedColumnName = "work_order_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "work_order_inventory_id", referencedColumnName = "inventory_id", nullable = false, updatable = false) })
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.Inventory> inventories;

	/**
	 */
	public void setWorkOrderId(Integer workOrderId) {
		this.workOrderId = workOrderId;
	}

	/**
	 */
	public Integer getWorkOrderId() {
		return this.workOrderId;
	}

	/**
	 */
	public void setWorkOrderScope(String workOrderScope) {
		this.workOrderScope = workOrderScope;
	}

	/**
	 */
	public String getWorkOrderScope() {
		return this.workOrderScope;
	}

	/**
	 */
	public void setWorkOrderAddress(String workOrderAddress) {
		this.workOrderAddress = workOrderAddress;
	}

	/**
	 */
	public String getWorkOrderAddress() {
		return this.workOrderAddress;
	}

	/**
	 */
	public void setWorkOrderCreatedOn(Calendar workOrderCreatedOn) {
		this.workOrderCreatedOn = workOrderCreatedOn;
	}

	/**
	 */
	public Calendar getWorkOrderCreatedOn() {
		return this.workOrderCreatedOn;
	}

	/**
	 */
	public void setWorkOrderExpectedEndDate(Calendar workOrderExpectedEndDate) {
		this.workOrderExpectedEndDate = workOrderExpectedEndDate;
	}

	/**
	 */
	public Calendar getWorkOrderExpectedEndDate() {
		return this.workOrderExpectedEndDate;
	}

	/**
	 */
	public void setWorkOrderEndDate(Calendar workOrderEndDate) {
		this.workOrderEndDate = workOrderEndDate;
	}

	/**
	 */
	public Calendar getWorkOrderEndDate() {
		return this.workOrderEndDate;
	}

	/**
	 */
	public void setWorkOrderStatus(String workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}

	/**
	 */
	public String getWorkOrderStatus() {
		return this.workOrderStatus;
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
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	/**
	 */
	@JsonIgnore
	public Set<Employee> getEmployees() {
		if (employees == null) {
			employees = new java.util.LinkedHashSet<axi.source.domain.Employee>();
		}
		return employees;
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
	public WorkOrder() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(WorkOrder that) {
		setWorkOrderId(that.getWorkOrderId());
		setWorkOrderScope(that.getWorkOrderScope());
		setWorkOrderAddress(that.getWorkOrderAddress());
		setWorkOrderCreatedOn(that.getWorkOrderCreatedOn());
		setWorkOrderExpectedEndDate(that.getWorkOrderExpectedEndDate());
		setWorkOrderEndDate(that.getWorkOrderEndDate());
		setWorkOrderStatus(that.getWorkOrderStatus());
		setClient(that.getClient());
		setEmployees(new java.util.LinkedHashSet<axi.source.domain.Employee>(
				that.getEmployees()));
		setInventories(new java.util.LinkedHashSet<axi.source.domain.Inventory>(
				that.getInventories()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("workOrderId=[").append(workOrderId).append("] ");
		buffer.append("workOrderScope=[").append(workOrderScope).append("] ");
		buffer.append("workOrderAddress=[").append(workOrderAddress)
				.append("] ");
		buffer.append("workOrderCreatedOn=[").append(workOrderCreatedOn)
				.append("] ");
		buffer.append("workOrderExpectedEndDate=[")
				.append(workOrderExpectedEndDate).append("] ");
		buffer.append("workOrderEndDate=[").append(workOrderEndDate)
				.append("] ");
		buffer.append("workOrderStatus=[").append(workOrderStatus).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((workOrderId == null) ? 0
				: workOrderId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof WorkOrder))
			return false;
		WorkOrder equalCheck = (WorkOrder) obj;
		if ((workOrderId == null && equalCheck.workOrderId != null)
				|| (workOrderId != null && equalCheck.workOrderId == null))
			return false;
		if (workOrderId != null && !workOrderId.equals(equalCheck.workOrderId))
			return false;
		return true;
	}
}
