package com.tarena.thread;
//完成一百遍问
//想让一个类有线程的功能，先继承Thread
public class FirstThread extends Thread {
   //调用run方法（父类Thread提供）
	public void run()
	{
		for (int i = 1; i <= 100; i++) {
				System.out.println("问：你是谁?"+i);
		}
	}
}
