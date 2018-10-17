package com.tarena.thread;

public class TestThread {
//线程演示
	public static void main(String[] args) {
	//for (int i = 1; i <= 100; i++) {
	//	System.out.println("问：你是谁?"+i);
	//}
       //答
	//for (int i = 0; i <=100; i++) {
		//System.out.println("答:毛线"+i);
	//}
		//使用多线程完成并发执行，问和答“并发执行”
		//"并发执行"并不是真正的同时执行
		
		
		//创建第一二个线程
		FirstThread fi = new FirstThread();
		SecondThread se = new SecondThread();
		//用start()方法启动线程,会自动执行线程中的run()方法
		fi.start();
		se.start();
	}

}
