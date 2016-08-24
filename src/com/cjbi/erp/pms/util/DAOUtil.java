package com.cjbi.erp.pms.util;

import com.cjbi.erp.pms.dao.DepartmentDao;
import com.cjbi.erp.pms.dao.EmployeeDao;

public class DAOUtil {
	
	
	public static DepartmentDao deptDao;
	
	public static EmployeeDao empDao;

	public static DepartmentDao getDepartmentDao() {
		if(deptDao == null) {
			deptDao = new DepartmentDao();
		}
		return deptDao;
	}

	public static EmployeeDao getEmployeeDao() {
		if(empDao == null) {
			empDao = new EmployeeDao();
		} 
		return empDao;
	}
	
	
	
}
