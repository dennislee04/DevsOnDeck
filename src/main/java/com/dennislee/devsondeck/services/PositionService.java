package com.dennislee.devsondeck.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dennislee.devsondeck.models.Position;
import com.dennislee.devsondeck.models.Skill;
import com.dennislee.devsondeck.repositories.PositionRepository;

@Service
public class PositionService {

	@Autowired
	private PositionRepository pRepo;
	
	public Position create(Position pos) {
		return this.pRepo.save(pos);
	}
	
	//Add Skill to position
	public void addSkill(Position position, Skill skill) {
		// get the all the current skills listed for position
		List<Skill> skills = position.getSkills();
		
		// Add the skill
		skills.add(skill);
		
		// Update Database
		this.pRepo.save(position);
	}
	
	// Remove Skill from position
	public void removeSKill(Position position, Skill skill) {
		position.getSkills().remove(skill);
		this.pRepo.save(position);
	}
}
