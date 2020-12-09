# day16

## 복습

- 스프링부트 장점
  - 라이브러리 관리 편하게 해준다 stateter해주서
  - xml설정을 편하게 해준다
    - 내가 만든 클래스는 컴포넌트 스캔으로 등록
    - 내가 만들지 않은 클래스들은 EnableAutoConfiguration(자동설정)을 통해 등로갷준다
  - EnalbeAutoConfiguation은 MeTA-INF에 spring.factories안에 있는 클래스들을 띄워준다
    - 어떤 것들이 자동실행되는지 보고싶으면 logLevel을 debug로 해준다
    - unconditional은 내가 @Contional을 안붙여줘서 그렇다

- 컨디셔널로 설정클래스 해보기 해보기

- 결론이 뭐냐 설정을 안하고 자동으로 객체들이 메모리에 떠서 다처리할수있게 된다
- 개발자들에게 2가지 걱정을 해방시켜준것이다
  - 개발자들은 자기가 개발할 소스에만 집중할 수 있게된다

- 이걸바탕으로 개발해보기
  - JDBCConnetionManagerRunner 만들기
  - ===> JDBCConnetionManagerRunner 생성 => main클래스에서 ComponentScan해줘서
    ===> JDBCConnectionManager 생성 ==> 얘는 자동생성해준애. @EnableAutoConfiguration을 해주었기 때문에
    - 내가만든 객체와 내가만들지 않은 객체 둘다 생성이되는것을 볼 수 있다
  - 이걸왜하는지 생각해야되
    - xml설정을 하라고하니까 초급개발자가 계속 실수해
      - 그래서 자동으로 생성되게 하겠다
- 새로운 BoardConfiguration 만들어서 오버라이딩해보기
  - BoardAutoConfiguration은 부트어플이 실행되자마자 자동설정에의해서 요타입 없다면 실행된다
    - NEwBoardConfiguration 은 자동설정클래스가 아니다 
      - AutoCofiguration에 등록되어 있지 않기 때문이다
      - 그래서 나중에 ComponnentScan에 의해서 실행되는 클래스이다
        - 원래는 오라클용이 생기고 그다음에 h2가 오버라이딩 한다
  - 포인트는 **자동설정으로 뜨는 설정클래스들을 얼마들지 내가만든 환경설정을 통해 오버라이드할 수 있다**
    - 한가지더 이거 메모리 낭비 아니야?
      - 이미 떠있는애에 속성을 바꿔주면 되지 않을까?

- 프로퍼티로 속성만 바꿔주기
  - 클래스만들고 @ConfigurationProperties(prefix="board.jdbc")//외부 프로퍼티 파일을 로딩해서 prefix로 시작하는 프로퍼티만 이용하겠다
  - 추가해주기 @EnableConfigurationProperties



## JPA

- Java Persistence API , 영속화된 데이터, 저장된 데이터
  - ORM프레임 워크는 은 DB연동뿐만아니라 다양한 기능을 제공한다
    - 특히 SQL을 제공해주는게 JPA특징이다
- 스프링 데이터 JPA는 스프링 부트에서 JPA를 쉽게 사용할 수 있도록 지원한다.
  - JPA만 이용해서 순수하게 DB 연동할 수 있는데 많이 복잡하다
  - 좀더쉽게하려면 스프링과 JPA를 연동해서 쓰면되는데 그것두 복잡하다
    - 스프링부트에서는 그 복잡한것을 최소화시켰다
- DB연동 기술 구분
  - SQL을 직접 다루는 기술(JDBC, Spring JDBC, iBATIS, MyBatis)
    - java에 적냐 xml에 적냐에 차이
  - SQL을 직접 다루지 않는 기술(Hibernate)
    - ORM 프레임워크는 프레임워크가 제너레이션 해준다
- SQL을 직접다루는 기술 사례
  - TABLE과 VO클래스를 연동하기 위해서는 CRUD SQL문이 필요했다
  - 만약 유지보수 과정에서 비밀번호가 필요하다면?
    - 테이블에 Paasword 컬럼 추가, 클래스에 변수 추가, 엄청많은 SQL문 추가
    - 유지보수가 어렵다/불편하다
