package com.appleyk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appleyk.model.Food;
import com.appleyk.repository.FoodRepository;
import com.appleyk.result.ResponseMessage;
import com.appleyk.result.ResponseResult;
import com.appleyk.result.ResultData;

@RestController
@RequestMapping("/rest/appleyk/food")
public class FoodController {
   
	@Autowired  
    FoodRepository foodRepository;
      
	/**
	 * 根据食物名查询食物实体
	 * @param name
	 * @return
	 */
    @RequestMapping("/get")  
    public List<Food> getFoods(@RequestParam(value="name") String name){
    	return foodRepository.findByName(name);
    }  
      
    /**
     * 创建一个食物节点
     * @param food
     * @return
     */
    @PostMapping("/save")  
    public ResponseResult saveFood(@RequestBody Food food){
    	foodRepository.save(food);
    	return new ResponseResult(ResponseMessage.OK);
    }  
	
    
    @RequestMapping("/query")  
    public ResponseResult queryFoodTiles(){
    	List<String> foodTiles = foodRepository.getFoodTiles();
    	ResultData<String> result = new ResultData<String>(ResponseMessage.OK, foodTiles);
    	return new ResponseResult(result);
    } 
}
