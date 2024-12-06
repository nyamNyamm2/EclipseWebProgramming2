package com.office.fashion.clothes.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.fashion.clothes.ClothesVo;
import com.office.fashion.clothes.HopeClothesVo;
import com.office.fashion.clothes.RentalClothesVo;

@Service
public class ClothesService {

	final static public int Clothes_ISBN_ALREADY_EXIST = 0;	// 이미 등록된 도서
	final static public int Clothes_REGISTER_SUCCESS = 1;	// 신규 도서 등록 성공
	final static public int Clothes_REGISTER_FAIL = -1;	// 신규 도서 등록 실패
	
	@Autowired
	ClothesDao clothesDao;

	public int registerClothesConfirm(ClothesVo clothesVo) {
		System.out.println("[ClothesService] registerClothesConfirm()");
		
		boolean isISBN = clothesDao.isISBN(clothesVo.getC_isbn());
		
		if (!isISBN) {
			int result = clothesDao.insertClothes(clothesVo);
			
			if (result > 0)
				return Clothes_REGISTER_SUCCESS;
			
			else
				return Clothes_REGISTER_FAIL;
			
		} else {
			return Clothes_ISBN_ALREADY_EXIST;
			
		}
		
	}
	
	public List<ClothesVo> searchClothesConfirm(ClothesVo clothesVo) {
		System.out.println("[ClothesService] searchClothesConfirm()");
		
		return clothesDao.selectClothessBySearch(clothesVo);
		
	}
	
	public ClothesVo ClothesDetail(int c_no) {
		System.out.println("[ClothesService] ClothesDetail()");
		
		return clothesDao.selectClothes(c_no);
		
	}
	
	public ClothesVo modifyClothesForm(int c_no) {
		System.out.println("[ClothesService] modifyClothesForm()");
		
		return clothesDao.selectClothes(c_no);
		
	}
	
	public int modifyClothesConfirm(ClothesVo clothesVo) {
		System.out.println("[ClothesService] modifyClothesConfirm()");
		
		return clothesDao.updateClothes(clothesVo);
		
	}
	
	public int deleteClothesConfirm(int c_no) {
		System.out.println("[ClothesService] deleteClothesConfirm()");
		
		return clothesDao.deleteClothes(c_no);
		
	}
	
	
	public List<RentalClothesVo> getRentalClothess() {
		System.out.println("[ClothesService] getRentalClothess()");
		
		return clothesDao.selectRentalClothess();
		
	}
	
	public int returnClothesConfirm(int c_no, int rc_no) {
		System.out.println("[ClothesService] getRentalClothess()");
		
		int result = clothesDao.updateRentalClothes(rc_no);
		
		if (result > 0) 
			result = clothesDao.updateClothes(rc_no);
			
		return result;
	}
	

	public List<HopeClothesVo> getHopeClothess() {
		System.out.println("[ClothesService] getHopeClothess()");
		
		return clothesDao.selectHopeClothess();
		
	}
	
	public int registerHopeClothesConfirm(ClothesVo ClothesVo, int hc_no) {
		System.out.println("[ClothesService] registerHopeClothesConfirm()");
		
		boolean isISBN = clothesDao.isISBN(ClothesVo.getC_isbn());
		
		if (!isISBN) {
			int result = clothesDao.insertClothes(ClothesVo);
			
			if (result > 0) {
				
				clothesDao.updateHopeClothesResult(hc_no);
				
				return Clothes_REGISTER_SUCCESS;
				
			} else {
				return Clothes_REGISTER_FAIL;
				
			}
			
		} else {
			return Clothes_ISBN_ALREADY_EXIST;
			
		}
		
	}
	
	public List<ClothesVo> getAllClothess() {
		System.out.println("[ClothesService] getAllClothess()");
		
		return clothesDao.selectAllClothess();
		
	}
	
}
