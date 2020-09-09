package com.dennislee.devsondeck.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dennislee.devsondeck.models.User;
import com.dennislee.devsondeck.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	public User findAUser(Long id) {
		User user = uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> findAllUsers(){
		return uRepo.findAll();
	}
	
	public User registerUser(User user) {
		// Generate a Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		// Set the hashed password on the users password field
		user.setPassword(hash);
		
		// Save the new user and the updated password to the database
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		// Make sure the user logging in is who they say they are
		// Try and query for user by email
		User user = this.uRepo.findByEmail(email);
		
		if (user == null) {
			return false;
		}
		
		// If we have reached this point, check the password against the password for this email in our database
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	//Add Skill to user
	public void addSkill(User user, String skill) {
		// get the all the current user's skills
		List<String> skills = user.getSkills();
		
		// Add the skill
		skills.add(skill);
		
		// Update Database
		this.uRepo.save(user);
	}
	
	// Remove Skill from user
	public void removeSkill(User user, String skill) {
		user.getSkills().remove(skill);
		this.uRepo.save(user);
	}
	
	public List<String> getSkills(User user) {
		List<String> skills = user.getSkills();
		return skills;
	}
	
	public String getSkillOne(User user) {
		String skill = user.getSkillOne();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillTwp(User user) {
		String skill = user.getSkillTwo();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillThree(User user) {
		String skill = user.getSkillThree();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillFour(User user) {
		String skill = user.getSkillFour();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillFive(User user) {
		String skill = user.getSkillFive();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
}
