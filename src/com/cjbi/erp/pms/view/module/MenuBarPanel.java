package com.cjbi.erp.pms.view.module;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.cjbi.erp.pms.listener.MenuBarListener;


public class MenuBarPanel extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu[] menu = new JMenu[2];
	JMenuItem[] menuItem = new JMenuItem[4];
	public MenuBarPanel() {
		System.out.println(">>调用MenuBar");
		menu[0] = new JMenu("员工管理");
		// menu[1] = new JMenu("系统设置");
		// menu[2] = new JMenu("用户管理");
		// menu[3] = new JMenu("数据管理");
		menu[1] = new JMenu("帮助");

		menuItem[0] = new JMenuItem("添加档案");
		menuItem[1] = new JMenuItem("工资管理");
		menuItem[2] = new JMenuItem("退出");
		menuItem[3] = new JMenuItem("关于");
		
		menu[0].add(menuItem[0]);
		menu[0].add(menuItem[1]);
		menu[0].add(menuItem[2]);
		menu[1].add(menuItem[3]);
		
		for (int i = 0; i < menu.length; i++) {// 菜单栏添加
			this.add(menu[i]);
		}

		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i].addActionListener(new MenuBarListener(this));
		}
		
	}
	
	public JMenuItem getMenuItem(int i) {//获取MenuItem
		return menuItem[i];
	}
}
