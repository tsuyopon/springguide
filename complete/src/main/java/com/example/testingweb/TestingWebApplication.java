package com.example.testingweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication は、次のすべてを追加する便利なアノテーションです。
 *    @Configuration: アプリケーションコンテキストの Bean 定義のソースとしてクラスにタグを付けます。
 *    @EnableAutoConfiguration: クラスパス設定、他の Bean、さまざまなプロパティ設定に基づいて
 *       Bean の追加を開始するよう Spring Boot に指示します。
 *    @EnableWebMvc: アプリケーションを Web アプリケーションとしてフラグを立て、
 *       DispatcherServlet のセットアップなどの主要な動作をアクティブにします。
 *       Spring Boot は、クラスパスで spring-webmvc を検出すると自動的に追加します。
 *    @ComponentScan: com.example.testingweb パッケージ内の他のコンポーネント、設定、サービスを探すように Spring
 *       に指示し、HelloController クラスを見つけさせます。
 *
 */
@SpringBootApplication
public class TestingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingWebApplication.class, args);
	}
}
