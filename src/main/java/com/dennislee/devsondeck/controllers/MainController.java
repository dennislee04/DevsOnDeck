package com.dennislee.devsondeck.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dennislee.devsondeck.models.Organization;
import com.dennislee.devsondeck.models.User;
import com.dennislee.devsondeck.services.OrganizationService;
import com.dennislee.devsondeck.services.PositionService;
import com.dennislee.devsondeck.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private OrganizationService oService;
	
	@Autowired
	private PositionService pService;

	@RequestMapping("/devs/register")
	public String registerDev(@ModelAttribute("user") User user){
		return "registerDev.jsp";
	}
	
	@PostMapping("/devs/register")
	public String registerDeveloper(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			// if there are any validation errors
			// we want to return them to the register dev page
			return "registerDev.jsp";
		}
		else {
			User user = this.uService.registerUser(newUser);
			session.setAttribute("user_s", user);
			return "redirect:/devs/register";
		}
	}
	
	@RequestMapping("/devs/login")
	public String devLoginPage(){
		return "devLogin.jsp";
	}
	
	@RequestMapping("/devlogin")
	public String devlogin(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if (!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/devs/login";
		}
		else {
			User user = this.uService.getByEmail(email);
			session.setAttribute("user_s", user);
			System.out.println("You have logged in as user: " + user.getFirstName() + user.getLastName());
			return "redirect:/devs/login";
		}
	}
	
	@RequestMapping("/orgs/register")
	public String registerOrg(@ModelAttribute("organization") Organization org){
		return "registerOrg.jsp";
	}
	
	@PostMapping("/orgs/register")
	public String registerOrganization(@Valid @ModelAttribute("organization") Organization newOrg, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			// if there are any validation errors
			// we want to return them to the register org page
			return "registerOrg.jsp";
		}
		else {
			Organization org = this.oService.registerOrg(newOrg);
			session.setAttribute("organization_s", org);
			return "redirect:/orgs/register";
		}
	}
	
	@RequestMapping("/orgs/login")
	public String orgLoginPage(){
		return "orgLogin.jsp";
	}
	
	@RequestMapping("/orglogin")
	public String orglogin(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if (!this.oService.authenticateOrg(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/orgs/login";
		}
		else {
			Organization org = this.oService.getByEmail(email);
			session.setAttribute("organization_s", org);
			System.out.println("You have logged in as Organization:" + org.getOrgName());
			return "redirect:/orgs/login";
		}
	}
}
