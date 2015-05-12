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
		//어느 요청이 들어왔는지에 대한 정보를 얻어와서 해당 model에 접근하여 데이터를 가져오도록
		if(num==null){ // 신제품 - 모든 수동공구를 화면에 보여주시오			
			List<SuBean> v = sutoolDao.getAllSutool();
			mav.addObject("v", v);
		}else { // 수동공구를 화면에 보여주시오			
			List<SuBean> v = sutoolDao.getSelectAllSutool(num);
			mav.addObject("v", v);
		}	

		mav.addObject("center","Sujak1.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");		

		return mav;
	}

	//수작업 공구 하나를 리턴하는 메소드
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

		//데이터 베이스에가서 카트에 저장할 데이터를 읽어드려야 합니다.
		SuCartBean scbean= sutoolDao.getSuCart(no);
		scbean.setQty(qty);

		//카트를 사용하기위한 설정
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			//세션을 만들어줌
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//카트에 상품을 추가
		cart.push(scbean);
		//카트의 내용을 보여주는 jsp페이지 호출
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", scbean.getSuname() +" 의 상품을 "+qty+"개 카트에 추가했습니다.");
		mav.addObject("cart", cart);
		mav.addObject("center","CartResult.jsp");
		mav.addObject("left","SujakLeft.jsp");
		mav.setViewName("ShoppingMain");	
		return mav;

	}

	//스탠리 소개 페이지를 호출하는 메소드
	@RequestMapping("/stanlyinfo.do")
	public ModelAndView stanlyInfo(String name){
		//배열에 이미지의 이름을 담기
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
	//공구사용법
	@RequestMapping("/tooluse.do")
	public ModelAndView toolUse(String name){
		//배열에 이미지의 이름을 담기
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

	//전동공구를 보여주는 메소드
	@RequestMapping("/jundong.do")

	public ModelAndView junDong(String num){

		ModelAndView mav = new ModelAndView();
		//어느 요청이 들어왔는지에 대한 정보를 얻어와서 해당 model에 접근하여 데이터를 가져오도록
		if(num==null){ // 신제품 - 모든 전동공구를 화면에 보여주시오			
			List<AutoBean> v = sutoolDao.getAllAutotool();
			mav.addObject("v", v);
		}else { // 수동공구를 화면에 보여주시오			
			List<AutoBean> v = sutoolDao.getSelectAllAutotool(num);
			mav.addObject("v", v);
		}	

		mav.addObject("center","AutoToolMain.jsp");
		mav.addObject("left","AutoToolLeft.jsp");
		mav.setViewName("ShoppingMain");		

		return mav;
	}

	//전동 공구 하나를 리턴하는 메소드
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

	//전동공구의 내용을 카트에 넣기
	@RequestMapping("/autotoolcart.do")
	public ModelAndView autotoolCart(int autono , int qty , HttpSession session){

		//데이터 베이스에가서 카트에 저장할 데이터를 읽어드려야 합니다.
		AutoBean autobean = sutoolDao.getOneAutotool(autono);

		SuCartBean scbean= new SuCartBean();		
		scbean.setQty(qty);
		scbean.setNo(autobean.getAutonum());
		scbean.setSuimg(autobean.getAutoimg());
		scbean.setSuname(autobean.getAutoname());
		scbean.setSuprice(autobean.getAutoprice());

		//카트를 사용하기위한 설정
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			//세션을 만들어줌
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		//카트에 상품을 추가
		cart.push(scbean);
		//카트의 내용을 보여주는 jsp페이지 호출
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", scbean.getSuname() +" 의 상품을 "+qty+"개 카트에 추가했습니다.");
		mav.addObject("cart", cart);
		mav.addObject("center","CartResult.jsp");
		mav.addObject("left","AutoToolLeft.jsp");
		mav.setViewName("ShoppingMain");	
		return mav;

	}

	//수동 공구 제품구매하기
	@RequestMapping("/sutoolbuy.do")
	public ModelAndView sutoolBuy(SuBean subean, HttpSession session){

		ModelAndView mav = new ModelAndView();
		//회원 정보를 사용하기위한 설정
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");
		if(mbean == null){

			mav.addObject("msg","2");
			mav.addObject("center","MemberJoinForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");

		}

		return mav;
	}

	//회원 가입처리
	@RequestMapping("/joinproc.do")
	public ModelAndView joinProc(MemberBean mbean ,HttpSession session){
		ModelAndView mav = new ModelAndView();
		//패스워드 확인
		if(mbean.getPasswd1().equals(mbean.getPasswd2())){	
			mbean.setPasswd(mbean.getPasswd1());
			//bean에 담겨진 회원 정보를 DAO(model)클래스에 넘겨줌
			sutoolDao.insertMember(mbean);			
			//회원에 대한 정보를 세션에 저장해야 합니다.
			session.setAttribute("mbean", mbean);
			//세션 유지 시간을 설정
			session.setMaxInactiveInterval(60*30);//30분을 의미
			mav.setViewName("ShoppingMain");

		}else {//비밀번호가 틀리다면
			mav.addObject("msg", "1");
			mav.addObject("center","MemberJoinForm.jsp");
			mav.addObject("left","SujakLeft.jsp");
			mav.setViewName("ShoppingMain");
		}		
		return mav;
	}

	//공구쇼핑몰의 처음 시작 부분
	@RequestMapping("/index.do")
	public ModelAndView index(HttpSession session){

		ModelAndView mav = new ModelAndView();
		//회원 정보를 사용하기위한 설정
		MemberBean mbean = (MemberBean) session.getAttribute("mbean");
		if(mbean == null){//top.jsp 에서 로그인 정보를 처리하기위한 소스
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
	  //데이터 베이스에 접근해서 해당 아이디와 패스워드가 있는지를 파악해줌
	  //데이터 베이스에 아이디와 패스워드가 일치 할경우
	  int result = sutoolDao.getLogin(mbean);
	  if(result==1){   
	   //로그인을 유지 시키려면 Session객체를 사용하시오
	   session.setAttribute("mbean", mbean);
	   return new ModelAndView(new RedirectView("index.do"));
	  }
	  else {//로그인정보가 틀릴경우
	   mav.addObject("center","MemberLogin.jsp");
	   mav.addObject("left","SujakLeft.jsp");
	   mav.setViewName("ShoppingMain");
	   mav.addObject("login" ,"1"); 
	   return mav;
	  }  
	
	 }
	 @RequestMapping("/logout.do")
	 public ModelAndView logoutProc(HttpSession session){
		 //회원정보를 얻어오기위한 설정
		 MemberBean mbean = (MemberBean)session.getAttribute("mbean"); 
		 session.setAttribute("mbean", null);
		 return new ModelAndView(new RedirectView("index.do"));
	 }
}








