package com.example.testingweb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * HomeControllerがNULLでないかどうかをチェック(assertThat)するだけのテストです。
 */
@SpringBootTest
public class SmokeTest {

	@Autowired
	private HomeController controller;

	/*
	 * AssertJ (英語)  （assertThat() およびその他のメソッドを提供）を使用して、テストアサーションを表現します。
	 *  cf. AssertJ: https://joel-costigliola.github.io/assertj/
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
