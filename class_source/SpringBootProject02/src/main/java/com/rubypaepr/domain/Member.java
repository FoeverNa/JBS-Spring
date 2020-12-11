package com.rubypaepr.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Member { //엔티티 만든뒤 쿼리 어노테이션테스트 실행하면 테이블 만들어짐
	@Id
	@Column(name = "MEMBER_ID") // 컬럼이름 지정
	private String id;
	private String password;
	private String name;
	private String role;
	
	// mappedBy는 양방향 매핑에서 연관관계의 주인이 아닌 쪽 변수에 선언한다 ( 속성 값은 연관관계 주인 변수 이름이다.)
	@OneToMany(mappedBy="member"
			,fetch=FetchType.EAGER
			,cascade=CascadeType.ALL) // 영속성 전이를 위한 속성, ALL은 모든 상태의 엔티티에 적용하겠다
	private List<Board> boardList = new ArrayList<Board>();
	
	
}
