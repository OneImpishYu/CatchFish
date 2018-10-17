package com.tarena.fish;
import javax.swing.JFrame;

public class Main {
public static void main(String[] args) {
		
	   //frame为窗体类型
	 JFrame frame = new JFrame();//创建窗体
	 //创建池塘对象
	 Pool p = new Pool();
	 //往窗体中添加池塘面板
	 frame.add(p);
	 //使用快捷键导包 ctrl+shift+o
	 //当关闭窗体时候，Java运行后台也关掉
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setVisible(true);//设置窗体可见
	 frame.setSize(800,500);//设置大小
	 frame.setTitle("捕鱼达人");//设置标题
	 frame.setLocationRelativeTo(null);//设置窗体居中
	 frame.setResizable(false);//设置窗体大小是否可变
	p.action();
	}

}
