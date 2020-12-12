package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Trader database table.
 * 
 */
@Entity
//@NamedQuery(name="Trader.findAll", query="SELECT t FROM Trader t")
public class Trader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@Column(name = "email")
//	private String email;


//	@Id  @Column(name="customerEmail")
//	private String customerEmail;
//
//
//	@OneToOne(mappedBy = "email")
//	private AppUser appUser;
//
//	@OneToOne(cascade = CascadeType.ALL, optional = false)
//	@JoinColumn(name = "email")
//	@MapsId
//	private AppUser appUser;

	//- Last Tried
//	@OneToOne(cascade = CascadeType.ALL)
//	@MapsId
//	@JoinColumn(name = "id", referencedColumnName = "id")
//	private AppUser appUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private AppUser appUser;


//	@Id
//	@Column(name="traderEmail")
//	private String traderEmail;

	@Column(name="accountStatus")
	private boolean accountStatus;
//
//
//	//bi-directional many-to-one association to AppUser
//	@EmbeddedId
//	@ManyToOne
//	@JoinColumn(name="traderEmail")
//	private AppUser appUser;


	//bi-directional many-to-many association to Bank
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Trading",
			joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "stockTransactionId", referencedColumnName = "stockTransactionId"))
	private Set<StockTrade> stockTrades;



//	public Trader(AppUser appUser, boolean accountStatus, Set<StockTrade> stockTrades) {
//
//		this.appUser = appUser;
//		this.accountStatus = accountStatus;
//		this.stockTrades = stockTrades;
//	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Set<StockTrade> getStockTrades() {
		return stockTrades;
	}

	public void setStockTrades(Set<StockTrade> stockTrades) {
		this.stockTrades = stockTrades;
	}

	public Trader() {
	}



}