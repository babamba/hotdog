package com.hotdog.www.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotdog.www.DTO.JSONResult;
import com.hotdog.www.DTO.SingletonClass;
import com.hotdog.www.service.UserService;

@Controller
@RequestMapping("/user/api")
public class UserApiController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/chkid")
	public JSONResult checkEmail(@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		boolean result = userService.idExist(email);

		SingletonClass sc = SingletonClass.getInstance();
		return JSONResult.success(result ? "exist" : "not exist");
	}
}
