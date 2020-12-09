package com.rubypaper.biz.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardServiceClient {

	public static void main(String[] args) {
//		BoardVO vo = new BoardVO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", "MyBaTIS ����");
		paramMap.put("wirter", "�׽���");
		paramMap.put("content", "MyBaTIS ����........");
		
		
		BoardDAOMyBATIS boardDAO = new BoardDAOMyBATIS();
		boardDAO.insertBoardMap(paramMap);
		
		BoardVO vo = new BoardVO();
		
		List<Map<String, Object>> boardList = boardDAO.getBoardListMap(vo);
		for (Map<String, Object> board: boardList) {
			System.out.println("---> " + board.get("SEQ")+ ":" + board.get("TITLE"));
		}

	}

}
