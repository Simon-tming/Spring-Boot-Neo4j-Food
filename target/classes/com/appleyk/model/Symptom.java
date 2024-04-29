package com.appleyk.model;

import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonProperty;

@NodeEntity
public class Symptom extends BaseEntity {

	private Long sid;
	private String name;

	public Symptom(){
		
	}
	
	public Long getSid() {
		return sid;
	}

	public void setSid(Long pid) {
		this.sid = sid;
	}

	public String getSName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
