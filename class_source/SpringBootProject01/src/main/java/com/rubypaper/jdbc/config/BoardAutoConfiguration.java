package com.rubypaper.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configuration
@ConditionalOnMissingBean(JDBCConnectionManager.class) //얘가 없을때만 bean을 생성하겠다!
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	private JDBCConnectionManagerProperties dbProperties;
	
	@Bean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass(dbProperties.getDriverClass());
		manager.setUrl(dbProperties.getUrl());
		manager.setUsername(dbProperties.getUsername());
		manager.setPassword(dbProperties.getPassword());
		return manager;
	}

}
