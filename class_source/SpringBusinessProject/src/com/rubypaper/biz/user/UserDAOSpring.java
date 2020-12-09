package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// DAO(Data Access Object) Ŭ����
//@Repository
public class UserDAOSpring implements UserDAO {

	@Autowired
	JdbcTemplate spring;

	// USERS ���̺� ���� SQL ��ɾ�
	private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET    = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

	// USERS ���̺� ���� CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring ������� insertUser() ��� ó��");
//		Object[] args= {vo.getId(),vo.getPassword(),vo.getName(),vo.getRole()};
		spring.update(USER_INSERT,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());		
	}
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring ������� getUser() ��� ó��");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
		
	}	
}




