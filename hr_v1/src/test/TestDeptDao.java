package test;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.net.aso.d;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 测试部门dao
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	private DeptDao dao = new DeptDao();
	
	@Test
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept("运行部","北京海淀区");
		dao.insert(dept);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Dept dept = new Dept(10,"技术部","南京");
		dao.update(dept);
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		dao.delete(60);	
	}
	
	@Test
	public void testQueryById() throws SQLException {
		Dept dept = dao.queryById(10);	
		System.out.println(dept);
	}
	
	@Test
	public void testQuery() throws SQLException {
		List<Dept> list = dao.query();	
		for(Dept dept : list) {
			System.out.println(dept);
		}
	}
}
