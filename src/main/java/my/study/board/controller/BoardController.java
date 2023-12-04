package my.study.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.study.board.dto.BoardVo;
import my.study.board.entity.BoardEntity;
import my.study.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 조회 페이지 이동
    @GetMapping("")
    public String MvList(Model model) {
        log.info("root");

        List<BoardEntity> dataList = boardService.selectList();
        model.addAttribute("list", dataList);

        return "list";
    }

    //게시글 조회
    @GetMapping("select/data")
    public String getList(Model model){
        log.info("selectData");

        List<BoardEntity> dataList = boardService.selectList();
        model.addAttribute("list", dataList);

        return "list";
    }
    
    // 게시글 추가 페이지 이동
    @GetMapping("create/view")
    public String CreateView(){
        log.info("저장 페이지 이동");
        return "createBoard";
    }
    
    // 게시글 추가
    @PostMapping("create/data")
    public String createData(BoardVo boardVo) {
        log.info("vo : " + boardVo.toString());

        log.info("vo : " + boardVo.getTitle());
        log.info("vo : " + boardVo.getCont());

        boardService.createData(boardVo);
        return "redirect:/";
    }

    // 게시글 수정
    @PatchMapping("updat/data/{id}")
    public ModelAndView updateData(BoardVo boardVo, @PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("list");
        modelAndView.addObject("data");

        return modelAndView;
    }

    // 게시글 삭제
    @DeleteMapping("delete/data{id}")
    public int delete(@PathVariable Long id) {

        return 0;
    }

    // 댓글 추가
    // 댓글 수정
    // 댓글 삭제

}
