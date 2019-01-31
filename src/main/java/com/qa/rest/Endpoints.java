package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.buiness.AccountBuinessLayer;

@Path("/account")
public class Endpoints {

	@Inject
	AccountBuinessLayer repo;
	
	@Path("/")
	@GET
	public String getAllAccounts() {

		return repo.getAllAccounts();

	}

	@Path("/")
	@POST
	public String createAccount(String account) {
		
		return repo.createAccount(account);

	}

	@Path("/{id}")
	@DELETE
	public String deleteAccount(@PathParam("id") Long id) {

		return repo.deleteAccount(id);

	}

	@Path("/{id}")
	@PUT
	public String updateAccount(@PathParam("id") Long id, String account) {

		return repo.updateAccount(id, account);

	}
	
}
