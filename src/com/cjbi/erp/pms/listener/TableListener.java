package com.cjbi.erp.pms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.view.MorePage;
import com.cjbi.erp.pms.view.module.EmpTable;

public class TableListener extends BaseListener implements ActionListener {
	
	private EmpTable tablePanel;	

	public TableListener(EmpTable tablepanel) {
		this.tablePanel = tablepanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer id = Integer.parseInt(tablePanel.getSeletedValueAt(0)); // 获取当前行ID号
		if (tablePanel.getSelectedColumn() == 8) {
			System.out.println("删除");
			System.out.println(id);
			employeeDao.delete(id);
			tablePanel.updateRow();// 更新行操作
		} else if (tablePanel.getSelectedColumn() == 9) {
			System.out.println("更多资料");
			Employee employee = employeeDao.get(id);
			new MorePage(employee);
		}
	}
}
