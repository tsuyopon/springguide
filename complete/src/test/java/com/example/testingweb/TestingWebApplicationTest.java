package com.example.testingweb;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/*
 * HomeControllerがNULLでないかどうかをチェック(assertThat)するだけのテストです。
 */


/*
 * @SpringBootTest アノテーションは、Spring Boot にメイン設定クラス（たとえば @SpringBootApplication を持つもの）を探し、
 * それを使用して Spring アプリケーションコンテキストを開始するように指示します。
 *
 * このテストは、IDE またはコマンドライン（./mvnw test または ./gradlew test を実行することで）で実行できます。
 */

/*
 * このテストはHttpRequestTest.javaと異なり、サーバを全く起動せずにテストする別のアプローチの方法です。
 *
 * Spring は受信 HTTP リクエストを処理し、コントローラーに渡します。そのようにして、ほぼすべてのスタックが使用され、
 * コードは実際の HTTP リクエストを処理する場合とまったく同じ方法で呼び出されますが、サーバーを起動するコストはかかりません。
 * これを行うには、Spring の MockMvc を使用し、テストケースで @AutoConfigureMockMvc アノテーションを使用して挿入するようにリクエストします。
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

	// Spring は @Autowired アノテーションを解釈し、テストメソッドが実行される前にコントローラーが挿入されます
	@Autowired
	private MockMvc mockMvc;

	// MockMvcによって、HTTPサーバを起動せずに「/greeting」へのリクエストを送る事ができるようになります。
	// (MockMvcというのはWebLayerTest.javaやWebMockTest.javaからの自動注入なわけではないことに注意。ここではまった)
	// これはGreetingController.javaで定義された「/greeting」の戻り値に「Hello, World"が含まれるかを検証します。
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		// 以下を「/greeting」にしてもレスポンスが同じはずなのでテストが通ります。
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
}
