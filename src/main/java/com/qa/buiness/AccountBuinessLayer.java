package com.qa.buiness;

public interface AccountBuinessLayer {
	
		String getAllAccounts();
		String createAccount(String account);
		String deleteAccount(Long id);
		String updateAccount(Long id, String account);
		
}
