# day2

## 게시판만들기?

- 회원테이블만들기

  - create table users(
    id varchar2(8) primary key,
    password varchar2(8) not null,
    name varchar2(30) not null,
    role varchar2(5) default 'USER')

    insert into users(id, password, name, role) values ('admin', 'admin', '관리자', 'ADMIN');
    insert into users(id, password, name ) values ('user', 'user', '회원1');

    select * from users;

  - JDBCProject - newsourcefolder - resources

    - 자바 코드 아닌 것들을 resources에 분리해서 저장한다
    - resources - new - other- sQL Deevelopment- SQLFIle - create_users.sql
      - 여기다가 회원테이블 만든것 붙여놓으면 된다

  - 이클립스에서 sql문할건지 물어보심

- new class com.rubypaper.biz.user/GetUserTest 클래스 생성

  - ctrl + shift + f -> 자동정렬

- main 만들고 Class.forName(h2dirver)해주고

  - jdbc url은 h2에서 복사해서 등록하면된다
  - 나머지는 getboardTEst와 같았다

- 반드시 finaaly에 close로 연결해제를 해야한다



- JDBC 재정리

  - JDBC 프로그램절차 복습
    - Connection을 연결하는데 가장오래걸리고 중요한 자원이기때문에 close를 꼭해줘야한다
    - Statement SQl문전달해주는 것
    - SQL 명령어 전송, Select면 qury로 다른것 update로
    - 검색결과 처리 
      - 단건이냐 목록이냐 차이,  단건이면 if로 하나만뽑고 목록이면 while로 돌리면된다
    - JDBC프로그램은 DBMS에 비종속적이다. 
      - 자바코드는 수저오디지 않고 url과 SQl문만 바뀐다

- 주석 처리 ctrl /  그룹 주석처리 ctrl shift / 

- Statement stmt = null;을 주석처리하고 PreparedStatemnet 로 대체한다 -> 5배이상빠르다 Statement 보다

  - 일반 Statement를 사용할 이유가 없다.

    - 

  - ctrl + 클릭 -> 소스보기

  - extend라고 한 이유, 단순히 변수와 메소드를 물려받는 것으로 생각하면 별의미가 없다.

    - 자식은 부모가 가진 것보다 더 많은 변수와 메소드 기능을 가지고 있다. 그래서 extends라고한다

  - 사용법이 달라진다

    - sql문이 stmt 생성할때 입력되고 createStatement에서 prepareStatement로 생성 메소드가 달라진다
    - exexcuteQury할 때 sql문을 더이상 입력하지 않는다
    - where id= password = 에 직접입력하던 값에 ?로 대체해준다
      - ?는 파라미터로 그아래에 stmt.setSring(1, "admin") stmt.setSring(2, "admin") 해준다
      - ?에 순서대로 해당 값을 넣어주는 형태이다

  - 왜 빠를까?

    - 데이터베이스가 sql문 받자마자 문법을 먼저 체크한다. 만약 틀렸다면 실행시키지 않는다(파싱-문법오류찾기)

    - object를 확인한다, users라는 테이블있는지 없는지 확인한다, 

    - 이두가지 모두 확인해야 데이터베이스 메모리에 올라간다

      - 만약 Statment로 하면 문법이 항상바뀌기 때문에 위에 두가지 작업 반복해서 오래걸린다

      - 하지만 prepare를 하면 ?로 둔것을 그대로 메모리에 넣어놓고 내용만바꿔서 위엦작업을 생략한다

      - ctrl+shift+o임포트

        

- InsertBoardTest 도 PreparedStatement로 교체해주었다

- Dynamic Web Project 테스트

  - http Procjet 생성
  - 톰캣 잡고 modul 2.5로 하면 xml생겨서 편집만 하면된다
  - 당분간은 Java Resources와 WebContent 만 집중해라

- Java Resources

  - .java는 src, 아닌것은 resources

- WebContent는 Web과 관련된 파일들이 작성된다

  - .new .htmlfile - hello.html  < h1> 나영원 - 실행 - 톰캣서버선택 - 내장 브라우저에서 뜬다
  - .new . jspfile 

-  JDBC 포레즉트돌아감
  - common 패킷만들고 JDBCUill 클래스 생성
    - 1,2번 복사하고 conn을 지우고 JDBCUtill.getConnetion 쳐주면 에러발생 -> 메서드만들기누루면 생김
    - 복사한 내용 붙여넣기
    - close도 따로빼서 메소드 만들기
- 출력하는 것을 정리하기위해 dataAccsObject만들것임 = DAO
  - 템플릿으로INSERT해놓고 나머지 이어서 쭉쭉함
  - 글 등록, 수정, 삭제, 상세 조회 , 목록 검색 끝남
- BoardDAO로 이렇게 등록해놓으면 클라이언트에 로직이 간단해져서 알고리즘에 집중할 수 있게 된다
  - 클리언트 어떤 클래스를 이용하는 모든 소스를 클라이언트이다
  - DAO InSEtTest가  상대적인 개념..
  - 알고리즘 ; 메소드로 구현해놓으면 재사용할 수 있고 클라이언트 가독성이 좋아진다
  - 나머지 Test도 다바꾸어주엇다
- 이코드에 문제가 있다 왜?
  - 메소드를 열어봐야 입력파라미터를 알 수 있다
  - 파라미터 상관없이 입력해도 내용이 입력될 수 있다(데이터가 잘못들어갈수 있다)
    - 에러가 뜨고 컴파일 안되면 다행인데 이런 에러가 문제이다
  - 이것 해결하기위해 매개변수 줄여야 한다
- 해결책 BoadVo 생성
  - prviate 변수생성
    - 변수명은 java에 카멜케이스
  - 게터세터생성 alt+shif+s
  - 생성자 -> 디폴트있느건빼고 만들기
    - ctrl +shift+
- InsertBoadTest에서 BoardVo 객체만들고 set으로 명시적으로 값을 입력받음
  - vo를 insertBoard에 넣어준다
  - insertBoard 로가서 vo객체에 getmethod로 값을 꺼내서 입력받게한다
  - 가독성이향상됬다
- 나머지 vo객체 입력받게 변경
  - 그중에 delete를 할때 int만 입력받다가 객체를 입력받는데 낭비아니냐?
    - 아니다, 나중에 매개변수가 추가됬을대(ex) password)
    - 옛날에는 메모리가 빈약했기때문에 메모리를위해서 의미가있었지만 현재는 충분하다
      - 일관성이 더유의미하다
  - 직관성이 좋다

- 문제상황 VO 수정할시 어떻게 할 것인가?
  - 귀찬타
  - 자동으로 처리할 수 있다
  - 롬복으로활용한다
- 롬복설치하고 다양한 메서드들을 에노테이션으로 생성한다
  - 모든걸 포함하는 어노테이션은 @Data
  - 이때부터 변수추가하고 수정하고 다해준다

- 객체에 한해서 사용하는 것이 클라이언트
  - 나를 사용해주는 클래스가 클라이언트가 된다
- DAO가 검색데이터를 어떻게 처리할지를 하면안된다
  - 그래서 DAO가서 vo 리스트로 출력되게 만듬
  - select기능에 메소드는 반드시 리턴타입이 void여서는 안된다
    - 리턴된 값을 클라이언트에서 이용해서 출력값을 결정할 수 있어야 된다.

- 마지막은 이것을 실핼할때마다 자동으로 조회수가 증가하도록 한다
  - 이걸 어떻게 하면 좋을가 생각해보자
  - update board set cnt = cnt +1 where seq = 1;
  - d

















