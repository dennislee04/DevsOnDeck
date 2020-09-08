package com.dennislee.devsondeck.uservalidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.dennislee.devsondeck.models.Organization;
import com.dennislee.devsondeck.repositories.OrganizationRepository;

@Component
public class OrgValidator {

	@Autowired
	private OrganizationRepository oRepo;
	
	public boolean supports(Class<?> clazz) {
		return Organization.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		Organization organization = (Organization) target;
		
		if(!organization.getPassword().equals(organization.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords do not match!");
		}
		
		// Make sure email is unique in the DB
		if(this.oRepo.existsByorgEmail(organization.getOrgEmail())) {
			errors.rejectValue("email", "Unique", "Email is already taken!");
		}
		
		// Additional validator example
		//if(user.getFirstName().equals("Matt")) {
		//	errors.rejectValue("firstName", "NoMattsAllowed", "Sorry, were full on matts now. Try again later!");
		//}

	}
}
