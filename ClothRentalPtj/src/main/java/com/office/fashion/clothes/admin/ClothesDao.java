package com.office.fashion.clothes.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.office.fashion.clothes.*;

@Component
public class ClothesDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean isISBN(String b_isbn) {
		System.out.println("[BookDao] isISBN()");
		
		String sql =  "SELECT COUNT(*) FROM tbl_book "
					+ "WHERE b_isbn = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, b_isbn);
		
		return result > 0 ? true : false;
		
	}
	
	public int insertBook(ClothesVo clothesVo) {
		System.out.println("[BookDao] insertBook()");
		
		String sql = "INSERT INTO tbl_book(b_thumbnail, "
										+ "b_name, "
										+ "b_author, "
										+ "b_publisher, "
										+ "b_publish_year, "
										+ "b_isbn, "
										+ "b_call_number, "
										+ "b_rantal_able, "
										+ "b_reg_date, "
										+ "b_mod_date) "
										+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql,
											clothesVo.getB_thumbnail(), 
											clothesVo.getB_name(),
											clothesVo.getB_author(),
											clothesVo.getB_publisher(),
											clothesVo.getB_publish_year(),
											clothesVo.getB_isbn(),
											clothesVo.getB_call_number(),
											clothesVo.getB_rantal_able()
											);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public List<ClothesVo> selectBooksBySearch(ClothesVo clothesVo) {
		System.out.println("[BookDao] selectBooks()");
		
		String sql =  "SELECT * FROM tbl_book "
					+ "WHERE b_name LIKE ? "
					+ "ORDER BY b_no DESC";
		
		List<ClothesVo> clothesVos = null;
		
		try {
			
			clothesVos = jdbcTemplate.query(sql, new RowMapper<ClothesVo>() {

				@Override
				public ClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ClothesVo clothesVo = new ClothesVo();
					
					clothesVo.setB_no(rs.getInt("b_no"));
					clothesVo.setB_thumbnail(rs.getString("b_thumbnail"));
					clothesVo.setB_name(rs.getString("b_name"));
					clothesVo.setB_author(rs.getString("b_author"));
					clothesVo.setB_publisher(rs.getString("b_publisher"));
					clothesVo.setB_publish_year(rs.getString("b_publish_year"));
					clothesVo.setB_isbn(rs.getString("b_isbn"));
					clothesVo.setB_call_number(rs.getString("b_call_number"));
					clothesVo.setB_rantal_able(rs.getInt("b_rantal_able"));
					clothesVo.setB_reg_date(rs.getString("b_reg_date"));
					clothesVo.setB_mod_date(rs.getString("b_mod_date"));
					
					return clothesVo;
					
				}
				
			}, "%" + clothesVo.getB_name() + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return clothesVos.size() > 0 ? clothesVos : null;
		
	}
	
	public ClothesVo selectBook(int b_no) {
		System.out.println("[BookDao] selectBook()");
		
		String sql = "SELECT * FROM tbl_book WHERE b_no = ?";
		
		List<ClothesVo> clothesVos = null;
		
		try {
			
			clothesVos = jdbcTemplate.query(sql, new RowMapper<ClothesVo>() {

				@Override
				public ClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ClothesVo clothesVo = new ClothesVo();
					
					clothesVo.setB_no(rs.getInt("b_no"));
					clothesVo.setB_thumbnail(rs.getString("b_thumbnail"));
					clothesVo.setB_name(rs.getString("b_name"));
					clothesVo.setB_author(rs.getString("b_author"));
					clothesVo.setB_publisher(rs.getString("b_publisher"));
					clothesVo.setB_publish_year(rs.getString("b_publish_year"));
					clothesVo.setB_isbn(rs.getString("b_isbn"));
					clothesVo.setB_call_number(rs.getString("b_call_number"));
					clothesVo.setB_rantal_able(rs.getInt("b_rantal_able"));
					clothesVo.setB_reg_date(rs.getString("b_reg_date"));
					clothesVo.setB_mod_date(rs.getString("b_mod_date"));
					
					return clothesVo;
					
				}
				
			}, b_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return clothesVos.size() > 0 ? clothesVos.get(0) : null;
		
	}
	
	public int updateBook(ClothesVo clothesVo) {
		System.out.println("[BookDao] updateBook()");
		
		List<String> args = new ArrayList<String>();
		
		String sql =  "UPDATE tbl_book SET ";
			   if (clothesVo.getB_thumbnail() != null) {
				   sql += "b_thumbnail = ?, ";
				   args.add(clothesVo.getB_thumbnail());
			   }
			   
			   sql += "b_name = ?, ";
			   args.add(clothesVo.getB_name());
			   
			   sql += "b_author = ?, ";
			   args.add(clothesVo.getB_author());
			   
			   sql += "b_publisher = ?, ";
			   args.add(clothesVo.getB_publisher());
			   
			   sql += "b_publish_year = ?, ";
			   args.add(clothesVo.getB_publish_year());
			   
			   sql += "b_isbn = ?, ";
			   args.add(clothesVo.getB_isbn());
			   
			   sql += "b_call_number = ?, ";
			   args.add(clothesVo.getB_call_number());
			   
			   sql += "b_rantal_able = ?, ";
			   args.add(Integer.toString(clothesVo.getB_rantal_able()));
			   
			   sql += "b_mod_date = NOW() ";
			   
			   sql += "WHERE b_no = ?";
			   args.add(Integer.toString(clothesVo.getB_no()));
			   
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, args.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public int deleteBook(int b_no) {
		System.out.println("[BookDao] deleteBook()");
		
		String sql =  "DELETE FROM tbl_book "
					+ "WHERE b_no = ?";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, b_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
}
