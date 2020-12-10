//package com.rubypaepr;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
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
////	@Before // org.junit // 테스트 초기화 // 초기화시만 필요함 
//	public void dataPrepare() {
//		for (int i = 1; i <= 200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목: " + i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//			
//		}
//	}
//	
//	@Test
//	public void testTFindByTitleContaining() {
//		// page 번호는 0부터 시작한다. 따라서 1페이지를 보고싶으면 0
//		// size 한페이지에 몇건의 데이터를 가져올 것인지 지정한다.
//		Pageable pageable = PageRequest.of(0 , 5, Sort.Direction.DESC, "seq" ); // Sort를 이용해서 페지징한것을 정렬할 수도 있다
////		List<Board> boardList = boardRepo.findByTitleContaining("17", pageable);  
//		Page<Board> pageInfo = boardRepo.findByTitleContaining("17", pageable);  
//		
//		//page에 관한 다양한 정보를 보여줄 수 있다
//		System.out.println("PAGE SIZE : " + pageInfo.getSize());
//		System.out.println("Total PAGES : " + pageInfo.getTotalPages());
//		System.out.println("Total COUNT : " + pageInfo.getTotalElements());
//		System.out.println("Total PAGE : " + pageInfo.nextPageable()); 
//		
//		// 글목록을 List에 담아준다
//		List<Board> boardList = pageInfo.getContent(); 
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//	
////	@Test
//	public void testFindByContentContainingOrderBySeqDesc() { //테스트 메소드이름을 원본과 비슷하게 가져가면 좋다
//		List<Board> boardList = boardRepo.findByContentContainingOrderBySeqDesc("17");  
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//	
//
//	
////	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("15", "17");  
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//	
////	@Test
//	public void testFindbyContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");  //17이 들어간 것들을 모두 검색해라
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//
//	
////	@Test
//	public void testFindbyTitle() {
//		List<Board> boardList = boardRepo.findByTitle("테스트 제목: 10");  //title로 검색한다
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString()); 
//		}
//	}
//
//	
//
//
//}
