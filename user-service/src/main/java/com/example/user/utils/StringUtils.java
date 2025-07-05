package com.example.user.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringUtils {
	public static String snakeToCamel(String snake) {
		StringBuilder result = new StringBuilder();
		boolean upperNext = false;
		for (char c : snake.toCharArray()) {
			if (c == '_') {
				upperNext = true;
			} else {
				result.append(upperNext ? Character.toUpperCase(c) : c);
				upperNext = false;
			}
		}
		return result.toString();
	}
}
