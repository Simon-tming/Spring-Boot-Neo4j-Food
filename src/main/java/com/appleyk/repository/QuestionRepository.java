package com.appleyk.repository;

import com.appleyk.model.Food;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * 基于饮食知识图谱的自问自答的查询接口

 */
public interface QuestionRepository extends Neo4jRepository<Food,Long> {

	/**
	 * 0 对应问题模板0 == nf(食物) 性
	 *
	 * @param name 食物
	 * @return 返回食物的性
	 */
	@Query("match(n:food) where n.name ={name} return n.xing")
	String getFoodXing(@Param("name") String name);

	/**
	 * 1 对应问题模板1 == nf(食物) 味
	 *
	 * @param name 食物味
	 * @return 返回食物的味
	 */
	@Query("match(n:food) where n.name ={name} return n.wei")
	String getFoodWei(@Param("name") String name);

	/**
	 * 2 对应问题模板2 == nf(食物) 归经
	 *
	 * @param name 食物归经
	 * @return 返回食物的归经
	 */
	@Query("match(n:food) where n.name ={name} return n.meridiantropism")
	String getFoodMeridiantropism(@Param("name") String name);

	/**
	 * 3 对应问题模板3 == nf(食物) 简介
	 *
	 * @param name 食物简介
	 * @return 返回食物的简介
	 */
	@Query("match(n:food) where n.name ={name} return n.introduction")
	String getFoodIntroduction(@Param("name") String name);

	/**
	 * 4 对应问题模板4 == nf(食物) 功效
	 *
	 * @param name 食物功效
	 * @return 返回食物的功效
	 */
	@Query("match(n:food) where n.name ={name} return n.effect")
	String getFoodEffect(@Param("name") String name);

	/**
	 * 5 对应问题模板5 == nf(食物)  ng(类型)
	 *
	 * @param name 类型名
	 * @return 返回类型
	 */
	@Query("match(n:food)-[:属于]-(m:genre) where n.name ={name} return m.gname")
	List<String> getGenreName(@Param("name") String name);

	/**
	 * 6 对应问题模板6 == nf(食物)  ns(症状)
	 *
	 * @param name 症状名称
	 * @return 返回症状名称列表
	 */
	@Query("match(n:food)-[:治疗]-(m:symptom) where n.name ={name} return distinct  m.sname")
	List<String> getSName(@Param("name") String name);


	/**
	 * 7 对应问题模板7 == nf(食物) 食用注意
	 *
	 * @param name 食物注意
	 * @return 返回食物的注意
	 */
	@Query("match(n:food) where n.name ={name} return n.attention")
	String getFoodAttention(@Param("name") String name);

	/**
	 * 8 对应问题模板8 == ng(食物) 食物列表
	 *
	 * @param gname genre名字
	 * @return 返回食物的名字
	 */
	@Query("match(n:food)-[:属于]-(m:genre) where m.gname ={gname} return distinct  n.name")
	List<String> getFoodGenre(@Param("gname") String gname);

	/**
	 * 9 对应问题模板9 == ng(食物) 应用食物
	 *
	 * @param sname 症状名字
	 * @return 返回食物的名字
	 */
	@Query("match(n:food)-[:治疗]-(m:symptom) where m.sname ={sname} return distinct  n.name")
	List<String> getFoodSymptom(@Param("sname") String sname);
}


