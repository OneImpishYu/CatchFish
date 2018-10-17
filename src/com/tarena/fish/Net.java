package com.tarena.fish;
//渔网对象
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Net {
	//一、特征
	//1.渔网图片
	BufferedImage netImg;
    //2.渔网大小
	int width;
	int height;
	//3.渔网坐标
	int x;
	int y;
	//4.渔网是否显示
	boolean show; //如果变量show的值为true，渔网就显示  如果变量show的值为false，渔网就不显示
	
	  //创建渔网的无参构造方法--对特征进行赋值
	public Net(){
		//画入渔网图片
		try {
			netImg=ImageIO.read(new File("java捕鱼达人图片/images/net09.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//渔网大小为原大小
	width=netImg.getWidth();
	height=netImg.getHeight();
	//确定渔网坐标
	x=300;
	y=200;
        }
    //二、行为
	//因为渔网跟着鼠标移动 是渔网的一个行为 所以在Net.java中添加该方法
    //添加一个方法--将渔网的xy坐标更改为鼠标的坐标
	public void moveTo(int mouseX,int mouseY){
		//渔网的坐标xy开始赋值的是300.200.现在将渔网的xy更改为鼠标的坐标
		x=mouseX;
		y=mouseY;
	}
    //添加一个方法--渔网捕鱼的规则--渔网应该怎么捕鱼
	//参数：Fish f  表示渔网要补得哪条鱼
	//返回类型：boolean  如果返回的为true，表示渔网能捕到鱼，如果返回的为false，表示渔网没捕到鱼
	public boolean isCanFish(Fish f){
		int dx=x-f.x;
		int dy=y-f.y;
		boolean flag=(dx>=0&&dx<=f.width&&dy>=0&&dy<=f.height);
		return flag;
		//如果flag返回的是true，说明渔网的中心点（鼠标的点）在鱼身上， 捕到鱼了
		//如果flag返回的是false，说明渔网的中心点（鼠标的点）不在鱼身上，没有捕到鱼了
	}
	
}


