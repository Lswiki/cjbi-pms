package com.cjbi.erp.pms.view.module;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.cjbi.erp.pms.listener.SearchListener;

public class SearchPanel extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton refreshButton = null;
	JButton searchButton = null;
	JComboBox searchComboBox = null;
	JTextField seachText = null;
	JLabel lb1 = null;
	JLabel lb2 = null;
	
	public SearchPanel() {
		
		refreshButton = new JButton("刷新");
		searchButton = new JButton("查询");

		lb1 = new JLabel("    条件    ");// 查询
		lb2 = new JLabel("             值    ");
		seachText = new JTextField(10);
		String str[] = { "ID", "NAME", "GENDER","DEPT"};// 下拉列表框
		searchComboBox = new JComboBox(str);
		
		this.add(lb1);
		this.add(searchComboBox);
		this.add(lb2);
		this.add(seachText);
		this.add(refreshButton);
		this.add(searchButton);
		this.getSearchButton().addActionListener(new SearchListener(this));
		this.getRefreshButton().addActionListener(new SearchListener(this));
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}
	

	public JTextField getsSeachText() {
		return seachText;
	}

	public JComboBox getSearchComboBox() {
		return searchComboBox;
	}
	public JButton getRefreshButton() {
		return refreshButton;
	}
}
