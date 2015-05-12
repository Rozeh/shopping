package model;

import java.io.Serializable;

public class SuCartBean implements Serializable{

	private int no;
	private String suname;
	private int suprice;
	private int qty;
	private String suimg;
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
	public int getSuprice() {
		return suprice;
	}
	public void setSuprice(int suprice) {
		this.suprice = suprice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getSuimg() {
		return suimg;
	}
	public void setSuimg(String suimg) {
		this.suimg = suimg;
	}
	
	
}
