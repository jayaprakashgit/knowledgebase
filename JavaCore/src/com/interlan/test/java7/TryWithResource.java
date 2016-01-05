package com.interlan.test.java7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Each AutoClosable resource created in the try statement will be automatically closed! 
 * If an exception is thrown in the try block and another Exception is thrown while closing the resource, 
 * the first Exception is the one eventually thrown to the caller. 
 * The second Exception is available to the caller via the ex.getSupressed() method. 
 * Throwable.getSupressed() is a new method added on Throwable in Java 7 just for this purpose.
 */
public class TryWithResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeBinaryFile("D:\\Workspace\\stsprojects\\JavaCore\\src\\com\\interlan\\test\\java7\\sample.txt");
		readBinaryFile("D:\\Workspace\\stsprojects\\JavaCore\\src\\com\\interlan\\test\\java7\\sample.txt");
		//testMethod("D:\\Workspace\\stsprojects\\JavaCore\\src\\com\\interlan\\test\\java7\\sample.txt");
	}

	
	
	public static void writeBinaryFile(String filePath){
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(filePath)))){
			for(int i = 1; i<=10; i++){
				dos.writeInt(i);
			}
		}
		catch(IOException ex){
			
		}
	}
	
	public static void readBinaryFile(String filePath){
		int data;
		int total = 0;

		try(DataInputStream dis = new DataInputStream(new FileInputStream(new File(filePath)))){
			while( (data = dis.readInt()) > 0){
				total = total + data;
				System.out.println(data);
			}
		}
		catch(IOException ex){
			if(ex instanceof EOFException)
				return;
		}
		finally{
			System.out.println("total sum in binary file is :"+total );
		}
	}
	
	public static void testMethod(String filePath){
		byte[] buffer = new byte[1000];
		
		try(FileInputStream fis = new FileInputStream(new File(filePath))){
			int data = 0;
			int total = 0;
			int iteration = 0;
			while((data = fis.read(buffer)) != -1){
				iteration++;
				System.out.println(new String(buffer));
				total += data;
			}
			
			System.out.println("Read " + total + " bytes, in "+iteration+" iteration");
		}
		catch(IOException ex){
			
		}
	}

}
