package com.example.dbmsSpring.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="AppUser")
//@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "passwordFl", nullable = false)
	private String passwordFl;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "phoneNo")
	private String phoneNo;

	@Column(name = "gender")
	private String gender;

	@Column(name = "isAdmin", nullable = false)
	private boolean isAdmin;

	//bi-directional many-to-one association to Bank
	@OneToMany(mappedBy="appUser", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Customer> customers;

	//bi-directional many-to-one association to Bank
	@OneToMany(mappedBy="appUser", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Trader> traders;







	public AppUser()
	{
		//Default Constructor
	}






	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Trader> getTraders() {
		return traders;
	}

	public void setTraders(List<Trader> traders) {
		this.traders = traders;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordFl() {
		return passwordFl;
	}

	public void setPasswordFl(String passwordFl) {
		this.passwordFl = passwordFl;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}









	@Override
	public String toString() {
		return "AppUser{" +
				"email=" + email + '\'' +
				"passwordFl=" + passwordFl + '\'' +
				"firstName=" + firstName + '\'' +
				"lastName=" + lastName + '\'' +
				"phoneNo=" + phoneNo + '\'' +
				"gender=" + gender + '\'' +
				'}';
	}





}