package com.appleyk.repository;

import com.appleyk.model.Symptom;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SymptomRepository extends Neo4jRepository<Symptom, Long>{
	 List<Symptom> findByName(@Param("sname") String sname);
}
