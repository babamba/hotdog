package com.hotdog.www.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.www.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public int insert(UserVo userVo){
		sqlSession.insert("user.insert", userVo);
		System.out.println(userVo);
		return userVo.getUsers_no();
	}
	
	public UserVo get(Long no){
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public UserVo getId(String email){
		return sqlSession.selectOne("user.getById", email);
	}
	
	public UserVo idExist(String email) {
		UserVo authUser = sqlSession.selectOne("user.idExist", email);
		return authUser;
	}
	
	public UserVo selectForLogin(String email, String pass_word, String nickname){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("pass_word", pass_word);
		map.put("nickname", nickname);
		UserVo authUser = sqlSession.selectOne("user.selectForLogin",map);
		System.out.println("UserDao login");
		return authUser;
	}
	
}
