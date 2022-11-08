package com.example.web.crawling;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaumCrawlingTests {
	@Test
	void getDaumC1010001() throws Exception {
		DaumCrawling.getDaumC1010001("카카오");
	}

	@Test
	void getDaumC1020001() throws Exception {
		DaumCrawling.getDaumC1020001("카카오");
	}
}
