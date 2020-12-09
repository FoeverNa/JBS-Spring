package com.rubypaper;

import java.util.Date;

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
		
		EntityTransaction tx = em.getTransaction(); // 입력전에 tx 받아야한다
		
		// 글 등록 처리
		 	//마치 .add하는 것처럼 등록하기
		
		try {
			// 비영속 상태의 엔티티 객체
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("테스터");
			board.setContent("JPA 내용.....");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// 글등록 처리
			// tx 시작
			tx.begin();
			em.persist(board); // find할때 등록하지 않고 가져오는 것위해 주석처리했음

//			Board board1 = em.find(Board.class, 1L); // JPA에 등록된 값이기 때문에 Select가 실행되지 않는다
//			System.out.println(board1.toString());

//			em.detach(board); // 준영속상태로 만듬
//			board.setTitle("----영속상태에 객체 제목 수정"); // 따로 매니저로 접근하는게 아닌 그냥 객체만 변하면 바로 update반영된다
//			em.merge(board); // 준영속상태에 객체를 영속상태로 만듬
//			em.remove(board); // 제거해라

			//tx 종료
			tx.commit(); // 정상작동 하면 commit 한다
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();// 비정상 작동시 rollback하게 한다
		} finally {
			em.close();
			emf.close();
		}
	}

}
