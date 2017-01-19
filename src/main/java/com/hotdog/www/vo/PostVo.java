package com.hotdog.www.vo;

public class PostVo {

	private int postNo;
	private String title;
	private String content;
	private String regDate;
	private String postImage;
	private int publish;
	private int usersNo;
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getPostImage() {
		return postImage;
	}
	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}
	public int getPublish() {
		return publish;
	}
	public void setPublish(int publish) {
		this.publish = publish;
	}
	public int getUsersNo() {
		return usersNo;
	}
	public void setUsersNo(int usersNo) {
		this.usersNo = usersNo;
	}
	
	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", postImage=" + postImage + ", publish=" + publish + ", usersNo=" + usersNo + "]";
	}
	
	
	
	
}
