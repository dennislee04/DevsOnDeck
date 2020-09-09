package com.dennislee.devsondeck.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	private String skillOne;
	
	private String skillTwo;
	
	private String skillThree;
	
	private String skillFour;
	
	private String skillFive;
	
	@Transient
	@Size(max = 5)
	private List<String> skills;

	private String bio;
	
	@Size(min= 8)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<String> getSkills() {
		String one = this.getSkillOne();
		skills.add(one);
		String two = this.getSkillTwo();
		skills.add(two);
		String three = this.getSkillThree();
		skills.add(three);
		String four = this.getSkillFour();
		skills.add(four);
		String five = this.getSkillFive();
		skills.add(five);

		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getSkillOne() {
		return skillOne;
	}

	public String getSkillTwo() {
		return skillTwo;
	}

	public void setSkillTwo(String skillTwo) {
		this.skillTwo = skillTwo;
	}

	public String getSkillThree() {
		return skillThree;
	}

	public void setSkillThree(String skillThree) {
		this.skillThree = skillThree;
	}

	public String getSkillFour() {
		return skillFour;
	}

	public void setSkillFour(String skillFour) {
		this.skillFour = skillFour;
	}

	public String getSkillFive() {
		return skillFive;
	}

	public void setSkillFive(String skillFive) {
		this.skillFive = skillFive;
	}

	public void setSkillOne(String skillOne) {
		this.skillOne = skillOne;
	}
	
}
