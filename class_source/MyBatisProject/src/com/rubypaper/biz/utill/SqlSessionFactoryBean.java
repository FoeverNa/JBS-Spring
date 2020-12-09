package com.rubypaper.biz.utill;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	
	private static SqlSessionFactory sessionFactory;
	
	static {
		// 
		try {
			if (sessionFactory ==null) {
				// MyBatis 컨테이너 공장을 메인 환경 설정파일(sql-map-config.xml)을 일겅서 생성한다.
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml"); // 입력스트림, 마이바틱스 입력설정파일을읽어내는
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); // 그 결과를 읽어서 만들어낸게 sessionFacotry
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstance() {
		// 컨테이너 공장(SqlSessionFactory)에서 MyBatis 컨테이너(SqlSession) 하나를 생성하여 리턴한다.
		// 그럼 이공장은 어떻게 만드는가?
		return sessionFactory.openSession();
	}

}
