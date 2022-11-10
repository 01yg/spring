package com.example.web.api;

import com.example.web.controller.api.DaumApi;
import com.example.web.crawling.DaumCrawling;
import org.junit.jupiter.api.Test;

public class DaumApiTests {
    @Test
    void daum_financials() throws Exception {

        System.out.println(new DaumApi().financials("카카오"));
    }

    @Test
    void data() throws Exception {
        new DaumApi().data("에스에이엠티");
    }
}
