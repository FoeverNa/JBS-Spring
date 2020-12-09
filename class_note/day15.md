# day15

## 부트로해보기

- 스프링 스타터 프로젝트 - 메이븐, 자바 11, 
  - jar - 웹프로젝트도 jar로할수잇도록 부트에서는 제공한다. jar로 한다
  - war -  web 아카이브 , 프로젝트 구조가 복잡하다

- 프로젝트 생성하면 라이브러리를 자동다운로드한다

  - .m2/repository 밑에 라이브러리를 다운바덱 된다
  - 패런트 두번눌러서들어가면     <maven-jar-plugin.version>3.2.0</maven-jar-plugin.version>을 찾는다
    - porm.xml에 넣고 다운그레이드한다

- 어플리케이션 키면 디폴트로 8080포트로 톰캣 실행한다

  - SpringWeb 추가했을때 starter-web이 디펜더시 추가해서 웹에 필요한 라이브러리가 온갖게 다들어있다
  - 스프링부트는 statrter를 추가할 수 있다- 처음에 Spring Web이라고 선택한것
    - 그럼 .jar파일 하나 등록되는데 그게 등록됨으로 인해서 자동으로 웹개발에 필요한 많은 라이브러리들을 다운로드하게 된다
  - test starter도 마찬가지이다
  - maven에는 2가지만 디펜던시에 추가가 되어있지만 여러개의 라이러리가 다운로드되어있다
    - 스타터는 jar파일 하나가 아니라 라이브러리에 패키지(묶음)이라고 이해하면 더 편하다
    - 스프링부트는 적은 설정으로 필요한 라이브러리를 다운받을수있다는게 장점이다

- 스프링부트는 어플시작되면 무조건 톰캣을 실행시킨다

  - 한번더 실행시키면 포트가 사용되고 있다고 에러가 발생하게 된다

- 톰캣서버가 필요하지 않을때 어떻게 해야하나?

  - 테스트와 같은 상황에서?
  - 스프링컨테이너는 2가지 종류가 이싿
    - 제너릭xml, 과 xmlAppAplication
    - default가 web =  WebApplicationType.SERVLET이 웹이고 아니면 WebApplicationType.NONE 으로하면 서버가 가동되지 않는다

- 프로퍼티로 설정할수도 있다

  - 자바와 프로퍼티가 갈리면 어떠헥되나? 외부 프로터피가 우선순위가 된다 spring.main.web-application-type=servlet / NONE
  - 서버 포트도 프로퍼티로 변경시킬 수 있다## Server Port Setting

- 프로젝트를l 스프링 부트로 만들었을때  스타터를 통해 최소한의 디펜더시 설정으로도 수만흥ㄴ 라이브러릴 구현할 수 있따

  - 스타터를 지우면 테스트에 필요한 라이브러리 뭉텡이도 사라지게 된다
  - 스프링으로 하나하나 추가해주던걸 한방에 해결해주는것

- 스프링  생성하면 기본저긍로 웹어플리케이션 상황으로 설정해주는데 풀어서 하면 web과 none으로 할수있다

  - 이런 설정은 외부 property로 할 수 있따
    - porpperty가 가장 우선순위가높다

- 이전 프로젝트에서 했듯이 외부 프로퍼티 파일을 이용할 수 있다. placeholder를 통해

  - coinfig도 지금 외부프로퍼티를 가져다 쓰고 있다

- 배너모드로 껏다킬수있다

  - 외부프로퍼티로도 확인할수있다
  - 나만의 배너를 만들고싶다?
    - 리소스에 banner.txt만들고 작성하면 콘솔에 배너가 뜬다
    - http://patorjk.com/software/taag/

  

  

스프링부트

- 스프링부트는 스프링 프레임우커르르 사용 가능한 상태로 만들어주는 도구
  - 스프링을 알고 있어야 된다
  - 스프링을 바로 사용할 수 있도록 초기화해주는 역할을 한다
  - 좀더빨리 보다 쉽게 스프링을 사용할수있도록 해주는 도구
- 스프링 부트의 개발이유?
  - 스프링 자체가 웹 개발용 프레임워크가 아니라 범용 프레임 워크이다
  -  스프링 이후에 웹 개발용 프레임워크(루비 온레이즈, 노드의 익스프레스)가 등장한다
    - 굉장히 사용하기 편하고 웹에 최적화가 되어있었음
  - 스프링이 얘내들하고 경쟁이 안된다
    - 제일 문제가되는게 라이브러리이다
      - 메이븐으로 하더라도 어느정도까지는 디펜던시를 설정해주어야 되기 때문에..
    - 다음으로는 스프링 xml 설정이 너무 복잡하다
      - 파일업로드시 멀티파트 리졸버.. 언어.. 예외 처리 등록할게 너무 많다
  - 이런 복잡함이 초보 개발자들이 스프링에 접근하기가 너무어려워진다
    - 소스가 아닌 xml이나 라이브러리에서 에러가 생기면 디버깅이 너무어렵다...
      - 왠지 공감이 간다..
  - 이런 것들을 원큐에 해결한게 스프링 부트 이다
    - 웹 개발에 적합하게 구현

- 스프링 부트의 장점
  - 라이브러리 관리 장동화
  - 라이브러리 버전 관리 자동화
  - 자동 설정 ==>> 중요!!
  - 자동화된 테스트 환경 제공
  - 내장 서버 (Tomcat)를 통한 설정 가능하다
  - 독립적으로 실행가능한 JAR

- 실습

  - TV 예전처럼 만들기
    - 비지니스레이어 삭제해보기
    - id는 bean에 넣어주거나 메소드명이 id가 된다

  - 의존성주입
    - setter 인젝션
      - set만들어서 bean생길때 set하도록 한다
        - 자바 코드로 해결해버린다

  

- @Configuration(proxyBeanMethods = false)
  @ConditionalOnWebApplication(type = Type.SERVLET) // 웹으로 되어 있어야된다
  @ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class }) // 해당 객체가 떠있지 않으면 그때만 실행한다
  @ConditionalOnMissingBean(WebMvcConfigurationSupport.class) // 해당 객체가 떠있다면 그때만 실행한다
  @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10) // 우선순위 올려준다
  @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
  		ValidationAutoConfiguration.class }) // 해당 컴피규 다음으로 띄워준다

- WebMvcAutoConfiguration이 실행된다

  - 그리고 그안에 빈 메소드들도 많은데 그중에서도 각각 컨디셔널이 달려있어서 띄워주게된다
    - 복잡학고 어렵다.. 

- EnableAutoConfiration과 ConponentScan은  매주중요하다
  - 내가 만들지 않은 객체와  만든 객체를 각각 
  - Enable은 다띄우는데 conditional에 의해서 적용이 되고 안되는 것이 있다
    - 그조건은 각클래스별로도 있고 클래스의 메소드별로도 있다
- logging.level.org.springframework=debug 
  - Positive matches 는 조건 맞아서 실행된것들
  - Negative matches 는 조건과 맞지 않은애들



- 자동설정 클래스 만들기
  - jdbc 클래스만들고 jdbc config만들고 spring.factories 만들기
    - 로그에 unconditional로 찍히게 된다

