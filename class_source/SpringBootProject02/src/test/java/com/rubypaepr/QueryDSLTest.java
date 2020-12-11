package com.rubypaepr;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.rubypaepr.domain.Board;
import com.rubypaepr.domain.QBoard;
import com.rubypaepr.persistence.DynamicBoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDSLTest {
	
	@Autowired
	private DynamicBoardRepository boardRepo;
	

	@Test
	public void testDynamicQuery() {
//		// 검색 관련 정보 설정
		String condition = "TITLE";
		String keyword = "도우너";
		
		BooleanBuilder builder = new BooleanBuilder(); // Dynamic 만들게도와준느애
		QBoard qboard = QBoard.board;
		
		if(condition.equals("TITLE")) {
			//쿼리를 동적으로 생성한다.
			builder.and(qboard.title.like("%"+ keyword + "%"));
		} else if(condition.equals("CONTENT")) {
			//쿼리를 동적으로 생성한다.
			builder.and(qboard.content.like("%"+ keyword + "%"));
		}  //연산자를 메소드형태로 제공을 한다
		
		
		// 모든 글 목록 검색한다.
		Pageable pageable = PageRequest.of(0, 5);
		Page<Board> boardList = boardRepo.findAll(builder, pageable); // findAll에 파람없으면 그냥 Select
		System.out.println("=========== 검색 결과 ==============");
		List<Board> list = boardList.getContent();
		for(Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}


}
