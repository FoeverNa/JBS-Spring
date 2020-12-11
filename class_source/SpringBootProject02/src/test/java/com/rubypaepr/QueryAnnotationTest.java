//package com.rubypaepr;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.rubypaepr.domain.Board;
//import com.rubypaepr.persistence.BoardRepository;
//
//@RunWith(SpringRunner.class)// 이래야 스프링테스트가 된다
//@SpringBootTest// 얘도 부트 테스트를 위해 필요하다 // 둘다 jUnit기반 테스트 케이스이다
//public class QueryAnnotationTest {
//	
//	@Autowired
//	private BoardRepository boardRepo; // 해당 인터페이스를 구현한 클래스를 스프링이 만들어서 메모리에 띠워준다 // 아우
//
//	@Test
//	public void testQueryAnnotationTest3() {
//
//		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//		List<Board> boardList = boardRepo.queryAnnotationTest3(pageable); 
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//
//	//@Test
//	public void testQueryAnnotationTest1() {
//
//		// 글목록을 List에 담아준다
//		List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 : 17");  //실제 실행되면 sql로 변환되서 실행된다
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//	
//
//
//}
