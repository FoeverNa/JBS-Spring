# day4



- 복습
  - 톱캣서버을 실행한다는 것은 톰캣을 실행하는 것
  - 로그에는 톰캣 서버 구동 로그와 서블릿엔진 구동 로그가 뜬다
  - web.xml. 문제있는데 구동하면 서블릿엔진이 구동이안된다
  - init이 실행되야 멤버변수 초기화할수 있다
  - 질문할거 있지
  - 메모리에 서블릿 객체가 있다면 바로 스레드할당으로 넘어가서 서비스 메소드 실행
    - 적은 메모리사용으로 많은 사용자 요청 처리할 수 있다
  - 톰캣 구동되고 요청해야 서블릿 객체 생성되고 이닛한다
  - 주소표시줄에서 요청 요구하는것은 get방식이다
  - if 브라우저가 GEt방식으로만 요구할것이라는 확신있으면 doGet만 오버라이딩 하면됨
    - 둘 중하나 들어올대는 서비스 사용해서 doGet, doPost로 분기해주면된다
    - 혹은 serviece로 둘다 처리하고자할때 오버라이딩하면된다ㅏ
  - destroy() 서블릿 객체가 삭제되기 전에 자동으로 호출 된다
  - Post방식으로만 할거면 doPost만 구현하면 된다
  - 서블릿엔진이 서블릿 객체가 만들어주고 메소드도 호출해준다
- doPost나 get에 respon와 request 객체를 파라미터로받는다
  - init에도 config파일 집어 넣어주어야 한다
  - 해당 메서드들이 잘실행됬다는 것은 누군가가 config, request, resonse 객체 생성해서 넣어준것이다
  - 사용자 아이디 입력한걸 request.getParameter("id")로 가져올 수 있다
    - 브라우저가 서버에전달한 요청 프로토콜을 리퀘스트 객체에 담아서 파라미터로 넣어준다(서블릿엔진이) => 제일중요오늘거에서
- 요청 프로토콜에 들어있는 것들을 모두 request 객체에 넣어준다
  - request.getMethod() , request.getRequestURI(), request.getProtocol, request.getHeader("User-Agent") 로 정보 다 가져올 수 있다
  - get으로지가하는 모든메서드들이 request로 가져올수있는 정보들
    - URI는 내가 잘못알고 있는건가
    - 다 doPost에 넣은것
  - 서블릿 라이플 사이클과 이것만 알면된다
    - request와 response는 내가 생성하는게 아니다, 내가하는건 5가지 규칙맞춰서 클래스만 만들어주면된다



- 새프로젝트 SevletProject
  - lib폴더에 lombok.jar 넣어준다. java resources -libraries-Web App libraries에 들어갔는지확인
  - h2 jar도 lib폴더에 넣기 -> 직접 라이브러리 추가하는것
  - HttpProcjet에서 login.html 가져오기
  - login.do로 고치고 실행 -> 404에러발생
    - new Servlet  LoginServlet => login.do로 만듬
      - web.xml에 login에 해줘라
    - next 생성자 체크풀고 doPost만 말들어놓고 finish
      - 로그인이니까 post만잇으니까 하나만만들기. 모르겟으면 service오버라이드
  - doPost 작성
    - 사용자 입력정보추출
      - request.getParameter
        - 리퀘스트 바디에 파라미터에 값들을 뽑아낸다
          - 파라미터의 key를 오타내면 값이 뽑히지 않는다 --- 주의!
    - DB연동
      - JDBC 플젝에서 3개 패키지 땡겨오기
        - test클래스 다삭제하고 DAO랑 VO만 남기기
    - 화면 네비게이션
      - 성공시
        - PrintWriter out = response.getWriter();
          - getWirter하면 출력스트림 얻을수있는데 이것은 응답프로토콜 body와 연결된 출력 스트림이 만들어진다
            - body들어가기전에 한글이 들어갈거같다고 header에 먼저 주어야 한다
            - out.println하면 출력스트림에 메시지 출력해준다(body에 입력해준다는 뜻)
              - 출력과 입력이 반전되는것 떠올려봐
          - getWirter, setContentType, sendRedirect가 중요하다
          - out에 추가해서 a태그로 링크걸어주는것도 추가해준다
        - sysoout으로 출력하면 서버콘솔에 찍힘 -> 의미가 없다 사용자가 확인해야되는데
        - out으로 출력해야 된다
          - 브라우저에 한글 출력이 깨진다
          - PrintWriter 하기 전에 response.setContentType통해 인코딩 타입을 담아주면된다
            - 반대로하면 깨진다
        - html으로 출력하면 더 크게 출력나온다
      - 실패시 response.sendRedirect("html")
        - html을 다시 요청하도록 브라우저에게 명령
          - 리다이렉트는 상태코드로되나?
