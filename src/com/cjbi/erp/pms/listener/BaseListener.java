package com.cjbi.erp.pms.listener;

import com.cjbi.erp.pms.dao.DepartmentDao;
import com.cjbi.erp.pms.dao.EmployeeDao;
import com.cjbi.erp.pms.util.DAOUtil;

public class BaseListener {
	protected EmployeeDao employeeDao = null;
	protected DepartmentDao departmentDao = null;
	{
		employeeDao = DAOUtil.getEmployeeDao();
		departmentDao = DAOUtil.getDepartmentDao();
	}

}
