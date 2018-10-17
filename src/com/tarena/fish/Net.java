package com.tarena.fish;
//��������
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Net {
	//һ������
	//1.����ͼƬ
	BufferedImage netImg;
    //2.������С
	int width;
	int height;
	//3.��������
	int x;
	int y;
	//4.�����Ƿ���ʾ
	boolean show; //�������show��ֵΪtrue����������ʾ  �������show��ֵΪfalse�������Ͳ���ʾ
	
	  //�����������޲ι��췽��--���������и�ֵ
	public Net(){
		//��������ͼƬ
		try {
			netImg=ImageIO.read(new File("java�������ͼƬ/images/net09.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//������СΪԭ��С
	width=netImg.getWidth();
	height=netImg.getHeight();
	//ȷ����������
	x=300;
	y=200;
        }
    //������Ϊ
	//��Ϊ������������ƶ� ��������һ����Ϊ ������Net.java����Ӹ÷���
    //���һ������--��������xy�������Ϊ��������
	public void moveTo(int mouseX,int mouseY){
		//����������xy��ʼ��ֵ����300.200.���ڽ�������xy����Ϊ��������
		x=mouseX;
		y=mouseY;
	}
    //���һ������--��������Ĺ���--����Ӧ����ô����
	//������Fish f  ��ʾ����Ҫ����������
	//�������ͣ�boolean  ������ص�Ϊtrue����ʾ�����ܲ����㣬������ص�Ϊfalse����ʾ����û������
	public boolean isCanFish(Fish f){
		int dx=x-f.x;
		int dy=y-f.y;
		boolean flag=(dx>=0&&dx<=f.width&&dy>=0&&dy<=f.height);
		return flag;
		//���flag���ص���true��˵�����������ĵ㣨���ĵ㣩�������ϣ� ��������
		//���flag���ص���false��˵�����������ĵ㣨���ĵ㣩���������ϣ�û�в�������
	}
	
}


