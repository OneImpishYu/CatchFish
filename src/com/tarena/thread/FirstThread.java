package com.tarena.thread;
//���һ�ٱ���
//����һ�������̵߳Ĺ��ܣ��ȼ̳�Thread
public class FirstThread extends Thread {
   //����run����������Thread�ṩ��
	public void run()
	{
		for (int i = 1; i <= 100; i++) {
				System.out.println("�ʣ�����˭?"+i);
		}
	}
}
