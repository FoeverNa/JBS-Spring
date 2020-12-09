package com.rubypaper.web.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.biz.board.BoardService;
import com.rubypaper.biz.board.BoardVO;

// @SessionAttributes를 이용하면 특정 이름으로 Model에 저장된 데이터를 세션에도 등록되도록 한다.
// 따라서 getBoard 메소드에서 model "board"라는 이름으로 BoardVO 객체를 Model에 저장하면
// 세션에도 "board"라는 이름으로 BoardVO 객체가 등록되는 것이다.

@SessionAttributes("board")
@Controller
public class boardController  {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody // HTTP 응답 프로토콜 Body에 JSON으로 변환된 글 목록을 출력하도록하는 설정 
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		return boardService.getBoardList(vo);
	}
	

	//글 등록 화면 이동
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardView(BoardVO vo) {
		// 매개변수로 받은 VO 객체는 자동으로 request 내장 객체에 등록된다.
		// 따라서 최종적으로 실행되는 화면(JSP)에서 EL을 이용하여 값을 뿌릴 수 있다.
		// EL은 Request나 Session에서 값을 가져오기때문에
		vo.setTitle("200자 미만으로...");
		vo.setWriter("테스터");
		vo.setContent("2000자 미만으로 작성해주세요.");
		
		return "insertBoard";

	}
	
	//글 등록
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		
//		System.out.println("수정 처리에서의 BoardVO 객체 정보");
//		BoardVO board = boardService.getBoard(vo);
//		System.out.println(board);
		
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/TEMP/upload_files/" + uploadFile.getOriginalFilename()));
		}
		
		
		// 글 등록 기능 처리
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";

	}
	
	//글 상세
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model)  {
		
		System.out.println("상세 화면에서의 BoardVO 객체 정보");
		BoardVO board = boardService.getBoard(vo);
		
		// Model에 저장한 뎅데이터는 자동으로 request에 등록된다.
		model.addAttribute("board", board);	
		return "getBoard";
		
	}
	
	//글 목록 검색
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		// Null check
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE"); 
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");  

		// 절대 검색 결과는 세션에 저장해서는 안된다. 검색 결과는 request에 등록해야 한다.
		// ModelAndView나 Model 객체에 검색 결과를 등록하면 자동으로 request에 등록해준다.

		model.addAttribute("boardList", boardService.getBoardList(vo));
		model.addAttribute("search", vo);
		
		// 글 목록 화면(getBoardList.jsp)으로 이동한다.
	
		return "getBoardList";
	}
	
	// 글 수정
	// @ModelAttribute는 세션에 "board"라는 이름으로 데이터가 등록되어 이싸면 그 객체를 vo 변수에 바인딩해라...라는 의미이다.(없으면 말고)
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {

		System.out.println("수정하기 위해서 가져온 BoardVO 객체 정보");
		BoardVO board = boardService.getBoard(vo);

		boardService.updateBoard(vo);
	
		return "forward:getBoardList.do";
	}
	
//	 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		boardService.deleteBoard(vo);
		
		// 3. 화면 네비게이션
		return "forward:getBoardList.do";
		
	}
	
	// 글 삭제
//
//	@RequestMapping("/deleteBoard.do")
//	public String deleteBoard(@RequestParam(value="seq", defaultValue="1", required=true) int boardSeq, BoardDAOJDBC boardDAO) {
//		System.out.println(boardSeq+ "번 게시 글 삭제 처리...."); // 이것도 된다
////		boardDAO.deleteBoard(vo);
//		
//		return "forward:getBoardList.do";
//		
//	}


	
	

}
