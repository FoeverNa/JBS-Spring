# day13

### 어제복습

그림그리기

web.xml 일겅서 서블릿 컨테이너 만들기 - > contextListener부르고 business-*.xml에 속하는 모든애들 다 읽준다 -> 첫번째 XmlWEbApplicationContext생성(스프링 컨테이너) - 이때 서비스 임플 객체가 뜬다(@service) - @Repository(DAO) 가 로딩된다- Autowired가되는것까지 처리가 됬을 것이다 // 여기까지가 Buisiness레이어에 IOC 가 적용된것 // - //AOP적용// @Service 붙어있는 ADvice 객체 생성, 그리고 포인트컷 설정과 어스팩트 가 그걸 연결해주는것까지가 이루어진다 //여기까지가 서버를 껏다켯을때 - 처음으로 .do 요청이 둘어왔을때 DispatcherServlet을 생성해준다 (Listner는 프리로딩, 서블릿은 레지이로딩) -> 디스패쳐 init()메서드가 presentation.xml 를 로딩하여 2번째 컨테이너를 생성한다 - > 얘도 XmlWebApplicationContext 근데 얘는 컴포넌트 스캔 범위가 다르다 -> @Controller객체와 @autowire되서 서비스 임플을 참조하게 된다.

- 서블릿 컨테이너는 web.xml을 읽었기에 리스너, 서블릿객체, 필터를 관리한다. 
- 첫번째 스프링컨테이너가service와 repository advice를 관리한다
- 두번재 스프링 컨테이너가 Controoler를 관리한다

- 이렇게 불리해놓으면 테스트가 엄청 편리하다 - > genericapplication 컨테이너가 있기때문에 톰캣을 구동안해도 테스트가 용의하다

스프링MVC 정리

