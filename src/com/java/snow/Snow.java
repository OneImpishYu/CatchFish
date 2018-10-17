package com.java.snow;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Snow extends Thread{
	private static final long serialVersionUID = 1L;
BufferedImage im1;
int width;
int height;
int x;
int y;
int step;
public Snow()
    { 
	try {
	
			im1 = ImageIO.read(new File("java�������ͼƬ/images/snow.png"));
		width = im1.getWidth();
		height = im1.getHeight();
		Random r = new Random(); //����һ�������
		x=r.nextInt(960-width);
		y=-height;
		step=r.nextInt(5)+1;//step  =>  1~5
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//���run()����,ʵ��ѩ������
public void run()
   { 
	while(true)
	{
		y=y+step;
		if (y>=640) {//�ж�y++��640��˵���Ѿ��������ˣ���ѩ�����½�
			Random r = new Random();
			x=r.nextInt(960-width);
			y=-height;
			step=r.nextInt(5)+1;
		}
		System.out.println(y);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //�õ�ǰ�߳�˯��xx����
		
	}
		
	}
	}