- 실습 위해 서버 껏다키기 -> 서블릿새로작성했으니
  - 로그인 실패시 로그인화면으로 돌아가는지 확인하기

- 서블릿은 실제프로젝트에서 사용하지는 않지만 스프링을 이해하는데 도움이 많이 된다
  - 스프링 MVC가 서블릿으로 되어있기때문에 중요하다
  - jsp 를 이해하는데도 좋다

- com.rubypaper.web.board 서블릿GetboardList생성
  - 사용자 입력정보 추출
  - DB 연동 처리
  - 응답 화면 구성
- 로그인 성공시 글목록으로 바로가도록 redirect해주기
- 공유해주신 GetBoardList를 복사해서 3번에 out.println에 붙여넣기
  - 이쁘게 게시판나옴
- 서블릿 망한 이유 설명해주심
  - java코드에 디자인이 들어감..
  - 디자인 바꾸는게 거의죽음에 가까움 
  - 그래서 jsp나옴
- 출력된 결과 db랑 연결해주기
  - test부분에 foreach해서 vo.get으로 하나씩 출력해주는것 반복
- 게시판 만들기에 필요한기술
  - SQL
  - JDBC
  - HTML
  - SERVLET
- 실행은 login.do아닌 .html로 해야된다
- 글등록하기
  - inser.html 복사해서 webcontent에 넣기
  - web.board에 InsertBoardServlet생성
  - 사용자 입력정보 추출
    - 한글입력하니 깨짐
    - request에서 값가져오기 전에 set.characterEncoding (utf8)
  - DB 연동 처리
  - 화면 네비게이션

- 쿼리 스트링 등록
  - getBoard.do?seq=7 
  - 서블릿을 만드는건만드는거고 몇번을 불러서 정보를넘겨저야한다
    - 웹은 이게 어렵다. 그전화면에서 계속 정보가전달이되야한다
  - getboard 넣어주기 - > 여기서 에러나서 잘못적었다 그 테스트거기다가 넣어줫다

- GetBoardServlet생성
  - 사용자 입력정보추출
  - db 연동처리
    - seq입력해야되는데 get.Parameter에리턴은 무조건 STring
      - so parseInt해줘야됨
  - 응답화면 구성
    - 복사해서 앞에 부분하고 마지막에 close해주고 그사이에 출력해준ㄴ거 입력하면됨
    - 파일중에 getboardsevlet에서 가져오면된다

- 수정 삭제는 내가해라
  - 수정
    - 3개에 물음 표 채워줘야한다
    - ​		out.println("<input type='hidden' name='seq' value=' " + board.getSeq() + "'/>");
      - 추가해줘야 2개에 서 하나더를 추가해준다.
    - Insertboard복사해서 update만들기
      - seq문 수정해주고 update를 해주어야한다
    - web.xml 등록이안되니 등록해줘야한다
      - 여기서도 에러낫다
- 왜중요한지 알아야 한다
  - 어떤 프로젝트를 할진모르지만 다똑같다
  - 넣고 삭제하고 수정하고 목록검색하고 상세화면보고

