package com.java.snow;

import javax.swing.JFrame;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JFrame frame = new JFrame();//��������
		 //������������
		 //Pool p = new Pool();
		 Sky s  =new Sky();
		 frame.add(s);
		 //����������ӳ������
		 //frame.add(p);
		 //ʹ�ÿ�ݼ����� ctrl+shift+o
		 //���رմ���ʱ��Java���к�̨Ҳ�ص�
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);//���ô���ɼ�
		 frame.setSize(960,640);//���ô�С
		 frame.setTitle("ѩ��ƮƮ");//���ñ���
		 frame.setLocationRelativeTo(null);//���ô������
		 frame.setResizable(false);//���ô����С�Ƿ�ɱ�
		 s.action();
	}

}
