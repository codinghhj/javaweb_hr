package test;

import java.sql.SQLException;

import org.junit.Test;




import com.icss.hr.emp.service.EmpService;

/**
 * ����Ա����ҵ���
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
