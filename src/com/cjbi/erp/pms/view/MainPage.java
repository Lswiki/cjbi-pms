package com.cjbi.erp.pms.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.cjbi.erp.pms.listener.MainListener;
import com.cjbi.erp.pms.view.module.MenuBarPanel;
import com.cjbi.erp.pms.view.module.MenuBtnPanel;
import com.cjbi.erp.pms.view.module.SearchPanel;
import com.cjbi.erp.pms.view.module.EmpTable;
import com.cjbi.erp.pms.view.module.TreePanel;

public class MainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TreePanel treePanel = new TreePanel();
	EmpTable tablePanel = new EmpTable();
	
	SearchPanel searchpanel = new SearchPanel();
	
	JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(treePanel), new JScrollPane(tablePanel));// 拆分
	
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel(new BorderLayout());
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	

	public MainPage() {
		panel2.add(sp, BorderLayout.CENTER);
		panel1.add(searchpanel, BorderLayout.NORTH);
		panel1.add(panel2, BorderLayout.CENTER);// 添加

		this.setJMenuBar(new MenuBarPanel());//菜单栏
		this.add(new MenuBtnPanel(), BorderLayout.NORTH);
		
		sp.setOneTouchExpandable(true);// 拆分三角允许
		this.add(panel1, BorderLayout.CENTER);
		this.setTitle("人事管理系统（数据库）");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new MainListener()); // /flag
	}

}
