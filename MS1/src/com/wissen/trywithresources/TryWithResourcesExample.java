package com.wissen.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * try with resources assures us that the resources will be closed after execuon of this block.
 * A resource is an object that must be closed after finishing the program.
 * The resources declared must implement AutoCloseable interface.
*/

public class TryWithResourcesExample {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("IOException in try block: " + e.getMessage());
		}

	}

}
