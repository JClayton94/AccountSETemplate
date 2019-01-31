package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	AccountMapRepository repo;

	JSONUtil util;

	@Before
	public void setup() {

		util = new JSONUtil();

		repo = new AccountMapRepository();

	}

	@Test
	public void addAccountTest() {

		repo.createAccount(util.getJSONForObject(new Account(1l, "bob", "dole")));

		assertEquals("bob", util.getObjectForJSON(repo.getAllAccounts(), Account[].class)[0].getfName());

		Account[] accounts = util.getObjectForJSON(repo.getAllAccounts(), Account[].class);

		assertEquals("bob", accounts[0].getfName());

	}

	@Test
	public void add2AccountTest() {

		repo.createAccount(util.getJSONForObject(new Account(1l, "bob", "dole")));
		repo.createAccount(util.getJSONForObject(new Account(2l, "dave", "davidson")));

		assertEquals(2, util.getObjectForJSON(repo.getAllAccounts(), Account[].class).length);

	}

	@Test
	public void removeAccountTest() {

		repo.createAccount(util.getJSONForObject(new Account(1l, "bob", "dole")));

		repo.deleteAccount(1l);

		assertEquals(0, util.getObjectForJSON(repo.getAllAccounts(), Account[].class).length);

	}

	@Test
	public void remove2AccountTest() {

		repo.createAccount(util.getJSONForObject(new Account(1l, "bob", "dole")));
		repo.createAccount(util.getJSONForObject(new Account(2l, "dave", "davidson")));

		repo.deleteAccount(1l);
		repo.deleteAccount(2l);

		assertEquals(0, util.getObjectForJSON(repo.getAllAccounts(), Account[].class).length);

	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {

	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {

	}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {

	}

	@Test
	public void accountConversionToJSONTest() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {

	}

}
