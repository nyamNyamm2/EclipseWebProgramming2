package com.office.fashion.clothes.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.office.fashion.clothes.ClothesVo;
import com.office.fashion.clothes.RentalClothesVo;

@Component
//@Component("user.ClothesDao")
public class ClothesDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ClothesVo> selectClothessBySearch(ClothesVo ClothesVo) {
		System.out.println("[ClothesDao] selectClothess()");
		
		String sql =  "SELECT * FROM tbl_Clothes "
					+ "WHERE c_name LIKE ? "
					+ "ORDER BY c_no DESC";
		
		List<ClothesVo> ClothesVos = null;
		
		try {
			
			ClothesVos = jdbcTemplate.query(sql, new RowMapper<ClothesVo>() {

				@Override
				public ClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ClothesVo ClothesVo = new ClothesVo();
					
					ClothesVo.setC_no(rs.getInt("c_no"));
					ClothesVo.setC_thumbnail(rs.getString("c_thumbnail"));
					ClothesVo.setC_name(rs.getString("c_name"));
					ClothesVo.setC_author(rs.getString("c_author"));
					ClothesVo.setC_publisher(rs.getString("c_publisher"));
					ClothesVo.setC_publish_year(rs.getString("c_publish_year"));
					ClothesVo.setC_isbn(rs.getString("c_isbn"));
					ClothesVo.setC_rantal_able(rs.getInt("c_rantal_able"));
					ClothesVo.setC_reg_date(rs.getString("c_reg_date"));
					ClothesVo.setC_mod_date(rs.getString("c_mod_date"));
					
					return ClothesVo;
					
				}
				
			}, "%" + ClothesVo.getC_name() + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return ClothesVos.size() > 0 ? ClothesVos : null;
		
	}
	
