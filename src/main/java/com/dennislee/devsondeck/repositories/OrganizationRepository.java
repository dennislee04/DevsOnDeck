package com.dennislee.devsondeck.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dennislee.devsondeck.models.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{

	List<Organization> findAll();
	
	boolean existsByorgEmail(String email);
	
	Organization findByorgEmail(String email);
}
