# day1

## 다형성

- samsung Tv클래스 작성

  - default 생성자의 역할 설명
    - 디폴트생성자는 매개변수가 없는 생성자는 디폴트생성자
    - 멤버변수를 초기화한다
    - int는 0, 참조형은 null
    - 디폴트생성자는 멤버변수를 디폴트 초기화 하기 때문에 디폴트 생성자이다. 
    - 이모든 것들이 중요하다스프링설명때

- TVUser 클래스 작성

  - main 만들고SamsungTV 객체생성하고 메소드들 써바
  - 이렇게 짤거면 C언어로하래
  - 유지보수가 어렵다 

- 삼성 티비 클래스 복사해서 LgTv 클래스 생성

  - LgTv 로 만드려고했더니
  - 다형성 없이 만들었더니 엄청 귀찮다, 이게 100개면 망한다

- polymorphism2 패키지 생성 

  - SamsungTv 클래스 - Refactor - ExtractInterface하면 알아서 인터페이스가 생김
  - LGTv도 해준다

- 다형성을 적용하니 적용하니 유지보수가 엄청 쉽다

  - One interface Multiple Implements -> 여러개의 구현체를 가진 하나의 인터페이스
  - 멀티 리모콘 으로 다양한 테레베 동작시킬 수 있는것 같이. 인터페이스가 통일되면 장점이 생긴다는거지

- 다형성의 문제?

  - 클라이언트를 아예 안건드리고 티비를 바꿀 수 있을까?

- polymophism3만들고 BeanFactory 클래스생성

  - 다형성 개념을 제대로 알고 있어야 나중에 나오는 내용들을 전체적으로 이해할 수 있다

  - 클라이언트를 수정안한다는게 무슨말이지?

  - 실행 버튼옆에 다운버튼 누루고 EditConfiguration - Configuration - Program arguments 에 값을 입력

  - Samsung입력하면 Samsung 생성

  - 자바소스를 건드리지 않고 자바소스를 유지보수할 수 있다

    

## 프로그래밍 발전

- 복사/붙여넣기하다가 반복되는것이 많아지니 나온게 함수

- 함수를 기반으로하는 절차지향 프로그래밍

- 함수만 가지고 있는게 아니고 데이터(변수)까지 가지고 있는게 클래스(코드재사용 극대화)

  - 클래스를 여러개 교체하면서 사용해야 되기 때문에 다형성이라는 것이 필요하다
  - 다형성 쓰지않을거면 구지 객체지향할 필요가 없다

- 다형성을 뛰어넘는 것이 디자인 패턴

- 클라이언트만 봐서는 무슨 TV가 실행할지 모른다 

  - 클라이언트소스만 봐서는 어떤게 실행될지 모르게 해야된다
  - 구글 TV만들어서 google로 실행한다고 구글티비되냐? 안된다, 팩토리가 포함안되있다
  - 그래서 TV추가될때마다 컴파일 다시하고 배치다시해야된다
  - 그럼 유지보수가 잘되려면 소스추가를 하지말아야한다

- 그걸 해결한게 스프링 프레임워크!

  - 유지보수할 때 java소스를 건드리지 않는다. 컴파일을 다시하지 않을수 잇다. 이에 따른 장점이 엄청 많다

  - 너는 왜 스프링을 쓰면 자바소스 안건드리고 유지보수가 가능하기 때문이라고 답하면된다

    

## JDBCProject - 데이터베이스 연동

- h2다운로드 압축풀기 - h2/bin/h2w.bat가 구동파일

- azul.com - zulu 많이쓴다 

- h2 실행

- jdbc:h2:tcp://localhost/~/test URL 을 변경

- 테이블 생성

  - create table board(
    seq number(5) primary key,
    title varchar2(200),
    writer varchar2(200),
    content varchar2(200),
    regdate date default sysdate,
    cnt int(5) default 0
    );
  - insert into board(seq, title, writer, content) values(1, '가입인사','테스터','잘 부탁드려요.');
  - select * from board;

- ProjectStructure - Libraries - +버튼 -  h2folder - bin - .jar 파일 추가하면 라이브러리 추가한것

