package com.wissen.multithreading;

public class BookTheaterSeat {
	int totalSeats = 10;
	
	 void bookSeats(int seats) {
		System.out.println("1-Seats booking is in progress");
		System.out.println("2-Seats booking is in progress");
		System.out.println("3-Seats booking is in progress");
		System.out.println("4-Seats booking is in progress");
		System.out.println("5-Seats booking is in progress");
		
		synchronized(this) {
			if(seats <= totalSeats) {
				System.out.println("-------START----------");
				System.out.println(seats + " seats are booked successfully");
				totalSeats = totalSeats - seats;
				System.out.println("remaining seats are " + totalSeats);
				System.out.println("-------END----------");
			}
			else {
				System.out.println("-------START----------");
				System.out.println(seats + " seats can not be booked");
				System.out.println("remaining seats are " + totalSeats);
				System.out.println("-------END----------");
			}
		}
		
		System.out.println("6-Seats booking is in progress");
		System.out.println("7-Seats booking is in progress");
		System.out.println("8-Seats booking is in progress");
		System.out.println("9-Seats booking is in progress");
		System.out.println("10-Seats booking is in progress");
	}
}
