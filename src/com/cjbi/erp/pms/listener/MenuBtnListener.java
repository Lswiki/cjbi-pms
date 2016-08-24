package com.cjbi.erp.pms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cjbi.erp.pms.view.AboutPage;
import com.cjbi.erp.pms.view.SaveOrUpdatePage;
import com.cjbi.erp.pms.view.module.MenuBtnPanel;


public class MenuBtnListener implements ActionListener {
	
	
	private MenuBtnPanel menuBtnPanel;
	
	public MenuBtnListener(MenuBtnPanel menuBtnPanel) {
		this.menuBtnPanel = menuBtnPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == (menuBtnPanel.getBtn(0))) {
			System.out.println("添加");
			new SaveOrUpdatePage(null);
		} else if (e.getSource() == (menuBtnPanel.getBtn(1))) {
			JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
		} else if (e.getSource() == (menuBtnPanel.getBtn(2))) {
			new com.cjbi.erp.pms.util.JCalculator();
		} else if (e.getSource() == (menuBtnPanel.getBtn(3))) {
			new com.cjbi.erp.pms.util.JNotepad();
		} else if (e.getSource() == (menuBtnPanel.getBtn(4))) {
			JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
		} else if (e.getSource() == (menuBtnPanel.getBtn(5))) {
			new AboutPage();
		} else if (e.getSource() == (menuBtnPanel.getBtn(6))) {
			System.exit(0);
		}
		
	}

}
