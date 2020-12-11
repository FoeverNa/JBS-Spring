package com.rubypaepr.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member") // 서로 참조변수 가지고 있기 때문에  참조고리 끊기 위해서 member변수를 제외 시켜버린다
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
	// OneToMany 를 가질 수 도있다
	
	// @ManyToOne은 N : 1 관계를 매핑하는 어노테이션
	// 게시글(N) : 회원(1)을 매핑
	
//	@ManyToOne(fetch=FetchType.LAZY) // default는 EAGER지만 LAZY로 변환할 수 있다
	@ManyToOne // N : 1 관계를 매핑하는 어노테이션 //왼쪽이 자신이고 오른쪽이 상대, 1:N이면 OneToMany로 표시해준다
	@JoinColumn(name="MEMBER_ID", nullable=false) // FK로 사용할 컬럼을 지정한다. // 생략하면 member_memberid가 된다
													//nullable=false는 이너 조인이 된다
	private Member member; // writer 대체할 변수

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);  // 아 보드를 추가할때 하나씩 다넣어주란소리인가?
	}

}
