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

// @SessionAttributes�� �̿��ϸ� Ư�� �̸����� Model�� ����� �����͸� ���ǿ��� ��ϵǵ��� �Ѵ�.
// ���� getBoard �޼ҵ忡�� model "board"��� �̸����� BoardVO ��ü�� Model�� �����ϸ�
// ���ǿ��� "board"��� �̸����� BoardVO ��ü�� ��ϵǴ� ���̴�.

@SessionAttributes("board")
@Controller
public class boardController  {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody // HTTP ���� �������� Body�� JSON���� ��ȯ�� �� ����� ����ϵ����ϴ� ���� 
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		return boardService.getBoardList(vo);
	}
	

	//�� ��� ȭ�� �̵�
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardView(BoardVO vo) {
		// �Ű������� ���� VO ��ü�� �ڵ����� request ���� ��ü�� ��ϵȴ�.
		// ���� ���������� ����Ǵ� ȭ��(JSP)���� EL�� �̿��Ͽ� ���� �Ѹ� �� �ִ�.
		// EL�� Request�� Session���� ���� �������⶧����
		vo.setTitle("200�� �̸�����...");
		vo.setWriter("�׽���");
		vo.setContent("2000�� �̸����� �ۼ����ּ���.");
		
		return "insertBoard";

	}
	
	//�� ���
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		
//		System.out.println("���� ó�������� BoardVO ��ü ����");
//		BoardVO board = boardService.getBoard(vo);
//		System.out.println(board);
		
		// ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/TEMP/upload_files/" + uploadFile.getOriginalFilename()));
		}
		
		
		// �� ��� ��� ó��
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";

	}
	
	//�� ��
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model)  {
		
		System.out.println("�� ȭ�鿡���� BoardVO ��ü ����");
		BoardVO board = boardService.getBoard(vo);
		
		// Model�� ������ �������ʹ� �ڵ����� request�� ��ϵȴ�.
		model.addAttribute("board", board);	
		return "getBoard";
		
	}
	
	//�� ��� �˻�
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		// Null check
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE"); 
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");  

		// ���� �˻� ����� ���ǿ� �����ؼ��� �ȵȴ�. �˻� ����� request�� ����ؾ� �Ѵ�.
		// ModelAndView�� Model ��ü�� �˻� ����� ����ϸ� �ڵ����� request�� ������ش�.

		model.addAttribute("boardList", boardService.getBoardList(vo));
		model.addAttribute("search", vo);
		
		// �� ��� ȭ��(getBoardList.jsp)���� �̵��Ѵ�.
	
		return "getBoardList";
	}
	
	// �� ����
	// @ModelAttribute�� ���ǿ� "board"��� �̸����� �����Ͱ� ��ϵǾ� �̽θ� �� ��ü�� vo ������ ���ε��ض�...��� �ǹ��̴�.(������ ����)
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {

		System.out.println("�����ϱ� ���ؼ� ������ BoardVO ��ü ����");
		BoardVO board = boardService.getBoard(vo);

		boardService.updateBoard(vo);
	
		return "forward:getBoardList.do";
	}
	
//	 �� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		boardService.deleteBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		return "forward:getBoardList.do";
		
	}
	
	// �� ����
//
//	@RequestMapping("/deleteBoard.do")
//	public String deleteBoard(@RequestParam(value="seq", defaultValue="1", required=true) int boardSeq, BoardDAOJDBC boardDAO) {
//		System.out.println(boardSeq+ "�� �Խ� �� ���� ó��...."); // �̰͵� �ȴ�
////		boardDAO.deleteBoard(vo);
//		
//		return "forward:getBoardList.do";
//		
//	}


	
	

}
