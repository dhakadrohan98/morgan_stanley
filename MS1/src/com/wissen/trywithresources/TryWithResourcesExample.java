package com.wissen.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
            System.out.println("IOException in try block: " + e.getMessage());
        }

	}

}
