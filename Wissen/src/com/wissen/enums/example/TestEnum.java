package com.wissen.enums.example;

public class TestEnum {

	public static void main(String[] args) {
		Department[] values = Department.values();
		for(Department val : values) {
			System.out.println(val.getName());
		}
//		System.out.println(Department.HR.getName());
		
		String str = "compliance";
		Department department = Department.getDepartmentByName(str);
//		System.out.println(department);
		
		if(department != null) {
			switch(department) {
				case TECHNOLOGY:
					System.out.println("This is the technology department");
					break;
				case FINANCE:
					System.out.println("This is the finance department");
					break;
				case HR:
					System.out.println("This is the HR department");
					break;
				case COMPILANCE:
					System.out.println("This is the COMPILANCE department");
					break;
				default:
					System.out.println("new department");
					break;
			}
		}
	}

}
