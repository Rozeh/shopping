package model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SutoolDAO {

	//�������� preparedstatement��ü�� ����ϴ� ��ü ����
	SimpleJdbcTemplate template;//������ ��������ִ� ��ü	

	//������ ���̽��� �����Ͽ� Ŀ�ؼ��� ������ ��ü
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//datasource�� �̿��ؼ� ������ �����ϼ��ֵ��� ��ü ����
		template = new SimpleJdbcTemplate(dataSource);
	}

	//��� ���۾� ������ �������ִ� �޼ҵ�
	public List<SuBean> getAllSutool() {
		String sql ="select * from sutool"; 
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		return template.query(sql, rm);
	}
	//���õ� ���۾� ������ �������ִ� �޼ҵ�
	public List<SuBean> getSelectAllSutool(String num) {
		String sql ="select * from sutool where sucategory=?"; 
		RowMapper<SuBean> rm = 
				new BeanPropertyRowMapper<SuBean>(SuBean.class);
		return template.query(sql, rm , num);
	}
	//�ϳ��� ���۾� ���� ������ ����
	public SuBean getOneSutool(int no) {
		String sql = "select * from sutool where no=?";
		RowMapper<SuBean> rm =
				new BeanPropertyRowMapper<SuBean>(SuBean.class);

		return template.queryForObject(sql, rm, no);
	}

	//īƮ�� ���� ������ �����ϴ� �޼ҵ�
	public SuCartBean getSuCart(int no) {
		String sql = "select * from sutool where no=?";
		RowMapper<SuCartBean> rm =
				new BeanPropertyRowMapper<SuCartBean>(SuCartBean.class);

		return template.queryForObject(sql, rm, no);
	}
	//���� ��� ����
	public List<AutoBean> getAllAutotool() {
		String sql ="select * from autotool"; 
		RowMapper<AutoBean> rm = 
				new BeanPropertyRowMapper<AutoBean>(AutoBean.class);
		return template.query(sql, rm);
	}
	//���� ������ ���õ� ������
	public List<AutoBean> getSelectAllAutotool(String num) {
		String sql ="select * from autotool where autocategory=?"; 
		RowMapper<AutoBean> rm = 
				new BeanPropertyRowMapper<AutoBean>(AutoBean.class);
		return template.query(sql, rm , num);
	}

	//�ϳ��� ���������� �����ϴ� �޼ҵ�
	public AutoBean getOneAutotool(int no) {
		String sql = "select * from autotool where autonum=?";
		RowMapper<AutoBean> rm =
				new BeanPropertyRowMapper<AutoBean>(AutoBean.class);

		return template.queryForObject(sql, rm, no);
	}

	//�ѻ���� ���� ȸ�� ������ �����ϴ� �޼ҵ�
	public void insertMember(MemberBean bean){
		//������ �غ�
		String sql="insert into springmember values"
				+ "(:memid,:passwd,:name,:phone,:address,:birthday,'d',"
				+ ":email,sysdate,:gender,:job)";
		//��Ŭ������ �������� 1:1���εǵ��� �ڵ�����
		SqlParameterSource sqlsource = new BeanPropertySqlParameterSource(bean);
		//���� �����Ͻÿ�
		template.update(sql, sqlsource);


	}

	//ȸ�� �α���ó�� �޼ҵ�
	public int getLogin(MemberBean mbean) {
		//�����غ�
		String sql ="select count(*) from springmember where memid=? and passwd=?";

		return template.queryForInt(sql, mbean.getMemid(), mbean.getPasswd());

	}

}




