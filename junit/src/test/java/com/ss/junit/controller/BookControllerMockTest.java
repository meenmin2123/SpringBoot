package com.ss.junit.controller;

import com.ss.junit.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.junit.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.springframework.transaction.annotation.Transactional;

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

        // 실행 순서
        // 1. 책의 객체 생성
        // 2. JSON 변환
        // 3. Mockito로 서비스 동작 설명
        // 4. 가상의 Http post 요청
        // 5. 응답 상태 검증
        // 6. 응답 본문 검증

        // given : Book 객체를 저장하기 위해서 저장을 했을 때 어떤 결과가 나올지 설정하는 부분
        Book book = new Book(null, "Spring Boot Book","Author");

        // 자바 객체를 JSON형식으로 변환함.
        // writeValueAsString(객체)  {"title":"스프링부트"} --> 이런 형태로 변환.
        String content = new ObjectMapper().writeValueAsString(book);

        // 특정 메서드가 호출되어서 실행할 수 있도록 설정
        when(bookService.save(book)).thenReturn(new Book(null, "Spring Boot Book","Author"));

        // when
        // http 요청 보냄.
        ResultActions resultActions = mockMvc.perform(post("/book")
                                             .contentType(MediaType.APPLICATION_JSON)
                                             .content(content));

        // then
        resultActions.andExpect(status().isCreated())
                     .andExpect(jsonPath("$.title").value("Spring Boot Book"));
    }

//    @Test
//    public void jsonPathTest1() throws Exception {
//        log.info("Test case 2: jsonPathTest1");
//
//        // 서버가 응답을 받아서 저장한 후
//        String respJson = "{\"id\":1,\"title\":\"Spring Boot Book\",\"author\":\"Author\"}";
//
//        // get 요청 후 검증
//        // ex)
//        mockMvc.perform(get("/user1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))    // id 값이 1인지 검증
//                .andExpect(jsonPath("$.title").value("Spring Boot Book"))
//                .andDo(print());    // 검색한 결과를 출력
//    }

//    @Test
//    public void jsonPathTest2() throws Exception {
//
//        // 서버에서 응답 JSON 배열
//        String jsonResponse = "[{ \"id\": 1, \"name\": \"John\" }, { \"id\": 2, \"name\": \"Jane\" }]";
//
//        // get 요청 후 검증
//        mockMvc.perform(get("/user"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1))    // id 값이 1인지 검증
//                .andExpect(jsonPath("$[1].title").value("Spring Boot Book"))
//                .andExpect(jsonPath("$", Matchers.hasSize(2)))    // 배열의 사이즈 맞는지 검증
//                .andDo(print());
//    }

    // ----
    @Test
    public void findAll_test() throws Exception {
        log.info("Test case 3: findAll test");

        // given
        // 1. 초기 데이터를 준비
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Spring Boot","Author"));
        books.add(new Book(2L, "React","js"));

        // when
        // 2. 어떤 행동을 할 지 설정!
        when(bookService.findAll()).thenReturn(books);

        // 3. 가짜 http 요청
        ResultActions resultActions = mockMvc.perform(get("/findAll")
                .contentType(MediaType.APPLICATION_JSON));

        // then (결과 응답 검증)
        resultActions.andExpect(status().isOk())
                     .andExpect(jsonPath("$.[0].title").value("The Great Gatsby"))
                     .andDo(print());

        resultActions.andExpect(status().isOk())
                     .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void findById_test() throws Exception {
        log.info("Test case 4: findById test");

        //given
        // 어떤 아이디 값을 이용해서 한 건을 가져올 지 결정
        Long id = 1L;

        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "The Great Gatsby","F. Scott Fitzgerald"));
        books.add(new Book(2L, "1984","George Orwell"));
        books.add(new Book(3L, "To Kill a Mockingbird","Harper Lee"));

        // when(어떤호출(id))
        // thenReturn(결과 객체)
        //when(실행)
        when(bookService.findById(id)).thenReturn(books.get(0));

        //then(응답 검증)
        ResultActions resultActions = mockMvc.perform(put("/book/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("The Great Gatsby"))
                .andExpect(jsonPath("$.author").value("F. Scott Fitzgerald"))
                .andDo(print());
    }

    @Test
    public void update_test() throws Exception {
        log.info("Test case 5: update_test");

        //given
        // 어떤 책을 아이디값으로 조회해서 수정할 값을 입력 받고
        // 어떤 메서드가 실행 매개변수로 어떤 객체와 어떤 변수가 넘어갈 지
        // 응답받는 객체타입을 작성
        Long id = 1L;
        Book updatedBook = new Book(1L, "Spring Boot Book","Author");

        String content = new ObjectMapper().writeValueAsString(updatedBook);

        //when(실행)
        when(bookService.update(id,updatedBook)).thenReturn(updatedBook);

        ResultActions resultAction = mockMvc.perform(get("/book/{id}", id)
                                             .content(content)
                                             .contentType(MediaType.APPLICATION_JSON));
        //then(응답 검증)
        resultAction.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Spring Boot Book"))
                .andExpect(jsonPath("$.author").value("Author"))
                .andDo(print());
    }

    @Test
    public void delete_test() throws Exception {
        log.info("Test case 5: delete_test");

        //given
        // 아이디값을 입력 받아서 어떤 메서드를 호출해서 아이디값을
        // 매개변수로 넘겨주고 thenReturn("ok")
        Long id = 1L;

        //when(실행)
        when(bookService.delete(id)).thenReturn("success");

        //then(응답검증)
        ResultActions resultAction = mockMvc.perform(delete("/book/{id}", id));

        //then(응답 검증)
        resultAction.andExpect(status().isOk())
                .andDo(print());
    }


    @AfterEach
    public void tearDown() {
        log.info("After each run!!");
    }
}
