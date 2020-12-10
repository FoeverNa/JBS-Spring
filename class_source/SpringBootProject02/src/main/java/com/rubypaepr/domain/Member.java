package com.rubypaepr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
}
