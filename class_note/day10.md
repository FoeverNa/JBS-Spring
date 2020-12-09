# day10

## 수업 내용 정리

### 지난 시간 리뷰

- 사용자가 시스템 사용하면서 호출하는 모든 비지니스 메소드를 jointpoint라고 한다, 
  - *Join point*: A point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point *always* represents a method execution. Join point information is available in advice bodies by declaring a parameter of type `org.aspectj.lang.JoinPoint`.
  - 좀더 찾아보니 조인포인트는 프로그램 실행중에 특정 시점을 말하는 것 같은데 Spring에서는 메소드가 실행되는 시점을 뜻하는 것 같다.

- 어드바이스는 포인트컷으로 필터링된 비지니스 메소드에서만 작동한다
  - 이 두개를 묶어주는 것이 어스팩트이다.
- 어스팩트(aspect)를 어드바이저(advisor)라고도 한다
- 어노테이션으로도 AOP를 설정이 가능하다
  - 먼저 \<aop:aspectj-autoproxy/>을 xml에 작성해주어 자동으로 AOP설정을 할수있도록 한다
  - 어드바이스 클래스에 @Service @Aspect를 달고 메소드를 선언해 @pointcut과 @Before와 같은 어노테이션을 달아주면 어스팩트 설정이 되서 빈으로 등록되어 사용된다

### JDBC Template

- 기존 JDBC프로그밍의 문제

  - 정해진 순서대로 진행해야 되기 때문에 하나라도 빠뜨리면 안되고 중복된 코드가 발생한다
  - 이런 절차적인 부분을 해결하고 가변하는 SQL문만 개발자가 처리할 수 있게 개발한것이 JDBCTemplates다

- 기존의 DAO 클래스를 복사해서 하나더 생성한후 JDBC를 위한 변수들을 지우고 JDBCTemplate 변수 spring을 선언한다

  - 이후 Insert, Update, Delete는 spring.update("[SQL문]") 을 통해 모든 코드를 대체할 수 있다
    - 10줄 이상의 코드가 1줄로 줄어드는 마법을 볼 수 있다
    - 물론 우리가 하지 않는 작업은 스프링 프레임워크에서 진행을 해주게 된다

  - JDBCTemplate을 사용하기 위해 xml에 파일에 bean으로 JdbcTemplate 클래스를 참조해주고 property로 dataSoruce를 넣어준다
    - bean 으로 datasource를 등록하고 아파치에서 제공하는 BasicDataSource를 참조하고 property로 db정보를 입력해준다
      - datasource는 입력 받은 db정보를 가지고 연결에 오래걸리는 커넥션을 풀로 만들어 놓아 커넥션 생성시간을 줄여 빠르게 디비 접근 작업을 처리해주는 역할을 한다
  - 소스 변경없이 DAO를 교체하기 위해서 DAO를 인터페이스로 만들어  두 클래스 모두 구현하고 DAO에 주석으로 @Repository 되있는 것들을 지우고 bean을 둘 중 하나만 등록하여 참조하는 클래스를 달리하면 autowired를 통해서 bean으로 등록되어있는 하나의 빈만 변수에 들어갈 수 있게 된다

-  getBoard, getBoardList의 경우 Iinsert와 다르게 retrun이 있어서 약간더 복잡하다

  - 먼저 Map을 return하게 할 수 있는데 spring.queryForMap([SQL문],args]을 통해 userVO의 정보를 Map형식으로 출력할 수 있게 한다
    - args는 Object[]로 SQL문에 ?에 값을 set할때 필요하다
  - 이 방식은 다른 설정없이 map으로 retru 받을수 있는것이 장점이지만 다른 메소드들과 retrunType이 다르다는 단점이 있다
    -  RowMapper를 통해 이를 해결할 수 있는데 RowMapper는 SQL문의 결과값인 ResultSet을 원하는 타입으로 Mapping할때 쓰는 클래스이다
  - boardRowMapper클래스를 만들고 RowMapper클래스를 구현하면 mapRow메소드를 오버라이드하는데 여기서 입력파라미터로 제공하는 ResultSet에서 값을 가져와서 원하는 타입으로 매핑을 하면된다
    - mapRow의 기본 returnType은 Object로 impleamnet할대 제너릭타입을 지정해주면 해당 returyType으로 바뀌게된다
    - 또하나의 파마미터인 int rowNum은 rs에 해당 rownum을 나타낸다
    - getBoard()메서드에 spring.queryForObject([SQL문],args,new boardRowMapping)같이 rowMapping 객체를 생성해서 넣어주면 



**어제 복습**

- 사용자가 시스템 사용하면서 호출하는 모든 비지니스 메소드를 joinpoint라고 한다

  - 포인트컷후보라고말하는 책도있다

- 어드바이스는 포인트컷으로 필터된 비지니스 메소에서만 작동한다

- 그래서 어스펙트 설정을 해주어야 한다

  - 포인트 컷 + 어드바이스
    - 어스팩트에는 포인트 컷, 사용시점, 어드바이스, 메소드이름이 들어간다
  - id를 통해서 포인으컷을 구분해서 적용한다

- 어스팩트를 어드바이저라고도 한다

  - 결국엔 같은 용어이다

- 어노테이션으로도 AOP 설정이 가능하다

  - <aop~ 가 필요하다
  - IoC에서는 컴포넌트 스캔이 필요했다

  - @Service와 @Aspect가 필요했다

