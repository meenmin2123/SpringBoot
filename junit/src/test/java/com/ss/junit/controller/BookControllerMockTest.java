package com.ss.junit.controller;

import com.ss.junit.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //가짜 서버를 생성
@AutoConfigureMockMvc   // MockMVC를 빈으로 등록해줌.
@Transactional
public class BookControllerMockTest {

    // @AutoConfigureMockMvc
    // MockMVC를 빈으로 등록해줌. 객체를 자동으로 생성하고 빈으로 등록해줌.
    // - 역할 : 실제 서버를 실행하지 않고도 HTTP 요청을 모의하여 컨트롤러를 테스트 할 수 있도록 함.

    @Autowired
    private MockMvc mockMvc;

    // 가짜 객체를 생성하는데 mockito 라이브러리에서 제공하는 어노테이션
    @Mock
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        log.info("Before each run!!");
    }

    @Test
    public void save_test() throws Exception {
        log.info("Test case 1: save test");





    }



//    @Test
//    @Transactional
//    public void test() throws Exception {
//        log.info("BookControllerMockTest - test() 실행");
//
//        MvcResult result = mockMvc.perform(get("/book"))
//                .andExpect(status().isOk())                      // 응답 상태 코드가 200인지 확인
//                .andExpect(content().string("success-bookMain()")) // 응답 본문이 기대한 내용과 일치하는지 확인
//                .andReturn();
//
//        log.info(result + "");
//        String contentStr = result.getResponse().getContentAsString();
//        System.out.println("content : " + contentStr);
//
//        int code = result.getResponse().getStatus();
//        System.out.println("code : " + code);
//    }


    @AfterEach
    public void tearDown() {
        log.info("After each run!!");
    }
}
