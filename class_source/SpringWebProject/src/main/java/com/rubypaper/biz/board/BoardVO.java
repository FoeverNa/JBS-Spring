package com.rubypaper.biz.board;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// 1. VO(Value Object) Ŭ����
/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
@Data
public class BoardVO {
	// ���̺��� �÷� �̸�(������ Ÿ�Ա���)�� ������ ��������� private���� �����Ѵ�. 
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	
	//MultipartFile ��ü�� ����ڰ� ���ε��� ������ ��� ����(������ �̸�, ���, ����Ʈ �迭 ����� ����)�� ��ϵǴ� ��ü
	// ������ �����̳ʰ� MultipartFile ��ü�� �����ϱ� ���ؼ��� CommonsMultipartResolver�� ������ �־�� �Ѵ�.
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
//		System.out.println(uploadFileName + " ������ ���ε� ��û�Ǿ��׿�....");
//		this.uploadFile = uploadFile;
//	}
	
	// private ��� ������ �����ϴ� public Getter/Setter �޼ҵ带 �ۼ��Ѵ�.
	// ���� Ű(Alt + Shift + S)�� �̿��Ѵ�. 
	
	
	
}
