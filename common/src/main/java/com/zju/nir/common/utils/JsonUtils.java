package com.zju.nir.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;

/**
 * @author xiaoguo
 */

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String jsonFromObject(Object object) {
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, object);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            return null;
        }
        return writer.toString();
    }


    public static <T> T objectFromJson(String json, Class<T> klass) {
        T object;
        try {
            object = mapper.readValue(json, klass);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            return null;
        }
        return object;
    }
}
