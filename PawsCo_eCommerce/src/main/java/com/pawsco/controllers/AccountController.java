package com.pawsco.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawsco.business.Order;
import com.pawsco.business.User;
import com.pawsco.db.orders.OrderJDBCTemplate;
import com.pawsco.db.users.UserJDBCTemplate;

@Controller
public class AccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public User user;
	@Autowired
	public UserJDBCTemplate userDB;
	@Autowired
	OrderJDBCTemplate orderDB;
	@Autowired
	public Order order;

	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "home"; // default action
		}

		// perform action and set URL to appropriate page
		String url = "/home";
		if (action.equals("home")) {
			url = "/home";
		} else if (action.equals("registerUser")) {
			try {
				url = registerUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("logout")) {
			url = logoutUser(request, response);
		} else if (action.equals("viewCookies")) {

			url = "/view_cookies.jsp";
		} else if (action.equals("deleteCookies")) {
			url = deleteCookies(request, response);
		}
		// forward to the view
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		// perform action and set URL to appropriate page
		String url = "/home";
		if (action.equals("registerUser")) {
			try {
				url = registerUser(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// forward to the view
		response.sendRedirect("home");
	}

//	public String handleGetLogin(Model model) {
//		model.addAttribute("signin", new User());
//		return "signin";
//	}
//
//	@PostMapping(value = "login")
//	public String handlePostLogin(HttpServletRequest request, HttpServletResponse response,
//			@Valid @ModelAttribute("login") User user) throws SQLException, IOException {
//
//		return loginUser(request, response);
//	}
//
//	public String handleGetLogout(Model model) {
//		model.addAttribute("loggedOut", new User());
//		return "loggedOut";
//	}
//
//	@PostMapping(value = "logout")
//	public String handlePostLogout(HttpServletRequest request, HttpServletResponse response,
//			@Valid @ModelAttribute("logout") User user) throws SQLException, ServletException, IOException {
//
//		return logoutUser(request, response);
//	}
//
//	public String handleGetRegistration(Model model) {
//		model.addAttribute("register", new User());
//		return "register";
//	}
//
//	@PostMapping(value = "register")
//	public String handlePostRegistration(HttpServletRequest request, HttpServletResponse response,
//			@Valid @ModelAttribute("register") User user) throws SQLException {
//
//		return registerUser(request, response);
//	}

	@PostMapping(value = "register")
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		userDB = context.getBean(UserJDBCTemplate.class);

		String url = null;
		String message = null;
		// get the user data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");

		if (userDB.userExists(email)) {
			message = "This email address already exists. <br>" + "Please enter another email address.";
			request.setAttribute("message", message);

//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);

			return "register";

		} else {

			user.setEmail(email);
			user.setFirstName(firstname);
			user.setLastName(lastname);

			userDB.registerUser(email, password, firstname, lastname);
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

	@PostMapping(value = "login")
	private String loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");
		HttpSession session = request.getSession();
		userDB = context.getBean(UserJDBCTemplate.class);

		String url = null;
		// get the user data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String message;
		
		if (userDB.userExists(email) && userDB.validateUser(email, password)) {
			// store the data in a User object
			user = userDB.getUser(email);
			System.out.println(user);
			user.setEmail(email);
			

			// store the User object as a session attribute
			// HttpSession session = request.getSession();
			session.setAttribute("user", user);

			if (request.getParameter("remember") != null) {
				String remember = request.getParameter("remember");
				System.out.println("remember : " + remember);
				// add a cookie that stores the user's email to browser
				Cookie c = new Cookie("email", email);
				c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
				c.setPath("/");
				System.out.println(c.getValue());
				// allow entire app to access it
				response.addCookie(c);
			}

			message = "logging in...";
			request.setAttribute("message", message);
			
			if(user.getIsAdmin()) {
				url = "admin";
			}else {
				url = "home";
			}
			
		} else {

			message = "Email does not exist";
			request.setAttribute("message", message);
			url = "invalidLogin";
		}

		return url;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	private String logoutUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");

		userDB = context.getBean(UserJDBCTemplate.class);
		HttpSession session = request.getSession();
		session.removeAttribute("user");

		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("email")) {
				System.out.println(c.getValue());
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		return "loggedOut";
	}

	@PostMapping(value = "delete_cookies")
	private String deleteCookies(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setMaxAge(0); // delete the cookie
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		String url = "/delete_cookies.jsp";
		return url;
	}
}
