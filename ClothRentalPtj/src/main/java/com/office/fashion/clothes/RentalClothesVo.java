package com.office.fashion.clothes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalClothesVo {

	int rc_no;
	String rc_start_date;
	String rc_end_date;
	String rc_reg_date;
	String rc_mod_date;
	
	int c_no;
	String c_thumbnail;
	String c_name;
	String c_author;	
	String c_publisher;
	String c_publish_year;
	String c_isbn;
	String c_call_number;
	int c_rantal_able;
	String c_reg_date;
	String c_mod_date;
	
	int u_m_no;
	String u_m_id;
	String u_m_pw;
	String u_m_name;
	String u_m_gender;
	String u_m_mail;
	String u_m_phone;
	String u_m_reg_date;
	String u_m_mod_date;
	
}
