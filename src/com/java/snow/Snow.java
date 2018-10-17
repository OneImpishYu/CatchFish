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
	
			im1 = ImageIO.read(new File("java捕鱼达人图片/images/snow.png"));
		width = im1.getWidth();
		height = im1.getHeight();
		Random r = new Random(); //创建一个随机数
		x=r.nextInt(960-width);
		y=-height;
		step=r.nextInt(5)+1;//step  =>  1~5
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//添加run()方法,实现雪花下落
public void run()
   { 
	while(true)
	{
		y=y+step;
		if (y>=640) {//判断y++到640，说明已经到窗底了，让雪花重新进
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
		} //让当前线程睡眠xx毫秒
		
	}
		
	}
	}

