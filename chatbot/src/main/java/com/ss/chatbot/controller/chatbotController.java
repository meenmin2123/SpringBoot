package com.ss.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.chatbot.entity.Article;
import com.ss.chatbot.entity.Comment;
import com.ss.chatbot.repository.ArticleRepository;
import com.ss.chatbot.repository.CommentRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class chatbotController {

    @Autowired
    private ArticleRepository article;

    @Autowired
    private CommentRepository comment;

    @GetMapping("/main.do")
    public String mainPage() {
        return "main/main";
    }

    @GetMapping("/chatting.do")
    public String chattingPage() {
        return "main/chatting";
    }

    // ---
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/articles")
    public String list(Model model, @RequestParam(defaultValue = "0") int page) {
        log.info("페이지 번호:" + page);

        // 페이지당 5개의 게시글,댓글을 보여줌
        // 페이지번호와 페이지 크기를 받아서
        // 페이지당 5개의 게시글을 출력할 수있도록
        // 설정한다.

        // Pageable spring Data JPA
        // 에서 데이터베이스에서 페이지 요청을
        // 정의하는 객체
        // PageRequest JPA가 데이터를
        // 페이징 처리할 수 있도록 도와주는 객체
        // 인터페이스로 반환된다.

        // 페이징 처리 객체 생성해서 인터페이스로 반환하기
        // 전에 특정페이지의 데이터를 가져오되
        // 5개의 항목씩 가져오라는 요청!
        Pageable pageable = PageRequest.of(page, 5);
        // 정렬 옵션을 추가할 수 있다.
        // of(page, 5 ,
        // Sort.by(컬럼명).ascending())
        // Sort.by(컬럼명).descending())
        Page<Article> articlePage = article.findAll(pageable);

        log.info("데이터:" + articlePage);

        model.addAttribute("articlePage", articlePage);

        return "show";
    }

    @GetMapping("/articles2")
    public String list2(Model model, @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "0") int commentPage) {
        log.info("페이지 번호:" + page);
        log.info("댓글 페이지 번호:" + commentPage);

//		Pageable pageable = PageRequest.of(commentPage, 5);
//		Page<Comment> commentList =
//					comment.findAll(pageable);
        // 게시글 번호를 가지고 와서
        // 1번 게시글의 댓글만 페이징 처리
        List<Comment> commentList2
                = comment.findByArticleId(1L);
        log.info("직접 만들 쿼리:" + commentList2);

        log.info("데이터:" + commentList2);

        model.addAttribute("commentList", commentList2);

        return "pageInfo";
    }
}