- sessionAttributes(board")
  - 수정작어밯려고했을때 null로 작성자가 되지않으려면 어떻게 해야할까?
  - 상세를 먼저보는데 Model이라고 객체에다 addAttribute를 "boad"에 담아 서 뿌려라했으면 리퀘스트에 저장해준단말이야
  - 근데 Model중에 "boad"라는 애가 나오면 session에도 넣어주어라(리퀘스트는 원래된다)
  - @ModelAttribute("boad")하면 세선에 board가 있으면  객체들를 가져와서 vo를 넣어주고 없으면 vo를 새로생성해서 넣어준다
  - **실제로 프로젝트할때 사용할수있는기능**

### 새로운내용

**파일 업로드**

- 핵심기능은 아닌데 써야하고 모르면 고생하는내용
- insertboard를 수정해준다
  - 파일업로드는 post방식밖게 되지 않는다
- BoardVo수정 
  - multiparFile 타입 변수 추가(스프링프레임웤)
  - 게터세터는 롬복으로 자동생성된다
- presentation-layer 수정
- BoardVO  돌아가서 @DAT 지우기 게터세터 만들기 그리고 다시 @DATA하기
  - 업로드파일만 내가만든걸로하겠다
- insrtboard 작동할때 boardVO vo에 나머지는 setter injection 하는데 ㄹ파일은 MultiFile은 그객체에 들어가야되는거지
  - 그럼 MF객체는 누가만들어주냐 컨테이너가 해준다.
    - 그객체만들때 여러 정보들도 다 넣어서 만들어주었겠지
- 게터세터는 지워주기
  - 담겨있는 MF를 가져다가 업로드처리를 해주면된다
- 근데 만약에 mutipartResovler가 등록되어있지 않으면?  쓸수가 없다
  - id가 특히중요한데 생성되있어도 틀리면화룡을 못한다
  - 얘가 있어야 객체를 생성할수있다 MultipartFIle
- 마지막으로 boardController에 가서 인서트수정
  - 파일 업로드 처리
  - 내가 지정한 디렉토리에 올라갓는지 확인
  - getOrigianlFilename : 파일이름을 부텨주기

**로그인컨트롤러**

- 9/0해주기

  - 500화면뜨는데 이걸 어떻게

- preentation-layer로 오기

  - exceptionResolver 빈으로만들기
    - <exceptionMappings 입력해주고 prop로 입력해주기
    - property는 prot list는 list 등 넣어줘야하는 것을 고려해서 넣어줘야 한다
    - 실행하면 뷰리졸버 작동해서 앞뒤로 붙어서 실행이 될것이기 때문에

- board에 error파일 만들기

  - arithmetic.jsp를 error에 추가하기
  - nullpointerexption도 추가하기
  - 다른 property로 기본 error(위에 에러 다른것하고는 다른거다)

- 에프터 스로잉어드바이스랑은 다르다

  - 그건 비지니스 메소드 실행했을때 어떻게처리할까에 문제이다
  - 위에 예외와는 화면에서의 예외처리는 다른다

  

**중요하고도 재밌는거**

다국적 사용자에게 맞게 로그인패이지가 바뀌도록 하는것

- resource에 패키지와 파일만들기
- properties 에디터 생성 - opnewith simple 로 열면 한글잘보인다
- 언어별 properties 작성해주기
- presentation 에 다국어 처리 설정 추가해주기
  - 파일이름을 판단을 못하기 때문에 
  - .properties는 확장로 두지 않는다
  - 컴포넌트 하나당 파일을 하나씩 작성해야한다
  - 로케일에 해당하는 것 지우고 한번에 로딩하게 된다
    - 관리하기 편하게 하기 위해서
    - 결론적으로는 확장자도 제외하고 _바도 제거한다
- LocaleResolver 등록
  - HTtpRequest 헤더에 locale 정보를 가져온다
  - 주로 SessionLocaleResolver를 사용한다
- login.jsp가기
  - <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>추가
- presentation-layer추가



**검색결과를 JSON으로 변환하기**

- A라는 회사가 B라는 회사로 30 이라는 데이터를 보낸다
  - B라는 회사는 30이라는 데이터가 뭔지  어떻게 알지?
  - 그래서 태그를 사용하는 XML이 등장했다
    - 지금은 설정파일에 쓰지만 원래목적은 데이터를 주고받으려고만들어졌다
- 왜 xml을 사용해야하나?
  - A시스템은 Java, B는 .NET으로 되어 있다면 데이터를 주고받을수 있는 방식이 제한되었다
  - 그래서 text파일 형식인 xml을 사용한 것이다
    - text는 어떤 언어나 플랫폼에서 처리가능한 형식이기 때문이다
- 근데 xml에 단점이 부각됨
  - 태그를 모두 사용해야하니 데이터가 많이 사용됬다
  - 그래서 경량화된 데이터 포맷이 개발되었다
  - 이게 **JSON**
  - key-value형식으로 구현되어있다

- presenation
  - \<mvc:annotation-driven/>하나면 충분하다, 필요한 3개 의 빈들 등록해준다
- boardController를 작성
- 이게 왜 중요하냐면 이 주소만 알면 게시글에 정보를 모두 확인할 수 있다. 디바이스에 상관 없이
  - 플랫폼과 상관없이 데이터주고받을수있게된다

- null값 뜨는애들 정리해주기
  - @Data 주석주석처리 하고 get메서드 만들어주기
  - @JasonIgnore 달아주기



### 이제 마이바틱스

- 새로 프로젝트만들고 dao복사해서 정리해주기

- 2개파일을 

  - 얘는 org에서 가져온애들이다

- boadMapping.xml

  - board관련sql을 다여기다 저장해줄거다
  - id 메소드랑 똑같이해서 SQL문 옮겨준다

- 예전에는 DAO 클래스안에 SQL문이 들어있었기에 SQL을 수정하면 컴파일을 다시했어야 했다

  - 가독성위해 +로 개행처리하면 String이라 메모리낭비가 컸다

- 이젠 sQL이 xml로 옮겨졌다

  - 컴파일 안하기 + 개행처리 쉬운것이 큰장점이다

- 문제는 ?를 ㅇ떻게 할것인가

  - parameterType 속성추가해서 넣어주면 ? 대신 변수명사용할수있다
    - 근데 컬럼과 변수명이 구별이안되는 문제가 발생했다!
    - {}으로묶어서 #을 붙여준다

- 추가로 select에서만 사용할수있는 속성있다 resutType

  - 검색결과인 rs를  어떤 데이터타입의 객체로 리턴할것인가
  - JDBCTemplate에서 했던것 떠올려보기- RowMapper만들어서

- 마이바티스의 가장큰 특징

  - sql문이 xml로 옮겨졋다
  - 모든 연동을 자바코드 한줄로할수있다
  - 로우매핑을 안해도 객체에 매핑해준다

  

- sql-map-config에서 mapper가 등록되어있는지 확인하기

  - 데이터소스 확인하기
    - datasbase.properties파일 필요하다
    - 복사해서오고 변수명?이 같은지 확인한다

- BoardDAOMyBATIS
  - 클래스명 위처럼변경
  - SqlSession mybatis 변수생성
  - Insert할때
    - mybatis.insert("id명", vo-정보가 담겨있는 객체);
      - id명에 sql문을 ?대신에 변수로 값을 채워서 sql문 완성하겠지
- 비어있는 SqlSession 채워주기만 하면된다
  - util package만들어서 bean하나 만들자
    - sessionFActory 변수만들어서 뭔가무너지모르는걸 막짜버린다
    - 생성자로 만들어놓은걸 생성해준다
- namespace에 5개에 id를 등록해준다(namespace로 추가한다)
  - 이게있어야 나중에 유니크한 id를 쉽게 만들 수 있다
  - dao로 돌아와서 id앞에 네임스페이스 추가해준다
    - 네임스페이스 있는경우는 붙여줘야한다

- 테스트 클래스 작성해서 실행해보

  - 잘되는데 insert하나 하고 그뒤로는 반복해서 는안된다
  - mybatis.commit()을 해주어야 한다. 
    - spring에서는 자동으로 커밋하게 해줄거니까크게중요하진안다

- 프레임워크는 컨테이너라고 이해해도된다..(맞나?)

  - 마이바티스도 컨테이너가지고있다
  - sqlSession객체가 컨테이너다
    - sqlSession 인터페이스를 구현한 객체가 있다는게 더정확한 표현
  - Mybatis가 어떤 db랑 연결해서 커넥션 처리할지는 알려줘야지 그래서 등록하고
    - 어떤 파일을 마이바티스가 사용할수있는지 알고있어야한다(mapper)

- SqlSession이 마이바티스 컨테이너 다

  - 스프링과 서블릿 컨테이너가 xml읽듯이 SqlSession 생성할대 xml을 읽어오야한다
  - 그래서 factory를 만들때 xml을 읽어온다. 그리고 factory로부터 session을 받아오면 된다

  	<!-- 아랫쪽에 mapper xml파일에서 사용할 Alias들을 등록한다. 
  	
  	
  	
  	 -->


  ​	 

  	<!-- MyBatis가 연동할 Database를 위한 DataSource를 등록한다.  -->

​	<!-- MyBatis가 사용할 SQL 구문들이 등록된 mapper xml 파일들의 위치를 등록한다.  -->

- 알리아스에 의미
  - parameter Type 에 패키지클래스명 말고 board라고 쓸수잇다
    - 오타와 데이터크기 줄여주는 장점있어서 안쓸수가 없다
- 파라미터 타입을 생략할수있다 - 리절트타입은 생략할수가 없다
  - mybatis.insert할대 파라미터로 넣은 것을 자료형으로 사용한다
  - 왜하냐? xml크기줄이려고
    - xml을 작게할수록 로딩이빨라진다. 그래서 줄여준다
  - 근데 이건 선택이다. 가독성을 위해 생략안할 수 있다
    - 근데 많이 생략한다
- resultMap 을 선언하고 사용해본다
  - 왜쓸까?
    - 컬럼이름에 언더바가 있는데 변수이름과 컬럼이름이 매칭이안될때
      - REG_DATE인데 변수는 regDate로 되어있다면 매칭을해줄필요가 있다
    - seq를 Alias로 "번호"로 바꾸었을대 컬럼며을 seq가아닌 '번호'로 매핑해줄 필요가있다
- SQL문에 \<을 써야하는데 xml에서 괄호를 태그로 인식해서 ㅂ모슨다
  - \&lt; 가 작다는 뜻 \&gt; 이 크다는뜻
  - CDATA섹션이라는 건데 가운데 괄호에서 엔터를 쳐서 그값을 넣준다
    - 그안에서는 괄호를 자유롭게 쓸수있다 <>(같지않다) == != 다쓸수있다
    - 캐릭터 영역이다 - 문자영역이니까 XML이 파싱하지 않는다고한다
      - CdataSection으로 꼭묶어주어야한다































































