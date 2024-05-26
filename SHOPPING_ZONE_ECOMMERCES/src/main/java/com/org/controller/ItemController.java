package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.ItemDao;
import com.org.dao.ProductDao;
import com.org.dao.UserDao;
import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.User;

@Controller
public class ItemController {
	@Autowired
	ProductDao productDao;

	@Autowired // here it use because we want the method of FetchUserById(), and using this
				// method
	UserDao userDao; // we can get all the details specially List<Items> because we have to set all
						// the details in it.

	@Autowired
	ItemDao itemDao;

	@GetMapping("/add_item") // Here we take the id of the product and also creating a session to get the
								// login user's ID
	public ModelAndView addtoCart(@RequestParam int productId, HttpSession session) {
		// Here we are using the method of FetchProductById() which is present in
		// ProductDao and pass the ID
		// Which we will get from the form
		Object object = session.getAttribute("userId");
		if (object != null) {
			Product product = productDao.FetchProductById(productId);
			// Now we will create the empty object and set the values.
			Item item = new Item();
			item.setName(product.getName()); // While setting the put the Product details because
			item.setPrice(product.getPrice()); // Product details and Items details are same, so we just get
			item.setCategory(product.getCategory()); // the data of Product and set the product data into
			item.setDescription(product.getDescription()); // items's object.
			item.setStockLeft(product.getStockLeft());
			item.setProductid(productId);

			int userId = (int) session.getAttribute("userId"); // get the user id of only the login user id.
			User user = userDao.FetchUserByID(userId); // by using userDao we can fetch all the details of user
			List<Item> items = user.getItems(); // Here we are taking only user's Item details, because we have
			// to insert all details of product into the Item.
			items.add(item); // Here we are just add all the data into the List<Item>.

			user.setItems(items); // here we are inserting the data into the Item, which is already present in the
									// user's details
			item.setUser(user);
			// here we are setting the items into the user's id.
			// The main motive of this 2 lines are, for an example User has a cart and user
			// want to add the
			// items into it so that's why we use user.setItems(item).
			// After adding items we have to set that the cart which contains lot of items
			// are belonging
			// to the same user which add the items in cart, for thats why we use
			// item.setUser(user)
			// to verify that all items belongs to user.

			itemDao.SaveAndUpdateItems(item); // after all adding the data into items we have save
			// the data, so for that we user itemDao and get the method, and put the
			// object of item into that.

			ModelAndView mav = new ModelAndView("User/user_home.jsp");
			mav.addObject("success", "Item Added successfully");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("User/user_login.jsp");
			mav.addObject("add_item_fail", "Enter Email & Password First !");
			return mav;
		}
	}

	@GetMapping("/remove_item")
	public ModelAndView removeItem(@RequestParam int itemId) {
		itemDao.RemoveItemById(itemId);
		ModelAndView mav = new ModelAndView("User/view_cart.jsp");
		return mav;
	}

	@GetMapping("/buy_item")
	public ModelAndView buyItem(@RequestParam int productId, HttpSession session) {
		Product product = productDao.FetchProductById(productId);
		session.setAttribute("buy", product);
		ModelAndView modelAndView = new ModelAndView("User/user_payment.jsp");
		return modelAndView;
	}

	@GetMapping("/confirm_buy")
	public ModelAndView confirmbuy(HttpSession session) {
		Object obj = session.getAttribute("userId");
		if (obj != null) {
			Product product = (Product) session.getAttribute("buy");
			int stockLeft = product.getStockLeft();
			stockLeft = stockLeft - 1;
			product.setStockLeft(stockLeft);
			productDao.SaveAndUpdateProduct(product);
			ModelAndView mav = new ModelAndView("User/user_home.jsp");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("User/user_payment.jsp");
			mav.addObject("failpayment", "Something Went Wrong !");
			return mav;
		}
	}

}
