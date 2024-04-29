package com.appleyk.model;

import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonProperty;

@NodeEntity
public class Food extends BaseEntity{

	private Long fid;
	private String xing;
	private String wei;
	private String name;
	private String introduction;
	private String meridiantropism;
	private String effect;
	private String attention;


	@Relationship(type = "属于")
	@JsonProperty("食物类型")
	private List<Genre> genres;

	@Relationship(type = "治疗")
	@JsonProperty("症状")
	private List<Symptom> symptoms;


	public Food() {

	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String  getXing() { return xing ; }

	public void setXing(String xing) {
		this.xing  = xing ;
	}

	public String getWei() {
		return wei ;
	}

	public void setWei(String wei ) {
		this.wei = wei;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String  getMeridiantropism() { return meridiantropism ; }

	public void setMeridiantropism(String meridiantropism) {
		this.meridiantropism  = meridiantropism ;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Symptom> getSymptoms() { return symptoms; }

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public void setAttention(String attention ) {
		this.attention = attention;
	}

	public String getAttention() {
		return attention;
	}

}
