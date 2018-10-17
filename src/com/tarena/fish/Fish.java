package com.tarena.fish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//鱼对象 == java中的类
public class Fish extends Thread {
// 一 特征
	BufferedImage image;// 1.鱼的种类(鱼的不同图片)
	// 2. 鱼的大小
	int width;
	int height;
	//3. 鱼的坐标
	int x;
	int y;
	//4.鱼的速度
	int step;
	
	//5.鱼的10个动作
	BufferedImage[] images; //该数组存储鱼的十个动作
	//6.鱼的两个翻腾动作图片
	BufferedImage catch01;
	BufferedImage catch02;
	//7.鱼是否被捕捉到
	boolean isCatched;  //如果isCatched是true，表明被渔网捕到了    如果为false，则没被捕到
	
	//鱼类中添加构造方法
	//把鱼类中的无参构造方法改为有参构造
	public Fish(String s)
	//s=fish01 02 03...09 fish13 fish14 s变量表示接收到不同种类的鱼
	{
		try {
			 
				image = ImageIO.read(new File("java捕鱼达人图片/images/"+s+"_00.png"));
			
			
			
			width = image.getWidth();
			height = image.getHeight();
			//临时坐标，再使用坐标随机生成
			Random r = new Random();
			x=800;
			y= r.nextInt(500-height);// 让鱼的纵坐标在0~500-height之间随机产生
			step=r.nextInt(5)+1;  //1-5
			//先创建数组images的大小
			images = new BufferedImage[10];
			//往数组images中放10个动作图片
			for (int i = 0; i < images.length; i++) { //i=0~9
				
					images[i]=ImageIO.read(new File("java捕鱼达人图片/images/"+s+"_0"+i+".png"));
		    //                                         java捕鱼达人图片/images/fish01_01.png  fish09_01.png      
				
			}
			//给鱼翻腾的两个动作赋值
			catch01=ImageIO.read(new File("java捕鱼达人图片/images/"+s+"_catch_01.png"));
			catch02=ImageIO.read(new File("java捕鱼达人图片/images/"+s+"_catch_02.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	int index=0;  //index变量表示访问images数组的下标
public void run()  //行为
	   { 
		while(true){
			if(isCatched==false){  //如果鱼没有被渔网捕捉到，该鱼正常游
				move();
			}else{  //如果鱼被渔网捕捉到(isCatched==true)，该鱼翻腾 消失
				turnOver();
				goOut();
			}
			move();  //调用move方法实现鱼游的功能
			//System.out.println(x);
			try {
				Thread.sleep(100);  //让当前线程睡眠xx毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	   }
       //添加一个方法--实现鱼游得方法（1.直线由左往右游 2.鱼自己10个动作的循环播放）
       public void move(){
    	   x=x-step;  //反向则+  
			//实现鱼自身的10个动作的播放(思想：从数组images中依次取出这十个动作，给image重新赋值)
			image=images[index];
			index++;
			if (index==10) {
				index=0;
			}
			
			//判断鱼是否游出去了
			if (x<=-width) {
				Random r = new Random();
				x=800;   //设置鱼进场的横坐标   从最右端进场
				//y=r.nextInt(500);
				y=r.nextInt(500-height);
				step=r.nextInt(5)+1;
			}
       }
       //添加一个方法--让鱼消失的行为--让鱼立刻重新入场
       public void goOut(){
    	   Random r = new Random();
			x=800;
			y= r.nextInt(500-height);  //让鱼的纵坐标在0~500-height之间随机产生
			step=r.nextInt(5)+1;  //1-5
			isCatched=false;//在鱼被渔网捕到后，做一次翻腾+消失后，要立刻把isCatched修改为false，鱼才会重新正常游
}
		//添加一个鱼翻腾的方法--在鱼被捕后翻腾几下
		public void turnOver(){
			for(int i=1;i<=5;i++){
				image=catch01;  //把第一个翻腾的动作给image重新赋值 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				image=catch02;  //把第二个翻腾的动作给image重新赋值 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}