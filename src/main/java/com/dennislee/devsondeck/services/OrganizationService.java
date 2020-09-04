package com.dennislee.devsondeck.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dennislee.devsondeck.models.Organization;
import com.dennislee.devsondeck.repositories.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository oRepo;
	
	public Organization findAOrd(Long id) {
		Organization org = oRepo.findById(id).orElse(null);
		return org;
	}
	
	public List<Organization> findAllOrgs(){
		return oRepo.findAll();
	}
	
	public Organization registerOrg(Organization org) {
		// Generate a Hash
		String hash = BCrypt.hashpw(org.getPassword(), BCrypt.gensalt());
		
		// Set the hashed password on the organization password field
		org.setPassword(hash);
		
		// Save the new organization and the updated password to the database
		return this.oRepo.save(org);
	}
	
	public boolean authenticateOrg(String email, String password) {
		// Make sure the organization logging in is who they say they are
		// Try and query for organization by email
		Organization org = this.oRepo.findByorgEmail(email);
		
		if (org == null) {
			return false;
		}
		
		// If we have reached this point, check the password against the password for this email in our database
		return BCrypt.checkpw(password, org.getPassword());
	}
	
	public Organization getByEmail(String email) {
		return this.oRepo.findByorgEmail(email);
	}
}
