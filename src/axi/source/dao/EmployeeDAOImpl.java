package axi.source.dao;

import axi.source.domain.Employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Employee entities.
 * 
 */
@Repository("EmployeeDAO")
@Transactional
public class EmployeeDAOImpl extends AbstractJpaDao<Employee> implements
		EmployeeDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Employee.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_connector
	 *
	 */
	@PersistenceContext(unitName = "mysql_connector")
	private EntityManager entityManager;

	/**
	 * Instantiates a new EmployeeDAOImpl
	 *
	 */
	public EmployeeDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */
	@Transactional
	public Employee findEmployeeByEmployeeId(Integer employeeId) throws DataAccessException {

		return findEmployeeByEmployeeId(employeeId, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeId
	 *
	 */

	@Transactional
	public Employee findEmployeeByEmployeeId(Integer employeeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEmployeeByEmployeeId", startResult, maxRows, employeeId);
			return (axi.source.domain.Employee) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */
	@Transactional
	public Employee findEmployeeByPrimaryKey(Integer employeeId) throws DataAccessException {

		return findEmployeeByPrimaryKey(employeeId, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByPrimaryKey
	 *
	 */

	@Transactional
	public Employee findEmployeeByPrimaryKey(Integer employeeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEmployeeByPrimaryKey", startResult, maxRows, employeeId);
			return (axi.source.domain.Employee) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeCommentContaining
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeeCommentContaining(String employeeComment) throws DataAccessException {

		return findEmployeeByEmployeeCommentContaining(employeeComment, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeCommentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeeCommentContaining(String employeeComment, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeeCommentContaining", startResult, maxRows, employeeComment);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeNameContaining
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeeNameContaining(String employeeName) throws DataAccessException {

		return findEmployeeByEmployeeNameContaining(employeeName, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeeNameContaining(String employeeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeeNameContaining", startResult, maxRows, employeeName);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeEmail
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeeEmail(String employeeEmail) throws DataAccessException {

		return findEmployeeByEmployeeEmail(employeeEmail, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeeEmail(String employeeEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeeEmail", startResult, maxRows, employeeEmail);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeePhoneNum
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeePhoneNum(Integer employeePhoneNum) throws DataAccessException {

		return findEmployeeByEmployeePhoneNum(employeePhoneNum, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeePhoneNum
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeePhoneNum(Integer employeePhoneNum, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeePhoneNum", startResult, maxRows, employeePhoneNum);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeName
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeeName(String employeeName) throws DataAccessException {

		return findEmployeeByEmployeeName(employeeName, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeeName(String employeeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeeName", startResult, maxRows, employeeName);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeComment
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeeComment(String employeeComment) throws DataAccessException {

		return findEmployeeByEmployeeComment(employeeComment, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeComment
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeeComment(String employeeComment, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeeComment", startResult, maxRows, employeeComment);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeEmailContaining
	 *
	 */
	@Transactional
	public Set<Employee> findEmployeeByEmployeeEmailContaining(String employeeEmail) throws DataAccessException {

		return findEmployeeByEmployeeEmailContaining(employeeEmail, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeeByEmployeeEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findEmployeeByEmployeeEmailContaining(String employeeEmail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeeByEmployeeEmailContaining", startResult, maxRows, employeeEmail);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */
	@Transactional
	public Set<Employee> findAllEmployees() throws DataAccessException {

		return findAllEmployees(-1, -1);
	}

	/**
	 * JPQL Query - findAllEmployees
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employee> findAllEmployees(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllEmployees", startResult, maxRows);
		return new LinkedHashSet<Employee>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Employee entity) {
		return true;
	}
}
