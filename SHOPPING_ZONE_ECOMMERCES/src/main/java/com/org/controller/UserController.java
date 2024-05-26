package com.org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.UserDao;
import com.org.daoImplementation.UserDaoImplement;
import com.org.dto.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;

	@RequestMapping("/submitFormUser")
	public ModelAndView userRegister(@ModelAttribute User user, HttpSession session) {
		ModelAndView view = new ModelAndView("User/user_login.jsp");
		userDao.SaveAndUpdateUser(user);
		return view;
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(@RequestParam(required = false) String email,
			@RequestParam(required = false) String password, HttpSession session) 
	{
		if (email != null && password != null) {
			User user = userDao.FetchUserByEmailAndPassword(email, password);
			if (user != null) {
				ModelAndView mav = new ModelAndView("User/user_home.jsp");
				session.setAttribute("userId", user.getId());
				return mav;
			}
		}
		ModelAndView mav = new ModelAndView("User/user_login.jsp");
		mav.addObject("fail", "Invalid Credentials");
		return mav;
	}

	@RequestMapping("/send_otp")
	public ModelAndView sendOTP(@RequestParam String email, HttpSession session) {
			User getEmail = userDao.FetchUserByEmail(email);
			if (getEmail != null) {
				ModelAndView mav = new ModelAndView("User/user_verify_otp.jsp");
				String otp = userDao.verificationUserOTP(email);
				session.setAttribute("gen_otp", otp);
				session.setAttribute("otp_email", getEmail);
				return mav;
			} 
			else 
			{
				ModelAndView mav = new ModelAndView("User/user_forgot_password.jsp");
				mav.addObject("failEmail", "Email is Not Found");
				return mav;
			}
		}

	@RequestMapping("/verify_otp")
	public ModelAndView verifyOTP(@RequestParam String otp, HttpSession session) {
			String gen_otp = (String) session.getAttribute("gen_otp");
			if (gen_otp.equals(otp)) {
				ModelAndView mav = new ModelAndView("User/user_change_password.jsp");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("User/user_verify_otp.jsp");
				mav.addObject("failOTP", "Invalid OTP");
				return mav;
			}
		}

	@RequestMapping("/confirm_pwd")
	public ModelAndView confirmPassword(@RequestParam String password, @RequestParam String confirm_password,
			HttpSession session) {
			User user = (User) session.getAttribute("otp_email");
			if (user != null) {
				if (password.equals(confirm_password)) {
					ModelAndView mav = new ModelAndView("User/user_login.jsp");
					user.setPassword(confirm_password);
					userDao.SaveAndUpdateUser(user);
					mav.addObject("passwordChange", "Password has been successfully change!");
					return mav;
				} else {
					ModelAndView mav = new ModelAndView("User/user_change_password.jsp");
					mav.addObject("passwordNotMatch", "Password and Confirm Password Should be Same.");
					return mav;
				}
			}
			return null;
		}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest req) {
		Object object = session.getAttribute("userId");
		if (object != null) {
			session.invalidate();
			ModelAndView mav = new ModelAndView("Main/index.jsp");
			return mav;
		}
		ModelAndView mav = new ModelAndView("User/user_login.jsp");
		mav.addObject("userlogout", "Enter Email and Password First!");
		return mav;
	}

	@GetMapping("/userProfile")
	public ModelAndView userProfile(HttpSession session) {
		Object usersession = session.getAttribute("userId");
		if (usersession != null) {
			int userId = (int) session.getAttribute("userId");
			User user = new UserDaoImplement().FetchUserByID(userId);
			if (user != null) {
				ModelAndView mav = new ModelAndView("User/user_profile.jsp");
				session.setAttribute("profile", user);
				return mav;
			}
		}
		ModelAndView mav = new ModelAndView("User/user_login.jsp");
		mav.addObject("profile", "Enter Email and Password First!");
		return mav;
	}

	@GetMapping("/userViewCart")
	public ModelAndView userViewCart(HttpSession session) {
		Object object = session.getAttribute("userId");
		if (object != null) {
			ModelAndView mav = new ModelAndView("User/view_cart.jsp");
			return mav;
		}
		ModelAndView mav = new ModelAndView("User/user_login.jsp");
		mav.addObject("viewCart", "Enter Email and Password First!");
		return mav;
	}
}
