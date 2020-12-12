package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the Accounts database table.
 * 
 */
@Entity
@Table(name="Account")
//@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId", nullable = false)
	private Long accountId;

	@Column(name = "accountName", nullable = false)
	private String accountName;


	//bi-directional many-to-one association to Bank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="accountNo", referencedColumnName = "bankId")
	private Bank bank;


	//bi-directional many-to-one association to Bank
//	@ManyToOne
//	@JsonIgnore
//	private Bank bank;

	//bi-directional many-to-one association to Checking
	@OneToMany(mappedBy="account")
	@JsonIgnore
	private List<Checking> checkings;



//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "address_id", referencedColumnName = "id")
//	private List<Checking> checkings;

	@OneToMany(mappedBy="account")
	private List<Saving> savings;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Checking> getCheckings() {
		return checkings;
	}

	public void setCheckings(List<Checking> checkings) {
		this.checkings = checkings;
	}

	public List<Saving> getSavings() {
		return savings;
	}

	public void setSavings(List<Saving> savings) {
		this.savings = savings;
	}

//
//	//bi-directional many-to-one association to Saving
//	@OneToMany(mappedBy="account")
//	private List<Saving> savings;

	public Account() {
	}



}