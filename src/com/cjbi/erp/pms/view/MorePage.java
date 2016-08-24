package com.cjbi.erp.pms.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.listener.MoreListener;

public class MorePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel pn = new JPanel(new BorderLayout()), contentPanel = new JPanel(new GridLayout(4, 4, 5, 5)),
			pn_2 = new JPanel();

	JButton btn_del = new JButton("删除");
	JButton btn_print = new JButton("打印");
	JButton btn_cancel = new JButton("关闭");
	JLabel[] label = new JLabel[8], label2 = new JLabel[8];

	final static String[] str = { "  编号：", "  姓名：", "  性别：", "  出生日期：", "  邮箱：", "  地址/联系：", "  创建时间：" };
	
	public MorePage(Employee employee) {

		String[] employeeToString = new String[str.length];
		
		System.out.println(employee);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		employeeToString[0] = employee.getId().toString();
		employeeToString[1] = employee.getName();
		employeeToString[2] = employee.getGender();
		employeeToString[3] = String.valueOf(employee.getBirth());
		employeeToString[4] = employee.getEmail();
		employeeToString[5] = employee.getContact();
		employeeToString[6] = sdf.format(employee.getCreateTime());

		for (int i = 0; i < str.length; i++) {
			label[i] = new JLabel(str[i]); // 新标签
			label2[i] = new JLabel(employeeToString[i]);// Label数据
			contentPanel.add(label[i]);
			contentPanel.add(label2[i]);
		}

		pn_2.add(btn_modify);
		pn_2.add(btn_del);
		pn_2.add(btn_print);
		pn_2.add(btn_cancel);

		btn_modify.addActionListener(new MoreListener(this, employee));
		btn_del.addActionListener(new MoreListener(this, employee));
		btn_print.addActionListener(new MoreListener(this, employee));
		btn_cancel.addActionListener(new MoreListener(this, employee));

		pn.setBorder(BorderFactory.createTitledBorder("详细信息"));
		pn.add(contentPanel, BorderLayout.CENTER);
		pn.add(pn_2, BorderLayout.SOUTH);
		this.setTitle(employee.getName() + "的个人资料");
		this.add(pn);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setFocusableWindowState(true);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new MoreListener(this, employee)); // /flag
	}

	public JButton getBtn_del() {
		return btn_del;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public JLabel[] getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel[] label2) {
		this.label2 = label2;
	}

	public JLabel[] getLabel() {
		return label;
	}

	public void setLabel(JLabel[] label) {
		this.label = label;
	}

	JButton btn_modify = new JButton("修改");

	public JButton getBtn_modify() {
		return btn_modify;
	}
}
