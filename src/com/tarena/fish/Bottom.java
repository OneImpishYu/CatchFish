package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//�Ʒְ����
public class Bottom {
	//1.ͼƬ
	BufferedImage image;
	//2.��С
	int width;
	int height;
	//3.λ��
    int x;
    int y;
    
    public Bottom(){
    	   try {
    		image=ImageIO.read(new File("java�������ͼƬ/images/bottom-bar.png"));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	    	//�Ʒְ��СΪԭ��С
    	    	width=image.getWidth();
    	    	height=image.getHeight();
    	    	//ȷ���Ʒְ�����
    	    	x=17;
    	    	y=402;
    	            }
    	    }