package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//���ڶ���
public class Barrel {
	//1.ͼƬ
	BufferedImage image;
	//2.��С
	int width;
	int height;
	//3.λ��
    int x;
    int y;
    
    public Barrel(){
    	   try {
    		image=ImageIO.read(new File("java�������ͼƬ/images/barrel.png"));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	    	//�Ʒְ��СΪԭ��С
    	    	width=image.getWidth();
    	    	height=image.getHeight();
    	    	//ȷ����������
    	    	x=420;
    	    	y=410;
    	            }
    	    }

