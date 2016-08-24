package com.cjbi.erp.pms.view.module;

import java.awt.Component;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.cjbi.erp.pms.dao.DepartmentDao;
import com.cjbi.erp.pms.entity.Department;
import com.cjbi.erp.pms.util.DAOUtil;

public class DeptComboBox extends JComboBox {

	private static DepartmentDao departmentDao = null;

	{
		departmentDao = DAOUtil.getDepartmentDao();
	}

	public DeptComboBox() {
		Vector<Department> model = new Vector<>();
		java.util.List<Department> dept = departmentDao.getAll();
		for (Department obj : dept) {
			// 将指定的组件添加到此向量的末尾
			model.addElement(obj);
		}
	    this.setModel(new DefaultComboBoxModel<Department>(model));
		this.setRenderer(new DeptRenderer());
	}
	public static void main(String[] args) {
		Vector<Department> model = new Vector<>();
		JFrame frame = new JFrame("测试");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(220, 100);
//	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    JComboBox comboBox =  new DeptComboBox();
	    java.util.List<Department> dept = departmentDao.getAll();
		for (Department obj : dept) {
			// 将指定的组件添加到此向量的末尾
			model.addElement(obj);
		}
	    frame.add(comboBox);
	    System.out.println(model);
	    Department dep = model.get(2);
	    comboBox.getModel().setSelectedItem(dep);
	    frame.setVisible(true);
	}

}

// 重写ComboBox 渲染器
class DeptRenderer extends BasicComboBoxRenderer {
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if (value != null) {
			Department dept = (Department) value;
			this.setText(dept.getDepartmentName());
		}

		// if (index == 2) {
		// Item item = (Item) value;
		// setText("" + item.getId());
		// }

		return this;
	}
}