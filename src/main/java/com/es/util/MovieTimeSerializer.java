package com.es.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MovieTimeSerializer extends JsonSerializer<Date> {

	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String strTime = sdf.format(value);
		gen.writeString(strTime);
	}

}
