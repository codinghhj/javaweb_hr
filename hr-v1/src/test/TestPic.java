package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;


public class TestPic {
	
	private PicDao dao = new PicDao();
	
	@Test
	public void TestInsert() throws SQLException, FileNotFoundException{
		
		File file = new File("e:\\1.png");
		FileInputStream fis = new FileInputStream(file);
		Pic pic = new Pic("1.png", file.getName(), file.length(), "zhangsan", fis);
		dao.insert(pic);
	}
	
	@Test
	public void TestUpdate() throws SQLException{
		
		//Pic pic = new Pic(2,"2.png", "美丽的中软国际", 1000002, "王同学", null, Date.valueOf("2018-01-12"));
		//dao.update(pic);
	} 
	
	@Test
	public void TestDelete() throws SQLException{
		dao.delete(68);
	} 
	
	@Test
	public void TestQueryById() throws SQLException, IOException{
		Pic pic = dao.queryById(64);
		InputStream in = pic.getPicData();
		int i = in.read();
		
	} 
	
	@Test
	public void TestQuery() throws SQLException{
		Pager pager = new Pager(10, 1);
		List<Pic> list = dao.query(pager);
		
		
		for(Pic pic : list) {
			System.out.println(pic);
		}
	} 
}
