package com.cjbi.erp.pms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cjbi.erp.pms.entity.Department;
import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.view.SaveOrUpdatePage;
import com.cjbi.erp.pms.view.module.EmpTable;

public class SaveOrUpdateListener extends BaseListener implements ActionListener, WindowListener {
	private SaveOrUpdatePage saveOrUpdatePage;
	private Employee employee = null;

	public SaveOrUpdateListener(SaveOrUpdatePage saveOrUpdatePage, Employee employee) {
		this.saveOrUpdatePage = saveOrUpdatePage;
		this.employee = employee;
	}

	public SaveOrUpdateListener(SaveOrUpdatePage saveOrUpdatePage) {
		this.saveOrUpdatePage = saveOrUpdatePage;

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == saveOrUpdatePage.getBtnAdd()) {
			System.out.println("添加");
			if (employee == null)
				employee = new Employee();

			Integer id = employee.getId();// 获得ID

			employee.setName(saveOrUpdatePage.getTextField(0).getText());// 姓名
			employee.setGender(saveOrUpdatePage.getComboBoxGender().getSelectedItem().toString());// 性别
			
			//获得下拉列表框选中的项
			Department sctItem = (Department) saveOrUpdatePage.getComboBoxDept().getModel().getSelectedItem();
			
			employee.setDepartment(sctItem);
			try {
				employee.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(saveOrUpdatePage.getTextField(2).getText()));
			} catch (ParseException e1) {
				System.out.println("请输入正确的日期！");
			} // 日期

			employee.setEmail(saveOrUpdatePage.getTextField(3).getText());// 邮箱
			employee.setContact(saveOrUpdatePage.getTextField(4).getText());// 联系方式
			employee.setCreateTime(new Date());
			
			employeeDao.saveOrUpdate(employee);

			if (id == null) {
				employee = null;
				for (int i = 0; i < 5; i++) {// 清空表格
					saveOrUpdatePage.getTextField(i).setText("");
				}
			} else {
				saveOrUpdatePage.dispose();
			}

			EmpTable.updateRow();// 更新表格

		} else if (e.getSource() == saveOrUpdatePage.getBtnCancel()) {
			saveOrUpdatePage.dispose();
		}
	}

	public Employee getTextFieldText() {

		return employee;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
