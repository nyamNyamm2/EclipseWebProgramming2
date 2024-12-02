package com.office.fashion.clothes.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.fashion.clothes.ClothesVo;
import com.office.fashion.clothes.RentalClothesVo;

@Service
//@Service("user.ClothesService")
public class ClothesService {

	@Autowired
	ClothesDao ClothesDao;

	public List<ClothesVo> searchClothesConfirm(ClothesVo ClothesVo) {
		System.out.println("[ClothesService] searchClothesConfirm()");
		
		return ClothesDao.selectClothessBySearch(ClothesVo);
		
	}
	
	public ClothesVo ClothesDetail(int c_no) {
		System.out.println("[ClothesService] ClothesDetail()");
		
		return ClothesDao.selectClothes(c_no);
		
	}
	
	public int rentalClothesConfirm(int c_no, int u_m_no) {
		System.out.println("[ClothesService] ClothesDetail()");
		
		int result = ClothesDao.insertRentalClothes(c_no, u_m_no);
		
		if (result >= 0)
			ClothesDao.updateRentalClothesAble(c_no);
		
		return result;
	}
	
	public List<RentalClothesVo> enterClothesshelf(int u_m_no) {
		System.out.println("[ClothesService] enterClothesshelf()");
		
		return ClothesDao.selectRentalClothess(u_m_no);
		
	}
	
	public List<RentalClothesVo> listupRentalClothesHistory(int u_m_no) {
		System.out.println("[ClothesService] listupRentalClothesHistory()");
		
		return ClothesDao.selectRentalClothesHistory(u_m_no);
		
	}
	
}
