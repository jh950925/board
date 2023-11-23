package my.study.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class BoardController {

    // 게시글 조회
    @GetMapping("/")
    public String MvList() {
        return "list";
    }
    // 게시글 추가
    // 게시글 수정
    // 게시글 삭제

    // 댓글 추가
    // 댓글 수정
    // 댓글 삭제

}
