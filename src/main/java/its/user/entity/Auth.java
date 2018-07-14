package its.user.entity;

import java.util.Date;

public class Auth {
	private int id;
	private String username;
	private String email;
	private String tel;
	private String name;
	private String idNo;
	private String edu;
	private String speciality;
	private String school;
	private String workspace;
	private String qq;
	private String wechat;
	private String frontPath;
	private String backPath;
	private String aidPath1;
	private String aidPath2;
	private String aidPath3;
	private String opinion;
	private int state=0;
	private Date createdTime;
	private Date auditTime;
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getWorkspace() {
		return workspace;
	}
	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getFrontPath() {
		return frontPath;
	}
	public void setFrontPath(String frontPath) {
		this.frontPath = frontPath;
	}
	public String getBackPath() {
		return backPath;
	}
	public void setBackPath(String backPath) {
		this.backPath = backPath;
	}
	public String getAidPath1() {
		return aidPath1;
	}
	public void setAidPath1(String aidPath1) {
		this.aidPath1 = aidPath1;
	}
	public String getAidPath2() {
		return aidPath2;
	}
	public void setAidPath2(String aidPath2) {
		this.aidPath2 = aidPath2;
	}
	public String getAidPath3() {
		return aidPath3;
	}
	public void setAidPath3(String aidPath3) {
		this.aidPath3 = aidPath3;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	@Override
	public String toString() {
		return "Auth [id=" + id + ", username=" + username + ", email=" + email + ", tel=" + tel + ", name=" + name
				+ ", idNo=" + idNo + ", edu=" + edu + ", speciality=" + speciality + ", school=" + school
				+ ", workspace=" + workspace + ", qq=" + qq + ", wechat=" + wechat + ", frontPath=" + frontPath
				+ ", backPath=" + backPath + ", aidPath1=" + aidPath1 + ", aidPath2=" + aidPath2 + ", aidPath3="
				+ aidPath3 + ", opinion=" + opinion + ", state=" + state + ", createdTime=" + createdTime
				+ ", auditTime=" + auditTime + ", getSpeciality()=" + getSpeciality() + ", getWechat()=" + getWechat()
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail()
				+ ", getTel()=" + getTel() + ", getName()=" + getName() + ", getIdNo()=" + getIdNo() + ", getEdu()="
				+ getEdu() + ", getSchool()=" + getSchool() + ", getWorkspace()=" + getWorkspace() + ", getQq()="
				+ getQq() + ", getFrontPath()=" + getFrontPath() + ", getBackPath()=" + getBackPath()
				+ ", getAidPath1()=" + getAidPath1() + ", getAidPath2()=" + getAidPath2() + ", getAidPath3()="
				+ getAidPath3() + ", getOpinion()=" + getOpinion() + ", getState()=" + getState()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getAuditTime()=" + getAuditTime() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}