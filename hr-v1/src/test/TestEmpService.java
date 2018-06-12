package test;

import java.sql.SQLException;

import org.junit.Test;




import com.icss.hr.emp.service.EmpService;

/**
 * 测试员工的业务层
 * @author Administrator
 *
 */
public class TestEmpService {
	private EmpService service = new EmpService();
	@Test
	public void TestCheckLogin() throws SQLException{
		int result = service.checkLogin("zhangsan", "123456");
		System.out.println(result);
	}
}
