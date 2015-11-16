package axi.source.dao;

import axi.source.domain.Employee;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Employee entities.
 * 
 */
public interface EmployeeDAO extends JpaDao<Employee> {

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */
	public Employee findEmployeeByEmployeeId(Integer employeeId) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */
	public Employee findEmployeeByEmployeeId(Integer employeeId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */
	public Employee findEmployeeByPrimaryKey(Integer employeeId_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */
	public Employee findEmployeeByPrimaryKey(Integer employeeId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeCommentContaining
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeCommentContaining(String employeeComment) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeCommentContaining
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeCommentContaining(String employeeComment, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeNameContaining
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeNameContaining(String employeeName) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeNameContaining
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeNameContaining(String employeeName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeEmail
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeEmail(String employeeEmail) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeEmail
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeEmail(String employeeEmail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeePhoneNum
	 *
	 */
	public Set<Employee> findEmployeeByEmployeePhoneNum(Integer employeePhoneNum) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeePhoneNum
	 *
	 */
	public Set<Employee> findEmployeeByEmployeePhoneNum(Integer employeePhoneNum, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeName
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeName(String employeeName_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeName
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeName(String employeeName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeComment
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeComment(String employeeComment_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeComment
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeComment(String employeeComment_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeEmailContaining
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeEmailContaining(String employeeEmail_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeeByEmployeeEmailContaining
	 *
	 */
	public Set<Employee> findEmployeeByEmployeeEmailContaining(String employeeEmail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */
	public Set<Employee> findAllEmployees() throws DataAccessException;

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */
	public Set<Employee> findAllEmployees(int startResult, int maxRows) throws DataAccessException;

}