package com.JavaAPI_SpringBoot.Home.Services;

public class RegularExpression {

	public String RemoveWhiteSpaces(String line){
		String lineWithOutSpace = line.replaceAll("\\s+", "");
		return lineWithOutSpace;
	}
}
