import java.util.Date;

import org.junit.Test;

import com.cjbi.erp.pms.dao.EmployeeDao;
import com.cjbi.erp.pms.entity.Department;
import com.cjbi.erp.pms.entity.Employee;

public class EmployeeDaoTest {

	EmployeeDao dao = new EmployeeDao();

	@Test
	public void testSave() {
		Employee emp = new Employee();
		emp.setName("AA");
		emp.setGender("CC");
		emp.setEmail("BB");
		emp.setBirth(new Date());
		Department dept = new Department();
		dept.setId(5);
		emp.setDepartment(dept);
		emp.setContact("DD");
		emp.setCreateTime(new Date());
		dao.saveOrUpdate(emp);
	}
	
	@Test
	public void testUpdate() {
		Employee emp = new Employee();
		emp.setId(462);
		emp.setName("AA");
//		emp.setGender("CC");
		emp.setEmail("BB");
		emp.setBirth(new Date());
		Department dept = new Department();
		dept.setId(5);
		emp.setDepartment(dept);
		emp.setContact("DD");
		emp.setCreateTime(new Date());
		dao.saveOrUpdate(emp);
	}
	
	@Test
	public void testGetById() {
		System.out.println(dao.get(462));
	}

}
