package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

public class Cart implements Serializable{

	//카트에 여러개의 상품을 담기 위해서 
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();

	public List<SuCartBean> getItemlist() {
		return itemlist;
	}
	
	//카트의 상품이 있는지 여부를 알아내는
	public boolean isEmpty(){
		
		if(this.itemlist ==null || this.itemlist.isEmpty()){
			return true;//카트가 비어있음
		}
		return false; //카트에 내용물이 있음
	}
	
	//카트에 상품을 추가해주는 메소드
	public void push(SuCartBean scbean){
		//기존에 상품이름이 있는지여부를 파악
		boolean alreadysutool = false;
		
		for (SuCartBean suCartBean : itemlist) {
			//카트에 기존 상품의 이름을 가져와서 현제 상품의 이름과 비교해줌
			if(scbean.getSuname().equals(suCartBean.getSuname())){
				//동일한 상품이 존재한다면 수량만 증가
				suCartBean.setQty(suCartBean.getQty()+scbean.getQty());
				alreadysutool = true;
				break;
			}
			
		}
		//기존에 상품이 없는 경우에만 상품을 추가 시키시오
		if(alreadysutool==false){
			itemlist.add(scbean);
		}
		
	}
	//카트 비우기
	public void clearCart(){
		itemlist = new  ArrayList<SuCartBean>();
	}

	// itemlist에서 하나의 상품을 삭제하는 메소드
	public void delete(String name) {
		//반복문을 돌면서 
		for (int i = 0; i < itemlist.size(); i++) {
			//빈클래스를 리턴 받아서
			SuCartBean bean = itemlist.get(i);
			//삭제 하고자 하는 이름이 있다면 그해당번지를 list에서 삭제함
			if(bean.getSuname().equals(name)){
				itemlist.remove(i);
				break;
			}
		}
		
	}
	
}








