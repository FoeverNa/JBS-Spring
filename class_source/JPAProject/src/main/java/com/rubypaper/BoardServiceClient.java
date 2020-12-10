package com.rubypaper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf =
//				Persistence.createEntityManagerFactory("JPAProject");
				Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		
		
		// 글 등록 처리
		 	//마치 .add하는 것처럼 등록하기
		
		try {
			EntityTransaction tx1 = em.getTransaction(); // 입력전에 tx 받아야한다// try문으로 가져온다
			 tx1.begin();
			 

			// 비영속 상태의 엔티티 객체
			Board board = new Board();
			board.setTitle("JPA 제목");
//			board.setWriter("테스터");
//			board.setContent("JPA 내용.....");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
			
			// 글등록 처리
			
			em.persist(board); // find할때 등록하지 않고 가져오는 것위해 주석처리했음
			Board findBoard1 = em.find(Board.class, 1L); // 이때 select를 한다
			Board findBoard2 = em.find(Board.class, 1L); // find1과 똑같다
			System.out.println(findBoard1.toString()); // 왜 insert보다 먼저 프린트될까? commit안됬기 대문에
			tx1.commit(); // 정상작동 하면 commit 한다 //이때 insert된다
			
//			EntityTransaction tx2 = em.getTransaction();
			
//			tx2.begin();
//			em.detach(board); // 준영속 상태로 만든다
//			board.setTitle("-------수정된 제목");
//			
//			// 다시 영속상태로 전환
//			em.merge(board); // 처음에 주석으로 막고 실행  //create로 만들고실행
//			tx2.commit(); // 
			
//			board.setTitle("----영속상태에 객체 제목 수정"); // 따로 매니저로 접근하는게 아닌 그냥 객체만 변하면 바로 update반영된다

//			Board board1 = em.find(Board.class, 1L); // JPA에 등록된 값이기 때문에 Select가 실행되지 않는다
//			System.out.println(board1.toString());

//			em.detach(board); // 준영속상태로 만듬
//			board.setTitle("----영속상태에 객체 제목 수정"); // 따로 매니저로 접근하는게 아닌 그냥 객체만 변하면 바로 update반영된다
//			em.merge(board); // 준영속상태에 객체를 영속상태로 만듬
//			em.remove(board); // 제거해라

			
		} catch (Exception e) {
			e.printStackTrace();
//			tx1.rollback();// 비정상 작동시 rollback하게 한다
//			tx2.rollback(); //에러나서 지움, 왜나지
		} finally {
			em.close();
			emf.close();
		}
	}

}
