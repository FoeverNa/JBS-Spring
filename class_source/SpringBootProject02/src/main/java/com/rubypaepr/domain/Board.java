package com.rubypaepr.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id
	@GeneratedValue
	private Long seq;
	private String title;
//	private String writer; //주석 막고 에러나는거 다주석처리하기
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;

	
	//참고
	//회원 (1) : 게시글(N)을 가지고 잇을 수 있다
	// OneToMany 를 가질 수 도있다 // 무슨차이야
	
	// @ManyToOne은 N : 1 관계를 매핑하는 어노테이션
	// 게시글(N) : 회원(1)을 매핑
	
	@ManyToOne // N : 1 관계를 매핑하는 어노테이션 //왼쪽이 자신이고 오른쪽이 상대, 1:N이면 OneToMany로 표시해준다
	@JoinColumn(name="MEMBER_ID") // FK로 사용할 컬럼을 지정한다. // 생략하면 member_memberid가 된다
	private Member member; // writer 대체할 변수


}
