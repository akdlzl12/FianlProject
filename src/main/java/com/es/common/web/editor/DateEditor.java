package com.es.common.web.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateEditor extends PropertyEditorSupport {

	private SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			setValue(yyyymmddhhmmss.parse(text));
		} catch (ParseException e1) {
			try {
				setValue(yyyymmdd.parse(text));
			} catch (ParseException e2) {
				
			}
		}
	}
	
	@Override
	public String getAsText() {
		String text = "";
		
		if(getValue() != null) {
			text = yyyymmddhhmmss.format(getValue());
			if(text == null)
				text = yyyymmdd.format(getValue());
		}
		return text;
	}
}
