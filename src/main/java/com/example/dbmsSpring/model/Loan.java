package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the Loan database table.
 * 
 */
@Entity
//@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loan_number")
	private String loanNumber;

	private int apr;


	@Column(name="loan_amount")
	private int loanAmount;

	@Column(name="loan_approval")
	private boolean loanApproval;

	@Column(name="loan_balance")
	private int loanBalance;

//	@Column(name="loan_id")
//	private BigInteger loanId;

	@Column(name="loan_name")
	private String loanName;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getApr() {
		return apr;
	}

	public void setApr(int apr) {
		this.apr = apr;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public boolean isLoanApproval() {
		return loanApproval;
	}

	public void setLoanApproval(boolean loanApproval) {
		this.loanApproval = loanApproval;
	}

	public int getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(int loanBalance) {
		this.loanBalance = loanBalance;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
//bi-directional many-to-one association to BankTransaction
//	@OneToMany(mappedBy="loan")
//	private List<BankTransaction> bankTransactions;

	//bi-directional many-to-one association to Bank
//	@ManyToOne
//	@JsonIgnore
//	private Bank bank;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="loanId", referencedColumnName = "bankID")
	private Bank bank;

	public Loan() {
	}





}