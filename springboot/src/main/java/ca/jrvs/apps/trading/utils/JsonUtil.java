package ca.jrvs.apps.trading.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtil {
    public static <T> T toObjectFromJson(String JsonStr, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.readValue(JsonStr, clazz);
    }
}
