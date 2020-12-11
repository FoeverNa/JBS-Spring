package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//AUTO는 생략가능
	private Long seq;
	
	private String title;
	
	@Column(updatable = false) // 작성자는 수정하지 않겠다
	private String writer;
	
	private String content;
	
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date createDate;
	
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private Long cnt;
}
