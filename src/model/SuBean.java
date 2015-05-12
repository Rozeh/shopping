package model;

import java.sql.Date;

//수동공구데이터를 저장해주는 빈클래스
public class SuBean {
	
	private int no;
	private String suname;
	private String suinfo;
	private String suimg;
	private int suprice;
	private Date sudate;
	private String sutemp;
	private String sucategory;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSuname() {
		return suname;
	}
	public void setSuname(String suname) {
		this.suname = suname;
	}
	public String getSuinfo() {
		return suinfo;
	}
	public void setSuinfo(String suinfo) {
		this.suinfo = suinfo;
	}
	public String getSuimg() {
		return suimg;
	}
	public void setSuimg(String suimg) {
		this.suimg = suimg;
	}
	public int getSuprice() {
		return suprice;
	}
	public void setSuprice(int suprice) {
		this.suprice = suprice;
	}
	public Date getSudate() {
		return sudate;
	}
	public void setSudate(Date sudate) {
		this.sudate = sudate;
	}
	public String getSutemp() {
		return sutemp;
	}
	public void setSutemp(String sutemp) {
		this.sutemp = sutemp;
	}
	public String getSucategory() {
		return sucategory;
	}
	public void setSucategory(String sucategory) {
		this.sucategory = sucategory;
	}
	
	
	

}
