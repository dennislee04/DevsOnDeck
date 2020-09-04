package com.dennislee.devsondeck.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dennislee.devsondeck.models.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>{

	List<Position> findAll();
}
