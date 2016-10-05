package com.interlan.test.problem;
import java.util.Scanner;

public class LogExtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int extractSize = 35;
		System.out.println(LogExtraction.extract("com.interlan.test.LogExtraction", extractSize));
				
	}
	public static String extract(String inputData, int extractSize){
		String result = "";
		if(inputData.length() < extractSize){
			return inputData;
		}
		else{
			String extractedData = canTrim(inputData); 
			if(inputData.equals(extractedData)){
				return inputData;
			}
			else{
				return extract(extractedData, extractSize);
			}
		}
	}
	public static String canTrim(String inputData){
		String[] packageDetails =  inputData.split("\\.");
		boolean isTrim = false;
		String result = "";
		int i = 1;
		for (String packageName : packageDetails) {
			if(packageName.length() > 1 && !isTrim && packageDetails.length!=i){
				result = result + packageName.substring(0, 1) + ".";
				isTrim = true;
			}
			else{
				result = result + packageName + ".";
			}
			i++;
		}
		return result.substring(0, result.length()-1);
	}
	
/*	public static String extract(String inputData, int extractSize){
		String result = "";
		if(inputData.length() > extractSize){
			String[] classInfo = inputData.split("\\.");
			for (String entity : classInfo) {
				if(inputData.length() > result.length())
					entity = entity.substring(0,1);
				result = result + entity +".";
			}
			result = result.substring(0, result.length()-1);
			return result; 
		}
		else{
			return inputData;
		}
		
	}*/
}
