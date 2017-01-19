package com.hotdog.www.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotdog.www.repository.BlogDao;
import com.hotdog.www.repository.ImageDao;
import com.hotdog.www.repository.PostDao;
import com.hotdog.www.repository.UserDao;
import com.hotdog.www.vo.BlogVo;
import com.hotdog.www.vo.ImageVo;
import com.hotdog.www.vo.PostVo;
import com.hotdog.www.vo.UserVo;

@Service
public class BlogService {
	
	private static final String SAVE_PATH = "c:\\upload";

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private ImageDao imageDao;
	
	
	public ImageVo selectByNo(int no){
		return imageDao.selectByNo(no);
	}
	
	public BlogVo getByNickname(String email, String nickname) {
		Integer no =  null;
		UserVo authUser = userDao.idExist(email);
		if (authUser != null) {
			no = authUser.getUsers_no();
		}
		BlogVo blogVo = blogDao.get(no);
		return blogVo;
	}
	
	public int insertImage(ImageVo imageVo) {
		return imageDao.insert(imageVo);
	}
	
	public UserVo getId(String email){
		return userDao.getId(email);
	}
	

/*	public Map<String, Object> index(String email){
		Integer usersNo = null;
		
		UserVo authUser = userDao.idExist(email);
		if(authUser != null){
			usersNo = authUser.getUsersNo();
		} 
		
		Map<String, Object> map = null;
		map = new HashMap<String, Object>();
		
		List<PostVo> postlist = postDao.getList(usersNo);
		map.put("post", postlist);
		
		
		return map;
		
		
		
	}*/
	
	public void restore(MultipartFile file, BlogVo blogVo) {
		String saveFileName = "";
		try {
			if (file.isEmpty() == true) {
				return;
			}

			String orgFileName = file.getOriginalFilename();
			String extName = orgFileName.substring(orgFileName.lastIndexOf('.') + 1);
			saveFileName = generateSaveFileName(extName);

			writeFile(file, saveFileName);
			blogVo.setLogoImage(saveFileName);
			blogDao.update(blogVo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void restore(MultipartFile file, Long userNo) {
		String saveFileName = "";
		try {
			if (file.isEmpty() == true) {
				return;
			}

			String orgFileName = file.getOriginalFilename();
			String extName = orgFileName.substring(orgFileName.lastIndexOf('.') + 1);
			saveFileName = generateSaveFileName(extName);

			writeFile(file, saveFileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += "." + extName;
		return fileName;
	}

	private void writeFile(MultipartFile file, String saveFileName) throws IOException {
		byte[] fileData = file.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.close();
	}
	
	
	
	
	
	
}
