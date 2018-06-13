package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.FileCopyUtils;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.service.DeptService;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;




public class TestPic {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private PicService service = (PicService) context.getBean(PicService.class);
	
	
	@Test
	public void TestInsert() throws SQLException, IOException{
		
		File file = new File("e:\\1.png");
		
		byte[] picData = FileCopyUtils.copyToByteArray(file);
		
		Pic pic = new Pic("1.png", file.getName(), file.length(), "zhangsan", picData,new Date());
		service.addPic(pic);
	}
	
	
	
	@Test
	public void TestDelete() throws SQLException{
		service.deletePic(103);
	} 
	
	@Test
	public void TestGetCount() throws SQLException, IOException{
		
		System.out.println(service.getPicCount());
	} 
	
	@Test
	public void TestQueryById() throws SQLException, IOException{
		
		Pic pic = service.queryPicById(101);
		System.out.println(pic);
		
	} 
	
	@Test
	public void TestQuery() throws SQLException{
		Pager pager = new Pager(service.getPicCount(),10, 1);
		List<Pic> list = service.queryPicByPage(pager);
		
		
		for(Pic pic : list) {
			System.out.println(pic);
		}
	} 
}
