package com.example.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class JsonUtility {
    public JsonUtility() {
    }

    public static <T> String objectToJson(T source) throws JsonGenerationException, JsonMappingException, IOException {
        String jsonString = getObjectMapper().writeValueAsString(source);
        return jsonString;
    }

    /*JsonUtility.jsonToObject(jsonString,List.class, AreaOutBean.class);*/
    public static <T> T jsonToObject(String json, Class<?> dataType, Class<?>... genericityTypes) throws JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException {
        ObjectMapper objectMapper = getObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructParametricType(dataType, genericityTypes);
        return getObjectMapper().readValue(json, type);
    }

    /*JsonUtility.jsonToObject(jsonString, HallActivatorBean.class);*/
    public static <T> T jsonToObject(String json, Class<T> dataType) throws JsonParseException, JsonMappingException, IOException, InstantiationException, IllegalAccessException {
        return getObjectMapper().readValue(json, dataType);
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // json进行换行缩进等操作
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // json不进行换行缩进等操作  默认就是不进行操作，写了这行和没写的效果一样
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        //去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置为东八区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 设置输入:禁止把POJO中值为null的字段映射到json字符串中
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        // 属性为Null的不进行序列化，只对pojo起作用，对map和list不起作用
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //序列化日期时以timestamps输出，默认true
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //序列化枚举是以toString()来输出，默认false，即默认以name()来输出
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        //序列化枚举是以ordinal()来输出，默认false
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);
        //类为空时，不要抛异常
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //反序列化时,遇到未知属性时是否引起结果失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //json是否允许属性名为单引号 ，默认是false
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //解析器支持解析结束符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // json是否允许属性名没有引号 ，默认是false
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return objectMapper;
    }
}
