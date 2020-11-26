package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rubypaper.biz.common.JDBCUtil;

// DAO(Data Access Object) 클래스
public class BoardDAO {
	// JDBC 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// BOARD 테이블 관련 SQL 명령어
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " + 
											       "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ=?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ=?";
	private static final String BOARD_LIST_TITLE = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
	private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";
	
	// BOARD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				// 검색 결과 한 건을 BoardVO 객체에 매핑한다.
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				// 검색 결과가 존재하는 경우 조회수를 증가시킨다.
				stmt = conn.prepareStatement(BOARD_UPDATE_CNT);
				stmt.setInt(1, vo.getSeq());
				stmt.executeUpdate();
			}				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		// 비어있는 리스트 컬렉션을 생성한다. 
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getSerachCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_TITLE);
				
			} else if(vo.getSerachCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
			}			
			stmt.setString(1, vo.getSerchKeyword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				// 검색 결과 한 ROW당 하나의 BoardVO 객체에 매핑한다.
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				// 검색 결과가 매핑된 BoardVO 객체를 리스트 컬렉션에 등록한다. 
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		// 검색 결과가 저장된 리스트 컬렉션을 클라이언트로 리턴한다.
		return boardList;
	}
}




