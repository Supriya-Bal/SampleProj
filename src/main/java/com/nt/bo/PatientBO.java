package com.nt.bo;


public class PatientBO {
	private Integer pId;
	private String pName;
	private String sex;
	private String pAdd;
	private Long pMob;
	private String diagnosedWith;
	//getter and setter
	public Integer getPid() {
		return pId;
	}
	public void setPid(Integer pId) {
		this.pId=pId;
	}
	
	public String getPname() {
		return pName;
	}
	public void setPname(String pName) {
		this.pName=pName;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	
	public String getPadd() {
		return pAdd;
	}
	public void setPadd(String pAdd) {
		this.pAdd=pAdd;
	}
	
	public Long getPmob() {
		return pMob;
	}
	public void setPmob(Long pMob) {
		this.pMob=pMob;
	}
	
	public String getDiagnosedWith() {
		
		return diagnosedWith;
	}
	public void setDiagnosedWith(String DiagnosedWith) {
		this.diagnosedWith=DiagnosedWith;
	}
	public String toString() {
		return "PatientBO[pId=" + pId + ", pName=" +pName+ ", sex=" + sex + ", pAdd="+ pAdd+ " , pMob="+ pMob +"]" ;
		
	}
}
