package com.rubypaepr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaepr.domain.Board;
import com.rubypaepr.persistence.BoardRepository;

@RunWith(SpringRunner.class)// 이래야 스프링테스트가 된다
@SpringBootTest// 얘도 부트 테스트를 위해 필요하다 // 둘다 jUnit기반 테스트 케이스이다
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo; // 해당 인터페이스를 구현한 클래스를 스프링이 만들어서 메모리에 띠워준다 // 아우

	@Test 
	public void testDeleteBoard() {
		//식별자 값을 넘겨서 특정데이터 삭제
		boardRepo.deleteById(2L); //Select먼저해서 1차캐시에 올리고 delete하게 된다 // update와 비슷하다
									//얘는 식별자를 자체적으로 주기대문에 find안해도 된다
	}								//어플리케이션을 다시실행하면 컨테이너가 다시만들어지는 것임으로 1차캐쉬가 비어진다
	
//	@Test 
	public void testUpdateBoard() {
		//수정할 데이터를 먼저 검색해야 한다 => 검색해야 1차캐시에 엔티티가 등록되고 이 상태가 영속 상태다.
		//수정하려면 일단 영속상태여야 한다
//		Board board = boardRepo.findById(1L).get(); // find가 있어야 수정이된다!
		Board board = new Board(); //find를 안하고 빈 테이블에 이런식으로 하면 insert가 작동한다
		board.setSeq(2L); // 존재하지 않는 값을 save
		board.setTitle("----수정----");
		// CrudRepository에 있는 save() 메소드는 merge()메소드와 유사하다.
		// 테이블에 존재하면 update하고 없으면 insert한다
		boardRepo.save(board); // 있는 데이터를 seq로 지정해서 넣어버리면 select하고 insert하지 않음 //실행하면 select가 먼저 실행된다
								// 만약 seq가 없으면 insert가 일어난다
		//식별자값을 지정해야만 select-> insert동작// 거의없다
		// 신규는 insert로 동작
		// 검색한 값은 updatefh 동작
	}
	
	
//	@Test 
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
		
	}
	
//	@Test// jupiter 말고 juint
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("Boot JPA 테스트");
		
		boardRepo.save(board); //persist()와 비슷한 역할을 한다
								// 매니저획득, 트렌젝션획득하는 코드 다들어있다
	}


}
