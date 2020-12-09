# day12

datasource 분리하기

외부프로포터 파일 로딩하기

- 에러생김
- 이거 왜하는지 xml파일수정안고할수있다

검색조건유지하기

- sesiion에 serach넘겨주기

- jsp고치기

- selected되어 있는게 보여준다

  - 검사하기로 코드보면 보인다
  - 설명먼저듣기

  **인텔리제이 고치기**

  

Spring MVC 흐름

- 서블릿 컨테이너와 스프링 컨테이너가 존재한다
  - 2종류의 컨테이너가 필요하다
- 흐름
  - 톰켓을 실행시키면 web.xml파일을 서블릿 컨테이너가 로딩을 한다
  - 브라우저가 요청할시 action 이라는 Despenthcr서블릿 객체를 생성한다(.do형태의 요청만)
    - 서블릿은 lazy loading, 필터와 리스너는 프리로딩
  - 서블릿 객체 생성시에 init메서드가 실행되는데 스프링 컨테이너를 생성하고 init-param에 등록된 xml을 읽어낸다
    - 왜 dipatcher가 스프링 컨테이너 만들까? 다른 객체와 협업해야되는데 이는 서블릿 컨테이너가 생성할 수 없는 객체이기 때문이다
    - 그래서 스프링컨테이너를 생성하면 스프링컨테이너가 빈으로 해당 객체들을 생성해줘서 서로 사호작용할수 있는것이다

어떻게 실행하는지 보기

- 요청 -> 핸들러매핑 - > 해당 컨트롤러 실행 (보드DAO 이용해서session에 저장) 모델엔뷰 리턴(원래는 모델과 뷰둘다 리턴해야되는데 우리는 뷰이름만 리턴) -> viwResolver를 이용한다 -> 받은 위치를 가지고 실행한다 



포워드와 리다이렉트 차이

- a.jsp와 b.jsp가 있다
- 포워드 방식
  - a를 요청하면 b를 출력해주는것, 
    - 주소가 바뀌지 않는다
    - 한번에 응답과 요청이 이루어지기 때문에 실행속도가 빠르다
    - 하지만 url이 안바뀌니까 답답하다
      - 누가 보낸건지모른다
- 리다이렉트 방식
  - senRedirect방식
  - 주소가 바뀐다
    - a가 응답을 보내면 브라우저가 b를 요청을 다시보낸다
    - 속도가 느린데신에  url이 바뀐다



엄청난걸할거다

- 컨트롤러 빈등록한걸 막아두기
- 핸들러도 안할거다
- 뷰리졸버는 놔둔다
- 컴포넌트 스캔 할거다
  - com.rubypaper.web
- 지금부터는 개념만 이해하기
  - 보드테이블 모든 데이터 삭제
  - POJO를 사용할수있다는데 insertBoardController는 포조가 아니다
    - 임플레멘트제거, 리스폰스 제거
    - @Controller 붙여주기
    - @RequestMapping("/insertboard.do") 붙여주기 -> 매핑 역할을 할수있다
      - 요청과 메서드를 연결해주는것
      - AOP에 Aspect로 Pointcut과 advice이어주던거랑 비슷하다
    - insert.jsp로 작성해서  등록해보면 등록이 가능하다는소리다
      - 디비로확인하기
  - BoardVO로 바꾸고 갑자기 다지우고 VO객체를 그냥활용해버리낟
    - BoardVo도 생성해서 사용자입력을 입력해서 알규먼츠로 입력해준다..와/? 어떻게된거지?
    - 이게되면 유지보수가엄청나게편해진다. 화면추가, sQl문 은 변할수있지만 자바코드는 안변해도 된다
  - 매개변수로 boardDAO도 받기로 해버렸어
    - 그럼 정말 한줄로 처리가 된다...와?
  - session 도 받을 수 있다
    - 파라미터의 종류도 제한없고 순서도 제한이없다... 이게 포조이다... 문법적 제약이 없다
  - 아니 이걸 어떻게 하는거지??? 강사님은 자기가 안만들어서 모른다는데?? 흠.. 그럼 자바는? 서블릿은?
  - 서블릿에서는 web.xml에 설정이 다 되어 있엇다
    - 그리고 inserBoard에 doPost도 서블릿컨테이너가 하고 변수들 초기화해서 request/response를 넣어준다
  - 기존방식대로 Contoller 임플해서 사용해도된다, 하지만 새로운방식이 훨씬 편하다
    - 어노테이션을 제대로 달아주어 잘 인식만 시켜주면  값잘넣어서 객체생성해서준다
  - 그걸 위한 전제조건은 무엇이지?
    - jsp에 파라미터에 이름이 중요하다(이거 생각하고 있었는데 맞앗당~)
    - title, wrtier, 하면 setTitle, setWriter로 한다(변수명하고는 상관없긴한데 상관없을수는 없긴해~)
      - 이거 IOC에서 propoerty로 setter 주입할때 name을 boardDAO라고하면 setBoardDAO해준던거랑 똑같은거다
        - 이것도 기억했다~~ 굿!
      - 만약 setter메소드가 같은게 2개 객체라면??
        - 둘다 호출이 된다 , 즉 파라미터에 있는 객체중에 같은 세터이름 있으면 다호출해주는것이다~ wow와우~
      - 이제는 request.getParam을 할 필요가없어졌다
  - 리턴값을 STring을 줘서  뷰리졸버에게 갑넘겨줄수있다

