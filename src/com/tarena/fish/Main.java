package com.tarena.fish;
import javax.swing.JFrame;

public class Main {
public static void main(String[] args) {
		
	   //frameΪ��������
	 JFrame frame = new JFrame();//��������
	 //������������
	 Pool p = new Pool();
	 //����������ӳ������
	 frame.add(p);
	 //ʹ�ÿ�ݼ����� ctrl+shift+o
	 //���رմ���ʱ��Java���к�̨Ҳ�ص�
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setVisible(true);//���ô���ɼ�
	 frame.setSize(800,500);//���ô�С
	 frame.setTitle("�������");//���ñ���
	 frame.setLocationRelativeTo(null);//���ô������
	 frame.setResizable(false);//���ô����С�Ƿ�ɱ�
	p.action();
	}

}
