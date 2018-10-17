package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//����� == java�е���
public class Fish extends Thread {
// һ ����
	BufferedImage image;// 1.�������(��Ĳ�ͬͼƬ)
	// 2. ��Ĵ�С
	int width;
	int height;
	//3. �������
	int x;
	int y;
	//4.����ٶ�
	int step;
	
	//5.���10������
	BufferedImage[] images; //������洢���ʮ������
	//6.����������ڶ���ͼƬ
	BufferedImage catch01;
	BufferedImage catch02;
	//7.���Ƿ񱻲�׽��
	boolean isCatched;  //���isCatched��true������������������    ���Ϊfalse����û������
	
	//��������ӹ��췽��
	//�������е��޲ι��췽����Ϊ�вι���
	public Fish(String s)
	//s=fish01 02 03...09 fish13 fish14 s������ʾ���յ���ͬ�������
	{
		try {
			 
				image = ImageIO.read(new File("java�������ͼƬ/images/"+s+"_00.png"));
			
			
			
			width = image.getWidth();
			height = image.getHeight();
			//��ʱ���꣬��ʹ�������������
			Random r = new Random();
			x=800;
			y= r.nextInt(500-height);// �������������0~500-height֮���������
			step=r.nextInt(5)+1;  //1-5
			//�ȴ�������images�Ĵ�С
			images = new BufferedImage[10];
			//������images�з�10������ͼƬ
			for (int i = 0; i < images.length; i++) { //i=0~9
				
					images[i]=ImageIO.read(new File("java�������ͼƬ/images/"+s+"_0"+i+".png"));
		    //                                         java�������ͼƬ/images/fish01_01.png  fish09_01.png      
				
			}
			//���㷭�ڵ�����������ֵ
			catch01=ImageIO.read(new File("java�������ͼƬ/images/"+s+"_catch_01.png"));
			catch02=ImageIO.read(new File("java�������ͼƬ/images/"+s+"_catch_02.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	int index=0;  //index������ʾ����images������±�
public void run()  //��Ϊ
	   { 
		while(true){
			if(isCatched==false){  //�����û�б�������׽��������������
				move();
			}else{  //����㱻������׽��(isCatched==true)�����㷭�� ��ʧ
				turnOver();
				goOut();
			}
			move();  //����move����ʵ�����εĹ���
			//System.out.println(x);
			try {
				Thread.sleep(100);  //�õ�ǰ�߳�˯��xx����
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	   }
       //���һ������--ʵ�����ε÷�����1.ֱ������������ 2.���Լ�10��������ѭ�����ţ�
       public void move(){
    	   x=x-step;  //������+  
			//ʵ���������10�������Ĳ���(˼�룺������images������ȡ����ʮ����������image���¸�ֵ)
			image=images[index];
			index++;
			if (index==10) {
				index=0;
			}
			
			//�ж����Ƿ��γ�ȥ��
			if (x<=-width) {
				Random r = new Random();
				x=800;   //����������ĺ�����   �����Ҷ˽���
				//y=r.nextInt(500);
				y=r.nextInt(500-height);
				step=r.nextInt(5)+1;
			}
       }
       //���һ������--������ʧ����Ϊ--�������������볡
       public void goOut(){
    	   Random r = new Random();
			x=800;
			y= r.nextInt(500-height);  //�������������0~500-height֮���������
			step=r.nextInt(5)+1;  //1-5
			isCatched=false;//���㱻������������һ�η���+��ʧ��Ҫ���̰�isCatched�޸�Ϊfalse����Ż�����������
}
		//���һ���㷭�ڵķ���--���㱻�����ڼ���
		public void turnOver(){
			for(int i=1;i<=5;i++){
				image=catch01;  //�ѵ�һ�����ڵĶ�����image���¸�ֵ 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				image=catch02;  //�ѵڶ������ڵĶ�����image���¸�ֵ 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}