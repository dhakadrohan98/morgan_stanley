package com.wissen.sorting;

import java.util.Comparator;

//modified version of TimSort
//TC: O(n * logn)
//SC: O(n) additional space for merging operations during sorting..

public class AgeComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student s1, Student s2) {
		return s1.age - s2.age;
	}
}
