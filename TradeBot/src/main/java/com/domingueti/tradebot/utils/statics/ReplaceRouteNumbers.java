package com.domingueti.tradebot.utils.statics;

public class ReplaceRouteNumbers {

	public static String execute(String route) {
		char[] chars = route.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (char c : chars) {
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		
		if(sb.length() == 0) {
			return route;
		}
		
		return route.replace(sb, "*");

	}
	
}
