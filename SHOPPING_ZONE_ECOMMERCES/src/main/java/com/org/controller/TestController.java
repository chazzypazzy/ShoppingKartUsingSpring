package com.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.Seller;
import com.org.dto.User;

@Controller
public class TestController 
{
	@RequestMapping("/emptyUser")
	public ModelAndView user()
	{
		User user = new User();
		ModelAndView view = new ModelAndView("User/user_register.jsp");
		view.addObject("user",user);
		return view;
	}

	@RequestMapping("/emptySeller")
	public ModelAndView seller()
	{
		Seller seller = new Seller();
		ModelAndView view = new ModelAndView("Seller/seller_register.jsp");
		view.addObject("seller",seller); 
		return view;
	}
	@RequestMapping("/emptyProduct")
	public ModelAndView emptyproduct(HttpSession s)
	{
		Object object = s.getAttribute("sellerId");
		if(object!=null)
		{
		Product product = new Product();
		ModelAndView mav = new ModelAndView("Seller/add_product.jsp");
		mav.addObject("product", product);
		return mav;
		}
		ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
		mav.addObject("etyseller","Enter Email & Password First !");
		return mav;
		
	}
	@RequestMapping("/emptyItem")
	public ModelAndView emptyItem()
	{
		Item item = new Item();
		ModelAndView view = new ModelAndView("User/add_item.jsp");
		view.addObject("item",item);
		return view;
	}

}
