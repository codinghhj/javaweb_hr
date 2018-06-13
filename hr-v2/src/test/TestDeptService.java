package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

public class TestDeptService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private DeptService service = (DeptService) context.getBean(DeptService.class);
	
	@Test
	public void testAddDept() {
		
		Dept dept = new Dept("aaa","aaa");
		service.addDept(dept);
		
	}
	@Test
	public void testUpdateDept(){
		Dept dept = new Dept(670, "安全部", "东莞市");
		service.updateDept(dept);
	}
	@Test
	public void testDeleteDept(){
	
		service.deleteDept(670);
	}
	
	@Test
	public void testQueryById(){
	
		System.out.println(service.queryDeptById(320));
	}
	
	@Test
	public void testQuery(){
		List<Dept> list = service.queryDept();
		System.out.println(list);
		
	}
}