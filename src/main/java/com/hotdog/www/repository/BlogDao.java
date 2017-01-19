package com.hotdog.www.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.www.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo get(int no){
		return sqlSession.selectOne("blog.get", no);
	}
	public void insert(BlogVo vo) {
		System.out.println("유저 가입하면서 블로그 인서트");
		sqlSession.insert("blog.insert", vo);
	}
	public void update(BlogVo vo) {
		sqlSession.update("blog.update", vo);
	}
	
}
