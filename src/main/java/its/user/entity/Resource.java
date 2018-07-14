package its.user.entity;

import java.util.Date;

public class Resource {
	private int id;
	private String title;
	private String description;
	private int type;
	private String path;
	private long size;
	private int downloadIntegral;
	private int downloadCount=0;
	private double score=5.0;
	private String createdUser;
	private Date createdTime;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public int getDownloadIntegral() {
		return downloadIntegral;
	}
	public void setDownloadIntegral(int downloadIntegral) {
		this.downloadIntegral = downloadIntegral;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", title=" + title + ", desc=" + description + ", type=" + type + ", path=" + path
				+ ", size=" + size + ", downloadIntegral=" + downloadIntegral + ", downloadCount=" + downloadCount
				+ ", score=" + score + ", createdUser=" + createdUser + ", createdTime=" + createdTime + "]";
	}
	
}
