package com.dennislee.devsondeck.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "positions")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String posName;
	
	@NotBlank
	private String description;
	
	private String skillOne;
	
	private String skillTwo;
	
	private String skillThree;
	
	private String skillFour;
	
	private String skillFive;
	
	@Transient
	@Size(max = 5)
	private List<String> skills;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")
	private Organization org;
	
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

	public Position() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public String getSkillOne() {
		return skillOne;
	}

	public void setSkillOne(String skillOne) {
		this.skillOne = skillOne;
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

}
