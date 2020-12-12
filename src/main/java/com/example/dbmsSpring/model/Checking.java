package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the Checking database table.
 * 
 */
@Entity
//@NamedQuery(name="Checking.findAll", query="SELECT c FROM Checking c")
public class Checking implements Serializable {
	private static final long serialVersionUID = 1L;


//	@JoinColumn(name="checkingNo", referencedColumnName = "accountId")
//	private String checkingNo;

	@Id
	@Column(name="checkingAccountNum")
	private String checkingAccountNum;

	@Column(name="checkingAccName")
	private String checkingAccName;

	@Column(name="checkingApproved")
	private boolean checkingApproved;


	@Column(name="currentCheckingBalance")
	private int currentCheckingBalance;



	@Column(name="withdrawLimit")
	private int withdrawLimit;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCheckingAccountNum() {
		return checkingAccountNum;
	}

	public void setCheckingAccountNum(String checkingAccountNum) {
		this.checkingAccountNum = checkingAccountNum;
	}

	public String getCheckingAccName() {
		return checkingAccName;
	}

	public void setCheckingAccName(String checkingAccName) {
		this.checkingAccName = checkingAccName;
	}

	public boolean isCheckingApproved() {
		return checkingApproved;
	}

	public void setCheckingApproved(boolean checkingApproved) {
		this.checkingApproved = checkingApproved;
	}

	public int getCurrentCheckingBalance() {
		return currentCheckingBalance;
	}

	public void setCurrentCheckingBalance(int currentCheckingBalance) {
		this.currentCheckingBalance = currentCheckingBalance;
	}

	public int getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(int withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	//bi-directional many-to-one association to Bank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="checkingNo", referencedColumnName = "accountId")
	private Account account;





	//bi-directional many-to-one association to BankTransaction
//	@OneToMany(mappedBy="checking")
//	private List<BankTransaction> bankTransactions;



	public Checking() {
	}





}