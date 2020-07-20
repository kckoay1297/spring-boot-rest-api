package com.example.springboot.model.provider;

import org.thymeleaf.util.StringUtils;

public class MaskedDataProvider {

	public static String maskedSensitiveName(String name) {
		String displayName = name;
		displayName = StringUtils.trim(displayName);
		if(!StringUtils.isEmpty(displayName)) {
			String maskedName = "";
			int len = displayName.length();
			if(len <= 7) {
				for(int i = 0; i < len; i ++) {
					char c = '*';
					if(i >= len - 3) {
						c = displayName.charAt(i);
					}
					maskedName = maskedName + c;
				}
				
			}else {
				for(int i = 0; i < len; i ++) {
					char c = '*';
					if(i >= len - 5) {
						c = displayName.charAt(i);
					}
					maskedName = maskedName + c;
				}
			}
			
			return maskedName;
		}
		
		return displayName;
	}
	
}
