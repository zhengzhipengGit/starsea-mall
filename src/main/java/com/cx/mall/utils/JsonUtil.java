package com.cx.mall.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 操作json的封装方法
 *
 * @author
 * @date
 */
public class JsonUtil {

    /*
     * 001.json转换成对象
     * @param:传入对象，json字符串
     * @return:Object
     */
    public static Object jsonToObj(Class objClass, String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }

    /*
     * 002.对象转换成json
     * @param:传入对象
     * @return:json字符串
     */
    public static String objToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
