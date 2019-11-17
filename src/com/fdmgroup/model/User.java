package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fdmgroup.util.IdGenerator;

@Entity
@Table(name = "VOYAGE_USER")
@NamedQuery(name = "findAllUsers", query = "SELECT u FROM User u")
@NamedQuery(name = "findUserByUserName", query = "SELECT u FROM User u WHERE u.userName = ?1")
@NamedQuery(name = "findUserByFirstName", query = "SELECT u FROM User u WHERE u.firstName = ?1")
public class User implements ISavable{

	@Id
	@Column (name = "USER_ID")
	private int id ;
	private String userName;
	@Column (name = "PWD")
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable (name = "VOYAGE_ENROLLMENT_PACKAGE", 
    joinColumns = @JoinColumn(name = "FK_USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "FK_PACKAGE_ID"))
	private List<Package> pList = new ArrayList<>();
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable (name = "VOYAGE_ENROLLMENT_CP", 
    joinColumns = @JoinColumn(name = "FK_USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "FK_PACKAGE_ID"))
	private List<CustomizedPackage> pCList = new ArrayList<>();
	
	public List<CustomizedPackage> getpCList() {
		return pCList;
	}

	public void setpCList(List<CustomizedPackage> pCList) {
		this.pCList = pCList;
	}

	public List<Package> getpList() {
		return pList;
	}

	public void setpList(List<Package> pList) {
		this.pList = pList;
	}

	public User() {
		super();
	}

	public User(String userName, String password, String firstName, String lastName, String email) {
		this(IdGenerator.generate(), userName, password, firstName, lastName, email);
	}
	
	public User(int id, String userName, String password, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
