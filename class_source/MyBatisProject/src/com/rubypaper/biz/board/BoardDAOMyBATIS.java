package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubypaper.biz.utill.SqlSessionFactoryBean;


// 2. DAO(Data Access Object) 클래스
public class BoardDAOMyBATIS  {
	
	// SqlSession이 MyBatis 프레임워크 객체다. Mybatis도 내부적으로 컨테이너를 운용한다.
	// 따라서 SqlSession 객체는 MyBatis 컨테이너이다.
	private SqlSession mybatis;
	
	public BoardDAOMyBATIS() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	

	// BOARD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard",vo);
		mybatis.commit();
	}
	
	// 글 등록
	public void insertBoardMap(Map<String, Object> vo) {
		System.out.println("===> MyBATIS 기반으로 insertBoardMap() 기능 처리");
		mybatis.insert("BoardDAO.insertBoardMap", vo);
		mybatis.commit();
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
		
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 deleteBoard() 기능 처리");
		mybatis.update("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 getBoard() 기능 처리");
		
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo); // Object로 return되서 캐스팅해야 컴파일이된다
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList"); // vo없으면 안넣어줘도된다
	}
	// 글 목록 검색
	public List<Map<String, Object>> getBoardListMap(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardListMap"); // vo없으면 안넣어줘도된다
	}
	
	// 게시글 수 검색
	public List<BoardVO> getTotalCount(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 getBoardList() 기능 처리");
		return (List<BoardVO>) mybatis.selectOne("BoardDAO.getTotalCount"); // vo없으면 안넣어줘도된다
	}
}




