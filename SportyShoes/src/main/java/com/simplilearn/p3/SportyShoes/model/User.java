package com.simplilearn.p3.SportyShoes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ss_user_master")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ssum_user_id")
	private Integer id;
	@Column(name="ssum_user_name")
	private String username;
	@Column(name="ssum_user_password")
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name = "ss_user_role", joinColumns = @JoinColumn(name = "ssur_user_id"), inverseJoinColumns = @JoinColumn(name = "ssur_role_id"))
	 public Set<Role> roles;
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public User() {
	
	}
	public User( String username, String password) {
		
		this.username = username;
		this.password = password;
	
	}
	
	
	
}
