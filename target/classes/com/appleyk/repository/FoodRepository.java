package com.appleyk.repository;

import com.appleyk.model.Food;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends Neo4jRepository<Food, Long>{

	 List<Food> findByName(@Param("name") String name);

	 @Query("match(n:food)-[:治疗]->(m:symptom) where n.name='香蕉' return m.name")
	 List<String> getFoodTiles();

}
