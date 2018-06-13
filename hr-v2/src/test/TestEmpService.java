package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;

/**
 * 测试员工的业务层
 * @author Administrator
 *
 */
public class TestEmpService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmpService service = (EmpService) context.getBean(EmpService.class);
	
	@Test
	public void TestInsert() throws SQLException{
		
		Dept dept = new Dept();
		dept.setDeptId(10);
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp("小王1", "xiaowang1", "123456", "177965744@qq.com", "18841692393", Date.valueOf("2018-5-25"), 500.88, dept, job, null, "无");
		service.addEmp(emp);
	}
	
	@Test
	public void TestUpdate() throws SQLException{
		
		Dept dept = new Dept();
		dept.setDeptId(20);
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp(61,"小王1", "xiaowang1", "123456", "28884@qq.com", "1885566622", Date.valueOf("2019-5-25"), 5050.88, dept, job, null, "无wu");
		service.updateEmp(emp);
	}
	
	@Test
	public void TestDelete() throws SQLException{
		service.deleteEmp(41);
	}
	
	@Test
	public void testQueryById() throws SQLException{
		Emp emp = service.queryEmpById(61);
		System.out.println(emp);
	}
	
	@Test
	public void testQueryByPage() throws SQLException{
		Pager pager = new Pager(service.getEmpCount(),5, 2);
		List<Emp> list = service.queryEmpByPage(pager);
		for(Emp emp:list) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void testGetEmpCount() throws SQLException{
		System.out.println(service.getEmpCount());
	}
	
	@Test
	public void testQueryByName() throws SQLException{
		Emp empPwd = service.queryEmpPwd("zhangsan");
		System.out.println(empPwd);
	}
	
	@Test
	public void testQueryEmpPic() throws SQLException{
		String pic = service.queryEmpPic("wangwu");
		System.out.println(pic);
	}
	
	@Test
	public void testUpdateEmpPic() throws SQLException{
		service.updateEmpPic("xiaowang1","");
	}
	
	@Test
	public void testUpdateEmpPwd() throws SQLException{
		service.updateEmpPwd("xiaowang1","126566");
	}
	
	@Test
	public void testCheckLogin() throws SQLException{
		int res = service.checkLogin("zhangsan55", "123456");
		System.out.println(res);
	}
}
