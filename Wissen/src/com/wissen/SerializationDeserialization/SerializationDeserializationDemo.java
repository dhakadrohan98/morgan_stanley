package com.wissen.SerializationDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDeserializationDemo {

	public static void main(String[] args) {
		Employee emp = new Employee("Mike", 15, 50000);
		String file = "byteStream.txt";
		//Serializing Employee object
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			oos.close();
			fos.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//Deserializing Employee object
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee empDeserializedObj = (Employee) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(empDeserializedObj);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