겟보드리스트도 해보기

- 매개변수 3개 등록
- 그외에 나머지것들도 다 메소드로 만들어서 하나의 클래스로 몰아주기



정리

- 지금까지 배운것에 총집합이 boardController다
- IoC는 역제어인제 객체에 대한 제어를 뜻한다 - 컨테이너가 한다
  - 객체 생성 - 자바소스에서 new가 사라진다
  - 의존관계 - 파라미터의 객체 누가 넣어줘? 컨테이너가 넣어준자나
- 지금은 Model쪽은 잘못쓰고있는데 나중에 또 고칠거다

추가적인 어노테이션

- vo대신 int seq넣어도 세팅을 해준다...오..
  - 원래는 String으로 되어있어서 parInst했는데 그것두 처리해줘서 넣어준다
  - 파라미터만 같으면된다..
    - 만약 boardSeq로 이름이 다르면 입력을 못받는다
- @RequestParam
  - 파람과 변수명이 다를때 사용한다. 
  - 근데 왜하냐? 잘쓸일이 없다
  - value="seq", defaultValue="1", required=true
    - 이렇게 쓰면 기본값이라도 주는 속성을 사용할 수 있게 된다
    - required=true 했는데 seq에 값이 안들어오면 에러가 뜬다
      - 필수 파라미터면
- seq처럼 하나여도 매개변수가 늘어날수 있으니 vo를 사용하는게 더 나은 방법이다

index.jsp 만들기

- 누구나 접근할수있는페이지만들어줘야한다

Insert 다가가게하기

- ​	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)

  - 얘는 그냥 진짜 redirect만하는것

- ​	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)

  - 이거 두개로 구분해서 할수 있게한다

- insertboard.do로 움직이기

  - 클릭해서들어가면 겟방식
  - 리스트에서 새글등록하면 insert.do하면 get방식 메소드가 사용되고 jsp에서 .do하면 post방식의 메소드실행이되는것
    - 우왕~

- 왜하는거야?

  - 회원정보 클릭하면 모든값다시입력하지 않고 이미입력되어있는 값들 있자나(불러온값들) 이런게 가능하다

  - 		vo.setTitle("200자 미만으로...");
      		vo.setWriter("테스터");
      		vo.setContent("2000자 미만으로 작성해주세요.");
    - jsp도 수정

  - 클래스이름에 소문자로 접근을한다.. 리퀘스트에 저장되면

로그인도 같은처리

- 로그인하기로 login.do를 하면 무조건 기능작동해버려

에러화면

- error-page 로 error-code 넣어서 에러페이지만들수있다

- 절절한 화면으로 매핑해줄수가 있다

  

세션에 저장하는거 request로 바꿔주기

- 세션에는 값을 저장하지 말아야한다고했다. 왜였는지 기억해보기
- session 대신 ModelAndVIe를 매개변수로 받아서 .addobject하면 key-value 저장이 가능하다
  - 모델정보라고한다
- seViewName 을 통해 ivewName까지 저장할 수있다
  - View 정보라고 한다
- 그래서 Model과 view이다. Moodel과 View 다 담아줘야 완전해진다
  - request라는 객체로 가져오게 된다..
    - requeset라는 객체가 따로있나보다 => 아니다 request가 그 request가맞다
- view이름으로 저장되어있는 곳에서 모델의 결과를 가져다 쓸수가 있다
  - setView가몬지 잘알아야겠다
- mev가 

문제 모델엔뷰를 쓰면 return타입이 통일되지 않는다

- POJO를 쓰지만 여전히 일관성을 중요한 개발 이슈이다
- 그래서 return타입을 String으로 통일 시킬필요가 있다
  - 그래서 ModelAndView 를잘안슨다
- 그래서 Model이 사용된다
  - 데이터만 저장할수 있고 view이름은 저장할수가 없다
  - 그래서 view이름은 retrun해야 한다(String형태로)
  - 그럼 return도 String으로하면서 
- 요건 굉장히 중요한 것이다...
  - 모델에 결과는 세션이 아닌 request에 

