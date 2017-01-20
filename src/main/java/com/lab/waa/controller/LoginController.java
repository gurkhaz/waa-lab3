package com.lab.waa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lab.waa.model.Users;
import com.lab.waa.service.LoginService;

@Controller
@SessionAttributes("user")

public class LoginController {

	@Autowired
	LoginService loginservice;

	@RequestMapping(value = "/")
	public String getHome() {

		return "redirect:login";
	}

	@RequestMapping(value = "/login")
	public String getLoginForm(Model model) {
		System.out.println("Here");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@CookieValue(value = "userName", defaultValue = "") String userName,
			@ModelAttribute Users user, Model model, boolean rememberMe, HttpServletRequest request,
			HttpServletResponse response) {

		if (loginservice.authenticateUser(user)) {

			if (rememberMe && userName.isEmpty()) {

				Cookie cookie = new Cookie("userName", user.getUserName());
				cookie.setMaxAge(30 * 24 * 60 * 60);
				response.addCookie(cookie);

			} else if (!rememberMe) {

				Cookie cookie = new Cookie("userName", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);

			}

			model.addAttribute("user", user);
			System.out.println("Here");
			return "redirect:/welcome";

		} else {

			model.addAttribute("err_msg", "username and/or passord invlaid.");
			return "login";

		}

	}

	@RequestMapping(value = "/welcome")
	public String getWelcome(Model model) {

		return "welcome";

	}

	@RequestMapping(value = "/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "login";
	}

}
