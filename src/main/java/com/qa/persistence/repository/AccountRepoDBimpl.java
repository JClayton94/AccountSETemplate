package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;


@Default
@Transactional(SUPPORTS)
public class AccountRepoDBimpl implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	JSONUtil util;

	public String getAllAccounts() {

		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();

		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createAccount(String account) {

		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";

	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			Account newAccount = util.getObjectForJSON(account, Account.class);
			em.remove(accountInDB);
			em.persist(newAccount);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		return "{\"message\": \"account does not exist\"}";

	}

	private Account findAccount(Long id) {
		return em.find(Account.class, id);
	}

}
