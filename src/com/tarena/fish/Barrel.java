package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//大炮对象
public class Barrel {
	//1.图片
	BufferedImage image;
	//2.大小
	int width;
	int height;
	//3.位置
    int x;
    int y;
    
    public Barrel(){
    	   try {
    		image=ImageIO.read(new File("java捕鱼达人图片/images/barrel.png"));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	    	//计分板大小为原大小
    	    	width=image.getWidth();
    	    	height=image.getHeight();
    	    	//确定渔网坐标
    	    	x=420;
    	    	y=410;
    	            }
    	    }

