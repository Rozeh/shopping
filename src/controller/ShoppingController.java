package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.AutoBean;
import model.MemberBean;
import model.SuBean;
import model.SuCartBean;
import model.SutoolDAO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class ShoppingController {

	SutoolDAO sutoolDao;	

	public void setSutoolDao(SutoolDAO sutoolDao) {
		this.sutoolDao = sutoolDao;
	}

	@RequestMapping("/sujak.do")

	public ModelAndView suJak(String num){

		ModelAndView mav = new ModelAndView();
		//��� ��û�� ���Դ����� ���� ������ ���ͼ� �ش� model�� �����Ͽ� �����͸� ����������
		if(num==null){ // ����ǰ - ��� ���������� ȭ�鿡 �����ֽÿ�			
			List<SuBean> v = sutoolDao.getAllSutool();
			mav.addObject("v", v);
		}else { // ���������� ȭ�鿡 �����ֽÿ�			
			List<SuBean> v = sutoolDao.getSelectAllSutool(num);
			mav.addObject("v", v);
		}	

		mav.addObject("center","Sujak1.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");		

		return mav;
	}

	//���۾� ���� �ϳ��� �����ϴ� �޼ҵ�
	@RequestMapping("/suinfo")
	public ModelAndView suInfo(int no){

		SuBean sbean = sutoolDao.getOneSutool(no);

		ModelAndView mav = new ModelAndView();
		mav.addObject("center","SutoolInfo.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.addObject("sbean", sbean);
		mav.setViewName("ShoppingMain");		

		return mav;
	}

	@RequestMapping("/sutoolcart.do")
	public ModelAndView sutoolCart(int no , int qty , HttpSession session){

		//������ ���̽������� īƮ�� ������ �����͸� �о����� �մϴ�.
		SuCartBean scbean= sutoolDao.getSuCart(no);
		scbean.setQty(qty);

		//īƮ�� ����ϱ����� ����
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			//������ �������
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//īƮ�� ��ǰ�� �߰�
		cart.push(scbean);
		//īƮ�� ������ �����ִ� jsp������ ȣ��
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", scbean.getSuname() +" �� ��ǰ�� "+qty+"�� īƮ�� �߰��߽��ϴ�.");
		mav.addObject("cart", cart);
		mav.addObject("center","CartResult.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");	
		return mav;

	}

	//���ĸ� �Ұ� �������� ȣ���ϴ� �޼ҵ�
	@RequestMapping("/stanlyinfo.do")
	public ModelAndView stanlyInfo(String name){
		//�迭�� �̹����� �̸��� ���
		String [] imgarr={"stanlycenterinfo","stanlycenterhistory1",
				"stanlycenterglobal","stanlycentercompany"};
		String [] history={"stanlycenterhistory1","stanlycenterhistory2",
				"stanlycenterhistory3","stanlycenterhistory4"};
		if(name == null){
			name="0";
		}		

		if(name=="1"){
			ModelAndView mav = new ModelAndView();
			mav.addObject("name",name);
			mav.addObject("history", history);
			mav.addObject("center","StanlyInfoMain.jsp");
			mav.addObject("left","StanlyInfoLeft.jsp");
			mav.setViewName("ShoppingMain");
			return mav;
		}else{

			ModelAndView mav = new ModelAndView();
			mav.addObject("imgname", imgarr[Integer.parseInt(name)]);
			mav.addObject("center","StanlyInfoMain.jsp");
			mav.addObject("left","StanlyInfoLeft.jsp");
			mav.setViewName("ShoppingMain");
			return mav;
		}
	}
	//��������
	@RequestMapping("/tooluse.do")
	public ModelAndView toolUse(String name){
		//�迭�� �̹����� �̸��� ���
		String [] imgarr={"tool1","tool2","tool3","tool4","tool5","tool6"
				,"tool7","tool8-1","tool9","tool10"};
		if(name == null){
			name="0";
		}		
		ModelAndView mav = new ModelAndView();
		mav.addObject("imgname", imgarr[Integer.parseInt(name)]);
		mav.addObject("center","ToolUseMain.jsp");
		mav.addObject("left","ToolUseLeft.jsp");
		mav.setViewName("ShoppingMain");
		return mav;

	}

	//���������� �����ִ� �޼ҵ�
	@RequestMapping("/jundong.do")

	public ModelAndView junDong(String num){

		ModelAndView mav = new ModelAndView();
		//��� ��û�� ���Դ����� ���� ������ ���ͼ� �ش� model�� �����Ͽ� �����͸� ����������
		if(num==null){ // ����ǰ - ��� ���������� ȭ�鿡 �����ֽÿ�			
			List<AutoBean> v = sutoolDao.getAllAutotool();
			mav.addObject("v", v);
		}else { // ���������� ȭ�鿡 �����ֽÿ�			
			List<AutoBean> v = sutoolDao.getSelectAllAutotool(num);
			mav.addObject("v", v);
		}	

		mav.addObject("center","AutoToolMain.jsp");
		mav.addObject("left","AutoToolLeft.jsp");
		mav.setViewName("ShoppingMain");		

		return mav;
	}

	//���� ���� �ϳ��� �����ϴ� �޼ҵ�
	@RequestMapping("/autoinfo.do")
	public ModelAndView autoInfo(int no){

		AutoBean autobean = sutoolDao.getOneAutotool(no);

		ModelAndView mav = new ModelAndView();
		mav.addObject("center","AutoToolInfo.jsp");
		mav.addObject("left","AutoToolLeft.jsp");
		mav.addObject("autobean", autobean);
		mav.setViewName("ShoppingMain");		

		return mav;
	}

	//���������� ������ īƮ�� �ֱ�
	@RequestMapping("/autotoolcart.do")
	public ModelAndView autotoolCart(int autono , int qty , HttpSession session){

		//������ ���̽������� īƮ�� ������ �����͸� �о����� �մϴ�.
		AutoBean autobean = sutoolDao.getOneAutotool(autono);

		SuCartBean scbean= new SuCartBean();		
		scbean.setQty(qty);
		scbean.setNo(autobean.getAutonum());
		scbean.setSuimg(autobean.getAutoimg());
		scbean.setSuname(autobean.getAutoname());
		scbean.setSuprice(autobean.getAutoprice());

		//īƮ�� ����ϱ����� ����
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			//������ �������
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//īƮ�� ��ǰ�� �߰�
		cart.push(scbean);
		//īƮ�� ������ �����ִ� jsp������ ȣ��
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", scbean.getSuname() +" �� ��ǰ�� "+qty+"�� īƮ�� �߰��߽��ϴ�.");
		mav.addObject("cart", cart);
		mav.addObject("center","CartResult.jsp");
		mav.addObject("left","AutoToolLeft.jsp");
		mav.setViewName("ShoppingMain");	
		return mav;

	}

	//���� ���� ��ǰ�����ϱ�
	@RequestMapping("/sutoolbuy.do")
	public ModelAndView sutoolBuy(SuBean subean, HttpSession session){

		ModelAndView mav = new ModelAndView();
		//ȸ�� ������ ����ϱ����� ����
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");
		if(mbean == null){

			mav.addObject("msg","2");
			mav.addObject("center","MemberJoinForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");

		}

		return mav;
	}

	//ȸ�� ����ó��
	@RequestMapping("/joinproc.do")
	public ModelAndView joinProc(MemberBean mbean ,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//�н����� Ȯ��
		if(mbean.getPasswd1().equals(mbean.getPasswd2())){	
			mbean.setPasswd(mbean.getPasswd1());
			//bean�� ����� ȸ�� ������ DAO(model)Ŭ������ �Ѱ���
			sutoolDao.insertMember(mbean);			
			//ȸ���� ���� ������ ���ǿ� �����ؾ� �մϴ�.
			session.setAttribute("mbean", mbean);
			//���� ���� �ð��� ����
			session.setMaxInactiveInterval(60*30);//30���� �ǹ�
			mav.setViewName("ShoppingMain");

		}else {//��й�ȣ�� Ʋ���ٸ�
			mav.addObject("msg", "1");
			mav.addObject("center","MemberJoinForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		}		
		return mav;
	}

	//�������θ��� ó�� ���� �κ�
	@RequestMapping("/index.do")
	public ModelAndView index(HttpSession session){

		ModelAndView mav = new ModelAndView();
		//ȸ�� ������ ����ϱ����� ����
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");
		if(mbean == null){//top.jsp ���� �α��� ������ ó���ϱ����� �ҽ�
			mav.addObject("mbean",null);
			mav.setViewName("ShoppingMain");
		}else{
			mav.addObject("mbean",mbean);
			mav.setViewName("ShoppingMain");
		}

		return mav;
	}
	
	@RequestMapping("/login.do")
	 public ModelAndView login(){
	  ModelAndView mav = new ModelAndView();
	  mav.addObject("center","MemberLogin.jsp");
	  mav.addObject("left","SujakLeft.jsp");
	  mav.setViewName("ShoppingMain");
	  return mav;
	 }
	
	 @RequestMapping("/loginproc.do")
	 public ModelAndView loginProc(HttpSession session , MemberBean mbean){
	  ModelAndView mav = new ModelAndView();
	  //������ ���̽��� �����ؼ� �ش� ���̵�� �н����尡 �ִ����� �ľ�����
	  //������ ���̽��� ���̵�� �н����尡 ��ġ �Ұ��
	  int result = sutoolDao.getLogin(mbean);
	  if(result==1){   
	   //�α����� ���� ��Ű���� Session��ü�� ����Ͻÿ�
	   session.setAttribute("mbean", mbean);
	   return new ModelAndView(new RedirectView("index.do"));
	  }
	  else {//�α��������� Ʋ�����
	   mav.addObject("center","MemberLogin.jsp");
	   mav.addObject("left","SujakLeft.jsp");
	   mav.setViewName("ShoppingMain");
	   mav.addObject("login" ,"1"); 
	   return mav;
	  }  
	
	 }
	 @RequestMapping("/logout.do")
	 public ModelAndView logoutProc(HttpSession session){
		 //ȸ�������� ���������� ����
		 MemberBean mbean = (MemberBean)session.getAttribute("mbean"); 
		 session.setAttribute("mbean", null);
		 return new ModelAndView(new RedirectView("index.do"));
	 }
}








