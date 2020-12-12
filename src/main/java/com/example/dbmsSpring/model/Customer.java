package com.example.dbmsSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Customer database table.
 * 
 */
@Entity
@Table(name="Customer")
//@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "id")
	private Integer id;


//	@Column(name = "email")
//	private String email;





	@Column(name="deactivated")
	private boolean deactivated = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private AppUser appUser;



	public boolean isDeactivated() {
		return deactivated;
	}

	public void setDeactivated(boolean deactivated) {
		this.deactivated = deactivated;
	}


	//bi-directional many-to-one association to Bank
	@OneToMany(mappedBy="address")
	@JsonIgnore
	private List<Bank> banks;




	//bi-directional many-to-many association to Bank
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JsonIgnore
	@JoinTable(name = "banksWith",
			joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "bankId", referencedColumnName = "bankId"))
	private Set<Bank> banks;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Customer() {
	}

//	public Customer(String customerEmail, AppUser appUser, Set<Bank> banks) {
//		this.customerEmail = customerEmail;
//		this.appUser = appUser;
//		this.banks = banks;
//	}


//	public String getCustomerEmail() {
//		return email;
//	}
//
//	public void setCustomerEmail(String customerEmail) {
//		this.email = customerEmail;
//	}

	public boolean isItDeactivated() {
		return deactivated;
	}

	public void setDeactivation(boolean deactivate) {
		this.deactivated = deactivate;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}
}