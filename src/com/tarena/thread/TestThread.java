package com.tarena.thread;

public class TestThread {
//�߳���ʾ
	public static void main(String[] args) {
	//for (int i = 1; i <= 100; i++) {
	//	System.out.println("�ʣ�����˭?"+i);
	//}
       //��
	//for (int i = 0; i <=100; i++) {
		//System.out.println("��:ë��"+i);
	//}
		//ʹ�ö��߳���ɲ���ִ�У��ʺʹ𡰲���ִ�С�
		//"����ִ��"������������ͬʱִ��
		
		
		//������һ�����߳�
		FirstThread fi = new FirstThread();
		SecondThread se = new SecondThread();
		//��start()���������߳�,���Զ�ִ���߳��е�run()����
		fi.start();
		se.start();
	}

}
