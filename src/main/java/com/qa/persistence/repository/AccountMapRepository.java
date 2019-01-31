package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	JSONUtil util = new JSONUtil();

	Map<Long, Account> accountMap = new HashMap<>();

	
	

	public String getAllAccounts() {

		return util.getJSONForObject(accountMap.values());
	}
	
	public String createAccount(String account) {

		Account newAccount = util.getObjectForJSON(account, Account.class);

		accountMap.put(newAccount.getId(), newAccount);

		return "Account created";
	}

	public String deleteAccount(Long id) {

		accountMap.remove(id);

		return "Account with id: " + id + " deleted!";
	}

	public String updateAccount(Long id, String account) {

		Account newAccount = util.getObjectForJSON(account, Account.class);

		accountMap.put(id, newAccount);

		return "Account updated";
	}
	

}
