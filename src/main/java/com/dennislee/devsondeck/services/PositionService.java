package com.dennislee.devsondeck.services;

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
}
