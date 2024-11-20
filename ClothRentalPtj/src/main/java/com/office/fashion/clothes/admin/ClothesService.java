package com.office.fashion.clothes.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.fashion.clothes.*;

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
	
	public ClothesVo ClothesDetail(int b_no) {
		System.out.println("[ClothesService] ClothesDetail()");
		
		return clothesDao.selectClothes(b_no);
		
	}
	
	public ClothesVo modifyClothesForm(int b_no) {
		System.out.println("[ClothesService] modifyClothesForm()");
		
		return clothesDao.selectClothes(b_no);
		
	}
	
	public int modifyClothesConfirm(ClothesVo clothesVo) {
		System.out.println("[ClothesService] modifyClothesConfirm()");
		
		return clothesDao.updateClothes(clothesVo);
		
	}
	
	public int deleteClothesConfirm(int b_no) {
		System.out.println("[ClothesService] deleteClothesConfirm()");
		
		return clothesDao.deleteClothes(b_no);
		
	}
	
	
}