- SQL 을 직접 다루지 않는 기술
  - ORM은 객체의 상태를 데이터베이스에 매핑해서 저장하지 않는다
  - 객체 자체를 컬렉션에 저장하는 것과 유사하다(실제로 그런것은 아니다)
    - 복잡한 SQL이 필요없을 뿐더라 데이터 관리가 매우 쉬워진다
  - hashMap을 사용하는것과 거의 유사하다
    - 프레임워크가 자동으로 해주기 때문에 우리가 할일이 단순해지는것이다
- JPA란?
  - 기존에 표준인 EJB가 너무느려서 못사용하는데 오픈소스인 HIbernate가 좋아서 이걸 표준으로 만든게 JPA이고 현재자바 표준이다
- JPA 개념
  - JDBC랑 비슷하게 이해하면 도움된다
    - Java.sql 패키지에 인터페이스 이용해서 DB에 상관없이 연결이 가능했었던것 기억
  - Application=DAO, 여러개의 orm중에 하나를 선택할 수 있게 사용할수있는 인터페이스인 JPA를 중간다리로 놓고 사용한다
- JPA 동작 원리
  - DAO에서 vo를 저정하려면 JPA이용해서 등록을 해주면 JPA가 JDBCAPI이용해서 지가 sql만들어서 SQL전송하면된다
    - 우리가 할일은 DAO에서 값을 만들어서 값을 전달해주기만 하면된다
  - MyBatis가 JDBCAPI 이용해서 커넥션만들어서 자기가 해주는것 까지는 똑같다
    - 한가지만 달라 SQL을 xml에 내가 직접 작성하던 것



## 실습

- JPA프로젝트 만들기
- porm.xml 추가
- import javax.persistence.Entity; 
  - 하이버네티스를 바로이용하면 안된다
- 프로퍼티스 추가
- 서비스 클래스만들기



- 스프링부트는 하이버네티으틀 기본 JPA 구현체로 사용한다

- Meta-INF 폴더를 JPA가 인지해서 클래스패스상에 META-INF가 있기만 하면 인지해서 xml파일을 일단 로딩을한다
  - 그과정이 우리눈에 안보이는 것 뿐이다
  - persistence.xml이 메인 설정파일이고 얘가 로딩된 상태서 여러개의 unit중에서 name이 맞는 unit을 생성해주어야한다
    - 다른 설정가진 unit있어도 무시하겠다
    - myBatis에서 SqlSession 공장이 있던거랑 똑같은 것이다
    - 그 팩토리에서 Manger를 얻어내면 걔가 JPA컨테이너다
- 프로퍼티 설저은 소스에
- @entity가 붙은 클래스만 em에서 사용할 수 있다
- @table가 없으면 Entity 클래스와 똑같은 이름에 테이블을 업데이트하거나 create한다
  - 근데 클래스이름을 다르게하고싶을때는 Table이름을 다르게 지정해주면된다
- 테이블 새로만들어질때 Enttity 변수이름이 컬럼으로 자동으로 사용이 된다
  - 이걸 바꾸고 싶으면 컬럼이라는 @Column(name="regDate") 것써서 변수명과 다른 컬럼만들수있다
    - update상태에서는 컬럼이름만 alter해서 바꾸어 준다
- @Id - 해당 변수가 프라이머리 key 해당하는 변수는 의미
- @GeneratedValue - 자동으로 +1씩 증가된 값이 할당이 된다



**식별자 값 자동 증가**

- 엔티티는 반드시 pk 칼럼과 식별자 필드를 가져야한다
  - @Id가 설정된 변수가 식별자 변수이다
- GeneratedValue 를 사용하여 식별자 필드에 자동으로 증가된 값을 할당할 수 있다
  - 식별자 값 자동증가 시킬때 사용하는 생성전략이 있다
- Table, SEQUENCE를 설명하시려다 오래걸린다고 안하신다 왜??
  - AUTO를 많이 사용한데. 하이버네이트가 데이터베이스에 맞는 PD값 생성 전략을 선택한다-
  - DB별로 최적화된 전략을 사용한다
    - AUTO로 했으면 MySQL을 하면 Identtity로하고 h2나 oracle로하면 sequence로 한다
  - DB별로 AUTO사용하지 않고 해당하는 전략을 실제 세팅할 수 도있다
