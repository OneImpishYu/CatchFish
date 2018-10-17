package com.tarena.fish;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//�ӵ�����   ��Ϊһ���ӵ��߳�
public class Bullet extends Thread{
	//һ������
	//1.�ӵ�ͼƬ
	BufferedImage image;
	//2.�ӵ���С
	int width;
	int height;
	//3.�ӵ�����
	int x;
	int y;
	//4.�ӵ�����ʱ�Ļ��ȣ�����
	double roate;
	//5.�ӵ��ĳ�����--������ת�����ĵ�--Բ��
	Point p;
	
	Pool pool;  //�����������
	int xx;  //�ӵ����й켣��x����
	int yy;  //�ӵ����й켣��y����
	
	//��ӹ��췽��--��ɶ������ĳ�ʼ��
	public Bullet(Pool pl){
		pool=pl;  //���������ݹ����ĳ�������pl��ֵ������pool
		try {
			image=ImageIO.read(new File("java�������ͼƬ/images/bullet1.png"));
			width=image.getWidth();
			height=image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//������Ϊ
    //���߳��е�run���������
    public void run() {
    	while(true){  //��ѭ��--ʵ���ӵ���ͣ�ƶ�
    		move();  //�ӵ�һ����10��λ��,˯��40����
    		try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    //���һ������--�ӵ����ƶ�����
    public void move(){
    	y=y-10;  //�ӵ�һ����10��λ��,˯��40����
    	//ʵ���ӵ������й켣������켣�ϵ�����
    	int r=p.y-17-y;  //r���Ǹ��ݹ�ʽ���İ뾶
    	//System.out.println("r="+r);
    	xx=p.x-10 + Math.round((float)Math.sin(roate)*r);  //xx������ʾ�ӵ����й켣��x����
    	yy=p.y-17 - Math.abs(Math.round((float)Math.cos(roate)*r));  //yy������ʾ�ӵ����й켣��y����
    	//System.out.println(xx+","+yy);
    	//����hint�������ӵ�ÿһ��move�ƶ�����Ҫ����Ƿ��ܻ�����
    	hint();
    }
    
    //���һ������--�ӵ�������ķ���
    public void hint(){
    	//ʹ��ѭ�������������е�������
    	for(int i=0;i<pool.fishs.length;i++){
    		Fish fish=pool.fishs[i];  //�����±�i�ӳ�����ȡ��ÿһ���㣬fish������ʾÿһ��ȡ������
    		//�ж��ӵ��Ƿ��ܻ�����--�ж��ӵ���x��y�����Ƿ��ܻ����������
    		if(xx>=fish.x && xx<=fish.x+fish.width && yy>=fish.y && yy<=fish.y+fish.height){
    			fish.isCatched=true;  //�����isCatched�޸�Ϊtrue����ʾ�㱻�ӵ�������
    			
    		}
    	}
    }
}
