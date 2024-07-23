package com.wissen.multithreading;

public class MovieBookApp extends Thread {

	static BookTheaterSeat b;
	int seats;
	
	public void run() {
		b.bookSeats(seats);
	}
	
	public static void main(String[] args) {
		b = new BookTheaterSeat();
		MovieBookApp deepak = new MovieBookApp();
		deepak.seats = 7;
		deepak.start();
		
		MovieBookApp shalini = new MovieBookApp();
		shalini.seats = 5;
		shalini.start();
	}
}
