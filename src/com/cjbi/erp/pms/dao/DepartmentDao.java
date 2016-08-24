package com.cjbi.erp.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cjbi.erp.pms.entity.Department;
import com.cjbi.erp.pms.util.DBHelper;

public class DepartmentDao {
	
	private static Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	static {
		try {
			conn = DBHelper.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Department get(int id) {
		String sql = "SELECT * FROM department WHERE ID=?";
		Department dept = new Department();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dept.setId(rs.getInt("ID"));
				dept.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanData();
		}
		return dept;
	}
	
	public List<Department> getAll() {
		String sql = "SELECT * FROM department";
		List<Department> list = new ArrayList<Department>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Department dept = new Department();
				dept.setId(rs.getInt("ID"));
				dept.setDepartmentName(rs.getString("DEPARTMENTNAME"));
				list.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanData();
		}
		return list;
	}
	
	/**
	 * 关闭连接，释放资源的方法
	 */
	public void cleanData() {
		//释放数据集对象
		if(rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 释放语句对象
		if(stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)  {
		List<Department> list = new DepartmentDao().getAll();
		for(Department d : list) {
			System.out.println(d);
		}
//		Department dept = new DepartmentDao().getById(5);
//		System.out.println(dept);
	}
	
}
