package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.ProductDao;
import com.org.dao.SellerDao;
import com.org.dto.Product;
import com.org.dto.Seller;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	SellerDao sellerDao;

	@PostMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute Product product, HttpSession session) {
		Object obj = session.getAttribute("sellerId");
		if (obj != null) {
			ModelAndView mav = new ModelAndView("Seller/add_product.jsp");
			int sellerId = (int) session.getAttribute("sellerId");
			Seller sellerById = sellerDao.FetchSellerById(sellerId);
			List<Product> products = sellerById.getProducts();
			products.add(product);
			product.setSeller(sellerById);
			productDao.SaveAndUpdateProduct(product);
			mav.addObject("success", "Product Added SuccessFully");
			return mav;
		}
		ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
		mav.addObject("addproduct", "Enter Email & Password First !");
		return mav;
	}

	@GetMapping("/update_product")
	public ModelAndView updateProduct(@RequestParam int productId, HttpSession session) {
		Object obj = session.getAttribute("sellerId");
		if (obj != null) {
			Product product = productDao.FetchProductById(productId);
			ModelAndView mav = new ModelAndView("Seller/add_product.jsp");
			mav.addObject("product", product);
			return mav;
		}
		ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
		mav.addObject("updateproduct", "Enter Email & Password First !");
		return mav;
	}

	@GetMapping("/delete_product")
	public ModelAndView deleteProduct(@RequestParam int productId,HttpSession session) {
		Object obj = session.getAttribute("sellerId");
		if(obj!=null)
		{
		productDao.deleteProduct(productId);
		ModelAndView mav = new ModelAndView("Seller/view_product.jsp");
		return mav;
		}
		ModelAndView mav = new ModelAndView("Seller/seller_login.jsp");
		mav.addObject("deleteproduct","Enter Email & Password First !");
		return mav;
	}
}
