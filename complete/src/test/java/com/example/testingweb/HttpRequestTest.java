package com.example.testingweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * 実際にHTTPサーバをランダムポートで起動して、「/」へのアクセスを確認するテストです。
 * Mockは使っていません。
 */

/* @SpringBootTestの説明はTestingWebApplicationTest.javaを参照のこと */

/*
 * webEnvironment=RANDOM_PORT を使用してランダムポートでサーバーを起動することに注意してください
 * （テスト環境での競合を回避するのに便利です）
 * webEnvironmentで指定された値を使うことで、@LocalServerPortに指定されたフィールドにポートを注入します。
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	// @LocalServerPort でポートを挿入します
	@LocalServerPort
	private int port;

	// Spring Boot が自動的に TestRestTemplate を提供していることに注意してください。@Autowired を追加するだけです。
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hello, World");
	}
}
