package com.cjbi.erp.pms.view.module;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.cjbi.erp.pms.dao.EmployeeDao;
import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.util.DAOUtil;

public class EmpTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static DefaultTableModel tableModel;
	final static String[]  tableHeads = { "编号", "姓名", "性别", "出生日期", "邮箱", "联系/地址", "部门", "创建时间", "删除", "更多" };

	private static EmployeeDao employeeDao = null;

	{
		employeeDao = DAOUtil.getEmployeeDao();
	}

	public EmpTable() {
		tableModel = (DefaultTableModel) this.getModel();
		tableModel.setColumnIdentifiers(tableHeads);
		this.getColumn("更多").setCellRenderer(new ButtonRenderer());
		this.getColumn("更多").setCellEditor(new ButtonEditor(new JCheckBox()));
		this.getColumn("更多").setMaxWidth(30);
		this.getColumn("更多").setMinWidth(30);
		this.getColumn("删除").setCellRenderer(new ButtonRenderer());
		this.getColumn("删除").setCellEditor(new ButtonEditor(new JCheckBox()));
		this.getColumn("删除").setMaxWidth(48);
		this.getColumn("删除").setMinWidth(48);
		setAutoscrolls(true);
		updateRow();
	}

	public String getSeletedValueAt(Integer column) {
		return (String) this.tableModel.getValueAt(this.getSelectedRow(), column);
	}

	public static void updateRow() {
		// tableModel.setRowCount(0);//设置行为0
		tableModel.getDataVector().clear();// 清空表格数据
		String[] str = new String[10];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Employee> employees = employeeDao.getAll();
		for (Employee employee : employees) {
			System.out.println(employee);
			str[0] = String.valueOf(employee.getId());
			str[1] = employee.getName();
			str[2] = employee.getGender();
			str[3] = String.valueOf(employee.getBirth());
			str[4] = employee.getEmail();
			str[5] = employee.getContact();
			if (employee.getDepartment() != null) {
				str[6] = employee.getDepartment().getDepartmentName();
			}
			str[7] = sdf.format(employee.getCreateTime());
			str[8] = "删";
			str[9] = "…";
			// 添加数据到表格
			tableModel.addRow(str);
		}
		tableModel.fireTableDataChanged();// 通知侦听器表的结构可能更改，刷新表格。
	}

	public static void updateRow(String column, String value) {

		// tableModel.setRowCount(0);
		tableModel.getDataVector().clear();// 清空表格数据
		String[] str = new String[10];
		List<Employee> employees = employeeDao.get(column, value);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (Employee employee : employees) {
			System.out.println(employee);
			str[0] = String.valueOf(employee.getId());
			str[1] = employee.getName();
			str[2] = employee.getGender();
			str[3] = String.valueOf(employee.getBirth());
			str[4] = employee.getEmail();
			str[5] = employee.getContact();
			if (employee.getDepartment() != null)
				str[6] = employee.getDepartment().getDepartmentName();
			str[7] = sdf.format(employee.getCreateTime()); //创建时间
			str[8] = "删";
			str[9] = "…";
			// 添加数据到表格
			tableModel.addRow(str);
		}
		tableModel.fireTableDataChanged();// 通知侦听器表的结构可能更改，刷新表格。
	}
	
	JButton btn_add = new JButton("保存");
	JTextField[] tf_ps = new JTextField[6];
	JPanel jpn_add = new JPanel();

	public class ButtonRenderer extends JButton implements TableCellRenderer {
		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			setText((value == null) ? "" : value.toString());
			return this;
		}

	}

	public class ButtonEditor extends DefaultCellEditor {
		protected JButton button;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new com.cjbi.erp.pms.listener.TableListener(EmpTable.this));
		
		}

		@Override
		public Component getTableCellEditorComponent(JTable table1, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				button.setForeground(getSelectionForeground());
				button.setBackground(getSelectionBackground());
			} else {
				button.setForeground(getForeground());
				button.setBackground(getBackground());
			}
			button.setText(table1.getValueAt(row, column).toString());

			return button;

		}

		// 若缺少此方法，点击按钮后将获取不到Button的Text值，将会显示false.
		@Override
		public Object getCellEditorValue() {
			return button.getText();
		}
	}

}
