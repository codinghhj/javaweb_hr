package com.icss.hr.pic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.icss.hr.common.DbUtil;
import com.icss.hr.common.Pager;
import com.icss.hr.pic.pojo.Pic;

/**
 * 图片库的dao类
 * @author Administrator
 *
 */
public class PicDao {
	/**
	 * 增加数据
	 * @param pic
	 * @throws SQLException
	 */
	public void insert(Pic pic) throws SQLException{

		Connection conn = DbUtil.getConnection();
		String sql = "insert into pic values (pic_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pic.getPicName());
		pstmt.setString(2, pic.getPicInfo());
		pstmt.setLong(3, pic.getPicSize());
		pstmt.setString(4, pic.getPicAuthor());
		pstmt.setBinaryStream(5, pic.getPicData());
		
		Timestamp  timestamp = new Timestamp(new Date().getTime());
		pstmt.setTimestamp(6, timestamp);
		
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	public void update(Pic pic) throws SQLException{

		Connection conn = DbUtil.getConnection();
		String sql = "update pic set pic_name = ?,pic_info = ?,pic_size = ?,pic_author = ?,pic_data = ?,pic_datetime = ? where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pic.getPicName());
		pstmt.setString(2, pic.getPicInfo());
		pstmt.setLong(3, pic.getPicSize());
		pstmt.setString(4, pic.getPicAuthor());
		pstmt.setBlob(5, pic.getPicData());
		pstmt.setTimestamp(6, pic.getPicDateTime());
		pstmt.setInt(7, pic.getPicId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	/**
	 * 删除数据
	 * @param picId
	 * @throws SQLException 
	 */
	public void delete(Integer picId) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		String sql = "delete from pic where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, picId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	/**
	 * 根据picId返图片数据
	 * @throws SQLException 
	 */
	public Pic queryById(Integer picId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select * from pic where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, picId);
		ResultSet rs = pstmt.executeQuery();
		Pic pic = null;
		if(rs.next()) {
			pic = new Pic();
			pic.setPicName(rs.getString(2));
			pic.setPicData(rs.getBinaryStream(6));
		}
		rs.close();
		pstmt.close();
		return pic;
	}
	/**
	 * 分页查询图库数据
	 * @return
	 * @throws SQLException 
	 */
	public List<Pic> query(Pager pager) throws SQLException{
		ArrayList<Pic> list = new ArrayList<Pic>();
		Connection conn = DbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append(" FROM (SELECT rownum rnum,p.* ");
		sql.append(" FROM (SELECT * FROM   pic ORDER  BY pic_datetime DESC) p) ");
		sql.append(" WHERE  rnum between ? and ?");
	
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1,pager.getStart());
		pstmt.setInt(2,pager.getEnd());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			list.add(new Pic(rs.getInt(2),rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6), null, rs.getTimestamp(8)));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	/**
	 * 获得总记录数
	 * @throws SQLException 
	 */
	public int getCount() throws SQLException {
		
		Connection conn = DbUtil.getConnection();

		String sql = "select count(*) from pic";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		rs.next();

		int count = rs.getInt(1);

		rs.close();
		pstmt.close();
		conn.close();

		return count;		
	}	
	
}
