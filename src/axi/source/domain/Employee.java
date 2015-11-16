package axi.source.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllEmployees", query = "select myEmployee from Employee myEmployee"),
		@NamedQuery(name = "findEmployeeByEmployeeComment", query = "select myEmployee from Employee myEmployee where myEmployee.employeeComment = ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeCommentContaining", query = "select myEmployee from Employee myEmployee where myEmployee.employeeComment like ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeEmail", query = "select myEmployee from Employee myEmployee where myEmployee.employeeEmail = ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeEmailContaining", query = "select myEmployee from Employee myEmployee where myEmployee.employeeEmail like ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeId", query = "select myEmployee from Employee myEmployee where myEmployee.employeeId = ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeName", query = "select myEmployee from Employee myEmployee where myEmployee.employeeName = ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeNameContaining", query = "select myEmployee from Employee myEmployee where myEmployee.employeeName like ?1"),
		@NamedQuery(name = "findEmployeeByEmployeePhoneNum", query = "select myEmployee from Employee myEmployee where myEmployee.employeePhoneNum = ?1"),
		@NamedQuery(name = "findEmployeeByPrimaryKey", query = "select myEmployee from Employee myEmployee where myEmployee.employeeId = ?1") })
@Table(catalog = "hibernatedb", name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "AXI_Final_Prototype/axi/source/domain", name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name = "employee_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	Integer employeeId;
	/**
	 */

	@Column(name = "employee_name", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String employeeName;
	/**
	 */

	@Column(name = "employee_phone_num")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Long employeePhoneNum;
	/**
	 */

	@Column(name = "employee_email", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String employeeEmail;
	/**
	 */

	@Column(name = "employee_comment")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String employeeComment;

	/**
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(catalog = "hibernatedb", name = "work_order_employee", joinColumns = { @JoinColumn(name = "work_order_employee_id", referencedColumnName = "employee_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "work_order_employee_work_order_id", referencedColumnName = "work_order_id", nullable = false, updatable = false) })
	@XmlElement(name = "", namespace = "")
	java.util.Set<axi.source.domain.WorkOrder> workOrders;

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeePhoneNum(Long employeePhoneNum) {
		this.employeePhoneNum = employeePhoneNum;
	}

	public Long getEmployeePhoneNum() {
		return this.employeePhoneNum;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeEmail() {
		return this.employeeEmail;
	}

	public void setEmployeeComment(String employeeComment) {
		this.employeeComment = employeeComment;
	}

	public String getEmployeeComment() {
		return this.employeeComment;
	}

	public void setWorkOrders(Set<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}

	@JsonIgnore
	public Set<WorkOrder> getWorkOrders() {
		if (workOrders == null) {
			workOrders = new java.util.LinkedHashSet<axi.source.domain.WorkOrder>();
		}
		return workOrders;
	}

	public Employee() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Employee that) {
		setEmployeeId(that.getEmployeeId());
		setEmployeeName(that.getEmployeeName());
		setEmployeePhoneNum(that.getEmployeePhoneNum());
		setEmployeeEmail(that.getEmployeeEmail());
		setEmployeeComment(that.getEmployeeComment());
		setWorkOrders(new java.util.LinkedHashSet<axi.source.domain.WorkOrder>(that.getWorkOrders()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("employeeId=[").append(employeeId).append("] ");
		buffer.append("employeeName=[").append(employeeName).append("] ");
		buffer.append("employeePhoneNum=[").append(employeePhoneNum).append("] ");
		buffer.append("employeeEmail=[").append(employeeEmail).append("] ");
		buffer.append("employeeComment=[").append(employeeComment).append("] ");

		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((employeeId == null) ? 0 : employeeId.hashCode()));
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee equalCheck = (Employee) obj;
		if ((employeeId == null && equalCheck.employeeId != null) || (employeeId != null && equalCheck.employeeId == null))
			return false;
		if (employeeId != null && !employeeId.equals(equalCheck.employeeId))
			return false;
		return true;
	}
}
