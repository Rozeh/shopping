package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

public class Cart implements Serializable{

	//īƮ�� �������� ��ǰ�� ��� ���ؼ� 
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();

	public List<SuCartBean> getItemlist() {
		return itemlist;
	}
	
	//īƮ�� ��ǰ�� �ִ��� ���θ� �˾Ƴ���
	public boolean isEmpty(){
		
		if(this.itemlist ==null || this.itemlist.isEmpty()){
			return true;//īƮ�� �������
		}
		return false; //īƮ�� ���빰�� ����
	}
	
	//īƮ�� ��ǰ�� �߰����ִ� �޼ҵ�
	public void push(SuCartBean scbean){
		//������ ��ǰ�̸��� �ִ������θ� �ľ�
		boolean alreadysutool = false;
		
		for (SuCartBean suCartBean : itemlist) {
			//īƮ�� ���� ��ǰ�� �̸��� �����ͼ� ���� ��ǰ�� �̸��� ������
			if(scbean.getSuname().equals(suCartBean.getSuname())){
				//������ ��ǰ�� �����Ѵٸ� ������ ����
				suCartBean.setQty(suCartBean.getQty()+scbean.getQty());
				alreadysutool = true;
				break;
			}
			
		}
		//������ ��ǰ�� ���� ��쿡�� ��ǰ�� �߰� ��Ű�ÿ�
		if(alreadysutool==false){
			itemlist.add(scbean);
		}
		
	}
	//īƮ ����
	public void clearCart(){
		itemlist = new  ArrayList<SuCartBean>();
	}
	
}








