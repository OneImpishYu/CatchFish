package com.java.snow;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sky extends JPanel {
	private static final long serialVersionUID = 1L;
	BufferedImage bg;//背景图片
	
	Snow[] snows;//多个雪花   声明一个数组 表示一个容器，该容器可以存储多个雪花对象
	
	//Snow n;
	public Sky()
    {
	 try {
		bg = ImageIO.read(new File("java捕鱼达人图片/images/sky.jpg"));
		//n = new Snow();
		//n.start();//调用start方法，启动雪花线程，执行run()方法
		snows = new Snow[20]; //下标0-19
		//往数组snows中根据大小放入对应的雪花对象
		for (int i = 0; i < snows.length; i++)
		{
			snows[i] = new Snow();  //每次循环创建一个雪花放入数组中
			snows[i].start();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public void paint(Graphics g)
    {
	super.paint(g);
	  g.drawImage(bg,0,0,960,640,null );
	 // g.drawImage(n.im1,n.x,n.y,n.width,n.height,null);
	  //使用画笔依次将数组中雪花画出来
	  for (int i = 0; i < snows.length; i++) 
	  {
		//每次循环就从数组中取出一个雪花，再用画笔画出来
		  Snow s = snows[i];
		  g.drawImage(s.im1,s.x,s.y,s.width,s.height,null );
	}
	}
//添加一个方法--不停刷新面板的内容--不停调用paint方法
public  void action()
   {
	while(true)
	{//repaint方法会重新执行一次paint方法
		repaint();//该方法是父类jpanel面板中，因为有继承关系，可以直接使用
	}
	}
}
