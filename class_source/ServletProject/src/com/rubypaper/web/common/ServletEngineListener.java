package com.rubypaper.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletEngineListener implements ServletContextListener {


    public ServletEngineListener() {
        System.out.println("===> ServletEngineListner ����");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("===> ���� ������ ������ ���Ŀ� ������ ����");
   }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("===> ���� ������ ���� �Ǳ� ������ ������ ����");
    }
   
	
}
