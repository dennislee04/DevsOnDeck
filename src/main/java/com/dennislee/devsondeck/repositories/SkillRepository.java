package com.dennislee.devsondeck.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dennislee.devsondeck.models.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long>{

	List<Skill> findAll();
}
