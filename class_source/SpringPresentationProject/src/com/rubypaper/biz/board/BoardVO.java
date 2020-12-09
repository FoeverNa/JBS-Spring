package com.rubypaper.biz.board;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// 1. VO(Value Object) 클래스
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
	private String searchCondition;
	private String searchKeyword;
	
	//MultipartFile 객체는 사용자가 업로드한 파일의 모든 정보(파일의 이름, 경로, 바이트 배열 등등의 정보)가 등록되는 객체
	// 스프링 컨테이너가 MultipartFile 객체를 생성하기 위해서는 CommonsMultipartResolver를 가지고 있어야 한다.
	private MultipartFile uploadFile;

	@JsonIgnore
	public String getSearchCondition() {
		return searchCondition;
	}

	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}

	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

//	public MultipartFile getUploadFile() {
//		return uploadFile;
//	}
//
//	public void setUploadFile(MultipartFile uploadFile) {
//		String uploadFileName = uploadFile.getOriginalFilename();
//		System.out.println(uploadFileName + " 파일이 업로드 요청되었네요....");
//		this.uploadFile = uploadFile;
//	}
	
	// private 멤버 변수에 접근하는 public Getter/Setter 메소드를 작성한다.
	// 단축 키(Alt + Shift + S)를 이용한다. 
	
	
	
}
