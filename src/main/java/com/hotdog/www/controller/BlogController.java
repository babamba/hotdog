package com.hotdog.www.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotdog.www.service.BlogService;

@Controller("")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/{email}")
	public String main(@PathVariable String email, Model model){
		/*Map<String, Object> map = blogService.index(email);
		System.out.println(map);*/
		return "blog/blog-main";
	}
	
	@RequestMapping("vod")
	public String vod(){
		return "blog/vod-main";
	}

	@RequestMapping("streaming")
	public String Streaming(){
		return "blog/streaming-main";
	}
	
	@RequestMapping("account")
	public String Account(){
		return "blog/account-main";
	}
	
	
}
