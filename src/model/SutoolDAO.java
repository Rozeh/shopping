package model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SutoolDAO {

	//스프링용 preparedstatement객체를 대신하는 객체 선언
	SimpleJdbcTemplate template;//쿼리를 실행시켜주는 객체	

	//데이터 베이스에 접근하여 커넥션을 얻어오는 객체
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//datasource를 이용해서 쿼리를 실행하수있도록 객체 생성
		template = new SimpleJdbcTemplate(dataSource);
	}

	//모든 수작업 공구를 리턴해주는 메소드
	public List<SuBean> getAllSutool() {
		String sql ="select * from sutool"; 
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		return template.query(sql, rm);
	}
	//선택된 수작업 공구를 리턴해주는 메소드
	public List<SuBean> getSelectAllSutool(String num) {
		String sql ="select * from sutool where sucategory=?"; 
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		return template.query(sql, rm , num);
	}
	//하나의 수작업 공구 정보를 리턴
	public SuBean getOneSutool(int no) {
		String sql = "select * from sutool where no=?";
		RowMapper<SuBean> rm =
				new BeanPropertyRowMapper<SuBean>(SuBean.class);

		return template.queryForObject(sql, rm, no);
	}

	//카트에 담을 정보를 리터하는 메소드
	public SuCartBean getSuCart(int no) {
		String sql = "select * from sutool where no=?";
		RowMapper<SuCartBean> rm =
				new BeanPropertyRowMapper<SuCartBean>(SuCartBean.class);

		return template.queryForObject(sql, rm, no);
	}
	//전동 모든 공구
	public List<AutoBean> getAllAutotool() {
		String sql ="select * from autotool"; 
		RowMapper<AutoBean> rm = 
				new BeanPropertyRowMapper<AutoBean>(AutoBean.class);
		return template.query(sql, rm);
	}
	//전동 공구중 선택된 공구만
	public List<AutoBean> getSelectAllAutotool(String num) {
		String sql ="select * from autotool where autocategory=?"; 
		RowMapper<AutoBean> rm = 
				new BeanPropertyRowMapper<AutoBean>(AutoBean.class);
		return template.query(sql, rm , num);
	}

	//하나의 전동공구를 리턴하는 메소드
	public AutoBean getOneAutotool(int no) {
		String sql = "select * from autotool where autonum=?";
		RowMapper<AutoBean> rm =
				new BeanPropertyRowMapper<AutoBean>(AutoBean.class);

		return template.queryForObject(sql, rm, no);
	}

	//한사람에 대한 회원 정보를 저장하는 메소드
	public void insertMember(MemberBean bean){
		//쿼리를 준비
		String sql="insert into springmember values"
				+ "(:memid,:passwd,:name,:phone,:address,:birthday,'d',"
				+ ":email,sysdate,:gender,:job)";
		//빈클래스가 쿼리문에 1:1맵핑되도록 자동설정
		SqlParameterSource sqlsource = new BeanPropertySqlParameterSource(bean);
		//쿼리 실행하시오
		template.update(sql, sqlsource);


	}

	//회원 로그인처리 메소드
	public int getLogin(MemberBean mbean) {
		//쿼리준비
		String sql ="select count(*) from springmember where memid=? and passwd=?";

		return template.queryForInt(sql, mbean.getMemid(), mbean.getPasswd());

	}

}




