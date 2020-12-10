package com.rubypaepr;

import java.util.Date;

import org.junit.Before;
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
	@Before
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
			board.setMember(member1); // 둘리가 등록한 게시 글
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
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();//CRUD는 따로 구현을 하지 않아도 된다 // Optional때문에 .get()
		System.out.println(board.getSeq() + "번 게시 글의 정보");
		System.out.println(board.getTitle());
		System.out.println(board.getCreateDate());
		System.out.println(board.getMember().getName());// 엔티티변수에 접근할 수 있다
		System.out.println(board.getMember().getId()); // Select, Join 할필요 없이 @ManyToOne만 해주면 내부적으로 해준다
		// 실행결과를 보면 실제로 sql로 join을 해준다
		
	}


}
