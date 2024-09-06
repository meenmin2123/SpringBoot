package com.ss.thymybatis.articlecontroller;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/articles")
@Controller
public class ArticleController {

    @Autowired
    private ArticleService service;

    // 글 번호를 이용해서 데이터를 상세 페이지로 출력
    @GetMapping("/detailPage/{id}")
    public String detailPage(Model model, @PathVariable Long id) {
        log.info("ArticleController - detailPage()");

        Article articlelist = service.findListById(id);
        log.info("id : ", id);
        log.info("articlelist : ", articlelist);

        // 게시글을 클릭했을 때 댓글들 모두 찾아서 show()로 보내야됨
        List<Comment> commentList;

        // 검사 없이 변환 (위험성 존재)
        commentList = service.commentList(id.intValue());

        // 안전하게 변환
        if (id >= Integer.MIN_VALUE && id <= Integer.MAX_VALUE) {
            commentList = service.commentList(id.intValue());
            Comment com = new Comment();
            com.setArticleId(id);

            model.addAttribute("comment", com);
        } else {
            throw new IllegalArgumentException("The id value is out of int range: " + id);
        }

        model.addAttribute("articlelist", articlelist);
        return "article/detailPage";
    }

    @GetMapping("/writePage")
    public String writePage(Model model) {
        log.info("ArticleController - writePage()");
        model.addAttribute("article", new Article());
        return "article/writePage";
    }

    @PostMapping("/writePro")
    public String saveArticle(Model model, Article article) {
        log.info("ArticleController - saveArticle()");

        boolean res = service.insert(article);

        if (res) {
            log.info("글이 추가되었습니다.");
        } else {
            log.info("글이 추가되지 않았습니다.");
        }

        return "redirect:/mainPage";
    }

    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model, @PathVariable Long id) {
        log.info("ArticleController - updatePage()");
        Article article = service.findListById(id);
        model.addAttribute("article", article);
        return "article/updatePage";
    }

    @PostMapping("/updatePro/{id}")
    public String updateArticle(Model model, Article article) {
        log.info("ArticleController - updateArticle()");

        boolean res = service.update(article);

        if (res) {
            log.info("글이 수정되었습니다.");
        } else {
            log.info("글이 수정되지 않았습니다.");
        }

        return "redirect:/mainPage";
    }

    @PostMapping("/commentNew")
    public String newComment(Comment comment) {
        log.info("ArticleController-commentNew()실행!");
        log.info("" + comment);

        service.insertComment(comment);

        return "redirect:/articles/" + comment.getArticeId();
    }
}
