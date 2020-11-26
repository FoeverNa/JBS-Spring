package com.rubypaper.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimeCheckFilter implements Filter {
	
    public TimeCheckFilter() {
        System.out.println("===> TimeCheckFilter 생성");
    }
    
	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 클라이언트가 요청한 서블릿 정보 추출
		// http://localhost:8080/ServletProject/aaa/bbb/ccc/getBoardList.do
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		long startTime = System.currentTimeMillis();
		
		// 클라이언트가 호출한 서블릿이 실행된다.
		chain.doFilter(request, response);
		
		long endTime = System.currentTimeMillis();
		System.out.println(path + " 요청 처리에 소요된 시간 : " + (endTime - startTime) + "(ms)초");
	}

	public void destroy() {}

}
