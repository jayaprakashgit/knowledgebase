package com.interlan.test.java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void writeFile(){
		Path inputFile = Paths.get("input.txt");
		Path outputFile = Paths.get("output.txt");
		try {
			BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset());
			BufferedWriter writer = Files.newBufferedWriter(inputFile, Charset.defaultCharset());
			String lineFromFile = "";
			while((lineFromFile = reader.readLine()) != null)
				writer.append(lineFromFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
