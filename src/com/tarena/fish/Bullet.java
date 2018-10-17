package com.tarena.fish;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//子弹对象   成为一个子单线程
public class Bullet extends Thread{
	//一、特征
	//1.子弹图片
	BufferedImage image;
	//2.子弹大小
	int width;
	int height;
	//3.子弹坐标
	int x;
	int y;
	//4.子弹发射时的弧度（方向）
	double roate;
	//5.子弹的出发点--大炮旋转的中心点--圆心
	Point p;
	
	Pool pool;  //定义池塘特征
	int xx;  //子弹运行轨迹的x坐标
	int yy;  //子弹运行轨迹的y坐标
	
	//添加构造方法--完成对特征的初始化
	public Bullet(Pool pl){
		pool=pl;  //将参数传递过来的池塘对象pl赋值给特征pool
		try {
			image=ImageIO.read(new File("java捕鱼达人图片/images/bullet1.png"));
			width=image.getWidth();
			height=image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//二、行为
    //把线程中的run方法点出来
    public void run() {
    	while(true){  //死循环--实现子弹不停移动
    		move();  //子弹一次走10个位置,睡眠40毫秒
    		try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    //添加一个方法--子弹的移动方法
    public void move(){
    	y=y-10;  //子弹一次走10个位置,睡眠40毫秒
    	//实现子弹的运行轨迹，求出轨迹上的坐标
    	int r=p.y-17-y;  //r就是根据公式理解的半径
    	//System.out.println("r="+r);
    	xx=p.x-10 + Math.round((float)Math.sin(roate)*r);  //xx变量表示子弹运行轨迹的x坐标
    	yy=p.y-17 - Math.abs(Math.round((float)Math.cos(roate)*r));  //yy变量表示子弹运行轨迹的y坐标
    	//System.out.println(xx+","+yy);
    	//调用hint方法，子弹每一次move移动，都要检查是否能击中鱼
    	hint();
    }
    
    //添加一个方法--子弹击中鱼的方法
    public void hint(){
    	//使用循环，遍历池塘中的所有鱼
    	for(int i=0;i<pool.fishs.length;i++){
    		Fish fish=pool.fishs[i];  //根据下标i从池塘中取出每一条鱼，fish变量表示每一条取出的鱼
    		//判断子弹是否能击中鱼--判断子弹的x和y坐标是否能击中鱼的身上
    		if(xx>=fish.x && xx<=fish.x+fish.width && yy>=fish.y && yy<=fish.y+fish.height){
    			fish.isCatched=true;  //把鱼的isCatched修改为true，表示鱼被子弹击中了
    			
    		}
    	}
    }
}
