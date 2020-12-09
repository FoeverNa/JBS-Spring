package com.rubypaper.jdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
//@ConfigurationProperties(prefix="board.jdbc")//외부 프로퍼티 파일을 로딩해서 prefix로 시작하는 프로퍼티만 이용하겠다
@ConfigurationProperties(prefix="board.jdbc")
public class JDBCConnectionManagerProperties {
	private String driverClass;
	private String url;
	private String username;
	private String password;

}