-  com.rubypaper.biz.board 패키지생성

  - JDBC 코드 작성(Java Database Connectivity)
    - InsertBoardTest 클래스만들고 Coonetion과 Statement 변수만들기
    - 드라이버 객체 메모리에 로딩
      - DriverManager.registerDriver(new org.h2.Driver());
      - 
    - 커넥션을 획득
      - 
    - SQL 전달(Statement)를 생성한다.
      - 
    - SQL을 전송한다
    - 
    - 1건의 데이터 처리 성공!! =

- JDBC 정리

  - 모든 RDB를 동일한 자바로직(코드)로 연결할 수 있는 기술

  - 위에 자바코드에서 달라지는 것은 SQL문과 커넥션이 달라진다

    - 문자열만 바뀌고 자바코드는 그대로 사용할 수 있다

  - java.sql 이 JDBC API 이다

    - Aplication = InsertBoadTest 라고 보면된다

  - 클라이언트가 있는데 얘가 InsertboadTest이다 이걸 개발하는데 인터페이스를 이용해서 개발한다

    - 인터페이스를 구현한 구현체들이 필요할 것이다
    - 구현체들은 교체가 가능하다
    - 소스만 변하지 않으면 클라이언트를 변화시킬 필요가 없다.
    - Connection과 Statement가 인터페이스다

  - JDBC API를 이용해서 연결하는데 JDBC Driver는 각 DB사들이 만든다

    - 우린 Application을 만드는 역할이다

  - PPT) Java 응용프로그램(IBT) - > JDBC Interface(java.sql)을 이용 한다 - 실제로는 구현 클래스들이 동작한다(얘들이 드라이버)

    - 클라이언트= java 으용프로그램, Tv = Jdbc, 각 Tv들 = 드라이버(벤더 개발자가만듬)

  - PPT JDBC의 동작 원리)

    - 응용 프로그램은 SQL String을 전달해서 주면 된다
    - 워크벤치쓰듯이 SQL이 DB로 전달되게 하는 과정인데 이때 중요한것이 JDBCInterface와 JDBC Driver가 중요하다
      - 우린 라이브러리에 h2.jar만 추가해주면 JDBC 인터페이스에 대한 구현체들이 라이브러리가 담고있어서 활용할 수 있다

  - JDBC URL 종류

    - DriverManager를 통해서 특정 Driver를 로드를 해야되는데 Db별로 Driver가 다르다
      - 그 드라이버를 등록하는 코드가 DriverManager.registerDriver(new org.h2.Driver()); 이다
        - 이게 제일 중요한 과정이다. 어떤 드라이버를 메모리에 로딩하는가 => 이게 가장 중요하다
      - Class.forName("new org.h2.Driver()") 
        - 문자열을 똑같이 메모리에 올린다?
        - 위와 같은 결과를 낸다 -> 간단해서 더 사용된다
        - 얘는 컴파일이 함부로 된다는 단점이 있다. 문자열만 체크하기때문에 ... 
        - 해당 위치의 클래스의 객체를 만들어서 메모리상에 올려준다
          - 그럼 JVM에서 내부적으로 찾아서 드라이버를 올려준다. 다검색하지는 않고 해당클래스 따라간대
            - 이런 내부코드보고 이해할 수 있을정도로 실력이 올라가고싶네

    

  - 4줄이 실질적인 JDBC 코드이다 - 얘는 외우는게 좋다

    - DriverManager.registerDriver(new org.h2.Driver());

  - Connetion 을 위해 사용하는 코드

    - DirverManager.getConnetion(url, sa, " "); 
    - url, id, password순으로 입력하고 이게 반드시 데이터베이스의 URL과 id, password와 같아야 한다
      - 이게 다르면 접속할 수 없다
    - jdbc:h2:tcp://localhost/~/test
      - url을 통해 h2데이터 베이스에 접속할 수 있다는 것, localhost = IP주소
    - url을 연결했을 때 h2와 연결할수 있는 이유는 h2 드라이버를 이용해서 접속했기 때문이다.

  - JDCB URL 종류

    - JDBC URL은 DB마다 다르다
      - DB관리자한테 물어보면된데..

  - stmt = conn.createstatement 를만든다

  - sql 문을 stmt.executeUPdate(sql)로 보내준다, cnt는 뭐지? 전송성공횟수?

