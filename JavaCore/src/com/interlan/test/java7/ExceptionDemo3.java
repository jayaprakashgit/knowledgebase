package com.interlan.test.java7;

public class ExceptionDemo3 {

	static String message;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String message = getMessage();
			System.out.println(message);
		}
		catch(Exception e){
			System.out.println(message);
		}
		finally{
			System.out.println(message);
		}
	}
	
	public static String getMessage()throws Exception{
		String message = "A";
		try{
			throw new Exception();
		}
		catch(Exception e){
			try{
				try{
					throw new Exception();
				}
				catch(Exception ex){
					message += "B";
				}
				throw new Exception();
			}
			catch(Exception x){
				message +="C";
			}
			finally{
				message += "D";
			}
		}
		finally{
			message += "E";
		}
		return message;
	}

}
