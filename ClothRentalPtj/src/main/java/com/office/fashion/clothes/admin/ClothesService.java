package com.office.fashion.clothes.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.fashion.clothes.*;

@Service
public class ClothesService {

	final static public int BOOK_ISBN_ALREADY_EXIST = 0;	// 이미 등록된 도서
	final static public int BOOK_REGISTER_SUCCESS = 1;	// 신규 도서 등록 성공
	final static public int BOOK_REGISTER_FAIL = -1;	// 신규 도서 등록 실패
	
	@Autowired
	ClothesDao clothesDao;

	public int registerBookConfirm(ClothesVo clothesVo) {
		System.out.println("[BookService] registerBookConfirm()");
		
		boolean isISBN = clothesDao.isISBN(clothesVo.getB_isbn());
		
		if (!isISBN) {
			int result = clothesDao.insertBook(clothesVo);
			
			if (result > 0)
				return BOOK_REGISTER_SUCCESS;
			
			else
				return BOOK_REGISTER_FAIL;
			
		} else {
			return BOOK_ISBN_ALREADY_EXIST;
			
		}
		
	}
	
	public List<ClothesVo> searchBookConfirm(ClothesVo clothesVo) {
		System.out.println("[BookService] searchBookConfirm()");
		
		return clothesDao.selectBooksBySearch(clothesVo);
		
	}
	
	public ClothesVo bookDetail(int b_no) {
		System.out.println("[BookService] bookDetail()");
		
		return clothesDao.selectBook(b_no);
		
	}
	
	public ClothesVo modifyBookForm(int b_no) {
		System.out.println("[BookService] modifyBookForm()");
		
		return clothesDao.selectBook(b_no);
		
	}
	
	public int modifyBookConfirm(ClothesVo clothesVo) {
		System.out.println("[BookService] modifyBookConfirm()");
		
		return clothesDao.updateBook(clothesVo);
		
	}
	
	public int deleteBookConfirm(int b_no) {
		System.out.println("[BookService] deleteBookConfirm()");
		
		return clothesDao.deleteBook(b_no);
		
	}
	
	
}
