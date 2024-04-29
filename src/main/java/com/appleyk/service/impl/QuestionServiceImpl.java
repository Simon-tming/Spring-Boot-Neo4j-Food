package com.appleyk.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.appleyk.core.CoreProcessor;
import com.appleyk.repository.QuestionRepository;
import com.appleyk.service.QuestionService;


/**
 * <p>核心问答业务实现类</p>
 */
@Service
@Primary
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CoreProcessor queryProcess;

    @Override
    public String answer(String question) throws Exception {

        List<String> reStrings = queryProcess.analysis(question);
        System.out.println("结果2：" +reStrings.get(1));
        int modelIndex = Integer.valueOf(reStrings.get(0));
        String answer ="111";
        String title;
        String name;

        /**匹配问题模板*/
        switch (modelIndex) {
            case 0:
                answer= getFoodXing(reStrings);
                break;
            case 1:
                answer = getFoodWei(reStrings);
                break;
            case 2:
                answer = getFoodMeridiantropism(reStrings);
                break;
            case 3:
                answer = getFoodIntroduction(reStrings);
                break;
            case 4:
                answer = getFoodEffect(reStrings);
                break;
            case 5:
                answer = getGenreName(reStrings);
                break;
            case 6:
                answer = getSName(reStrings);
                break;
            case 7:
                answer = getFoodAttention(reStrings);
                break;
            case 8:
                answer = getFoodGenre(reStrings);
                break;
            case 9:
                answer = getFoodSymptom(reStrings);
                break;
            default:
                break;
        }
        System.out.println(answer);
        if (answer != null && !"".equals(answer) && !("\\N").equals(answer)) {
            return answer;
        } else {
            return "sorry,主人,小five我没有找到你要的答案";
        }
    }

    /**nf 性 == 食物性*/
    private String getFoodXing(List<String> reStrings) {
        String name;
        String xing;
        String answer;
        name = reStrings.get(1);
        xing = questionRepository.getFoodXing(name);
        if (xing != null) {
            answer = xing;
        } else {
            answer = null;
        }
        return answer;
    }

    /** nf 味 == 食物的味*/
    private String getFoodWei(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        String wei = questionRepository.getFoodWei(name);
        if (wei != null) {
            answer = wei;
        } else {
            answer = null;
        }
        return answer;
    }

    /**nf 归经 == 食物归经*/
    private String getFoodMeridiantropism(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        String meridiantropism = questionRepository.getFoodMeridiantropism(name);
        if (meridiantropism != null) {
            answer = meridiantropism;
        } else {
            answer = null;
        }
        return answer;
    }

    /** nf 简介 == 食物简介*/
    private String getFoodIntroduction(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        String introduction = questionRepository.getFoodIntroduction(name);
        if (introduction != null) {
            answer = introduction;
        } else {
            answer = null;
        }
        return answer;
    }

    /** nf 功效  == 食物功效*/
    private String getFoodEffect(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        String effect = questionRepository.getFoodEffect(name);
        if (effect != null) {
            answer = effect;
        }else {
            answer = null;
        }
        return answer;
    }

    /** nf(食物)  ng(类型)*/
    private String getGenreName(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        List<String> Foodgenre = questionRepository.getGenreName(name);
        if (Foodgenre.size() == 0) {
            answer = null;
        } else {
            answer = Foodgenre.toString().replace("[", "").replace("]", "");
        }
        return answer;
    }

    /* nf(食物)  ns(症状)*/
    private String getSName(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        List<String> Symptomss= questionRepository.getSName(name);
        if (Symptomss == null) {
            answer = null;
        } else {
            answer = Symptomss.toString().replace("[", "").replace("]", "");
        }
        return answer;
    }


    private String getFoodAttention(List<String> reStrings) {
        String name;
        String attention;
        String answer;
        name = reStrings.get(1);
        attention = questionRepository.getFoodAttention(name);
        if(attention != null) {
            answer = attention;
        } else {
            answer = null;
        }
        return answer;
    }

    private String getFoodGenre(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        List<String> food= questionRepository.getFoodGenre(name);
        if (food == null) {
            answer = null;
        } else {
            answer = food.toString().replace("[", "").replace("]", "");
        }
        return answer;
    }

    private String getFoodSymptom(List<String> reStrings) {
        String name;
        String answer;
        name = reStrings.get(1);
        List<String> foods= questionRepository.getFoodSymptom(name);
        if (foods == null) {
            answer = null;
        } else {
            answer = foods.toString().replace("[", "").replace("]", "");
        }
        return answer;
    }


}
