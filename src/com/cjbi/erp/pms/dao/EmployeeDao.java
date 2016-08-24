package com.cjbi.erp.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.cjbi.erp.pms.entity.Department;
import com.cjbi.erp.pms.entity.Employee;
import com.cjbi.erp.pms.util.DBHelper;

public class EmployeeDao {

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

	public List<Employee> getAll() {
		System.out.println("getAll");
		String sql = "SELECT * FROM employee";
		List<Employee> list = new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			System.out.println(stmt.toString());
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				Employee emp = new Employee();
				Department dept = new Department(); // 关联的部门对象
				emp.setId(rs.getInt("ID"));
				emp.setName(rs.getString("NAME"));
				emp.setGender(rs.getString("GENDER"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setBirth(rs.getDate("BIRTH"));

				int deptId = rs.getInt("DEPARTMENT");
				dept = new DepartmentDao().get(deptId);

				emp.setDepartment(dept);
				emp.setContact(rs.getString("CONTACT"));
				emp.setCreateTime(rs.getTimestamp("CREATETIME"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete(int id) {
		String sql = "DELETE FROM employee WHERE ID =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanData();
		}
	}

	public void saveOrUpdate(Employee emp) {
		// 如果 id 等于空则新增
		String sql;
		if (emp.getId() != null) {
			sql = "UPDATE employee SET NAME=?, GENDER=?, EMAIL=?, BIRTH=?, DEPARTMENT=?, CONTACT=?, CREATETIME=? WHERE ID=?";
		} else {
			sql = "INSERT INTO employee ( NAME, GENDER, EMAIL, BIRTH, DEPARTMENT, CONTACT, CREATETIME) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getGender());
			pstmt.setString(3, emp.getEmail());
			if (emp.getBirth() != null) {
				pstmt.setDate(4, new java.sql.Date(emp.getBirth().getTime()));
			} else {
				pstmt.setDate(4, null);
			}
			if (emp.getDepartment() != null) {
				pstmt.setInt(5, emp.getDepartment().getId());
			} else {
				pstmt.setDate(5, null);
			}
			pstmt.setString(6, emp.getContact());
			if (emp.getCreateTime() != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				pstmt.setString(7, sdf.format(emp.getCreateTime()));
			} else {
				pstmt.setString(7, null);
			}
			if (emp.getId() != null) {
				pstmt.setInt(8, emp.getId());
			}
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanData();
		}
	}

	public List<Employee> get(String column, String value) {
		value = "%" + value + "%";
		String sql = "SELECT * FROM employee WHERE " + column + " LIKE ?";
		List<Employee> list = new ArrayList<Employee>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				Department dept = new Department(); // 关联的部门对象
				emp.setId(rs.getInt("ID"));
				emp.setName(rs.getString("NAME"));
				emp.setGender(rs.getString("GENDER"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setBirth(rs.getDate("BIRTH"));

				int deptId = rs.getInt("DEPARTMENT");
				dept = new DepartmentDao().get(deptId);

				emp.setDepartment(dept);
				emp.setContact(rs.getString("CONTACT"));
				emp.setCreateTime(rs.getTimestamp("CREATETIME"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public Employee get(int id) {
		String sql = "SELECT * FROM employee WHERE ID=?";
		Employee emp = new Employee();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Department dept = new Department(); // 关联的部门对象
				emp.setId(rs.getInt("ID"));
				emp.setName(rs.getString("NAME"));
				emp.setGender(rs.getString("GENDER"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setBirth(rs.getDate("BIRTH"));

				int deptId = rs.getInt("DEPARTMENT");
				dept = new DepartmentDao().get(deptId);

				emp.setDepartment(dept);
				emp.setContact(rs.getString("CONTACT"));
				emp.setCreateTime(rs.getTimestamp("CREATETIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cleanData();
		}
		return emp;
	}

	/**
	 * 关闭连接，释放资源的方法
	 */
	public void cleanData() {
		// 释放数据集对象
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 释放语句对象
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		List<Employee> list = new EmployeeDao().get("ID", "12");
		for (Employee e : list) {
			System.out.println(e);
		}
	}

}
