package com.office.fashion.clothes.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.office.fashion.clothes.ClothesVo;
//import com.office.fashion.clothes.HopeClothesVo;
import com.office.fashion.clothes.RentalClothesVo;

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
	
	
//	public List<RentalClothesVo> selectRentalClothess() {
//	System.out.println("[ClothesDao] selectRentalClothess()");
//	
//	String sql =  "SELECT * FROM tbl_rental_Clothes rb "
//				+ "JOIN tbl_Clothes b "
//				+ "ON rb.c_no = b.c_no "
//				+ "JOIN tbl_user_member um "
//				+ "ON rb.u_m_no = um.u_m_no "
//				+ "WHERE rb.rc_end_date = '1000-01-01' "
//				+ "ORDER BY um.u_m_id ASC, rb.rc_reg_date DESC";
//	
//	List<RentalClothesVo> rentalClothesVos = new ArrayList<RentalClothesVo>();
//	
//	try {
//		
//		rentalClothesVos = jdbcTemplate.query(sql, new RowMapper<RentalClothesVo>() {
//
//			@Override
//			public RentalClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				RentalClothesVo rentalClothesVo = new RentalClothesVo();
//				
//				rentalClothesVo.setRc_no(rs.getInt("rc_no"));
//				rentalClothesVo.setc_no(rs.getInt("c_no"));
//				rentalClothesVo.setU_m_no(rs.getInt("u_m_no"));
//				rentalClothesVo.setRc_start_date(rs.getString("rc_start_date"));
//				rentalClothesVo.setRc_end_date(rs.getString("rc_end_date"));
//				rentalClothesVo.setRc_reg_date(rs.getString("rc_reg_date"));
//				rentalClothesVo.setRc_mod_date(rs.getString("rc_mod_date"));
//				
//				rentalClothesVo.setc_thumbnail(rs.getString("c_thumbnail"));
//				rentalClothesVo.setc_name(rs.getString("c_name"));
//				rentalClothesVo.setc_author(rs.getString("c_author"));
//				rentalClothesVo.setc_publisher(rs.getString("c_publisher"));
//				rentalClothesVo.setc_publish_year(rs.getString("c_publish_year"));
//				rentalClothesVo.setc_isbn(rs.getString("c_isbn"));
//				rentalClothesVo.setc_call_number(rs.getString("c_call_number"));
//				rentalClothesVo.setc_rantal_able(rs.getInt("c_rantal_able"));
//				rentalClothesVo.setc_reg_date(rs.getString("c_reg_date"));
//				
//				rentalClothesVo.setU_m_id(rs.getString("u_m_id"));
//				rentalClothesVo.setU_m_pw(rs.getString("u_m_pw"));
//				rentalClothesVo.setU_m_name(rs.getString("u_m_name"));
//				rentalClothesVo.setU_m_gender(rs.getString("u_m_gender"));
//				rentalClothesVo.setU_m_mail(rs.getString("u_m_mail"));
//				rentalClothesVo.setU_m_phone(rs.getString("u_m_phone"));
//				rentalClothesVo.setU_m_reg_date(rs.getString("u_m_reg_date"));
//				rentalClothesVo.setU_m_mod_date(rs.getString("u_m_mod_date"));
//				
//				return rentalClothesVo;
//				
//			}
//			
//		});
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		
//	}
//	
//	return rentalClothesVos;
//	
//}

public List<RentalClothesVo> selectRentalClothess() {
	System.out.println("[ClothesDao] selectRentalClothess()");
	
	String sql =  "SELECT * FROM tbl_rental_Clothes rb "
				+ "JOIN tbl_Clothes b "
				+ "ON rb.c_no = b.c_no "
				+ "JOIN tbl_user_member um "
				+ "ON rb.u_m_no = um.u_m_no "
				+ "WHERE rb.rc_end_date = '1000-01-01' "
				+ "ORDER BY um.u_m_id ASC, rb.rc_reg_date DESC";
	
	List<RentalClothesVo> rentalClothesVos = new ArrayList<RentalClothesVo>();
	
	try {
		
		RowMapper<RentalClothesVo> rowMapper = BeanPropertyRowMapper.newInstance(RentalClothesVo.class);
		rentalClothesVos = jdbcTemplate.query(sql, rowMapper);
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	
	return rentalClothesVos;
	
}

public int updateRentalClothes(int rc_no) {
	System.out.println("[ClothesDao] updateRentalClothes()");
	
	String sql =  "UPDATE tbl_rental_Clothes "
				+ "SET rc_end_date = NOW() "
				+ "WHERE rc_no = ?";
	
	int result = -1;
	
	try {
		
		result = jdbcTemplate.update(sql, rc_no);
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	
	return result;
}

public int updateClothes(int c_no) {
	System.out.println("[ClothesDao] updateRentalClothes()");
	
	String sql =  "UPDATE tbl_Clothes "
				+ "SET c_rantal_able = 1 "
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
