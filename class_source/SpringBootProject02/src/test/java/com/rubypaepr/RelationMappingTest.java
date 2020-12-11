package com.rubypaepr;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaepr.domain.Board;
import com.rubypaepr.domain.Member;
import com.rubypaepr.persistence.BoardRepository;
import com.rubypaepr.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private BoardRepository boardRepo; 

	@Autowired
	private MemberRepository memberRepo; 

	// 실행전 create해서 다지우기
//	@Before
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("둘리");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("도우너");
		memberRepo.save(member2);
		
		for(int i = 1; i <=3; i++) {
			Board board = new Board();
			board.setMember(member1); // 보드객체가 멤버객체 참조할수있도록 넣어주는게 중요하다!!
			board.setTitle("둘리가 등록 게시 글 : " + i);
			board.setCreateDate(new Date());
			boardRepo.save(board);
		}
		
		for(int i = 1; i <=3; i++) {
			Board board = new Board();
			board.setMember(member2); // 둘리가 등록한 게시 글
			board.setTitle("도우너가 등록 게시 글 : " + i);
			board.setCreateDate(new Date());
			boardRepo.save(board);
		}
	}
	
	
	@Test
	public void testCascadeDelete() {
			memberRepo.deleteById("member1"); // member2가 가진 3개의 board삭제 후에 member2 삭제
		}
		
	
//	@Test
	public void testCascadeInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("둘리");

		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("도우너");
		
		for(int i = 1; i <=3; i++) {
			Board board = new Board();
			board.setMember(member1); 
			//member2.getBoardList().add(board);// 보드도 등록되도록 해줘야된다// 그래서 setMember에 추가해준것이다
			board.setTitle("둘리가 등록 게시 글 : " + i);
			board.setCreateDate(new Date());
		}
		
		memberRepo.save(member1); // 회원 등록될때 보드리스트도 같이 등록이 된다
		 
		for(int i = 1; i <=3; i++) {
			Board board = new Board();
			board.setMember(member2); 
			board.setTitle("도우너가 등록 게시 글 : " + i);
			board.setCreateDate(new Date());
		}
		
		memberRepo.save(member2);
	}
	
	
//	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		System.out.println("[ " + member.getName() + "가 등록한 게시글 정보 ] ");
		List<Board> boardList = member.getBoardList();
		for(Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
	}
	
//	@Test
	public void testManyToOneSelectfetchLAZY() { // LAZY로 하고 Member 정보 사용하지 않으면 join하지 않고 Board만 사용한다
		Board board = boardRepo.findById(5L).get();
		System.out.println(board.getSeq() + "번 게시 글의 정보");
		System.out.println(board.getTitle());
		System.out.println(board.getCreateDate());
	} 
	
//	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();//CRUD는 따로 구현을 하지 않아도 된다 // Optional때문에 .get()
		System.out.println(board.getSeq() + "번 게시 글의 정보");
		System.out.println(board.getTitle());
		System.out.println(board.getCreateDate());
		System.out.println(board.getMember().getName());// 엔티티변수에 접근할 수 있다
		System.out.println(board.getMember().getId()); // Select, Join 할필요 없이 @ManyToOne만 해주면 내부적으로 해준다
		// 실행결과를 보면 실제로 sql로 forienkey와 primarykey 이용해서 join을 해준다
	}


}
