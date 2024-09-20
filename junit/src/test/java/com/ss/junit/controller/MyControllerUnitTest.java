package com.ss.junit.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyController.class)
@Slf4j
public class MyControllerUnitTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        log.info("MyControllerUnitTest - test() 실행");
        // perform() : 가짜 Http 요청을 만듦.
        // - 요청을 만든 뒤 통신을 보냄.
        MvcResult result = mockMvc.perform(get("/test")) // /test 경로에 GET 요청 수행
                .andExpect(status().isOk())                      // 응답 상태 코드가 200인지 확인
                .andExpect(content().string("!!Hello world!!")) // 응답 본문이 기대한 내용과 일치하는지 확인
                .andReturn();

        log.info(result + "");

        String contentStr = result.getResponse().getContentAsString();

        System.out.println("result : " + contentStr);

        // 상태코드를 반환해서 출력
        int code = result.getResponse().getStatus();
        System.out.println("code : " + code);

        // header(응답헤더)
        String resultHeader = result.getResponse().getHeader("content-type");
        System.out.println("resultHeader : " + resultHeader);

        String resultBody = result.getResponse().getContentAsString();
        System.out.println("resultBody : " + resultBody);

        // MockHTTPServletResponse : 실제 http 응답과 거의 동일한 구조로 이루어져있음.
        // - 다만 실제 네트워크 통신은 아님.
    }

    @Test
    // Post 요청 테스트
    public void testPort() throws Exception {
        log.info("MyControllerUnitTest - testPort()");

        String jsonContent = "{\"name\":\"만두\", \"age\":10}";

        MvcResult result = mockMvc.perform(post("/create")
                                  .contentType(MediaType.APPLICATION_JSON_UTF8)
                                  .content(jsonContent))        // 요청바디에 JSON 데이터에
                                  .andExpect(status().isOk())   // 200 확인
                                  .andExpect(content().string("created"))
                                  .andReturn();

        log.info(result + "");
        String contentStr = result.getResponse().getContentAsString();
        System.out.println("result : " + contentStr);

        int code = result.getResponse().getStatus();
        System.out.println("code : " + code);

        String resultHeader = result.getResponse().getHeader("content-type");
        System.out.println("resultHeader : " + resultHeader);

        String resultBody = result.getResponse().getContentAsString();
        System.out.println("resultBody : " + resultBody);

    }

    @Test
    public void testPut() throws Exception {
        log.info("MyControllerUnitTest - testPut()");

        String jsonContent = "{\"name\":\"만두\", \"age\":11}";

        MvcResult result = mockMvc.perform(put("/update/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(jsonContent))        // 요청바디에 JSON 데이터에
                        .andExpect(status().isOk())   // 200 확인
                        .andExpect(content().string("update!"))
                        .andReturn();

        log.info("put 응답내용 : " + result.getResponse().getContentAsString());
        String contentStr = result.getResponse().getContentAsString();
        System.out.println("result : " + contentStr);

        int code = result.getResponse().getStatus();
        System.out.println("code : " + code);
    }

}
