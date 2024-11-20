package com.office.fashion.clothes.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.office.fashion.clothes.ClothesVo;

@Component
public class ClothesDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean isISBN(String c_isbn) {
		System.out.println("[ClothesDao] isISBN()");
		
		String sql =  "SELECT COUNT(*) FROM tbl_clothes "
					+ "WHERE c_isbn = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, c_isbn);
		
		return result > 0 ? true : false;
		
	}
	
	public int insertClothes(ClothesVo clothesVo) {
		System.out.println("[ClothesDao] insertClothes()");
		
		String sql = "INSERT INTO tbl_clothes(c_thumbnail, "
										+ "c_name, "
										+ "c_author, "
										+ "c_publisher, "
										+ "c_publish_year, "
										+ "c_isbn, "
										+ "c_rantal_able, "
										+ "c_reg_date, "
										+ "c_mod_date) "
										+ "VALUES(?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql,
											clothesVo.getC_thumbnail(), 
											clothesVo.getC_name(),
											clothesVo.getC_author(),
											clothesVo.getC_publisher(),
											clothesVo.getC_publish_year(),
											clothesVo.getC_isbn(),
											clothesVo.getC_rantal_able()
											);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public List<ClothesVo> selectClothessBySearch(ClothesVo clothesVo) {
		System.out.println("[ClothesDao] selectClothess()");
		
		String sql =  "SELECT * FROM tbl_clothes "
					+ "WHERE c_name LIKE ? "
					+ "ORDER BY c_no DESC";
		
		List<ClothesVo> clothesVos = null;
		
		try {
			
			clothesVos = jdbcTemplate.query(sql, new RowMapper<ClothesVo>() {

				@Override
				public ClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ClothesVo clothesVo = new ClothesVo();
					
					clothesVo.setC_no(rs.getInt("c_no"));
					clothesVo.setC_thumbnail(rs.getString("c_thumbnail"));
					clothesVo.setC_name(rs.getString("c_name"));
					clothesVo.setC_author(rs.getString("c_author"));
					clothesVo.setC_publisher(rs.getString("c_publisher"));
					clothesVo.setC_publish_year(rs.getString("c_publish_year"));
					clothesVo.setC_isbn(rs.getString("c_isbn"));
					clothesVo.setC_rantal_able(rs.getInt("c_rantal_able"));
					clothesVo.setC_reg_date(rs.getString("c_reg_date"));
					clothesVo.setC_mod_date(rs.getString("c_mod_date"));
					
					return clothesVo;
					
				}
				
			}, "%" + clothesVo.getC_name() + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return clothesVos.size() > 0 ? clothesVos : null;
		
	}
	
	public ClothesVo selectClothes(int c_no) {
		System.out.println("[ClothesDao] selectClothes()");
		
		String sql = "SELECT * FROM tbl_clothes WHERE c_no = ?";
		
		List<ClothesVo> clothesVos = null;
		
		try {
			
			clothesVos = jdbcTemplate.query(sql, new RowMapper<ClothesVo>() {

				@Override
				public ClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ClothesVo clothesVo = new ClothesVo();
					
					clothesVo.setC_no(rs.getInt("c_no"));
					clothesVo.setC_thumbnail(rs.getString("c_thumbnail"));
					clothesVo.setC_name(rs.getString("c_name"));
					clothesVo.setC_author(rs.getString("c_author"));
					clothesVo.setC_publisher(rs.getString("c_publisher"));
					clothesVo.setC_publish_year(rs.getString("c_publish_year"));
					clothesVo.setC_isbn(rs.getString("c_isbn"));
					clothesVo.setC_rantal_able(rs.getInt("c_rantal_able"));
					clothesVo.setC_reg_date(rs.getString("c_reg_date"));
					clothesVo.setC_mod_date(rs.getString("c_mod_date"));
					
					return clothesVo;
					
				}
				
			}, c_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return clothesVos.size() > 0 ? clothesVos.get(0) : null;
		
	}
	
	public int updateClothes(ClothesVo clothesVo) {
		System.out.println("[ClothesDao] updateClothes()");
		
		List<String> args = new ArrayList<String>();
		
		String sql =  "UPDATE tbl_clothes SET ";
			   if (clothesVo.getC_thumbnail() != null) {
				   sql += "c_thumbnail = ?, ";
				   args.add(clothesVo.getC_thumbnail());
			   }
			   
			   sql += "c_name = ?, ";
			   args.add(clothesVo.getC_name());
			   
			   sql += "c_author = ?, ";
			   args.add(clothesVo.getC_author());
			   
			   sql += "c_publisher = ?, ";
			   args.add(clothesVo.getC_publisher());
			   
			   sql += "c_publish_year = ?, ";
			   args.add(clothesVo.getC_publish_year());
			   
			   sql += "c_isbn = ?, ";
			   args.add(clothesVo.getC_isbn());
			   
			   sql += "c_rantal_able = ?, ";
			   args.add(Integer.toString(clothesVo.getC_rantal_able()));
			   
			   sql += "c_mod_date = NOW() ";
			   
			   sql += "WHERE c_no = ?";
			   args.add(Integer.toString(clothesVo.getC_no()));
			   
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, args.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public int deleteClothes(int c_no) {
		System.out.println("[ClothesDao] deleteClothes()");
		
		String sql =  "DELETE FROM tbl_clothes "
					+ "WHERE c_no = ?";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, c_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
}
