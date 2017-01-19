package com.hotdog.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotdog.security.Auth;
import com.hotdog.www.DTO.JSONResult;
import com.hotdog.www.service.UserService;
import com.hotdog.www.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo vo, Model model){
		System.out.println("login");
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/join")
	public String join(@ModelAttribute UserVo vo, Model model) {
		int no = userService.join(vo);
		vo.setUsers_no(no);
		userService.insert(vo);
		return "redirect:/";
	}

	
	@Auth
	@RequestMapping("/logout")
	public String logout() {
		return "main/index";
	}
	
	// 코드 체크 
	@ResponseBody
	@RequestMapping("/checkcode")
	public Object test2(@RequestParam( value="code", required=true, defaultValue="" ) int inputCode,
							HttpServletRequest request){
		int code=(int)request.getSession().getAttribute("code");
		System.out.println("input Code: " + inputCode);
		System.out.println("code: "+ code);
		return JSONResult.success(userService.checkCode(inputCode,code)? "yes":"no");
	}
	
	
}
