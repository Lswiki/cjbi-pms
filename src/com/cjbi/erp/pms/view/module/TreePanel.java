package com.cjbi.erp.pms.view.module;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.cjbi.erp.pms.listener.TreeListener;

public class TreePanel extends JTree {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode("根节点");
	
	private DefaultMutableTreeNode personnelTreeNode = new DefaultMutableTreeNode("人事管理                       ");//人事管理
	private DefaultMutableTreeNode addEmpTreeNode = new DefaultMutableTreeNode("添加员工");
	private DefaultMutableTreeNode wageTreeNode = new DefaultMutableTreeNode("工资管理");
	private DefaultMutableTreeNode deptTreeNode = new DefaultMutableTreeNode("部门管理");
	
	private DefaultMutableTreeNode toolsTreeNode  = new DefaultMutableTreeNode("附加工具                       ");//附加工具
	private DefaultMutableTreeNode calculatorTreeNode = new DefaultMutableTreeNode("计算器");
	private DefaultMutableTreeNode notepadTreeNode = new DefaultMutableTreeNode("记事本");
	private DefaultMutableTreeNode exportExcelTreeNode = new DefaultMutableTreeNode("导出表格");
	
	private DefaultMutableTreeNode sysTreeNode  = new DefaultMutableTreeNode("系统管理                       ");//系统管理
	private DefaultMutableTreeNode aboutTreeNode = new DefaultMutableTreeNode("关于");
	private DefaultMutableTreeNode dataSourceTreeNode = new DefaultMutableTreeNode("数据源");
	private DefaultMutableTreeNode exitTreeNode = new DefaultMutableTreeNode("退出");
	
	public TreePanel() {
		
		// 树结构
		personnelTreeNode.add(addEmpTreeNode); //二级菜单 人事管理
		personnelTreeNode.add(wageTreeNode);
		personnelTreeNode.add(deptTreeNode);
		
		toolsTreeNode.add(calculatorTreeNode); //二级菜单 附加工具
		toolsTreeNode.add(notepadTreeNode);
		toolsTreeNode.add(exportExcelTreeNode);
		
		sysTreeNode.add(aboutTreeNode); //二级菜单 系统管理
		sysTreeNode.add(dataSourceTreeNode);
		sysTreeNode.add(exitTreeNode);
		
		
		rootTreeNode.add(personnelTreeNode); //一级菜单
		rootTreeNode.add(toolsTreeNode);
		rootTreeNode.add(sysTreeNode);
		
		DefaultTreeModel model = new DefaultTreeModel(rootTreeNode);
		
		
		this.setRootVisible(false);
		this.setShowsRootHandles(true);
		this.addMouseListener(new TreeListener(this));
//		this.addTreeSelectionListener(new TreeSelectionListener(this));
		this.setModel(model);
	}

}