그다음에 괸장히 위험한거할거다

- JDBC에서 UPDATESQL문을  수정한다
  - Writer를 수정하게 하고 수정하지 않을시 그대로유지하는 코드를짠다
  - 이게 자바로하려고하면 어렵다
  - @SessionAttributes("board")
    - Model에 저장된 객체를 Session에도 저장하게 한다
    - {(), ()}배열형태로 여러개의 view이름을 저장할수도있다
  - 해당 board가 있는 메소드에 파라미터에가서 @ModelAttribute를 쓰면 그 객체를 vo 변수에 바인딩하라는뜻..
- 중요한건 이거다
  - 수정을 하려면 뭐부터봐야되냐면 상세화면부터 봐야한다
  - 수정 버튼을 누를 때 원래는 새롭게 vo 가 생성되서 title content seq만 전달되서 업데이트를한다, 그래서 writer가 비어있다
    - 어노테이션 붙이면 혹시 session에 데이터가 있으면 vo를 새로만들지말고 그대로 파라미터에 바인딩해라
    - 그리고 바뀐것만 바꾸면 나머지 데이터는 그대로 유지가 된다.
  - 수정위해 상세와 업데이트 두가지 단계로이루어진다는걸 알아야 한다
    - 세션에 있는 객체를 가져오지만 가져오는 객체에다가 사용자가 입력한 값만 수정해주어서 vo를 넣어주는 것이다 -> wow~
      - 맞네 수정한 값이 반영이 되야 하니까
  - 그래서 쌍으로 기억해야 한다.. SessionAttributes와 ModelAttribute
    - 이런 어노테이션을 어떻게 기억해아할지 방법을 찾아보야될 것 같다

스프링 MVC 마지막

- layer 통합 그림보기 - 절대로 이런구조로 실행해서는 안된다
  - aop관련 설정들이 동작이 안되었다  왜?
  - 컨트롤러가 DAo객체를 직접이용해서 그렇다. -> 포인트컷을 서비스 임플에만 걸어두었자나- > 맞네예~
  - 그래서 절대로 컨트롤러가 DAO 를 직접이용해서 안된다
    - aop 못씀
    - DAO를 다른걸로 변경하려고 했을때 모든 컨트롤러를 다 수정해야한다..
- 그래서 결론은 비지니스 컴포넌트 입장에서 컨터롤러가 서비스 인터페이스를 이용해서 서비스 를 사용하게 해야한다



반영하기

- 컨트롤러에 보드dao입력다징귀
- boardService 변수만들어서 autowired해주기
  - 컴포넌트 스캔 범위가 controller만 포함되기 때문이다 - 아하
    - 그럼 web지우고 상위 패키지로 하면되지 않아?? -> 실행안된다
      - spring빈등록해도 또 부족해
      - jdbcTemplate빈등록해줘
        - dataSoruce도 넣어줘
          - datyasoruce도 빈등록해줘야되
          - 답이없다
- 이건 답이 될수가 없다
- 투레이어 방식은 개발이 분리된다는 의미이다
  - 이것은 서로 레이어의 변화가  서로에게 영향을 주지 않는다는 의미이다
  - 그러러면 xml을 따로따로 가지고 잇어야 한다는 뜻이다
  - 테스트할수 있어야 되기 때문에 더 필요하다



가장중요한설명

- Preseenttaion-layer는 서블릿이 로딩한다
- 그럼 누군가는 비지니스쪽 xml을 읽어서 생성해주어야 한다
  - 그게 리스너에 역할이다
- web.xml 수정
  - 인코딩 필터 바꾸고 지우기
  - ContextLoaderListener 는 컨테이너를 로딩하는 리스너를 등록한다
    - 등록만하면 에러가 난다 왜?
    - 서블릿엔진이 생성되면서 프리로딩을 하면서 리스너르통해 만들어주는데 xmll위치가 아까그거였어
    - 그래서 param으을 바꿔줄거야
  -   <context-param>
      	<param-name>contextConfigLocation</param-name>
      	<param-value>classpath:business-*.xml</param-value>
      </context-param>
  - 그리고 실행하면 3개의 xml을 가져온다
- 서버 키면 모델 컨테이너가 생성되서 준비가된다
  - 아직 컨트롤쪽 컨테이너는 안떳다
  - 실행해보면 다른기능 다동작가능하고 JDBC기반으로 동작할수도 있다

- 포인트는 스프링컨테이너는 2개가 필요하고 가장중요한 서블릿 컨테이너가 1개가 필요하다
  - 서블릿 컨테이너가 생성되면서 리스너를 만들고 그다음에 요청들어오면 디스패처 서블릿 객체가 필요하다














































