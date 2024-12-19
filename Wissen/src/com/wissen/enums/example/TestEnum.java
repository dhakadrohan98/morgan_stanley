package com.wissen.enums.example;

public class TestEnum {

	public static void main(String[] args) {
		Department[] values = Department.values();
		for(Department val : values) {
			System.out.println(val.getName());
		}
		System.out.println();
//		System.out.println(Department.HR.getName());
		
		String str = "FINA";
		Department department = Department.getDepartmentByName(str);
		System.out.println(department);
		
		if(department != null) {
			switch(department) {
				case TECHNOLOGY:
					System.out.println(Department.COMPANY.getName());
					break;
				case FINANCE:
					System.out.println(Department.COMPANY.getName());
					break;
				case HR:
					System.out.println(Department.COMPANY.getName());
					break;
				case COMPILANCE:
					System.out.println(Department.COMPANY.getName());
					break;
				default:
					System.out.println("department is not a part of wissen technology company");
					break;
			}
		}
	}

}
