package com.cjbi.erp.pms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cjbi.erp.pms.view.module.SearchPanel;
import com.cjbi.erp.pms.view.module.EmpTable;

public class SearchListener extends BaseListener implements ActionListener {

	private SearchPanel searchPanel;

	public SearchListener(SearchPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == (searchPanel.getSearchButton())) {//查询事件

			System.out.println("查询");
			if ("".equals((searchPanel.getsSeachText().getText()))) {
				EmpTable.updateRow();
				System.out.println("未输入任何内容！");
			} else {
				String column = searchPanel.getSearchComboBox().getSelectedItem().toString();
				String value = searchPanel.getsSeachText().getText();
				System.out.println(column+"<>" + value);
				EmpTable.updateRow(column, value);
			}
		}
		if (e.getSource() == (searchPanel.getRefreshButton())) {//查询事件
			System.out.println("刷新");
			EmpTable.updateRow();
			
		}
	}

}
