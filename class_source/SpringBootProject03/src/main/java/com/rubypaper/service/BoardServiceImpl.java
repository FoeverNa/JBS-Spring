package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Bean

	public CharacterEncodingFilter characterEncodingFilter() {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

	    characterEncodingFilter.setEncoding("EUC-KR");

	    characterEncodingFilter.setForceEncoding(true);

	    return characterEncodingFilter;

	}
	
	@Autowired
	private BoardRepository boardRepo;
	
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get(); //업데이트 전에는 select먼저해서 1차캐쉬에 올려야한다
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(board); // save 가 업데이트와 인서트 다사용된다
	}
	
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq()); //내부적으로 select를 먼저하고 1차캐쉬에 올려놓고 삭제처리함
	}
	
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	public List<Board> getBoardList(Board board) {
		
//		return (List<Board>)boardRepo.findAll(); // 명시적 형변환 해주어야 한다
		return boardRepo.findAllDESC();
	}



}