	public ClothesVo selectClothes(int c_no) {
		System.out.println("[ClothesDao] selectClothes()");
		
		String sql = "SELECT * FROM tbl_Clothes WHERE c_no = ?";
		
		List<ClothesVo> ClothesVos = null;
		
		try {
			
			ClothesVos = jdbcTemplate.query(sql, new RowMapper<ClothesVo>() {

				@Override
				public ClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ClothesVo ClothesVo = new ClothesVo();
					
					ClothesVo.setC_no(rs.getInt("c_no"));
					ClothesVo.setC_thumbnail(rs.getString("c_thumbnail"));
					ClothesVo.setC_name(rs.getString("c_name"));
					ClothesVo.setC_author(rs.getString("c_author"));
					ClothesVo.setC_publisher(rs.getString("c_publisher"));
					ClothesVo.setC_publish_year(rs.getString("c_publish_year"));
					ClothesVo.setC_isbn(rs.getString("c_isbn"));
					ClothesVo.setC_rantal_able(rs.getInt("c_rantal_able"));
					ClothesVo.setC_reg_date(rs.getString("c_reg_date"));
					ClothesVo.setC_mod_date(rs.getString("c_mod_date"));
					
					return ClothesVo;
					
				}
				
			}, c_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return ClothesVos.size() > 0 ? ClothesVos.get(0) : null;
		
	}
	
	public int insertRentalClothes(int c_no, int u_m_no) {
		System.out.println("[ClothesDao] insertRentalClothes()");
		
		String sql =  "INSERT INTO tbl_rental_Clothes(c_no, u_m_no, rc_start_date, rc_reg_date, rc_mod_date) "
					+ "VALUES(?, ?, NOW(), NOW(), NOW())";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, c_no, u_m_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public void updateRentalClothesAble(int c_no) {
		System.out.println("[ClothesDao] updateRentalClothesAble()");
		
		String sql =  "UPDATE tbl_Clothes "
					+ "SET c_rantal_able = 0 "
					+ "WHERE c_no = ?";
		
		try {
			
			jdbcTemplate.update(sql, c_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public List<RentalClothesVo> selectRentalClothess(int u_m_no) {
		System.out.println("[ClothesDao] selectRentalClothess()");
		
		String sql =  "SELECT * FROM tbl_rental_Clothes rb "
					+ "JOIN tbl_Clothes b "
					+ "ON rb.c_no = b.c_no "
					+ "JOIN tbl_user_member um "
					+ "ON rb.u_m_no = um.u_m_no "
					+ "WHERE rb.u_m_no = ? AND rb.rc_end_date = '1000-01-01'";
		
		List<RentalClothesVo> rentalClothesVos = new ArrayList<RentalClothesVo>();
		
		try {
			
			rentalClothesVos = jdbcTemplate.query(sql, new RowMapper<RentalClothesVo>() {

				@Override
				public RentalClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					RentalClothesVo rentalClothesVo = new RentalClothesVo();
					
					rentalClothesVo.setRc_no(rs.getInt("rc_no"));
					rentalClothesVo.setC_no(rs.getInt("c_no"));
					rentalClothesVo.setU_m_no(rs.getInt("u_m_no"));
					rentalClothesVo.setRc_start_date(rs.getString("rc_start_date"));
					rentalClothesVo.setRc_end_date(rs.getString("rc_end_date"));
					rentalClothesVo.setRc_reg_date(rs.getString("rc_reg_date"));
					rentalClothesVo.setRc_mod_date(rs.getString("rc_mod_date"));
					
					rentalClothesVo.setC_thumbnail(rs.getString("c_thumbnail"));
					rentalClothesVo.setC_name(rs.getString("c_name"));
					rentalClothesVo.setC_author(rs.getString("c_author"));
					rentalClothesVo.setC_publisher(rs.getString("c_publisher"));
					rentalClothesVo.setC_publish_year(rs.getString("c_publish_year"));
					rentalClothesVo.setC_isbn(rs.getString("c_isbn"));
					rentalClothesVo.setC_call_number(rs.getString("c_call_number"));
					rentalClothesVo.setC_rantal_able(rs.getInt("c_rantal_able"));
					rentalClothesVo.setC_reg_date(rs.getString("c_reg_date"));
					
					rentalClothesVo.setU_m_id(rs.getString("u_m_id"));
					rentalClothesVo.setU_m_pw(rs.getString("u_m_pw"));
					rentalClothesVo.setU_m_name(rs.getString("u_m_name"));
					rentalClothesVo.setU_m_gender(rs.getString("u_m_gender"));
					rentalClothesVo.setU_m_mail(rs.getString("u_m_mail"));
					rentalClothesVo.setU_m_phone(rs.getString("u_m_phone"));
					rentalClothesVo.setU_m_reg_date(rs.getString("u_m_reg_date"));
					rentalClothesVo.setU_m_mod_date(rs.getString("u_m_mod_date"));
					
					return rentalClothesVo;
					
				}
				
			}, u_m_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return rentalClothesVos;
		
	}
	
	public List<RentalClothesVo> selectRentalClothesHistory(int u_m_no) {
		System.out.println("[ClothesDao] selectRentalClothess()");
		
		String sql =  "SELECT * FROM tbl_rental_Clothes rb "
					+ "JOIN tbl_Clothes b "
					+ "ON rb.c_no = b.c_no "
					+ "JOIN tbl_user_member um "
					+ "ON rb.u_m_no = um.u_m_no "
					+ "WHERE rb.u_m_no = ? "
					+ "ORDER BY rb.rc_reg_date DESC";
		
		List<RentalClothesVo> rentalClothesVos = new ArrayList<RentalClothesVo>();
		
		try {
			
			rentalClothesVos = jdbcTemplate.query(sql, new RowMapper<RentalClothesVo>() {

				@Override
				public RentalClothesVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					RentalClothesVo rentalClothesVo = new RentalClothesVo();
					
					rentalClothesVo.setRc_no(rs.getInt("rc_no"));
					rentalClothesVo.setC_no(rs.getInt("c_no"));
					rentalClothesVo.setU_m_no(rs.getInt("u_m_no"));
					rentalClothesVo.setRc_start_date(rs.getString("rc_start_date"));
					rentalClothesVo.setRc_end_date(rs.getString("rc_end_date"));
					rentalClothesVo.setRc_reg_date(rs.getString("rc_reg_date"));
					rentalClothesVo.setRc_mod_date(rs.getString("rc_mod_date"));
					
					rentalClothesVo.setC_thumbnail(rs.getString("c_thumbnail"));
					rentalClothesVo.setC_name(rs.getString("c_name"));
					rentalClothesVo.setC_author(rs.getString("c_author"));
					rentalClothesVo.setC_publisher(rs.getString("c_publisher"));
					rentalClothesVo.setC_publish_year(rs.getString("c_publish_year"));
					rentalClothesVo.setC_isbn(rs.getString("c_isbn"));
					rentalClothesVo.setC_call_number(rs.getString("c_call_number"));
					rentalClothesVo.setC_rantal_able(rs.getInt("c_rantal_able"));
					rentalClothesVo.setC_reg_date(rs.getString("c_reg_date"));
					
					rentalClothesVo.setU_m_id(rs.getString("u_m_id"));
					rentalClothesVo.setU_m_pw(rs.getString("u_m_pw"));
					rentalClothesVo.setU_m_name(rs.getString("u_m_name"));
					rentalClothesVo.setU_m_gender(rs.getString("u_m_gender"));
					rentalClothesVo.setU_m_mail(rs.getString("u_m_mail"));
					rentalClothesVo.setU_m_phone(rs.getString("u_m_phone"));
					rentalClothesVo.setU_m_reg_date(rs.getString("u_m_reg_date"));
					rentalClothesVo.setU_m_mod_date(rs.getString("u_m_mod_date"));
					
					return rentalClothesVo;
					
				}
				
			}, u_m_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return rentalClothesVos;
		
	}
	
	
}
