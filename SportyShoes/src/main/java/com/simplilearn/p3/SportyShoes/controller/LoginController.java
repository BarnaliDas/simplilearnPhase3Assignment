package com.simplilearn.p3.SportyShoes.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.p3.SportyShoes.model.User;
import com.simplilearn.p3.SportyShoes.repository.UserDao;



@Controller
public class LoginController {
	@Autowired
	UserDao userdao;
	/*@GetMapping("/")
	public String loginpage(){
		return "login";
	}
	 */
   

	@GetMapping("/")
	public String dashboard(){
		return "dashboard";
	}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginuser() {
        
        return "login";
    }
   /* @RequestMapping(value = {"/welcome"}, method = RequestMethod.POST)
    public String loginSubmit(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        if(error==null && logout==null){
        	return "welcome";

        }
        return "login";
    }*/
   /* @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }*/
    @GetMapping(value="/changePassword")
    public String showChangePassword()
    {
    	return "change-password";
    }
    
    @PostMapping(value="/saveNewPassword")
    public String saveChangedPassword(@RequestParam("oldpassword") String oldpass, @RequestParam("newpassword") String newpass, Principal principal)
    {
    	System.out.println("old pass: "+ oldpass);
    	System.out.println("new pass: "+ newpass);
    	String username= principal.getName();
    	User currentuser=this.userdao.findByUsername(username);
    	System.out.println("loggedin user password"+currentuser.getPassword());
    	if(currentuser.getPassword().equals(oldpass)){
    		currentuser.setPassword(newpass);
    		this.userdao.save(currentuser);
    	}else
    	{
    		System.out.println("error");
    	}
    	return "change-password";
    }
}
