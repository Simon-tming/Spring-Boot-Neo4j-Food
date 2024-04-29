package com.appleyk.config;

import com.appleyk.utils.CustomDictWordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class ConfigRunner implements CommandLineRunner {

    @Value("${HanLP.CustomDictionary.path.foodDict}")
    private String foodDictPath;

    @Value("${HanLP.CustomDictionary.path.genreDict}")
    private String genreDictPath;

    @Value("${HanLP.CustomDictionary.path.symptomDict}")
    private String symptomDictPath;

    @Value("${HanLP.CustomDictionary.cache.path}")
    private String cacheDictPath;

    @Override
    public void run(String... args){

        //先删除缓存
        File file = new File(cacheDictPath);
        if(file.exists()){
            file.delete();
            System.out.println("CustomDictionary.txt.bin delete success .");
        }

        /**加载自定义的【食物】字典 == 设置词性 nf 0*/
        loadDict(foodDictPath,0);
        /**加载自定义的【类型】字典 == 设置词性 ng 0*/
        loadDict(genreDictPath,1);
        /**加载自定义的【症状】字典 == 设置词性 ns 0*/
        loadDict(symptomDictPath,2);

    }

    /**
     * 加载自定义词性字典
     * @param path 字典路径
     * @param type 类型
     */
    public void loadDict(String path,Integer type) {
        File file = new File(path);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            addCustomDictionary(br, type);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * 添加自定义分词及其词性，注意数字0表示频率，不能没有
     *
     * @param br 字节流（读）
     * @param type 字典类型
     */
    public void addCustomDictionary(BufferedReader br, int type) {

        String word;
        try {
            while ((word = br.readLine()) != null) {
                switch (type) {
                    /**设置食物名词词性 == nf 0*/
                    case 0:
                        CustomDictWordUtils.setNatureAndFrequency(word,"nf 0",true);
                        break;
                    /**设置食物类型名词 词性 == ng 0*/
                    case 1:
                        CustomDictWordUtils.setNatureAndFrequency(word,"ng 0",true);
                        break;
                    /**设置症状词 词性 == ns 0*/
                    case 2:
                        CustomDictWordUtils.setNatureAndFrequency(word,"ns 0",true);
                        break;
                    default:
                        break;
                }
            }
            br.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
