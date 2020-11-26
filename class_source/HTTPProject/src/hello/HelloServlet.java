package hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloServlet() {
        System.out.println("===> HelloServlet 객체 생성");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    		System.out.println("---> init() 호출");
    }
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.println("---> service() 호출");
    }
    
    @Override
    public void destroy() {
    		System.out.println("---> destroy() 호출");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> doGet() 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> doPost() 호출");
	}
}
