package com.wissen.functional.interfacee;

public class LamdaExpressionToFunctionalInterface {

	public static void main(String[] args) {
		
		Thread th1 = new Thread(() -> {
			//implementation for Runnable interface run method
			for(int i=0; i<5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		th1.start();
	}

}

//create anonymous inner class object
//new Thread(new Runnable() {
// @Override public void run()
// {
//     System.out.println("New thread created");
// }
//}).start();
