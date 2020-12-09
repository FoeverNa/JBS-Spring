package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubypaper.biz.utill.SqlSessionFactoryBean;


// 2. DAO(Data Access Object) Ŭ����
public class BoardDAOMyBATIS  {
	
	// SqlSession�� MyBatis �����ӿ�ũ ��ü��. Mybatis�� ���������� �����̳ʸ� ����Ѵ�.
	// ���� SqlSession ��ü�� MyBatis �����̳��̴�.
	private SqlSession mybatis;
	
	public BoardDAOMyBATIS() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	

	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� insertBoard() ��� ó��");
		mybatis.insert("BoardDAO.insertBoard",vo);
		mybatis.commit();
	}
	
	// �� ���
	public void insertBoardMap(Map<String, Object> vo) {
		System.out.println("===> MyBATIS ������� insertBoardMap() ��� ó��");
		mybatis.insert("BoardDAO.insertBoardMap", vo);
		mybatis.commit();
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
		
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� deleteBoard() ��� ó��");
		mybatis.update("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoard() ��� ó��");
		
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo); // Object�� return�Ǽ� ĳ�����ؾ� �������̵ȴ�
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoardList() ��� ó��");
		return mybatis.selectList("BoardDAO.getBoardList"); // vo������ �ȳ־��൵�ȴ�
	}
	// �� ��� �˻�
	public List<Map<String, Object>> getBoardListMap(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoardList() ��� ó��");
		return mybatis.selectList("BoardDAO.getBoardListMap"); // vo������ �ȳ־��൵�ȴ�
	}
	
	// �Խñ� �� �˻�
	public List<BoardVO> getTotalCount(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoardList() ��� ó��");
		return (List<BoardVO>) mybatis.selectOne("BoardDAO.getTotalCount"); // vo������ �ȳ־��൵�ȴ�
	}
}




