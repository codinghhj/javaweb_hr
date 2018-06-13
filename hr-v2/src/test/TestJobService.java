package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.hr.dept.service.DeptService;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

public class TestJobService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private JobService service = (JobService) context.getBean(JobService.class);
	
	@Test
	public void TestAddJob() throws SQLException{
		Job job = new Job("创新部", 1055, 80000);
		service.addJob(job);
	}
	
	@Test
	public void TestUpdateJob() throws SQLException{
		Job job = new Job(61, "创新部", 5000, 8000);
		service.updateJob(job);
	}
	
	@Test
	public void TestDeleteJob() throws SQLException {
		service.deleteJob(61);
	}
	
	@Test
	public void TestQueryJobById() throws SQLException{
		Job job = service.queryJobById(21);
		System.out.println(job);
	}	
	
	@Test
	public void TestQueryJob() throws SQLException {
		List list = service.queryJob();
		System.out.println(list);
	}
}
