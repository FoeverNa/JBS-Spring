package com.rubypaper.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("business-layer.xml");
		
		BoardService boardService = (BoardService)container.getBean("boardService");
			

		if(boardService != null) {
			System.out.println(boardService + ": Looukup 성공");
		}
		
		BoardVO vo = new BoardVO();
//		vo.setSeq(11);
		vo.setTitle("Spring 제목");
		vo.setWriter("테스터");
		vo.setContent("Spring 내용...");
		boardService.insertBoard(vo);
		
		vo.setSerachCondition("TITLE");
		vo.setSerchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
	
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	
		container.close();
	
	}
	
}
