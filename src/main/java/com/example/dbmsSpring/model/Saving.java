package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the Savings database table.
 * 
 */
@Entity
@Table(name="Savings")
//@NamedQuery(name="Saving.findAll", query="SELECT s FROM Saving s")
public class Saving implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="savingsAccountNum")
	private String savingsAccountNum;

	@Column(name="currentSavingsBalance")
	private int currentSavingsBalance;



	@Column(name="intrestRate")
	private int intrestRate;



	@Column(name="monthlyWithdrawalTimes")
	private int monthlyWithdrawalTimes;



	@Column(name="savingsAccName")
	private String savingsAccName;

	@Column(name="savingsApproved")
	private boolean savingsApproved;



//	@Column(name="savingsNo")
//	private BigInteger savingsNo;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSavingsAccountNum() {
		return savingsAccountNum;
	}

	public void setSavingsAccountNum(String savingsAccountNum) {
		this.savingsAccountNum = savingsAccountNum;
	}

	public int getCurrentSavingsBalance() {
		return currentSavingsBalance;
	}

	public void setCurrentSavingsBalance(int currentSavingsBalance) {
		this.currentSavingsBalance = currentSavingsBalance;
	}

	public int getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(int intrestRate) {
		this.intrestRate = intrestRate;
	}

	public int getMonthlyWithdrawalTimes() {
		return monthlyWithdrawalTimes;
	}

	public void setMonthlyWithdrawalTimes(int monthlyWithdrawalTimes) {
		this.monthlyWithdrawalTimes = monthlyWithdrawalTimes;
	}

	public String getSavingsAccName() {
		return savingsAccName;
	}

	public void setSavingsAccName(String savingsAccName) {
		this.savingsAccName = savingsAccName;
	}

	public boolean isSavingsApproved() {
		return savingsApproved;
	}

	public void setSavingsApproved(boolean savingsApproved) {
		this.savingsApproved = savingsApproved;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="savingsNo", referencedColumnName = "accountId")
	private Account account;



//	//bi-directional many-to-one association to BankTransaction
//	@OneToMany(mappedBy="saving")
//	private List<BankTransaction> bankTransactions;



	public Saving() {
	}


}