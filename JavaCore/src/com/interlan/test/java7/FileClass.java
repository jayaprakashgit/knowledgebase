package com.interlan.test.java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class FileClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f="file1.java";
		File f1 = new File(f);	
		//Reader iout = new FileReader(f1);
		//InputStream iout = new FileInputStream(f1);
		//InputStream iout = new InputStream() wrong
		FileOutputStream iout = new FileOutputStream(f1);
		
		FileInputStream fis = new FileInputStream("file.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		//FileReader fr = new FileReader(fis) wrong
		
		RandomAccessFile rf = new RandomAccessFile(file, mode)
		FileReader fr = new Reader
				
		 
	}

}
