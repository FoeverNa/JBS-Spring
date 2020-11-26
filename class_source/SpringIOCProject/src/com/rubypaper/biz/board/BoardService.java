package com.rubypaper.biz.board;

import java.util.List;

// 3. Service 인터페이스
public interface BoardService {

	// BOARD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 검색
	List<BoardVO> getBoardList(BoardVO vo);

}