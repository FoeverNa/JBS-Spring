package com.rubypaper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity // 하이버네틱스꺼 사용하면 안된다 // 클래스를 등록한것처럼 Entity클래스들은 자동으로 인지한다

//@Table(name="NEW_BOARD", //이름을 다른걸로 바꿔서 테이블을 만들수도있다
//	uniqueConstraints={@UniqueConstraint(columnNames={"SEQ", "WRITER"})}) //unique제약조건을 두개의 컬럼을 조합해서 건다(2개가 겹치면안된다)

public class Board {
	
	@Id
	@GeneratedValue //(strategy=GenerationType.AUTO) // 디폴트가 AUTO이고 생략가능하다
	private Long seq; // 프라이머리키 컬럼과 매핑되는 변수를 식별자 변수라고 한다.

	//@Column(nullable=false, length=200, unique=true) unique 조건을 하나의 컬럼에만 건다
	@Column(nullable=false, length=200) // 길이제한
	private String title;

//	@Column(nullable=false, updatable=false) // 길이제한 없고 sql- update할때 해당 column은 제외시켜라// 게시글 수정할때 작성자는 수정하지 않겠다
//											// sql을 자동으로만드는데 이런 힌트를 주는 것이다
//	private String writer;
//
//	@Column(nullable=false)
//	private String content;
//
//	@Temporal(TemporalType.TIMESTAMP) // Time, Date 시간만 저장해라, 날짜만 저장해라, TITMESTAMP는 날짜시간까지 다저장해라
//	@Column(columnDefinition="date default sysdate") // 시스템시간을 기본값으로
//	private Date createDate = new Date();
//
//	@Column(columnDefinition="number default 0") // 기본값을 넣을수 있게해준다 // 주석풀고해보기
//	private Long cnt = 0L;
//	
//	@Transient // 임시변수라 테이블에 만들필요 없다
//	private String searchCondition;
//
//	@Transient
//	private String searchKeyword;

}
