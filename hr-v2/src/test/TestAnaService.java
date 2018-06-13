package test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.icss.hr.analyze.
dto.DeptEmpCount;
import com.icss.hr.analyze.service.AnaService;
import com.icss.hr.dept.service.DeptService;

public class TestAnaService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private AnaService service = (AnaService) context.getBean(AnaService.class);
	
	@Test
	public void testQueryEmpCount() throws SQLException {
		List<DeptEmpCount> list = service.queryEmpCounts();
		for(DeptEmpCount emc : list) {
			System.out.println(emc);
		}
	}
	@Test
	public void testQueryJobAvgSal() throws SQLException{
		List<Map<String, Object>> list = service.queryJobAvgSal();
		System.out.println(list);
	}
	@Test
	public void testQueryMaxMinSal() throws SQLException{
		List<Map<String, Object>> list = service.queryMaxMinSal();
		System.out.println(list);
	}
}
