package com.pawsco.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawsco.business.User;
import com.pawsco.db.users.UserJDBCTemplate;
import com.pawsco.db.users.UserMapper;

@Controller
//@RequestMapping(value = "/register")
public class AccountController {

	@Autowired
	public User user;
	@Autowired
	public UserJDBCTemplate userDB;

	@GetMapping("/myAccount")
	public String myAccount() {
		return "myAccount";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "home"; // default action
		}

		// perform action and set URL to appropriate page
		String url = "/home.jsp";
		if (action.equals("home")) {
			url = "/home.jsp";
		} else if (action.equals("register")) {
			try {
				url = registerUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("viewCookies")) {
			url = "/view_cookies.jsp";
		} else if (action.equals("deleteCookies")) {
			url = deleteCookies(request, response);
		}
		// forward to the view
		response.sendRedirect("home.jsp");
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		// perform action and set URL to appropriate page
		String url = "/home.jsp";
		if (action.equals("registerUser")) {
			try {
				url = registerUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// forward to the view
		response.sendRedirect("home.jsp");
	}

	@GetMapping(value = "/register")
	public String handleGetRegistration(Model model) {
		model.addAttribute("register", new User());
		return "register";
	}

	@PostMapping(value = "register")
	public String handlePostRegistration(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("register") User user) throws SQLException {

		return registerUser(request, response);

	}
//	@RequestMapping(value="/register", method = RequestMethod.GET)
//	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("register");
//		mav.addObject("user", new User());
//		mav.addObject("UserDB", new UserJDBCTemplate());
//		return mav;
//
//	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		UserMapper map = new UserMapper();
		UserJDBCTemplate userjdbc = context.getBean(UserJDBCTemplate.class);

		String url = null;
		String message = null;
		// get the user data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");

		if (userjdbc.userExists(email)) {
			message = "This email address already exists. <br>" + "Please enter another email address.";
			request.setAttribute("message", message);
			return "register";

		} else {
			User user = new User();
			user.setEmail(email);
			user.setFirstName(firstname);
			user.setLastName(lastname);

			userjdbc.registerUser(email, password, firstname, lastname);
			// store the User object as a session attribute
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// add a cookie that stores the user's email to browser
			Cookie c = new Cookie("email", email);
			c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
			c.setPath("/"); // allow entire app to access it
			response.addCookie(c);
			return "home";

		}

	}

	private String deleteCookies(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		User user = (User) session.getAttribute("user");
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0); // delete the cookie
			cookie.setPath("/");
			response.addCookie(cookie);

		}

		String url = "/delete_cookies.jsp";
		return url;
	}

}
