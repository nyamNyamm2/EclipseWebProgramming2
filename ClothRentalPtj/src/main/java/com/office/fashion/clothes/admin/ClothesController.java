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
import com.office.fashion.clothes.ClothesVo;
//import com.office.fashion.clothes.HopeClothesVo;
import com.office.fashion.clothes.RentalClothesVo;
import com.office.fashion.clothes.admin.util.UploadFileService;

@Controller
@RequestMapping("/Clothes/admin")
public class ClothesController {

	@Autowired
	ClothesService clothesService;
	
	@Autowired
	UploadFileService uploadFileService;
	
	/*
	 * 도서 등록
	 */
//	@RequestMapping(value = "/registerClothesForm", method = RequestMethod.GET)
	@GetMapping("/registerClothesForm")
	public String registerClothesForm() {
		System.out.println("[ClothesController] registerClothesForm()");
		
		String nextPage = "admin/Clothes/register_Clothes_form";
		
		return nextPage;
		
	}
	
	/*
	 * 도서 등록 확인
	 */
//	@RequestMapping(value = "/registerClothesConfirm", method = RequestMethod.POST)
	@PostMapping("/registerClothesConfirm")
	public String registerClothesConfirm(ClothesVo clothesVo, 
									  @RequestParam("file") MultipartFile file) {
		System.out.println("[ClothesController] registerClothesConfirm()");
		
		String nextPage = "admin/Clothes/register_Clothes_ok";
		
		// SAVE FILE
		String savedFileName = uploadFileService.upload(file);
		
		if (savedFileName != null) {
			clothesVo.setC_thumbnail(savedFileName);
			int result = clothesService.registerClothesConfirm(clothesVo);
			
			if (result <= 0)
				nextPage = "admin/Clothes/register_Clothes_ng";
			
		} else {
			nextPage = "admin/Clothes/register_Clothes_ng";
			
		}
		
		return nextPage;
		
	}
	
	/*
	 * 도서 검색
	 */
//	@RequestMapping(value = "/searchClothesConfirm", method = RequestMethod.GET)
	@GetMapping("/searchClothesConfirm")
	public String searchClothesConfirm(ClothesVo clothesVo, Model model) {
		System.out.println("[UserClothesController] searchClothesConfirm()");
		
		String nextPage = "admin/Clothes/search_Clothes";
		
		List<ClothesVo> clothesVos = clothesService.searchClothesConfirm(clothesVo);
		
		model.addAttribute("ClothesVos", clothesVos);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 상세
	 */
//	@RequestMapping(value = "/ClothesDetail", method = RequestMethod.GET)
	@GetMapping("/ClothesDetail")
	public String ClothesDetail(@RequestParam("c_no") int c_no, Model model) {
		System.out.println("[ClothesController] ClothesDetail()");
		
		String nextPage = "admin/Clothes/Clothes_detail";
		
		ClothesVo clothesVo = clothesService.ClothesDetail(c_no);
		
		model.addAttribute("ClothesVo", clothesVo);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 수정
	 */
//	@RequestMapping(value = "/modifyClothesForm", method = RequestMethod.GET)
	@GetMapping("/modifyClothesForm")
	public String modifyClothesForm(@RequestParam("c_no") int c_no, 
								 Model model, 
								 HttpSession session) {
		System.out.println("[ClothesController] ClothesDetail()");
		
		String nextPage = "admin/Clothes/modify_Clothes_form";
		
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			return "redirect:/admin/member//loginForm";
		
		ClothesVo clothesVo = clothesService.modifyClothesForm(c_no);
		
		model.addAttribute("ClothesVo", clothesVo);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 수정 확인
	 */
//	@RequestMapping(value = "/modifyClothesConfirm", method = RequestMethod.POST)
	@PostMapping("/modifyClothesConfirm")
	public String modifyClothesConfirm(ClothesVo clothesVo, 
									@RequestParam("file") MultipartFile file, 
									HttpSession session) {
		System.out.println("[ClothesController] modifyClothesConfirm()");
		
		String nextPage = "admin/Clothes/modify_Clothes_ok";
		
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			return "redirect:/admin/member//loginForm";
		
		if (!file.getOriginalFilename().equals("")) {
			// SAVE FILE
			String savedFileName = uploadFileService.upload(file);
			if (savedFileName != null)
				clothesVo.setC_thumbnail(savedFileName);
			
		}
		
		int result = clothesService.modifyClothesConfirm(clothesVo);
		
		if (result <= 0)
			nextPage = "admin/Clothes/modify_Clothes_ng";
		
		return nextPage;
		
	}
	
	/*
	 * 도서 삭제 확인
	 */
//	@RequestMapping(value = "/deleteClothesConfirm", method = RequestMethod.GET)
	@GetMapping("/deleteClothesConfirm")
	public String deleteClothesConfirm(@RequestParam("c_no") int c_no, 
									HttpSession session) {
		System.out.println("[ClothesController] deleteClothesConfirm()");
		
		String nextPage = "admin/Clothes/delete_Clothes_ok";
		
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			return "redirect:/admin/member//loginForm";
		
		int result = clothesService.deleteClothesConfirm(c_no);
		
		if (result <= 0)
			nextPage = "admin/Clothes/delete_Clothes_ng";
		
		return nextPage;
		
	}
	
	
	/*
	 * 대출 도서 목록
	 */
	
//	@RequestMapping(value = "/getRentalClothess", method = RequestMethod.GET)
	@GetMapping("/getRentalClothess")
	public String getRentalClothess(Model model) {
		System.out.println("[ClothesController] getRentalClothess()");
		
		String nextPage = "admin/Clothes/rental_Clothess";
		
		List<RentalClothesVo> rentalClothesVos = clothesService.getRentalClothess();
		
		model.addAttribute("rentalClothesVos", rentalClothesVos);
		
		return nextPage;
		
	}
	
	/*
	 * 도서 반납 확인
	 */
//	@RequestMapping(value = "/returnClothesConfirm", method = RequestMethod.GET)
	@GetMapping("/returnClothesConfirm")
	public String returnClothesConfirm(@RequestParam("c_no") int c_no, 
									@RequestParam("rc_no") int rc_no) {
		System.out.println("[ClothesController] returnClothesConfirm()");
		
		String nextPage = "admin/Clothes/return_Clothes_ok";
		
		int result = clothesService.returnClothesConfirm(c_no, rc_no);
		
		if (result <= 0)
			nextPage = "admin/Clothes/return_Clothes_ng";
		
		return nextPage;
		
	}
	
}
