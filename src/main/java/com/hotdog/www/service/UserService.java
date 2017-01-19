package com.hotdog.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.mail.SendMail;
import com.hotdog.www.repository.BlogDao;
import com.hotdog.www.repository.UserDao;
import com.hotdog.www.vo.BlogVo;
import com.hotdog.www.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public int join(UserVo userVo){
		return userDao.insert(userVo);
	}
	
	public void insert(UserVo userVo){
		UserVo vo1 = getId(userVo.getEmail());
		BlogVo blogVo = new BlogVo();
		blogVo.setUsersNo(vo1.getUsers_no());
		blogVo.setTitle(vo1.getNickname() + "블로그");
		blogVo.setLogoImage("a.jpg");
		System.out.println(vo1);
		
		System.out.println(blogVo);
		System.out.println("유저서비스 블로그생성");
		blogDao.insert(blogVo);
	}
	
	public UserVo getId(String email){
		return userDao.getId(email);
	}
	
	public UserVo getUser(Long no){
		return userDao.get(no);
	}
	
	public boolean idExist(String email) {
		if (userDao.idExist(email) != null) {
			System.out.println("idExist");
			return true;
		}
		return false;
	}
	
	public UserVo login(String email, String pass_word, String nickname){
		UserVo authUser = userDao.selectForLogin(email, pass_word, nickname);
		System.out.println("loginService");
		return authUser;
	}
	
	public void sendCode(String email,int code){
		SendMail sendMail = new SendMail();
		sendMail.sendMail(email, code);
	}
	
	public boolean checkCode(int inputCode,int code){
		
		if(inputCode==code){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