- After는 단순히 로그를 출력한다거나 아주기본적인 사후처리만한다. return값을 가지지 않기때문에




**오늘 수업**

- JDBC 프로그램의 문제
  - 1)정해진 순서대로 진행해야한다
    - ?가 20개면 20개를 다세팅해야하고 빠뜨리면 안된다, 많을수록 힘들어진다
    - finally를 안하면 실행도 다되지만 다른 곳에서 접근하러면 기다려야한다
    - 다른 메서드와 겹치는 코드가 많아진다
    - => 누군가가 중복되는 코드 처리해주면 개발자들은 SQL만 처리하면안될까? 
      - 여기서 출발한게 스프링 JDBC
- Autowired있으면 반드시 빈에 있고 2개있으면 안된다
  - id가 필요없이 떠잇기민하면 autowired 해주겠지
- 실행시키면 또에러
  - property해야된데 (세터인젝션)
  - porperty에 datasource추가
    - bean등록해줘야 하니까 해주고 property 4개 추가해주기
  - A factory for connections to the physical data source that this DataSource object represents. An alternative to the DriverManager facility, a DataSource object is the preferred means of getting a connection. 
  - 데이터 소스?
    - SQL이 db에 전송되서 처리되는것은 시간이 얼마 거릴지 않는데 커넥션이 오래걸린다
    - 근데 DataSource는 여러 회사에서 공통적으로 커넥션 풀(Connetion Pool)을 가지고 있다
      - 커넥션 풀은 벡터같은 자료구조인데 이안에 커넥션이 생성되어 대기하고 있음
    - 커넥션 정보를 읽어서 커넥션을 몇개 미리 풀에 생성해 놓음
      - 꺼내쓰고 반납하는 구조
    - 이렇게해서 커넥션을 생성하는 시간을 줄여놓는다
    - 그래서 데이터소스를 생성하고 디비연동을하는게 기본이다
- 직접하던 JDBC API 사용을 JDBTemplate에게 맡김
  - 그럼 JDBCTemplate은 어떻게 알고 연결을하냐?
    - DataSource를 내가 알려주어야 한다
    - Setter나 생성자로 넣어주어야 Datasource에 커넥션풀을 이용할수 있다
    - 그래서 Template은 datasource없이 동작할수가없다
- JDBC에서 template으로바꾸기
  - serviceimpl 에서 바꾸면되지
  - insert, update, delete다 동작한다
  - 얘를 안쓸수가 없다 자바코드가 이렇게 주는데
- 두개 바궈가면써쓰게하기
  - 인터페이스 만들어서 다형성만들고
  - @Repository지우기
  - 둘중하나만 bean등록하기
- Getboard
  - Map으로 return하고 queryForMap해준다
  - arg 선언해서 물음표갯수만큼 값을 세팅해주면 자동으로 채워준다
  - 인터페이스와 dao 고쳐주고 getboard하면 된다
  - 테스트에서 이제 평집해서 보여주기 get(key)로 value가져와서
- 근데 문제가 있다
  - 모든 DAO를 getBoard를 BoardVO로 통일할 수 가 없다
  - 일단 이게 편하니까 쓰는거다
- GetboardList
  - qeuryForList쓰면 map형태로 List로 가져온다
- 장점은 이게 편하다. 근데 return이 BoardVO야 되는데 안된다
  - 그럼 검색결과를 보드vo로 넣어서 줄수있다. 
    - 근데 귀찬타..
- 그래서 다시 return을 boardVo로 바꾸기
  - 각각의 query메서드를 바꿔준다
- 클래스하나 더만들기
  - BoardRowMapper 만들어서 넣어주었더니 Vo와 List로 유지할수있다
  - 그외에 고쳤던 것들을 다시 VO로 고쳐주고 실행해보면 잘된다
  - RowMapper가 뭐해주는애인지 찾아보면좋겟네
- User는 내가해보기
  - rowMapper가 무어냐
    - 조회해서 나온 RS에 검색결과가 나올텐데 RowMapper를 이용해서 매핑해
      - RS의 Row를 어떻게 Maping할것이냐를 결정하는애가 Mapper인거지
      - 그거를 Template에서 해준다
- queryForObject 메소드는 검색 결과가 하나인 쿼리를 위한 메소드다.
  - 만약에 실행 결과가 두 건 이상이면 Exception 발생
  - 따라서 검색 결과가 두건이상이면 .query()를 사용해야한다
- User 실습
  - args넘겨줄때 Object args 만들어서 넘겨줘도된다
  - rowmapper에서 rs쓸때 1,2,3,4 넣어도되는데 뭐가먼지를 모름

- MapRow메소드에 rowNum은 Rs에 row번호가 한번식들어간다
  - 3개의 자료있다면 mapRow가 3번 실행되는데 그때마다 rowNum에 0번부터 들어가게된다



이제 트랜젝션으로 가야됨

- xml하나더만들어서 분화
  - 너무많은면 이렇게 분화하면된다
  - 보통은 기능별로 xml을 여려개를 작성한다
- tx 네임스페이스를 추가해준다
- xml을 연결해주어야한다
  - String[] 으로 두개 다 담아서 넣어준다
  - business-*.xml으로 둘다 읽어버림
  - 이래서 import 태그를안쓴다..