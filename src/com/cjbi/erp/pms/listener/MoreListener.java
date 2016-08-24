package com.cjbi.erp.pms.listener;

import java.awt.event.*;

import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.view.MorePage;
import com.cjbi.erp.pms.view.SaveOrUpdatePage;
import com.cjbi.erp.pms.view.module.EmpTable;

public class MoreListener extends BaseListener implements ActionListener ,WindowListener{
	private MorePage morePage;
	private Employee employee;

	public MoreListener(MorePage morePage,Employee employee) {
		this.morePage = morePage;
		this.employee =employee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("监听");
		if (e.getSource() == morePage.getBtn_modify()) {
//			Integer id = Integer.parseInt(tablePanel.getSelectedValueAt(0));// 获取ID
//			Employee employee = employeeService.get(id);
			new SaveOrUpdatePage(employee);
			
//			saveOrUpdatePage.getTextField(0).setText(employee.getName());
//			saveOrUpdatePage.getComboBoxGender().setSelectedItem(employee.getGender());
//			saveOrUpdatePage.getTextField(2).setText(String.valueOf(employee.getBirth()));
//			saveOrUpdatePage.getTextField(3).setText(employee.getEmail());
//			saveOrUpdatePage.getTextField(4).setText(employee.getContact());

			// saveOrUpdatePage.getTextField(5).setText("dept");
			morePage.dispose();// 关闭操作
		}
		if (e.getSource() == morePage.getBtn_del()) {
			System.out.println("删除");
			employeeDao.delete(employee.getId());// 获取表格ID
			EmpTable.updateRow();// 更新行操作
			morePage.dispose();// 关闭操作
		}

		if (e.getSource() == morePage.getBtn_cancel()) {
			morePage.dispose();
		}
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" 将 Window 设置为活动 Window 时调用。");

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("因对窗口调用 dispose 而将其关闭时调用。");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" 用户试图从窗口的系统菜单中关闭窗口时调用。");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" 当 Window 不再是活动 Window 时调用。");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" 窗口从最小化状态变为正常状态时调用。");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" 窗口从正常状态变为最小化状态时调用。");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" 窗口首次变为可见时调用。");
		
	}
}
