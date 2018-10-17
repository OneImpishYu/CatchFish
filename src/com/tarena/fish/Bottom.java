package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//计分板对象
public class Bottom {
	//1.图片
	BufferedImage image;
	//2.大小
	int width;
	int height;
	//3.位置
    int x;
    int y;
    
    public Bottom(){
    	   try {
    		image=ImageIO.read(new File("java捕鱼达人图片/images/bottom-bar.png"));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	    	//计分板大小为原大小
    	    	width=image.getWidth();
    	    	height=image.getHeight();
    	    	//确定计分板坐标
    	    	x=17;
    	    	y=402;
    	            }
    	    }