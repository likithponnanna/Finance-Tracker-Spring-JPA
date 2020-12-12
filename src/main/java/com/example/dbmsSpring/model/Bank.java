package com.example.dbmsSpring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Bank database table.
 * 
 */


@Entity
@Table(name = "Bank")
//@NamedQuery(name="Bank.findAll", query="SELECT b FROM Bank b")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bankID")
	private Long bankID;

	@Column(name = "bankName")
	private String bankName;


	@Column(name = "branchType")
	private boolean branchType = false;



	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="bank")
	private List<Account> accounts;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="zipcode")
	private Address address;




	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},mappedBy = "banks")
	private Set<Customer> customers = new HashSet<>();



	//bi-directional many-to-one association to CreditCard
	@OneToMany(mappedBy="bank")
	private List<CreditCard> creditCards;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="bank")
	private List<Loan> loans;

	public Bank() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getBankID() {
		return bankID;
	}

	public void setBankID(Long bankID) {
		this.bankID = bankID;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public boolean isBranchType() {
		return branchType;
	}

	public void setBranchType(boolean branchType) {
		this.branchType = branchType;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
}