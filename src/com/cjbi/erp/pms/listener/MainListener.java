package com.cjbi.erp.pms.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainListener extends BaseListener implements WindowListener {
	
	public MainListener() {
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(" 将 Window 设置为活动 Window 时调用。");

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("因对窗口调用 dispose 而将其关闭时调用。");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(" 用户试图从窗口的系统菜单中关闭窗口时调用。");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(" 当 Window 不再是活动 Window 时调用。");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(" 窗口从最小化状态变为正常状态时调用。");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(" 窗口从正常状态变为最小化状态时调用。");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(" 窗口首次变为可见时调用。");
		
	}

}
