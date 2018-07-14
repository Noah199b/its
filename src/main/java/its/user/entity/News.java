package its.user.entity;

import java.util.Date;

public class News {
	private int id;
	private int type;
	private int newsType;
	private String link;
	private String title;
	private String subTitle;
	private byte[] content;
	private int totalVisits=0;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewsType() {
		return newsType;
	}
	public void setNewsType(int newsType) {
		this.newsType = newsType;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public int getTotalVisits() {
		return totalVisits;
	}
	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", type=" + type + ", newsType=" + newsType + ", link=" + link + ", title=" + title
				+ ", subTitle=" + subTitle + ", content=" + content + ", totalVisits=" + totalVisits + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser="
				+ modifiedUser + "]";
	}
	
}
