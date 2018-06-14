package com.icss.hr.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

/**
 * 数据库连接工具类
 * @author Administrator
 *
 */
public class DbUtil {
	
	//创建本地线程对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	//注册驱动
	static{
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回一个数据库连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		//判断本地线程中是否已经有数据库连接
		Connection conn = threadLocal.get();
		
		//如果没有数据库对象或者数据库对象被关闭
		if(conn == null || conn.isClosed()) {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "myhr";
			String password = "myhr";
			conn = DriverManager.getConnection(url,user,password);
			//设置连接对象到本地线程中
			threadLocal.set(conn);
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 */
	public static void close() {
		//从本地线程取出数据库连接对象
		Connection conn = threadLocal.get();
		
		//如果连接对存在则关闭
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
