package com.pawsco.controllers;	

import java.io.IOException;	
import java.util.List;	

import javax.servlet.ServletException;	
import javax.servlet.http.HttpServlet;	
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;	
import javax.servlet.http.HttpSession;	

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.context.annotation.AnnotationConfigApplicationContext;	
import org.springframework.stereotype.Controller;	
import org.springframework.web.bind.annotation.GetMapping;	
import org.springframework.web.bind.annotation.PostMapping;	
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.RequestParam;	
import org.springframework.web.servlet.ModelAndView;	

import com.pawsco.business.User;	
import com.pawsco.business.WishListItem;	
import com.pawsco.db.wishlist.WishListItemJDBCTemplate;	

@Controller	
@RequestMapping("/wishlist")	
public class WishlistController extends HttpServlet {	

	private static final long serialVersionUID = 2L;	

	@Autowired	
	private List<WishListItem> wlitem;	

	@GetMapping	
	public ModelAndView getWishlist(HttpServletRequest request, HttpServletResponse response)	
			throws IOException, ServletException {	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");	
		WishListItemJDBCTemplate wishlistDB = context.getBean(WishListItemJDBCTemplate.class);	
		// get current action	
		HttpSession session = request.getSession();	
		User user = (User) session.getAttribute("user");	
		wlitem = wishlistDB.getWishlist(user.getEmail());	
		System.out.println(wlitem);	

		ModelAndView mav = new ModelAndView();	

		List<WishListItem> wishlistItems = wishlistDB.getWishlist(user.getEmail());	


		mav.addObject("wishlist", wishlistItems);	
		mav.setViewName("wishlist");	
		((AnnotationConfigApplicationContext) context).close();	

		return mav;	
	}	

	@PostMapping	
	public ModelAndView addWishlistItem(@RequestParam String action, @RequestParam int productID, @RequestParam(required = false) Integer quantity, HttpSession session) {	

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");	
		WishListItemJDBCTemplate wishlistDB = context.getBean(WishListItemJDBCTemplate.class);	
		User user = (User) session.getAttribute("user");	
	
		wishlistDB.setWishlist(user.getEmail(), productID);	
		ModelAndView mav = new ModelAndView();	

		List<WishListItem> wishlistItems = wishlistDB.getWishlist(user.getEmail());	


		mav.addObject("wishlist", wishlistItems);	
		mav.setViewName("wishlist");	
		((AnnotationConfigApplicationContext) context).close();	

		return mav;	
	}	


}