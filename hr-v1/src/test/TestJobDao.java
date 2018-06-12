package test;

import java.util.List;
import java.sql.SQLException;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 测试职务dao
 * @author Administrator
 *
 */
public class TestJobDao {
	private JobDao dao = new JobDao();
	@Test
	public void TestInsert() throws SQLException{
		Job job = new Job("前台", 2000, 8000);
		dao.insert(job);
	}
	@Test
	public void TestUpdate() throws SQLException{
		Job job = new Job(3,"程序员", 8000, 80000);
		dao.update(job);
	}
	@Test
	public void Testdelete() throws SQLException{
		
		dao.delete(5);
	}
	
	@Test
	public void TestQueryById() throws SQLException{
		
		Job job = dao.queryById(1);
		System.out.println(job.toString());
	}
	
	@Test
	public void TestQuery() throws SQLException{
		
		List<Job> list = dao.query();
		for(Job job : list) {
			System.out.println(job);
		}
	}
}
