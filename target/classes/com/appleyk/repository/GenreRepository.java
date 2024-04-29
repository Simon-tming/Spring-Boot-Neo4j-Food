package com.appleyk.repository;

import com.appleyk.model.Genre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends Neo4jRepository<Genre, Long>{
	
	 @Query("MATCH (n:genre) where n.name='健脾和胃类' return n")
	 List<Genre> getGenres(@Param("name") String name);
	
	 List<Genre> findByName(@Param("name") String name); 
}