- 서블릿에서 기억할 메서드 6개

  - request

    - request.setCharacterEncoding()
    - request.getParameter()
    - request.getSession()

  - response

    - response.setContentType

    - PrintWriter out = response.getWirter();

    - reponse.sendRedirect()

      

- crud는 다했고 부가적기능

  - web.xml가서 InsertBoard에 가서 파람설정
    - 이파라미터는 요서브릿에서만 로컬파라미터 접근할수있다
  - Insertboard로 이동
    - String encoding; 변수생성
    - init(config) 오버라이드
      - 로컬파라미터 정보 추출
      - CharacterEncoding에 encoding넣어주기
    - 서블릿 객체가 생긴직후에 ini메서드 호출
      - init은 config객체를 받는다
        - 서블릿이 config 객체를 생성시에 로컬파라미터 정보를 세팅해서 넣어준다 
          - 리퀘스트객체랑 비슷하다
          - 로컬파람은 여러개 등록이 가능하다
      - 실습 껏다켜야지 xml을 수정햇으니
      - 이짓을 왜할까?
        - 나중에 인코딩 정책이 수정되면 자바소스 안건드리고 web.xml만 고칠수있다
      - 근데 Insert뿐 아니라 다 필요하다 그럼??
        - 글로벌 파람 선언
        - SevletContext를 통해 글로벌 파람 가져올 수 있따
          - getServletContext로 받을 수 있다
          - SevleConfig는 로컬파라미터
      - insert와 Update에 둥록
      - 인코딩과 같이 전체적으로 적용되며 한번에 바꿔줘야하는애들 글로벌 로가면됨

- 필터
  -  web.user.new.filter TimeChekcFilter  timecheck로 만들고 *.do로 만든다
    - web.xml에 필터등록되어 있다
      - 서블릿과 비슷하고 동작도 비슷하다
      - 근데 *.do가 특이해
        - 어떤.do가 와도 timecheckfilter 써라
  - 디폴트생성자
  - 디스트로이메서드
  - 필터도 이닛을통해 로컬파람가져올수있다
    - config파일이있다
  - 필터는 톰캣키자마자생성됨 -> pre-loading -> web.xml 로딩하자마자
    - 서블릿은 Lazy 로딩-> 요청해야 생성된다 
    - 생성시점이 다르다
  - test.do / xxxx.do / deifjlsf.do 만하면 dofilter가 동작한다
  - 필터는 init / destory /do filter를 필수로 오버라이딩해야한다
    - filter는 인터페이스여서 그렇다
    - 보통 init/dstroy는 중요하지 안음
  - 필터 동작 순서 이해
    - 필터등록후에는 사전처리 사후처리가 서블릿 메소드 실행을 감싼다 
      - 사전처리
      - 서블릿 메소드 실행
      - 사후처리
    - 모든.do요청을 필터가 가로챈다 그래서 사전처리가먼저실행되고 chain.dofilter를 만날대 서블릿메소드실행되고 다시 제어권은 필터로 돌아온다
      - 사후처리까지 끝난응답이 필터에서 브라우저로 들어간다
      - 서블릿이 샐행되기 전후에 동작하는게 필터다
      - 만약 login.do에 만 했으면 개만 제어한다
    - chin을 주석으로 막으면 서블릿이 실행안됨 
  - 왜필요할까?
    - chin시점이 클라이언트가 호출한 서블릿이 실행될수된다
      - 그거전에 시간체크하고 후에 체크하면 서블릿을 수행시간을 알수있다
      - 너무오래걸리면 튜닝해야한다
    - 실습 -> startTime endTime, 해서 초세기
      - 클릭하면 콘솔에 시간표시됨
        - 근데 무슨서블릿실행됫는지 보고싶음
        - path 작성해서 syso에 넣어줌
        - uri를 받아서 /으로 해서 가장 마지막것을 가져오는 메소드
  - 숙제 검색기능
    - 글목록화면에서 검색키워드 하고 검색누루면 내가원하는 데이터만보여주면된다
      - SQl JDBC SERVLET 다 고쳐야된다
      - 요거해보면 다복습할 수 있다

