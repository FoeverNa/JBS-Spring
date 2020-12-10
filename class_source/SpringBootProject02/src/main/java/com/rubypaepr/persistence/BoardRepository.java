package com.rubypaepr.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaepr.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
//	List<Board> findByTitle(String searchKeyword); //구현되어있는 클래스를 ctrl+space로 가져온다
//	//이런 메소드를 쿼리 메소드라고 한다
//	
//	List<Board> findByContentContaining(String searchKeyword); // Containing이라고 하면 포함된 것으로 검색해준다(LIKE 연산)
//	
//	List<Board> findByTitleContainingOrContentContaining(String title, String content); // 파람 2개넣어줘야한다, 같아도 2개넣어야한다
//
//	List<Board> findByContentContainingOrderBySeqDesc(String searchKeyword); //내용에 특정 검색을 찾아오는데 정렬한다 //Desc혹은 Asec
//	
////	List<Board> findByTitleContaining(String searchKeyword, Pageable pageable); // org.springframework.data.domain.Pageable
//	
//	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable); // Return만 Page로 바꾸어주었다
//	
//	// @Query 어노테이션을 이용한 JPQL 등록
//	// JPQL은 검색 대상이 테이블이 아니라 영속 상태에 있는 엔티티 객체들이다.
//	// 그리고 컬럼명이 사용되는 것이 아니라 엔티티 객체의 변수가 사용된다. (SELECT, WHERE, ORDER BY, GROUP BY)
////	@Query("SELECT b FROM Board AS b WHERE b.title like %?1% ORDER BY b.seq DESC") // ?1 위치기반 
//	@Query("SELECT b FROM Board AS b WHERE b.title like %:keyword ORDER BY b.seq DESC") // 이름기반으로 파람설정
//	List<Board> queryAnnotationTest1(@Param("keyword") String keyword);
//	
//	// 보충할 것
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board AS b WHERE b.title like %:keyword ORDER BY b.seq DESC") // 이름기반으로 파람설정
//	List<Object[]> queryAnnotationTest2(@Param("keyword") String keyword);
//	
//	// 페이징
//	@Query("SELECT b FROM Board AS b ORDER BY b.seq DESC") 
//	List<Board> queryAnnotationTest3(Pageable pageable);
}
