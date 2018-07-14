package its.user.entity;

import java.util.Date;

public class Message {
	
	private int id;//消息id
	private int type=0;//0-未读 1-已读
	private String title;//消息标题
	private String content;//消息内容
	private String user;//用户
	private int flag=0;//0-未读 1-已读
	private String createdUser;//用户名
	private Date createdTime;//时间
	private int articleId;//文章id
	private int resourceId;//资源id
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", type=" + type + ", title=" + title + ", content=" + content + ", user=" + user
				+ ", flag=" + flag + ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", articleId="
				+ articleId + ", resourceId=" + resourceId + "]";
	}
	
}
