package com.dennislee.devsondeck.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dennislee.devsondeck.models.Skill;
import com.dennislee.devsondeck.repositories.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository sRepo;
	
	public Skill findASkill(Long id) {
		Skill skill = sRepo.findById(id).orElse(null);
		return skill;
	}
	
	public List<Skill> findAllSkills(){
		return sRepo.findAll();
	}
}
