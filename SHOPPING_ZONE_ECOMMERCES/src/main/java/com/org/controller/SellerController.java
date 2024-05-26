package com.org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.SellerDao;
import com.org.dto.Seller;
import com.org.dto.User;

@Controller
public class SellerController {
	@Autowired
	private SellerDao sellerDao;

	@PostMapping("/submitForm")
	public ModelAndView sellerRegisteration(@ModelAttribute Seller seller) {
		ModelAndView view = new ModelAndView("Seller/seller_login.jsp");
		sellerDao.SaveAndUpdateSeller(seller);
		return view;
	}

	@RequestMapping("/sellerLogin")
	public ModelAndView emailandpassword(@RequestParam(required = false) String email,
			@RequestParam(required = false) String password, HttpSession session) 
	{
		if (email != null && password != null) {
			Seller seller = sellerDao.FetchSellerByEmailAndPassword(email, password);
			if (seller != null) {
				ModelAndView mav = new ModelAndView("Seller/seller_home.jsp");
				session.setAttribute("sellerId", seller.getId());
				return mav;
			}
		}
		ModelAndView view = new ModelAndView("Seller/seller_login.jsp");
		view.addObject("faill", "Invalid Credentials");
		return view;
	}

	@RequestMapping("/seller_send_otp")
	public ModelAndView sendOTP(@RequestParam String email, HttpSession session) {
			Seller getEmail = sellerDao.FetchSellerByEmail(email);
			if (getEmail != null) {
				ModelAndView mav = new ModelAndView("Seller/seller_verify_otp.jsp");
				String otp = sellerDao.verificationSellerOTP(email);
				session.setAttribute("seller_gen_otp", otp);
				session.setAttribute("seller_otp_email", getEmail);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("Seller/seller_forgot_password.jsp");
				mav.addObject("sellerfailEmail", "Email is Not Found");
				return mav;
			}
		}

	@RequestMapping("/seller_verify_OTP")
	public ModelAndView verifyOTP(@RequestParam String otp, HttpSession session) {
			String gen_otp = (String) session.getAttribute("seller_gen_otp");
			if (gen_otp.equals(otp)) {
				ModelAndView mav = new ModelAndView("Seller/seller_change_password.jsp");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("Seller/seller_verify_otp.jsp");
				mav.addObject("failOTP", "Invalid OTP");
				return mav;
			}
		}

	@RequestMapping("/seller_confirm_pwd")
	public ModelAndView confirmPassword(@RequestParam String password, @RequestParam String confirm_password,
			HttpSession session) {
			Seller seller = (Seller) session.getAttribute("seller_otp_email");
			if (seller != null) {
				if (password.equals(confirm_password)) {
					ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
					seller.setPassword(confirm_password);
					sellerDao.SaveAndUpdateSeller(seller);
					mav.addObject("passwordChange", "Password has been successfully change!");
					return mav;
				} else {
					ModelAndView mav = new ModelAndView("Seller/seller_change_password.jsp");
					mav.addObject("passwordNotMatch", "Password and Confirm Password Should be Same.");
					return mav;
				}
			}
			return null;
		}
	@GetMapping("/sellerviewProduct")
	public ModelAndView userViewCart(HttpSession session) {
		Object object = session.getAttribute("sellerId");
		if (object != null) {
			ModelAndView mav = new ModelAndView("Seller/view_product.jsp");
			return mav;
		}
		ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
		mav.addObject("sellerviewproduct", "Enter Email and Password First!");
		return mav;
	}
	
	@GetMapping("/sellerlogout")
	public ModelAndView logout(HttpSession session, HttpServletRequest req) {
		Object object = session.getAttribute("sellerId");
		if (object != null) {
			session.invalidate();
			ModelAndView mav = new ModelAndView("Main/index.jsp");
			return mav; 
		}
		ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
		mav.addObject("sellerlogout", "Enter Email and Password First!");
		return mav;
	}
}