- 테이블 전략 vs 시퀀스 전략 장단점
  - 테이블 전략은 DBMS에 무관하게 사용할수있지만 별도의 테이블이 필요하고 속도가 느리다. => 잘사용하지 않는다
    - 의도하지 않은 테이블을 만들어야 한다
  - 시퀀스 전략은 빠르고 테이블을 만들지 않아도 되지만 시퀀스를 지원하는 데이터베이스에서만 사용할 수 있다
- 식별자값 자동생성전략을 오토로 하면 DB가 h2면 시퀀스 지원하면 시퀀스지가 만들어서 쓴다
  - mysql로바뀌면 identity 선택하고 identity이용해서 increment한다



**JPA에 이해**

- 1) MentityManagerFactory ENtityManager 이해

  - META-INF에 persistenc.xml만 있으면 Persistence 메모리에 띠운다
  - ENtityMangaerFactory를 만든다
  - factoryf를통해 manager를 만든다

- Persistence라는 클래스에 .createEntityMangerFactory 스태틱메소드 호출하면 "unitname" META-inf persistence가 로딩이된다

  - EntityManager em = emf.createEntitymanager();

- em에게 이제 명령을 내린다(컨테이너에게 명령을 내린다)

  - persist-insert
  - merge-update
  - remove-delete
  - find-select one
  - createQuery-select list

- 2) 영속성 컨텍스트

  - 영속성 컨텍스트 = 영속성 컨테이너 = EntityManager
    - 영속성을 해게해주는 컨테이너로 이해하면될까?
  - JPA컨테이너에 접근하려면 EntityManger에 메소드를 이용해야한다
    - EntityManager = JPA컨테이너라고 이해하면 된다
      - 그니까 완전똑같은건 아닌가보다
    - Manager는 JPA컨테이너에 접근하기위한 매니저인가보다

- 엔티티의 상태

  - JPA 컨테이너에 등록된 객체는 4가지 상태를 가질수 있다
    - 생성(New)  : 비영속 상태라고 하며 아직 JPA컨테이너에 등록되지 않은 java객체
      - Board board= new Board(), 엔티티객체가 생성만 되어있는것
    - 영속(Managed) :
      - persist()메소드
        -  persist()메소드를 통해 JPA컨테이너에 등록이 된 상태
        - JPA 컨테이에게 관리해달라고 Manger가 persist하는 것임
          - 이후 JPA에서 영속상태에 객체를 기준으로 DB에 insert문을 작성한다
      - FInd메소드
        - JPA컨테이너에 등록되어있는 entity를 find하면 select하지 않고 객체를 그대로 출력함
          - JPA컨테이너에 등록되어있지 않은 경우 DB에서 Select에서 가져와서 JPA Entity로 등록하고 값을 가져온다
      - 영속상태에 있는 객체에 변수값을 바꾸면 자동으로 Update가 발생하게 된다
        - 관리상태에 있는 객체는 값을 변경시키면 JPA컨테이너가 자동으로 변경사항을 변경한다
        - writer변수는 updateble=false를 줬기때문에 따로 update SQl에서 제외되게 된다
    - 준영속(Detached) : 
      - 준영속 상태는 영속성 컨텍스에 들어간 컨텍스트가 잠깐 벗어난 상태
        - 값을 변경해도 update되지 않는다(관리되지 앟는다)
        - em.persist하고 다시 em.detach 하면 준영속상태로 일시적으로 영속상태 벗어난다
          - 이때 set해서 값을 변경시켜도 update되지 않는다
        - em.merge를 통해 다시 영속상태로 되돌릴 수 있다
          - 이때 수정된 값이 db에 저장되게 된다
    - 삭제(Removed)
      - 엔티티를 JPA컨테이너에서 제거하는 것
        - db에 delete가 처리 된다
        - 생성만한 객체와 똑같다. => 객체자체를 지우는게 아니니까! 
          - 다시 persist를 통해 객체를 등록할 수 있다
            - 하지만 다시사용하지않고 GC되도록두는게좋다

  - 그림을 인해하면된다

![image-20201208220213145](C:\Users\foevn\Documents\dev\devlog\Images\image-20201208220213145.png)

- 

































