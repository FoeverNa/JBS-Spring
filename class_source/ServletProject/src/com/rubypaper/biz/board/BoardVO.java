package com.rubypaper.biz.board;

import java.sql.Date;

import lombok.Data;

// VO(Value Object) 클래스
/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
@Data
public class BoardVO {
	// 테이블의 컬럼 이름(데이터 타입까지)과 동일한 멤버변수를 private으로 선언한다. 
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String serachCondition;
	private String serchKeyword;
	
	// private 멤버 변수에 접근하는 public Getter/Setter 메소드를 작성한다.
	// 단축 키(Alt + Shift + S)를 이용한다. 
}
