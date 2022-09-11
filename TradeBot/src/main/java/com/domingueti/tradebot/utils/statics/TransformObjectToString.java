package com.domingueti.tradebot.utils.statics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TransformObjectToString {

	public static String execute(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String objectToJsonString;

		try {
			mapper.registerModule(new JavaTimeModule());
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectToJsonString = mapper.writeValueAsString(object);

			return objectToJsonString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
