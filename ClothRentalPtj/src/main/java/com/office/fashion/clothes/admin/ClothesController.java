package com.office.fashion.clothes.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.office.fashion.admin.member.AdminMemberVo;
import com.office.fashion.clothes.*;
import com.office.fashion.clothes.admin.util.*;

@Controller
@RequestMapping("/book/admin")
public class ClothesController {

	@Autowired
	ClothesService clothesService;
	
	@Autowired
	UploadFileService uploadFileService;
	
	/*
	 * 도서 등록
	 */
//	@RequestMapping(value = "/registerBookForm", method = RequestMethod.GET)
	@GetMapping("/registerBookForm")
	public String registerBookForm() {
		System.out.println("[BookController] registerBookForm()");
		
		String nextPage = "admin/book/register_book_form";
		
		return nextPage;
		
	}
	
	/*
	 * 도서 등록 확인
	 */
//	@RequestMapping(value = "/registerBookConfirm", method = RequestMethod.POST)
	@PostMapping("/registerBookConfirm")
	public String registerBookConfirm(ClothesVo clothesVo, 
									  @RequestParam("file") MultipartFile file) {
		System.out.println("[BookController] registerBookConfirm()");
		
		String nextPage = "admin/book/register_book_ok";
		
		// SAVE FILE
		String savedFileName = uploadFileService.upload(file);
		
		if (savedFileName != null) {
			clothesVo.setB_thumbnail(savedFileName);
			int result = clothesService.registerBookConfirm(clothesVo);
			
			if (result <= 0)
				nextPage = "admin/book/register_book_ng";
			
		} else {
			nextPage = "admin/book/register_book_ng";
			
		}
		
		return nextPage;
		
	}
	
	/*
	 * 도서 검색
	 */
//	@RequestMapping(value = "/searchBookConfirm", method = RequestMethod.GET)
	@GetMapping("/searchBookConfirm")
	public String searchBookConfirm(ClothesVo clothesVo, Model model) {
		System.out.println("[UserBookController] searchBookConfirm()");
		
		String nextPage = "admin/book/search_book";
		
		List<ClothesVo> clothesVos = clothesService.searchBookConfirm(clothesVo);
		
		model.addAttribute("bookVos", clothesVos);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 상세
	 */
//	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	@GetMapping("/bookDetail")
	public String bookDetail(@RequestParam("b_no") int b_no, Model model) {
		System.out.println("[BookController] bookDetail()");
		
		String nextPage = "admin/book/book_detail";
		
		ClothesVo clothesVo = clothesService.bookDetail(b_no);
		
		model.addAttribute("bookVo", clothesVo);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 수정
	 */
//	@RequestMapping(value = "/modifyBookForm", method = RequestMethod.GET)
	@GetMapping("/modifyBookForm")
	public String modifyBookForm(@RequestParam("b_no") int b_no, 
								 Model model, 
								 HttpSession session) {
		System.out.println("[BookController] bookDetail()");
		
		String nextPage = "admin/book/modify_book_form";
		
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			return "redirect:/admin/member//loginForm";
		
		ClothesVo clothesVo = clothesService.modifyBookForm(b_no);
		
		model.addAttribute("bookVo", clothesVo);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 수정 확인
	 */
//	@RequestMapping(value = "/modifyBookConfirm", method = RequestMethod.POST)
	@PostMapping("/modifyBookConfirm")
	public String modifyBookConfirm(ClothesVo clothesVo, 
									@RequestParam("file") MultipartFile file, 
									HttpSession session) {
		System.out.println("[BookController] modifyBookConfirm()");
		
		String nextPage = "admin/book/modify_book_ok";
		
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			return "redirect:/admin/member//loginForm";
		
		if (!file.getOriginalFilename().equals("")) {
			// SAVE FILE
			String savedFileName = uploadFileService.upload(file);
			if (savedFileName != null)
				clothesVo.setB_thumbnail(savedFileName);
			
		}
		
		int result = clothesService.modifyBookConfirm(clothesVo);
		
		if (result <= 0)
			nextPage = "admin/book/modify_book_ng";
		
		return nextPage;
		
	}
	
	/*
	 * 도서 삭제 확인
	 */
//	@RequestMapping(value = "/deleteBookConfirm", method = RequestMethod.GET)
	@GetMapping("/deleteBookConfirm")
	public String deleteBookConfirm(@RequestParam("b_no") int b_no, 
									HttpSession session) {
		System.out.println("[BookController] deleteBookConfirm()");
		
		String nextPage = "admin/book/delete_book_ok";
		
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			return "redirect:/admin/member//loginForm";
		
		int result = clothesService.deleteBookConfirm(b_no);
		
		if (result <= 0)
			nextPage = "admin/book/delete_book_ng";
		
		return nextPage;
		
	}
	
}
