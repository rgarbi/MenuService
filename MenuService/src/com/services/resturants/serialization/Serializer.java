package com.services.resturants.serialization;

import java.util.List;

import com.google.gson.Gson;

public class Serializer {
	
	public static String serializeToJSON(Object object) {
		
		return new Gson().toJson(object);
	}
	
	public static <T> String serializeToJSON(List<T> domainObjects) {
		return new Gson().toJson(domainObjects);
	}
	
	public static <T> Object serializeFromJson(String json, Class<T> t) {
		
		return (t.cast(new Gson().fromJson(json, t)));
	
	}
	
	
	
}
