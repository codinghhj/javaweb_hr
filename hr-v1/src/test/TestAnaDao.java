package test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.icss.hr.analyze.dao.AnaDao;
import com.icss.hr.analyze.
dto.DeptEmpCount;
import com.sun.javafx.collections.MappingChange.Map;

public class TestAnaDao {
	
	private AnaDao dao = new AnaDao();
	
	@Test
	public void testQueryEmpCount() throws SQLException {
		List<DeptEmpCount> list = dao.queryEmpcount();
		for(DeptEmpCount emc : list) {
			System.out.println(emc);
		}
	}
	@Test
	public void testQueryJobAvgSal() throws SQLException{
		List<HashMap<String, Object>> list = dao.queryJobAvgSal();
		System.out.println(list);
	}
}
