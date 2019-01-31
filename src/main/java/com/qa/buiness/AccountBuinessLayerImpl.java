package com.qa.buiness;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountBuinessLayerImpl implements AccountBuinessLayer {

	@Inject
	private AccountRepository repo;
	
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {

		return repo.getAllAccounts();

	}

	public String createAccount(String account) {
		
		if(util.getObjectForJSON(account, Account.class).getId() == 9) {
			
			return "Account ID 9 Blocked";
			
		}

		return repo.createAccount(account);

	}

	public String deleteAccount(Long id) {

		return repo.deleteAccount(id);

	}

	public String updateAccount(Long id, String account) {

		return repo.updateAccount(id, account);

	}

}
