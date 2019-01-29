package com.qa.persistence.domain;

public class Account {

	Long id;
	private String fName;
	private String sName;

	public Account(Long id, String fName, String sName) {
		this.id = id;
		this.fName = fName;
		this.sName = sName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

}
