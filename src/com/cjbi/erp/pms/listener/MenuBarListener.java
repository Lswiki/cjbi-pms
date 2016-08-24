package com.cjbi.erp.pms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cjbi.erp.pms.view.AboutPage;
import com.cjbi.erp.pms.view.SaveOrUpdatePage;
import com.cjbi.erp.pms.view.module.MenuBarPanel;

public class MenuBarListener implements ActionListener {
	
	private MenuBarPanel menuBarPanel;
	public MenuBarListener(MenuBarPanel menuBarPanel) {
		this.menuBarPanel = menuBarPanel;
	}
	

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == menuBarPanel.getMenuItem(0)) {
			new SaveOrUpdatePage(null);
		} else if (e.getSource() == menuBarPanel.getMenuItem(1)) {
			JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
		} else if (e.getSource() == menuBarPanel.getMenuItem(2)) {
			System.exit(0);
		} else if (e.getSource() == menuBarPanel.getMenuItem(3)) {
			new AboutPage();
		}
	}


}
