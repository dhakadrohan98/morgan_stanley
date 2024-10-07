package com.wissen.trywithresources;

import java.io.FileOutputStream;

public class TryWithSingleResource {

	public static void main(String[] args) {
		
		try {
			// Creating an object of FileOutputStream to write stream or raw data
			// Adding resource
			FileOutputStream fos = new FileOutputStream("outputfile.text");
			String text = "Hello World. This is my java program to demonstrate try with "
					+ "resources feature";
			
			byte[] bytes = text.getBytes();
			
			//writting text to the file
			fos.write(bytes);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Resource are closed and message has been written into outputfile.text "
				+ "file");

	}

}
