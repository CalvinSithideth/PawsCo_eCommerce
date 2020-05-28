package com.pawsco.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
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

import com.pawsco.business.LineItem;
import com.pawsco.business.Order;
import com.pawsco.business.User;
import com.pawsco.db.orders.LineItemJDBCTemplate;
import com.pawsco.db.orders.OrderJDBCTemplate;
import com.pawsco.db.products.ProductJDBCTemplate;
import com.pawsco.db.users.UserJDBCTemplate;

@Controller
//@RequestMapping(value = "/register")
public class AccountController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public User user;
	@Autowired
	public UserJDBCTemplate userDB;
	@Autowired
	OrderJDBCTemplate orderDB;
	@Autowired
	public Order order;


	/**
	 * Gets the login page and the user object
	 * @param model
	 * @return user object to the signin page
	 */
	public String handleGetLogin(Model model) {
		model.addAttribute("signin", new User());
		return "signin";
	}
	
	/**
	 * checks to see if the login button was clicked and sets the user data into
	 * the loginUser method and sets the values to the user object and database
	 * @param request
	 * @param response
	 * @param user
	 * @return loginUser method
	 * @throws SQLException
	 */

	@PostMapping(value = "login")
	public String handlePostLogin(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("login") User user) throws SQLException {

		return loginUser(request, response);
	}

	
	/**
	 * Gets the loggedOut page and the user object
	 * @param model
	 * @return loggedout page
	 */
	public String handleGetLogout(Model model) {
		model.addAttribute("loggedOut", new User());
		return "loggedOut";
	}
	
	/**
	 * once the logout button is pressed, the post method will cal the logoutUser method and remove the
	 * user from the session
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */

	@PostMapping(value = "logout")
	public String handlePostLogout(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("logout") User user) throws SQLException, ServletException, IOException {

		return logoutUser(request, response);
	}

	/**
	 * Gets the register page and the user object
	 * @param model
	 * @return register page
	 */
	public String handleGetRegistration(Model model) {
		model.addAttribute("register", new User());
		return "register";
	}

	/**
	 * once the register button is pressed it calls the registerUser method
	 * then gets the values in the form and sets them to the user object
	 * and the database
	 * @param request
	 * @param response
	 * @param User
	 * @return registerUser method
	 * @throws SQLException
	 */
	@PostMapping(value = "register")
	public String handlePostRegistration(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("register") User user) throws SQLException {

		return registerUser(request, response);
	}


	/**
	 * sets the paramaters passed from the form in the jsp page, checks to see if the user exists in the
	 * database, if it doesn't exist it will insert that new user data into the database and redirect you to
	 * the home page with you signed in. If it does exist, it will redirect you to the register page.
	 * @param request
	 * @param response
	 * @return register or home page
	 * @throws SQLException
	 */
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

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

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

	/**
	 * gets the email from the login form and checks to see if that email exists in the user table from the database.
	 * if the user doesnt exist it will redirect you to the invalidLogin page to tell you the username or
	 * password doesnt exist
	 * @param request
	 * @param response
	 * @return login or invalidLogin page
	 * @throws SQLException
	 */
	private String loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.pawsco");

		userDB = context.getBean(UserJDBCTemplate.class);

		String url = null;
		// get the user data
		String email = request.getParameter("email");
		String message;
		// check that email address doesn't already exist
		if (userDB.userExists(email)) {
			// store the data in a User object
			user = userDB.getUser(email);
			user.setEmail(email);
			// store the User object as a session attribute
			HttpSession session = request.getSession();
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
			url = "home";
		} else {

			message = "Email does not exist";
			request.setAttribute("message", message);
			url = "invalidLogin";
		}

		return url;
	}

	/**
	 * if the signout button is pressed, the site will remove the user session and take you to the loggedOut page
	 * then after 5 seconds it will redirect you to the home page
	 * @param request
	 * @param response
	 * @return loggedOut.jsp
	 * @throws ServletException
	 * @throws IOException
	 */
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
}


//	private String deleteCookies(HttpServletRequest request, HttpServletResponse response) {
//
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				cookie.setValue("");
//				cookie.setMaxAge(0); // delete the cookie
//				cookie.setPath("/");
//				response.addCookie(cookie);
//			}
//		}
//		String url = "/delete_cookies.jsp";
//		return url;
//	}
//}
