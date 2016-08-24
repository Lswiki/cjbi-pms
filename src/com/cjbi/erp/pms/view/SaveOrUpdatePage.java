package com.cjbi.erp.pms.view;

import java.awt.*;
import javax.swing.*;
import com.cjbi.erp.pms.dao.DepartmentDao;
import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.listener.SaveOrUpdateListener;
import com.cjbi.erp.pms.util.DAOUtil;
import com.cjbi.erp.pms.view.module.DeptComboBox;


public class SaveOrUpdatePage extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pn = new JPanel(new BorderLayout()), pn_1 = new JPanel(new GridLayout(3, 3, 5, 5)), pn_2 = new JPanel();
	JLabel[] lb = new JLabel[8];
	JTextField[] textField = new JTextField[6];
	
	final static String[] gender = { "男", "女" };
	final static String[] str = { "  姓名：", "  性别：", "  出生日期(yyyy-MM-dd)：", "  邮箱：", "  地址/联系：", "  部门：" };
	
	JComboBox<?> comboBoxGender = new JComboBox<>(gender);
	DeptComboBox comboBoxDept = new DeptComboBox();

	JButton btn_add = new JButton("保存");
	JButton btn_cancel = new JButton("关闭");
	
	private static DepartmentDao departmentDao = null;

	{
		departmentDao = DAOUtil.getDepartmentDao();
	}
	
	
	public JButton getBtn_add() {
		return btn_add;
	}

	private Employee employee;

	public SaveOrUpdatePage(Employee employee) {
		this.employee = employee;

		for (int i = 0; i < str.length; i++) {
			lb[i] = new JLabel(str[i]);
			textField[i] = new JTextField();
			pn_1.add(lb[i]);
		}

		pn_1.add(lb[0]);
		pn_1.add(textField[0]);// 姓名

		pn_1.add(lb[1]);
		pn_1.add(comboBoxGender);// 性别

		pn_1.add(lb[2]);
		pn_1.add(textField[2]);// 出生日期

		pn_1.add(lb[3]);
		pn_1.add(textField[3]);// 邮箱

		pn_1.add(lb[4]);
		pn_1.add(textField[4]);// 地址/联系

		pn_1.add(lb[5]);
		 
		 
		pn_1.add(comboBoxDept);

		pn_2.add(btn_add);
		pn_2.add(btn_cancel);

		pn.setBorder(BorderFactory.createTitledBorder("人事信息"));
		pn.add(pn_1, BorderLayout.CENTER);
		pn.add(pn_2, BorderLayout.SOUTH);

		btn_add.addActionListener(new SaveOrUpdateListener(this, employee));
		btn_cancel.addActionListener(new SaveOrUpdateListener(this, employee));

		if (employee != null)
			update();

		this.add(pn);
		this.setTitle("添加/修改档案");
		// this.setSize(420, 230);
		this.pack();
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new SaveOrUpdateListener(this, employee)); // /flag
	}

	public void update() {
		textField[0].setText(employee.getName());
		comboBoxGender.setSelectedItem(employee.getGender());
		comboBoxDept.getModel().setSelectedItem(employee.getDepartment());
		textField[2].setText(String.valueOf(employee.getBirth()));
		textField[3].setText(employee.getEmail());
		textField[4].setText(employee.getContact());
	}

	public JButton getBtnAdd() {
		return btn_add;
	}

	public JButton getBtnCancel() {
		return btn_cancel;
	}

	public JTextField getTextField(int i) {
		return textField[i];
	}

	public JComboBox getComboBoxGender() {
		return comboBoxGender;
	}

	public DeptComboBox getComboBoxDept() {
		return comboBoxDept;
	}
}
