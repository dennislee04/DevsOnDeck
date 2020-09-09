package com.dennislee.devsondeck.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dennislee.devsondeck.models.Organization;
import com.dennislee.devsondeck.models.User;
import com.dennislee.devsondeck.services.OrganizationService;
import com.dennislee.devsondeck.services.PositionService;
import com.dennislee.devsondeck.services.UserService;
import com.dennislee.devsondeck.uservalidator.OrgValidator;
import com.dennislee.devsondeck.uservalidator.UserValidator;

@Controller
public class MainController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private OrganizationService oService;
	
	@Autowired
	private PositionService pService;
	
	@Autowired
	private UserValidator uValidator;
	
	@Autowired
	private OrgValidator oValidator;

	@RequestMapping("/devs/register")
	public String registerDev(@ModelAttribute("user") User user){
		return "registerDev.jsp";
	}
	
	@PostMapping("/devs/register")
	public String registerDeveloper(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
		uValidator.validate(newUser, result);
		if (result.hasErrors()) {
			// if there are any validation errors
			// we want to return them to the register dev page
			return "registerDev.jsp";
		}
		else {
			User user = this.uService.registerUser(newUser);
			session.setAttribute("user_s", user);
			return "redirect:/devs/skills/languages";
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
//			System.out.println("You have logged in as user: " + user.getFirstName() + user.getLastName());
			return "redirect:/devs/skills/languages";
		}
	}
	
//	@RequestMapping("/devs/skills/languages")
//	public String languagesPage(Model viewModel, HttpSession session) {
//		User user = (User) session.getAttribute("user_s");
//		session.setAttribute("user_s", user);
//		viewModel.addAttribute("user", user);
//		return "language.jsp";
//	}
	
	@GetMapping("/devs/skills/{type}")
	public String userProfile(@PathVariable("type") String type, HttpSession session, Model viewModel) {
		User user = (User) session.getAttribute("user_s");
		if(user == null) {
			return "redirect:/devs/login";
		}
		else {
			session.setAttribute("user_s", user);
			viewModel.addAttribute("user", user);
			viewModel.addAttribute("type", type);
			if (type.equals("languages") || type.equals("frameworks")){
				return "userDashboard.jsp";
			}
			else {
				return "redirect:/devs/login";
			}
		}
	}
	
	@RequestMapping("/orgs/register")
	public String registerOrg(@ModelAttribute("organization") Organization org){
		return "registerOrg.jsp";
	}
	
	@PostMapping("/orgs/register")
	public String registerOrganization(@Valid @ModelAttribute("organization") Organization newOrg, BindingResult result, HttpSession session) {
		oValidator.validate(newOrg, result);
		if (result.hasErrors()) {
			// if there are any validation errors
			// we want to return them to the register org page
			return "registerOrg.jsp";
		}
		else {
			Organization org = this.oService.registerOrg(newOrg);
			session.setAttribute("organization_s", org);
			return "redirect:/orgs/dashboard";
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
//			System.out.println("You have logged in as Organization:" + org.getOrgName());
			return "redirect:/orgs/dashboard";
		}
	}
	
	@RequestMapping("/orgs/dashboard")
	public String orgDashbaord(Model viewModel, HttpSession session) {
		Organization organization = (Organization) session.getAttribute("organization_s");
		if (organization == null) {
			return "redirect:/orgs/login";
		}
		else {
			session.setAttribute("organization_s", organization);
			viewModel.addAttribute("organization", organization);
			return "orgDashboard.jsp";
		}
	}
	
	@RequestMapping("/logout/org")
	public String logoutOrg(HttpSession session) {
		session.invalidate();
		return "redirect:/orgs/login";
	}
	
	@RequestMapping("/logout/dev")
	public String logoutDev(HttpSession session) {
		session.invalidate();
		return "redirect:/devs/login";
	}
}