- JDBC 정리

  - App "SQL"을 D/B로 보내는게 핵심
  - 비유 : SQL이 사람이라면 DB가 부산이다.
    - 그럼 고속도로는 Connetion이다
      - 고속도로를 뚤으려면 3개의 정보 필요, url, id, p/w,
      - 대전으로가려면 이정보가 달라져야겠지
    - Conntion을 타고갈수있는 자동차가 Statement
      - 서울과 부산이 연결되고 자동차가 Statement이다.
      - 자동차에 사람을 태우는게 stmt.executeUpdate(sql);이다.

- DelteBoardTest 클래서 작성

  - 1,2,3 까지 똑같고 4번에 sql문만 달라지면 delete가능하다
  - executeUpdate 하나로 모두 실행한다

- UpdateBoardTest 도 한다

- Select도하는데 제일 복잡하다

  - .executeUpdate는 curd를 위한것
  - .executeQuery로 바꿔주고 int가아닌 Resultset을 받아줘야한다
  - 출력은 RS.GETiNT이런식으로 받아준다

- ResultSet 객체의 구조

  - executeQuery 는 select 전용 메서드
    - 결과집합을 return한다
    - 그림으로 그리면 이런모양이다.
      - Before Fist
      - 데이터1
      - 데이터2
      - .....
      - After Last
    - 커서라는 게 있다.  처음에 Before First에 가있다
    - 이때 while문 rs.next를 하면 커서를 밑으로 한칸내려준다
      - return이 boolean 데이터 읽을게 있으면 true
      - 데이터가 이싿면 6개의 컨솔에 뿌리는게 getInt.이런식으로 읽어서 표시해준다
    - 다시 올라가서 rs.next()로 가서 커서내려나고 반복되다가 AfterLAst가면 false된다
  - 만약 while문 없이 컴파일을 했다면? rs.next를 안했기 때문에 읽으려면 NOdata is availabe에러가 난다
    - rs.next를 해야 커서가 내려가야 한다.
      - 그래서 while문 돌린다.
  - 각각의 컬럼의 값을 가져올땐 datatype에 가져와야 한다. 
    - 정수는 in로 가져오고 varchar는 String, 날짜는 Date
  - 컬럼이름을 모르는 상황에서는? 
    - 1,2,3,4,5 같이 위치를 지정해도 실행이 된다.
      - 실행이되도 문제는 가독성이 떨어진다.
      - 그래서 가급적이면 컬럼이름을 써야 한다
      - 컬럼 이름은 대문자로 표기하라
      - 컬럼의 순서는 안맞춰도 되지만 맞춰주는게 좋다
  - 그다음 List말고 상세정보 출력할때
    - sql문 병경
    - 검색결과 처리
      - 모두 ln으로 바꿔주고 while문 if로 바꿔주고(하나만 체크해서 있냐만 보면되니까)
      - 그 다음 앞에 항목이름만 붙여주면 되니까
  - CRUD 가 끝났다
  - 근데 이렇게 끝내면 작살난다 왜? Connetion은 닫아줘야 한다
    - 커넥션은 비용으로 이어진다
    - 웹에 경우는 수백명이 DB연동 할수있기 때문에 커넥션을 꼭닫아줘야한다
    - 커넥션으로부터 세트이트먼트 얻었고 스테이트먼트 에서 리절트셋 얻었는데 역순으로 닫아줘야 한다
      - 그래서 rs닫고 stmt닫고 conn닫았는데 문제가 생긴다 
        - rs나 stmt 에서 예외가 발생하면 conn이 close가 안된다!
          - tyr에서 하나만 excetipn 뜨면 catch로 넘어가버리자나 오오
        - 그래서 각자 trycatch해서 해준다
        - 근데 conn을 하나더추가해줘야 한다
          - 이결과를 다른 클래스에 모두복사
  - primarykey
    - values((select nvl(max(seq), 0) +1 from board), '테스트제목', '테스터', '테스트 내용....')"
      - 데이터가 없을대 Max구하면 null이 나온다, null + 1은 null, null 비교연산은 false
      - primarykey에는 null못넣는다 그래서 null값안들어가게 nvl을 써야한다
      - nvl(max(seq), 0) => nullvalue (max(seq)가 null이면 0으로 바꿔줘라) -> 그럼 이제 null걱정없이 사용할 수있다

### 숙제

해당 프로젝트를 eclipse로 옮기기

