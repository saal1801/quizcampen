package com.quizcampen.utils;


import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter {

    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	    .serializeSpecialFloatingPointValues().create();

    public static <T> T convertFromJson(String toConvert, Class<T> clazz) {

	return (T) gson.fromJson(toConvert, clazz);
    }

    //
    // List<UnibetEvent> unibetevents =
    // JsonConverter.convertFromJson(responseString, new
    // TypeToken<List<UnibetEvent>>() {
    // }.getType());
    //
    public static <T> T convertFromJson(String toConvert, Type typeOfT) {

	return (T) gson.fromJson(toConvert, typeOfT);
    }

    public static String convertToJson(Object toConvert) {

	return gson.toJson(toConvert);
    }
}
