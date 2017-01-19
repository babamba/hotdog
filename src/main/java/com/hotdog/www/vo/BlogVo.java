package com.hotdog.www.vo;

public class BlogVo {

	private int usersNo;
	private String title;
	private String logoImage;
	
	public int getUsersNo() {
		return usersNo;
	}
	public void setUsersNo(int usersNo) {
		this.usersNo = usersNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogoImage() {
		return logoImage;
	}
	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}
	
	@Override
	public String toString() {
		return "BlogVo [usersNo=" + usersNo + ", title=" + title + ", logoImage=" + logoImage + "]";
	}
	

	
	
	
}
