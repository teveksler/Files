package axi.source.dao;

import axi.source.domain.Client;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Client entities.
 * 
 */
public interface ClientDAO extends JpaDao<Client> {

	/**
	 * JPQL Query - findClientByClientComment
	 *
	 */
	public Set<Client> findClientByClientComment(String clientComment) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientComment
	 *
	 */
	public Set<Client> findClientByClientComment(String clientComment, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientCity
	 *
	 */
	public Set<Client> findClientByClientCity(String clientCity) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientCity
	 *
	 */
	public Set<Client> findClientByClientCity(String clientCity, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientCityContaining
	 *
	 */
	public Set<Client> findClientByClientCityContaining(String clientCity_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientCityContaining
	 *
	 */
	public Set<Client> findClientByClientCityContaining(String clientCity_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientAddress
	 *
	 */
	public Set<Client> findClientByClientAddress(String clientAddress) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientAddress
	 *
	 */
	public Set<Client> findClientByClientAddress(String clientAddress, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */
	public Client findClientByClientId(Integer clientId) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientId
	 *
	 */
	public Client findClientByClientId(Integer clientId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientAddressContaining
	 *
	 */
	public Set<Client> findClientByClientAddressContaining(String clientAddress_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientAddressContaining
	 *
	 */
	public Set<Client> findClientByClientAddressContaining(String clientAddress_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllClients
	 *
	 */
	public Set<Client> findAllClients() throws DataAccessException;

	/**
	 * JPQL Query - findAllClients
	 *
	 */
	public Set<Client> findAllClients(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */
	public Client findClientByPrimaryKey(Integer clientId_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPrimaryKey
	 *
	 */
	public Client findClientByPrimaryKey(Integer clientId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientCommentContaining
	 *
	 */
	public Set<Client> findClientByClientCommentContaining(String clientComment_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientCommentContaining
	 *
	 */
	public Set<Client> findClientByClientCommentContaining(String clientComment_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientTypeContaining
	 *
	 */
	public Set<Client> findClientByClientTypeContaining(String clientType) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientTypeContaining
	 *
	 */
	public Set<Client> findClientByClientTypeContaining(String clientType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPostalCodeContaining
	 *
	 */
	public Set<Client> findClientByPostalCodeContaining(String postalCode) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPostalCodeContaining
	 *
	 */
	public Set<Client> findClientByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientEmailContaining
	 *
	 */
	public Set<Client> findClientByClientEmailContaining(String clientEmail) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientEmailContaining
	 *
	 */
	public Set<Client> findClientByClientEmailContaining(String clientEmail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientEmail
	 *
	 */
	public Set<Client> findClientByClientEmail(String clientEmail_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientEmail
	 *
	 */
	public Set<Client> findClientByClientEmail(String clientEmail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */
	public Set<Client> findClientByClientName(String clientName) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientName
	 *
	 */
	public Set<Client> findClientByClientName(String clientName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientType
	 *
	 */
	public Set<Client> findClientByClientType(String clientType_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientType
	 *
	 */
	public Set<Client> findClientByClientType(String clientType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientExt
	 *
	 */
	public Set<Client> findClientByClientExt(Integer clientExt) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientExt
	 *
	 */
	public Set<Client> findClientByClientExt(Integer clientExt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPostalCode
	 *
	 */
	public Set<Client> findClientByPostalCode(String postalCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByPostalCode
	 *
	 */
	public Set<Client> findClientByPostalCode(String postalCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */
	public Set<Client> findClientByClientNameContaining(String clientName_1) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientNameContaining
	 *
	 */
	public Set<Client> findClientByClientNameContaining(String clientName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientPhoneNum
	 *
	 */
	public Set<Client> findClientByClientPhoneNum(Integer clientPhoneNum) throws DataAccessException;

	/**
	 * JPQL Query - findClientByClientPhoneNum
	 *
	 */
	public Set<Client> findClientByClientPhoneNum(Integer clientPhoneNum, int startResult, int maxRows) throws DataAccessException;

}