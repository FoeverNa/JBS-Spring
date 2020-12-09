package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

//@Controller
@RestController // 자동으로 모든 메소드에 ResponsBody 붙여주는애
public class BoardController {
	public BoardController() {
		System.out.println("===> BoardController created");
	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@GetMapping("hello") // requestMapping에 편한버전
//	@ResponseBody	// 응답프로토콜 body쪽에 return값을 담아주겠다
	public String hello(String name) {
		return "hello : " + name;  // /hello?name=xxx 해주면 xxx가 출력됨
	}
	// 서버 안 켯다껐다 하기 위해 디펜더시 추가 해주기 위해
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("임시 제목");
		board.setWriter("임시완");
		board.setContent("임시 내용...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i = 0; i<5; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(++i);
			board.setTitle("임시 제목" + i);
			board.setWriter("임시완" + i);
			board.setContent("임시 내용..." + i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}

}
