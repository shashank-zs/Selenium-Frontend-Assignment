package com.qa.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class testUtil {
    /**
     * This is a method for serialization of POJO Object
     * @param object
     * @return String
     */
    public static String getSerialization(Object object){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        String jsonString=null;
        try {
            jsonString=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}


