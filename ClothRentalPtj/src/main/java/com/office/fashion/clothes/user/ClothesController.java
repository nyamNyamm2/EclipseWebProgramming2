package com.office.fashion.clothes.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.office.fashion.clothes.ClothesVo;
import com.office.fashion.clothes.RentalClothesVo;
import com.office.fashion.user.member.UserMemberVo;

@Controller
//@Controller("user.ClothesController")
@RequestMapping("/Clothes/user")
public class ClothesController {

	@Autowired
	ClothesService ClothesService;
	
	/*
	 * 도서 검색
	 */
//	@RequestMapping(value = "/searchClothesConfirm", method = RequestMethod.GET)
	@GetMapping("/searchClothesConfirm")
	public String searchClothesConfirm(ClothesVo ClothesVo, Model model) {
		System.out.println("[UserClothesController] searchClothesConfirm()");
		
		String nextPage = "user/Clothes/search_Clothes";
		
		List<ClothesVo> ClothesVos = ClothesService.searchClothesConfirm(ClothesVo);
		
		model.addAttribute("ClothesVos", ClothesVos);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 상세
	 */
//	@RequestMapping(value = "/ClothesDetail", method = RequestMethod.GET)
	@GetMapping("/ClothesDetail")
	public String ClothesDetail(@RequestParam("b_no") int b_no, Model model) {
		System.out.println("[UserClothesController] ClothesDetail()");
		
		String nextPage = "user/Clothes/Clothes_detail";
		
		ClothesVo ClothesVo = ClothesService.ClothesDetail(b_no);
		
		model.addAttribute("ClothesVo", ClothesVo);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 대출
	 */
//	@RequestMapping(value = "/rentalClothesConfirm", method = RequestMethod.GET)
	@GetMapping("/rentalClothesConfirm")
	public String rentalClothesConfirm(@RequestParam("b_no") int b_no, HttpSession session) {
		System.out.println("[UserClothesController] rentalClothesConfirm()");
		
		String nextPage = "user/Clothes/rental_Clothes_ok";
		
		UserMemberVo loginedUserMemberVo = 
				(UserMemberVo) session.getAttribute("loginedUserMemberVo");

//		if (loginedUserMemberVo == null)
//			return "redirect:/user/member/loginForm";
		
		int result = ClothesService.rentalClothesConfirm(b_no, loginedUserMemberVo.getU_m_no());
		
		if (result <= 0)
			nextPage = "user/Clothes/rental_Clothes_ng";
		
		return nextPage;
		
	}
	
	/*
	 * 나의 책장
	 */
//	@RequestMapping(value = "/enterClothesshelf", method = RequestMethod.GET)
	@GetMapping("/enterClothesshelf")
	public String enterClothesshelf(HttpSession session, Model model) {
		System.out.println("[UserClothesController] enterClothesshelf()");
		
		String nextPage = "user/Clothes/Clothesshelf";
		
		UserMemberVo loginedUserMemberVo = (UserMemberVo) session.getAttribute("loginedUserMemberVo");
		
		List<RentalClothesVo> rentalClothesVos = ClothesService.enterClothesshelf(loginedUserMemberVo.getU_m_no());
		
		model.addAttribute("rentalClothesVos", rentalClothesVos);
		
		return nextPage;
	
	}
	
	/*
	 * 도서 대출 이력
	 */
//	@RequestMapping(value = "/listupRentalClothesHistory", method = RequestMethod.GET)
	@GetMapping("/listupRentalClothesHistory")
	public String listupRentalClothesHistory(HttpSession session, Model model) {
		System.out.println("[UserClothesController] listupRentalClothesHistory()");
		
		String nextPage = "user/Clothes/rental_Clothes_history";
		
		UserMemberVo loginedUserMemberVo = (UserMemberVo) session.getAttribute("loginedUserMemberVo");
		
		List<RentalClothesVo> rentalClothesVos = ClothesService.listupRentalClothesHistory(loginedUserMemberVo.getU_m_no());
		
		model.addAttribute("rentalClothesVos", rentalClothesVos);
		
		return nextPage;
		
	}
	
}