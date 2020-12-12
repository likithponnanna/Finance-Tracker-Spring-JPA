package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the credit_card database table.
 * 
 */
@Entity
@Table(name="credit_card")
//@NamedQuery(name="CreditCard.findAll", query="SELECT c FROM CreditCard c")
public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="creditCardNo")
	private String creditCardNo;

	@Column(name="cardApproved")
	private boolean cardApproved;



	@Column(name="cardCurrentUsage")
	private int cardCurrentUsage;



//	@Column(name="cardId")
//	private BigInteger cardId;



	@Column(name="cardLimit")
	private int cardLimit;



	@Column(name="cardName")
	private String cardName;

	//bi-directional many-to-one association to Bank
//	@ManyToOne
//	@JsonIgnore
//	private Bank bank;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cardId", referencedColumnName = "bankID")
	private Bank bank;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public boolean isCardApproved() {
		return cardApproved;
	}

	public void setCardApproved(boolean cardApproved) {
		this.cardApproved = cardApproved;
	}

	public int getCardCurrentUsage() {
		return cardCurrentUsage;
	}

	public void setCardCurrentUsage(int cardCurrentUsage) {
		this.cardCurrentUsage = cardCurrentUsage;
	}

	public int getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(int cardLimit) {
		this.cardLimit = cardLimit;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public CreditCard() {
	}







}