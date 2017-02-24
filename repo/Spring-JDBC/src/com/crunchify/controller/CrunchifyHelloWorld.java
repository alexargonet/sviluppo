package com.crunchify.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.security.Principal;
import java.util.List;
import com.crunchify.controller.*;

import cpm.crunchify.model.Materiale;
 
/*
 * author: Crunchify.com
 * 
 */
 
@Controller
public class CrunchifyHelloWorld {
 
	@Autowired 
	MagDAO magDao;
	 
	 /*@Autowired 
	 public void getMagDao(MagDAO magDao) {
		 this.magDao = magDao;
	 }*/
	//private MagDAO magDao;
		
	 
	 
	 
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!!");
        return "welcomePage";
    }
	
	 

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public ModelAndView adminPage() {
		 	
			List<Materiale> list=magDao.listMag();
			//List<Materiale> list=null;
			return new ModelAndView("adminPage","list",list); 
	        //return "adminPage";
	    }
	 
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage(Model model ) {
	         
	        return "loginPage";
	    }
	 
	    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	    public String logoutSuccessfulPage(Model model) {
	        model.addAttribute("title", "Logout");
	        return "logoutSuccessfulPage";
	    }
	 
	    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	    public String userInfo(Model model, Principal principal) {
	 
	        // After user login successfully.
	        String userName = principal.getName();
	 
	        System.out.println("User Name: "+ userName);
	 
	        return "userInfoPage";
	    }
	 
	    @RequestMapping(value = "/403", method = RequestMethod.GET)
	    public String accessDenied(Model model, Principal principal) {
	         
	        if (principal != null) {
	            model.addAttribute("message", "Hi " + principal.getName()
	                    + "<br> You do not have permission to access this page!");
	        } else {
	            model.addAttribute("msg",
	                    "You do not have permission to access this page!");
	        }
	        return "403Page";
	    }
}
