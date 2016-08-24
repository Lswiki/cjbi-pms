package com.cjbi.erp.pms.view.module;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.cjbi.erp.pms.listener.MenuBtnListener;

public class MenuBtnPanel extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton[] btn = new JButton[7];

	public MenuBtnPanel() {
		System.out.println(">>调用MenuButton");
		btn[0] = new JButton(" 添加档案 ", new ImageIcon(this.getClass().getResource("/icon/btn0.png")));
		btn[1] = new JButton(" 工资管理 ", new ImageIcon(this.getClass().getResource("/icon/btn1.png")));
		btn[2] = new JButton(" 计 算 器 ", new ImageIcon(this.getClass().getResource("/icon/btn2.png")));
		btn[3] = new JButton(" 记 事 本 ", new ImageIcon(this.getClass().getResource("/icon/btn3.png")));
		btn[4] = new JButton("导出 EXCEL", new ImageIcon(this.getClass().getResource("/icon/btn4.png")));
		btn[5] = new JButton("  关  于  ", new ImageIcon(this.getClass().getResource("/icon/btn5.png")));
		btn[6] = new JButton("  退  出  ", new ImageIcon(this.getClass().getResource("/icon/btn6.png")));
		for (int i = 0; i < 7; i++) {
			btn[i].addActionListener(new MenuBtnListener(this));
			btn[i].setVerticalTextPosition(JButton.BOTTOM);
			btn[i].setHorizontalTextPosition(JButton.CENTER);
			btn[i].setFont(new Font("宋体", Font.BOLD, 10));// 工具栏按钮字体
		}
		
		for (int i = 0; i < btn.length; i++) {// 工具栏添加
			this.add(btn[i]);
		}
	}
	
	public JButton getBtn(int i) {//获取JButton
		return btn[i];
	}
}
