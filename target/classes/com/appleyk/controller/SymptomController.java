package com.appleyk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appleyk.model.Symptom;
import com.appleyk.repository.SymptomRepository;
import com.appleyk.result.ResponseMessage;
import com.appleyk.result.ResponseResult;

@RestController
@RequestMapping("/rest/appleyk/person")
public class SymptomController {

	@Autowired
	SymptomRepository symptomRepository;

	/**
	 * 根据症状名查询Symptom实体
	 * 
	 * @param name 姓名
	 * @return
	 */
	@RequestMapping("/get")
	public List<Symptom> getSymptoms(@RequestParam(value = "name") String name) {
		return symptomRepository.findByName(name);
	}

	/**
	 * 创建一个症状节点
	 * 
	 * @param symptom 业务模型
	 * @return
	 */
	@PostMapping("/save")
	public ResponseResult saveSymptom(@RequestBody Symptom symptom) {
		symptomRepository.save(symptom);
		return new ResponseResult(ResponseMessage.OK);
	}

	
}
