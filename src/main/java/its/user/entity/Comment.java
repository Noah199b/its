package its.user.entity;

import java.util.Date;

public class Comment{
	private int id;//评论id
	private String content;//回复内容
	private int parentId;//父评论ID
	private int articleId;//文章ID
	private int userId;//用户ID
	private String createdUser;//用户名
	private Date createdTime;//回复时间
	private String spare1;//备用字段1
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", parentId=" + parentId + ", articleId=" + articleId
				+ ", userId=" + userId + ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", spare1="
				+ spare1 + "]";
	}
	
}
