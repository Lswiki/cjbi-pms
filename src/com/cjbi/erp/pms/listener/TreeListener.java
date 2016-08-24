package com.cjbi.erp.pms.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import com.cjbi.erp.pms.util.JNotepad;
import com.cjbi.erp.pms.view.AboutPage;
import com.cjbi.erp.pms.view.SaveOrUpdatePage;

public class TreeListener implements MouseListener {

	private JTree tree;

	public TreeListener(JTree tree) {
		this.tree = tree;
	};

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		int selRow = tree.getRowForLocation(e.getX(), e.getY());
		TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
		if (selRow != -1) {
			// 双击事件
			if (e.getClickCount() == 2) {
				DefaultMutableTreeNode note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				String noteName = note.toString();// 获得这个结点的名称
				// System.out.println(name);
				if ("添加员工".equals(noteName)) {
					System.out.println("添加员工");
					new SaveOrUpdatePage(null);
				} else if ("工资管理".equals(noteName)) {
					JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
				} else if ("部门管理".equals(noteName)) {
					JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
				} else if ("计算器".equals(noteName)) {
				} else if ("记事本".equals(noteName)) {
					new JNotepad();
				} else if ("导出表格".equals(noteName)) {
					JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
				} else if ("关于".equals(noteName)) {
					new AboutPage();
				} else if ("数据源".equals(noteName)) {
					JOptionPane.showMessageDialog(null, "           功能实现中...", "功能实现中...", JOptionPane.PLAIN_MESSAGE);
				} else if ("退出".equals(noteName)) {
					System.exit(0);
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
