package test;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.net.aso.d;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * ���Բ���dao
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	private DeptDao dao = new DeptDao();
	
	@Test
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept("���в�","����������");
		dao.insert(dept);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Dept dept = new Dept(10,"������","�Ͼ�");
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
