package com.es.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.es.employee.vo.EmployeeTimetable;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class EmployeeTimetableDeserializer extends JsonDeserializer<EmployeeTimetable> {

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public EmployeeTimetable deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectCodec codec = jsonParser.getCodec();
		JsonNode node = codec.readTree(jsonParser);
		
		EmployeeTimetable employeeTimetable = new EmployeeTimetable();
		int employeeId = node.get("employeeId").asInt();
		int id = node.get("id").asInt();
		int managementId = node.get("managementId").asInt();
		String managementDetail = node.get("managementDetail").asText();
		
		String startedAt = node.get("startedAt").asText();
		String endedAt = node.get("endedAt").asText();
		String restStartedAt = node.get("restStartedAt").asText();
		String restEndedAt = node.get("restEndedAt").asText();
		
		employeeTimetable.setEmployeeId(employeeId);
		
		try {
			employeeTimetable.setStartedAt(format.parse(startedAt));
		} catch (ParseException e) {
			employeeTimetable.setStartedAt(null);
		}
		
	
		
		return employeeTimetable;
	}
}
