package com.java.snow;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sky extends JPanel {
	private static final long serialVersionUID = 1L;
	BufferedImage bg;//����ͼƬ
	
	Snow[] snows;//���ѩ��   ����һ������ ��ʾһ�����������������Դ洢���ѩ������
	
	//Snow n;
	public Sky()
    {
	 try {
		bg = ImageIO.read(new File("java�������ͼƬ/images/sky.jpg"));
		//n = new Snow();
		//n.start();//����start����������ѩ���̣߳�ִ��run()����
		snows = new Snow[20]; //�±�0-19
		//������snows�и��ݴ�С�����Ӧ��ѩ������
		for (int i = 0; i < snows.length; i++)
		{
			snows[i] = new Snow();  //ÿ��ѭ������һ��ѩ������������
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
	  //ʹ�û������ν�������ѩ��������
	  for (int i = 0; i < snows.length; i++) 
	  {
		//ÿ��ѭ���ʹ�������ȡ��һ��ѩ�������û��ʻ�����
		  Snow s = snows[i];
		  g.drawImage(s.im1,s.x,s.y,s.width,s.height,null );
	}
	}
//���һ������--��ͣˢ����������--��ͣ����paint����
public  void action()
   {
	while(true)
	{//repaint����������ִ��һ��paint����
		repaint();//�÷����Ǹ���jpanel����У���Ϊ�м̳й�ϵ������ֱ��ʹ��
	}
	}
}
