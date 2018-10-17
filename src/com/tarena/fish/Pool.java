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
//һ ����
//1.��������ͼƬ��ˮ��ˮ�ݣ�
	BufferedImage bg;//��������ͼƬ����
	//Fish f;
	Fish[]fishs;//2.������  ��������

//3.����
	Net net = new Net();//��ʾ�����е�һ������  ����������-
//4.����
	Barrel bar=new Barrel();
//5.�Ʒְ�
    Bottom bot=new Bottom();
//6.10�����
    BufferedImage[] golds;  //�������������洢0-9��10�����
    int mouseX;  //����ڴ����е�x���꣬�ڴ˴������������������κ�һ��λ��ʹ��
    int mouseY;  // ����ڴ����е�y���꣬�ڴ˴������������������κ�һ��λ��ʹ��
    double f;    //��ʾ������ת�ķ���
    ArrayList<Bullet> bullets=new ArrayList<Bullet>();  //�ø����Լ��ϱ�ʾ���У���������ӵ��� <Bullet>��ʾֻ�ܷ��ӵ����͵�
	
    //���췽���������������и�ֵ��  ������������ʱ�Զ�ִ��
	public Pool()
	{
		//ʹ��ImageIO�������е�read������ȡͼƬ����File��ʽ��ȡ
		try {
			
			bg = ImageIO.read(new File("java�������ͼƬ/images/bg2.jpg"));
		    // f = new Fish();//����һ���� ��ֵ������f
		    // f.start();
			//��������ֵ����n
			//��ȡ����ͼƬ
			fishs = new Fish[11];   //����11����ͬ�������
			//�����Ʒְ�
			//ʹ��ѭ�������������з�ǰ9����ͬ������
			for (int i = 0; i < 9; i++) {//i=0 1 2 3...
				//�ڴ������ʱ��Ҫȷ��������࣬��fish0a����ʾ��ͬ������㣬aȡֵΪ1 2 3 ...
				//fish01 fish02 ... fish09
				fishs[i] = new Fish("fish0"+(i+1));  
				fishs[i].start();      //ÿ��������������̣߳�ִ��run()����
			}
			//����������С���9��λ�ú�10λ�÷�ʣ�µ������㣨fish13 fish14��
			fishs[9]=new Fish("fish13");
			fishs[9].start();
			fishs[10]=new Fish("fish14");
			fishs[10].start();
			golds=new BufferedImage[10];//�����������Ĵ�С
			//ʹ��ѭ���ķ�ʽһ���������з�����
			for(int i=0;i<golds.length;i++){
				//���������з�10��0���
				golds[i]=ImageIO.read(new File("java�������ͼƬ/images/0.png"));
			}
		} //try{}�д������ִ��catch
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//�� ��Ϊ
	public void paint(Graphics g)
	{
	super.paint(g);
	//ʹ�û���g������bg���ڳ��������
	//����1��������ͼƬ  ����2��3����ʾ��ʲôλ���Ͽ�ʼ�� ����4��5:����ͼƬ��С(��ȣ��߶�)
     g.drawImage(bg,0,0,800,500,null);
     //�Ʒְ�
     g.drawImage(bot.image,bot.x,bot.y,bot.width,bot.height,null );
  //ʹ�û���g���㻭�ڳ������
     //g.drawImage(f.image,f.x,f.y,f.width,f.height,null);
    for (int i =0; i <fishs.length; i++) {
	       Fish f = fishs[i];
		g.drawImage(f.image,f.x,f.y,f.width,f.height,null );
    }
		if(net.show==true){  //���if�������������  ������ʾ
			 //ʹ�û��ʽ��������������
		    //��������ԭ����Ļ��������ƶ���֮һ�Ŀ�ȣ����ƶ���֮һ�ĸ߶�
		    int x=net.x-net.width/2;
		    int y=net.y-net.height/2;
		    g.drawImage(net.netImg,x,y,net.width,net.height,null);	
		
	}
		//���ʻ����Ʒְ�
		//  �޸Ļ��ʵ���ɫ
		g.setColor(new Color(255,0,0));
        //  ʹ�û��ʽ��������������
		//  ����1�������ַ�������    ����2.3������λ��
		g.drawString(count+"",13,13);
		//ʹ�û��ʽ����ڻ�����
		//�����������ת�����ĵ�����
		int centerX=bar.x+19;
		int centerY=bar.y+39;
		double a=(double)mouseY-centerY;
		double b=(double)mouseX-centerX;
		f=-Math.atan(b/a);  //f���Ǹ�������ֱ�Ǳߵı�ֵ����Ļ���
		Graphics2D g2D=(Graphics2D)g.create();  //���2D����
		//ʹ��2D����������ת�Ļ��Ⱥ����ĵ�
		g2D.rotate(f,centerX,centerY);
		//��g2D����
	     g2D.drawImage(bar.image,bar.x,bar.y,bar.width,bar.height,null );
	     
	     //ʹ�û��ʽ������������ӵ�����
	     for(int i=0;i<bullets.size();i++){  //��������������������ͬ������ͨ���±��������
	    	Bullet bul=bullets.get(i);  //bul������ʾÿһ��ѭ�������±��ȡ�����е��ӵ�
	    	//�����л��ȵ��ӵ�ʹ��g2D
	    	Graphics2D gd=(Graphics2D)g.create();
	    	//�������ӵ��Ļ��Ⱥ����ĵ�(������ת�����ĵ�)
	    	gd.rotate(bul.roate,centerX,centerY);
	    	//ʹ��gd���ʽ��ӵ�����
	    	gd.drawImage(bul.image,bul.x,bul.y,bul.width,bul.height,null);
	     }
	     //ʹ�û��������½Ƕ�Ӧ��λ�û�6��0���
	     for(int i=0;i<6;i++){  //i=0 1 2 3 4 5
	    	 g.drawImage(golds[i],34+i*24,448,20,20,null);
	     }
}
	
	//2.���һ������--��ͣ�ĵ���paint������ʵ������ˢ��
public void action()
   {
	//ʵ��������--MouseAdapter�ǳ����࣬����ֱ��new���� ʹ�������ڲ���ķ�ʽ����
	//�����ڲ�����Ϊû���Լ������������Դ������Ǹ���/���ӿڣ�{}��ʾ�����ڲ��������
	MouseAdapter mouse=new MouseAdapter(){
		//��갴���¼��ļ���--��������Ĺ���--�����ӵ������ӵ�ץ��
		public void mousePressed(MouseEvent e) {
			//catchFish();  //��������
			//����갴��ʱ,�ȴ���һ���ӵ�
			Bullet bullet=new Bullet(Pool.this);  //�ڴ����ӵ���ʱ�򣬰��ж����� ����������Ϊ�������ݹ�ȥ
			//�ӵ�ͼƬ�ʹ�С��ȷ����������ӵ�����ͷ��仡�ȸ�ֵ			
			bullet.x=bar.x+19-10;//�ӵ���x����Ϊ��ת�����ĵ�����10������
			bullet.y=bar.y+39-17;//�ӵ���y����Ϊ��ת�����ĵ�����17������
			bullet.roate=f;//�Ѵ��ڷ����ӵ�ʱ�Ļ��ȸ�ֵ���ӵ�����Ϊ�ӵ��Ļ���
			//����һ���㣬�õ�λ������ת�����ĵ㣬�����ӵ���p������ֵ
			bullet.p=new Point(bar.x+19,bar.y+39);
		    //�Ѹ��ӵ�װ�뵯���� 
			bullets.add(bullet);
 		//�Ѹ��ӵ����߳�����
			bullet.start();
		}
		//����ƶ�ʱ��ļ���--�����������Ĺ���
		public void mouseMoved(MouseEvent e) {
			//��ȡ���������е�����ֵ
			mouseX=e.getX();
			mouseY=e.getY();
			//System.out.println(mouseX+","+mouseY);
			//����Net���е�moveTo��������������µ�����ֵͨ���÷������ݸ�������xy����
			net.moveTo(mouseX, mouseY);
		}
		//�������¼��ļ���--������ʾ����
        public void mouseEntered(MouseEvent e) {
        	net.show=true;//�������show��ֵΪtrue����������ʾ 
        	//System.out.println("������...");
		}
        //����뿪�¼��ļ���--�������صĹ���
		public void mouseExited(MouseEvent e) {
			net.show=false;//�������show��ֵΪfalse�������Ͳ���ʾ
			//System.out.println("����뿪...");
		}
	};
	//�Ѵ���������������MouseAdapter�󶨵����������
	//this�ͱ�ʾ��ǰ�������
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);
	
	//��ͣ����paint()����
	while(true)
	{
		repaint();
	}
	}
    //3 ���һ������--�ڳ������������������Ϊ
    public int count=0;  //��ʾ���������
    public void catchFish(){
	//ʹ��ѭ�����������е�11���� ��һ����������һ���������
	for(int i=0;i<fishs.length;i++){
		if(net.isCanFish(fishs[i])){
			if(net.isCanFish(fishs[i])==true){ //�����if�жϳ��������� ˵������������ĳһ����
				//1.���������ĳһ���㣬�ø���ֱ����ʧ
				//fishs[i].goOut();
				fishs[i].isCatched=true; //�������е�isCatched��Ϊtrue����Ǹ��㱻����
				//2.ͳ���������
				count++;  //ÿ�ɹ���׽��һ���㣬count��++һ��
				//����countΪ325����ʾ��׽325����
				//��Ҫ��golds������{0 0 0 0 0 0 0 0 0 0}��Ӧ��ǰ����λ�õ�0�޸�Ϊ 3 2 5
				//��count��������ת��Ϊ�ַ������� 
				String str=count+"";  //"325"
				//�ַ����ķ���Ҳ�Ǹ����±����   �±�  012
				//ʹ��ѭ�������±����η����ַ����е�ÿһ���ַ�
				for(int j=0;j<str.length();j++){  //j= 0 1 2
					char c=str.charAt(j);  //c=3 2 5  �����±�ȡ�����Ƕ�Ӧ���ַ�
					String img="java�������ͼƬ/images/"+c+".png";  //��ɷ��ʽ��ͼƬ��·��
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