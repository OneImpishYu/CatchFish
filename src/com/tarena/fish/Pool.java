package com.tarena.fish;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pool extends JPanel{

	private static final long serialVersionUID = 1L;
//一 特征
//1.池塘背景图片（水，水草）
	BufferedImage bg;//用来处理图片类型
	//Fish f;
	Fish[]fishs;//2.多条鱼  建立数组

//3.渔网
	Net net = new Net();//表示池塘中的一个渔网  并创建对象-
//4.大炮
	Barrel bar=new Barrel();
//5.计分板
    Bottom bot=new Bottom();
//6.10个金币
    BufferedImage[] golds;  //数组容器用来存储0-9的10个金币
    int mouseX;  //鼠标在窗体中的x坐标，在此处声明，可以在下面任何一处位置使用
    int mouseY;  // 鼠标在窗体中的y坐标，在此处声明，可以在下面任何一处位置使用
    double f;    //表示大炮旋转的幅度
    ArrayList<Bullet> bullets=new ArrayList<Bullet>();  //用该线性集合表示弹夹，用来存放子弹。 <Bullet>表示只能放子弹类型的
	
    //构造方法用来对特征进行赋值。  创建池塘对象时自动执行
	public Pool()
	{
		//使用ImageIO工具类中的read方法读取图片，以File方式读取
		try {
			
			bg = ImageIO.read(new File("java捕鱼达人图片/images/bg2.jpg"));
		    // f = new Fish();//创建一条鱼 赋值给变量f
		    // f.start();
			//给渔网赋值变量n
			//读取渔网图片
			fishs = new Fish[11];   //创建11条不同种类的鱼
			//创建计分板
			//使用循环依次往数组中放前9条不同种类鱼
			for (int i = 0; i < 9; i++) {//i=0 1 2 3...
				//在创建鱼的时候，要确定鱼的种类，“fish0a”表示不同种类的鱼，a取值为1 2 3 ...
				//fish01 fish02 ... fish09
				fishs[i] = new Fish("fish0"+(i+1));  
				fishs[i].start();      //每条鱼进场都启动线程，执行run()方法
			}
			//单独往数组小标的9的位置和10位置放剩下的两条鱼（fish13 fish14）
			fishs[9]=new Fish("fish13");
			fishs[9].start();
			fishs[10]=new Fish("fish14");
			fishs[10].start();
			golds=new BufferedImage[10];//创建金币数组的大小
			//使用循环的方式一次往数组中放内容
			for(int i=0;i<golds.length;i++){
				//先往数组中放10个0金币
				golds[i]=ImageIO.read(new File("java捕鱼达人图片/images/0.png"));
			}
		} //try{}中代码出错，执行catch
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//二 行为
	public void paint(Graphics g)
	{
	super.paint(g);
	//使用画笔g将背景bg画在池塘面板中
	//参数1：画哪张图片  参数2和3：表示在什么位置上开始画 参数4和5:所画图片大小(宽度，高度)
     g.drawImage(bg,0,0,800,500,null);
     //计分板
     g.drawImage(bot.image,bot.x,bot.y,bot.width,bot.height,null );
  //使用画笔g将鱼画在池塘面板
     //g.drawImage(f.image,f.x,f.y,f.width,f.height,null);
    for (int i =0; i <fishs.length; i++) {
	       Fish f = fishs[i];
		g.drawImage(f.image,f.x,f.y,f.width,f.height,null );
    }
		if(net.show==true){  //如果if后面的条件成立  渔网显示
			 //使用画笔将渔网画在面板上
		    //将渔网在原坐标的基础上左移二分之一的宽度，上移二分之一的高度
		    int x=net.x-net.width/2;
		    int y=net.y-net.height/2;
		    g.drawImage(net.netImg,x,y,net.width,net.height,null);	
		
	}
		//画笔画出计分板
		//  修改画笔的颜色
		g.setColor(new Color(255,0,0));
        //  使用画笔将鱼的数量画出来
		//  参数1：画的字符串内容    参数2.3：坐标位置
		g.drawString(count+"",13,13);
		//使用画笔将大炮画出来
		//计算出大炮旋转的中心点坐标
		int centerX=bar.x+19;
		int centerY=bar.y+39;
		double a=(double)mouseY-centerY;
		double b=(double)mouseX-centerX;
		f=-Math.atan(b/a);  //f就是根据两个直角边的比值求出的弧度
		Graphics2D g2D=(Graphics2D)g.create();  //获得2D画笔
		//使用2D画笔设置旋转的弧度和中心点
		g2D.rotate(f,centerX,centerY);
		//用g2D大炮
	     g2D.drawImage(bar.image,bar.x,bar.y,bar.width,bar.height,null );
	     
	     //使用画笔将弹夹中所有子弹画出
	     for(int i=0;i<bullets.size();i++){  //集合容器与数组容器相同，都是通过下标访问内容
	    	Bullet bul=bullets.get(i);  //bul变量表示每一次循环根据下标获取弹夹中的子弹
	    	//画带有弧度的子弹使用g2D
	    	Graphics2D gd=(Graphics2D)g.create();
	    	//先设置子弹的弧度和中心点(大炮旋转的中心点)
	    	gd.rotate(bul.roate,centerX,centerY);
	    	//使用gd画笔将子弹画出
	    	gd.drawImage(bul.image,bul.x,bul.y,bul.width,bul.height,null);
	     }
	     //使用画笔在左下角对应的位置画6个0金币
	     for(int i=0;i<6;i++){  //i=0 1 2 3 4 5
	    	 g.drawImage(golds[i],34+i*24,448,20,20,null);
	     }
}
	
	//2.添加一个方法--不停的调用paint方法，实现面板的刷新
public void action()
   {
	//实现鼠标监听--MouseAdapter是抽象类，不能直接new创建 使用匿名内部类的方式创建
	//匿名内部类因为没有自己的类名，所以创建的是父类/父接口，{}表示匿名内部类的类体
	MouseAdapter mouse=new MouseAdapter(){
		//鼠标按下事件的监听--渔网捕鱼的功能--发射子弹，由子弹抓鱼
		public void mousePressed(MouseEvent e) {
			//catchFish();  //渔网捕鱼
			//在鼠标按下时,先创建一个子弹
			Bullet bullet=new Bullet(Pool.this);  //在创建子弹的时候，把有多条鱼 池塘对象作为参数传递过去
			//子弹图片和大小以确定，还需对子弹坐标和发射弧度赋值			
			bullet.x=bar.x+19-10;//子弹的x坐标为旋转的中心点左移10个距离
			bullet.y=bar.y+39-17;//子弹的y坐标为旋转的中心点上移17个距离
			bullet.roate=f;//把大炮发射子弹时的弧度赋值给子弹，作为子弹的弧度
			//创建一个点，该点位大炮旋转的中心点，并给子弹的p特征赋值
			bullet.p=new Point(bar.x+19,bar.y+39);
		    //把该子弹装入弹夹中 
			bullets.add(bullet);
 		//把该子弹的线程启动
			bullet.start();
		}
		//鼠标移动时间的监听--渔网跟随鼠标的功能
		public void mouseMoved(MouseEvent e) {
			//获取鼠标在面板中的坐标值
			mouseX=e.getX();
			mouseY=e.getY();
			//System.out.println(mouseX+","+mouseY);
			//调用Net类中的moveTo方法，将鼠标最新的坐标值通过该方法传递给渔网的xy坐标
			net.moveTo(mouseX, mouseY);
		}
		//鼠标进入事件的监听--渔网显示功能
        public void mouseEntered(MouseEvent e) {
        	net.show=true;//如果变量show的值为true，渔网就显示 
        	//System.out.println("鼠标进入...");
		}
        //鼠标离开事件的监听--渔网隐藏的功能
		public void mouseExited(MouseEvent e) {
			net.show=false;//如果变量show的值为false，渔网就不显示
			//System.out.println("鼠标离开...");
		}
	};
	//把创建出来的鼠标监听MouseAdapter绑定到池塘面板中
	//this就表示当前池塘面板
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);
	
	//不停调用paint()方法
	while(true)
	{
		repaint();
	}
	}
    //3 添加一个方法--在池塘中用渔网捕鱼的行为
    public int count=0;  //表示捕鱼的数量
    public void catchFish(){
	//使用循环遍历池塘中的11条鱼 看一下渔网在哪一个鱼的身上
	for(int i=0;i<fishs.length;i++){
		if(net.isCanFish(fishs[i])){
			if(net.isCanFish(fishs[i])==true){ //如果该if判断出条件成立 说明渔网捕到了某一条鱼
				//1.如果捕到了某一条鱼，让该鱼直接消失
				//fishs[i].goOut();
				fishs[i].isCatched=true; //把鱼类中的isCatched改为true，标记该鱼被捕到
				//2.统计鱼的条数
				count++;  //每成功捕捉到一条鱼，count就++一次
				//假设count为325，表示捕捉325条鱼
				//需要将golds数组中{0 0 0 0 0 0 0 0 0 0}对应的前三个位置的0修改为 3 2 5
				//将count整数类型转换为字符串类型 
				String str=count+"";  //"325"
				//字符串的访问也是根据下标访问   下标  012
				//使用循环根据下标依次访问字符串中的每一个字符
				for(int j=0;j<str.length();j++){  //j= 0 1 2
					char c=str.charAt(j);  //c=3 2 5  根据下标取出的是对应的字符
					String img="java捕鱼达人图片/images/"+c+".png";  //组成访问金币图片的路径
					try {
						golds[j]=ImageIO.read(new File(img));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}
}
}