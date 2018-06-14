package test;

import java.util.List;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;
import com.sun.crypto.provider.RSACipher;

public class TestEmpDao {
	private EmpDao dao = new EmpDao();
	@Test
	public void testInsert() throws SQLException{
		Dept dept = new Dept();
		dept.setDeptId(10);
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp("小黄", "xiaohuang", "123456", "1749574663@qq.com", "18841692393", Date.valueOf("2016-08-25"), 10000.0, dept, job, null, "这是一个图");
		dao.insert(emp);
		System.out.println("成功");
	}
	
	@Test
	public void testUpdate() throws SQLException{
		Dept dept = new Dept();
		dept.setDeptId(10);
		Job job = new Job();
		job.setJobId(1);
		Emp emp = new Emp(1,"王五", "wangwu", "123456", "1749574663@qq.com", "18841692393", Date.valueOf("2016-08-25"), 10000.0, dept, job, null, "这是一个图");
		dao.update(emp);
		System.out.println("成功");
	}
	
	@Test
	public void testDelete() throws SQLException{
	
		dao.delete(3);
	}
	
	@Test
	public void testQueryById() throws SQLException{
	
		Emp emp = dao.queryById(1);
		System.out.println(emp);
	}
	
	@Test
	public void testQuery() throws SQLException{
	
		List<Emp> list = dao.query();
		for(Emp emp:list) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void testQuery1() throws SQLException{
		
		List<Emp> list = dao.query(10,15);
		for(Emp emp:list) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void testQueryByPage() throws SQLException{
		Pager pager = new Pager(dao.getCount(),10,2);
		List<Emp> list = dao.queryByPage(pager);
		for(Emp emp : list) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void testQueryByName() throws SQLException{
	
		Emp emp = dao.queryByName("xiaozhang");
		System.out.println(emp.getEmpPwd());
	}
	


	@Test
	public void tesUpdateEmpPic() throws SQLException{
	
		dao.updateEmpPic("xiaohuang","16365");
	
	}
	

	@Test
	public void tesUpdateEmpPwd() throws SQLException{
	
		dao.updateEmpPwd("xiaohuang","16365");
	
	}
}
