package com.dennislee.devsondeck.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dennislee.devsondeck.models.Position;
import com.dennislee.devsondeck.repositories.PositionRepository;

@Service
public class PositionService {

	@Autowired
	private PositionRepository pRepo;
	
	public Position create(Position pos) {
		return this.pRepo.save(pos);
	}
	
	//Add Skill to position
	public void addSkill(Position position, String skill) {
		// get the all the current skills listed for position
		List<String> skills = position.getSkills();
		
		// Add the skill
		skills.add(skill);
		
		// Update Database
		this.pRepo.save(position);
	}
	
	// Remove Skill from position
	public void removeSkill(Position position, String skill) {
		position.getSkills().remove(skill);
		this.pRepo.save(position);
	}
	
	public List<String> getSkills(Position position) {
		List<String> skills = position.getSkills();
		return skills;
	}
	
	public String getSkillOne(Position position) {
		String skill = position.getSkillOne();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillTwp(Position position) {
		String skill = position.getSkillTwo();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillThree(Position position) {
		String skill = position.getSkillThree();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillFour(Position position) {
		String skill = position.getSkillFour();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
	
	public String getSkillFive(Position position) {
		String skill = position.getSkillFive();
		if (skill == null) {
			skill = "";
		}
		return skill;
	}
}
