package com.icss.hr.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

/**
 * ���ݿ����ӹ�����
 * @author Administrator
 *
 */
public class DbUtil {
	
	//���������̶߳���
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	//ע������
	static{
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ����һ�����ݿ����Ӷ���
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		//�жϱ����߳����Ƿ��Ѿ������ݿ�����
		Connection conn = threadLocal.get();
		
		//���û�����ݿ����������ݿ���󱻹ر�
		if(conn == null || conn.isClosed()) {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "myhr";
			String password = "myhr";
			conn = DriverManager.getConnection(url,user,password);
			//�������Ӷ��󵽱����߳���
			threadLocal.set(conn);
		}
		return conn;
	}
	
	/**
	 * �ر�����
	 */
	public static void close() {
		//�ӱ����߳�ȡ�����ݿ����Ӷ���
		Connection conn = threadLocal.get();
		
		//������ӶԴ�����ر�
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
				threadLocal.remove();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
