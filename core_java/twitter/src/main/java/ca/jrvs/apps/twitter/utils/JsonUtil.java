package ca.jrvs.apps.twitter.utils;

import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtil {
//    public static  Object toObjFromJson(String jsonString,Class clazz) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
////        System.out.println("object mppping");
////        System.out.println(jsonString);
////        System.out.println(clazz);
//        return  objectMapper.readValue(jsonString,clazz);
//    }

    public static <T> T toObjectFromJson(String JsonStr, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.readValue(JsonStr, clazz);
    }

}
