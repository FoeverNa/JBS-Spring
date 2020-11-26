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
        System.out.println("===> HelloServlet ��ü ����");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    		System.out.println("---> init() ȣ��");
    }
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.println("---> service() ȣ��");
    }
    
    @Override
    public void destroy() {
    		System.out.println("---> destroy() ȣ��");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> doGet() ȣ��");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---> doPost() ȣ��");
	}
}
