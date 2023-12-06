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
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 목록 페이지 이동
     *
     * @param
     * @return String
     */
    @GetMapping("/")
    public String MvList(Model model) {
        log.info("root");

        List<BoardEntity> dataList = boardService.selectList();
        model.addAttribute("list", dataList);

        return "list";
    }

    /**
     * 게시글 추가 페이지 이동
     *
     * @return
     */
    @GetMapping("/create/view")
    public String CreateView() {
        return "createBoard";
    }

    // 게시글 수정 페이지 이동
    @GetMapping("/update/view/{boardId}")
    public String UpdateView(@PathVariable Long boardId, Model model) {
        // id값 가져오기
        log.info("id : " + boardId);

        // service에서 상세조회 데이터 확인
        model.addAttribute("data", boardService.detailData(boardId));
        log.info("상세정보 : " + model.getAttribute("data"));

        // 데이터 넘기기
        return "createBoard";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 게시글 목록 조회
     *
     * @param model
     * @return String
     */
    @GetMapping("/select/dataList")
    public String getList(Model model) {
        log.info("selectData");

        List<BoardEntity> dataList = boardService.selectList();
        model.addAttribute("list", dataList);

        return "list";
    }

    /**
     * 게시글 추가
     *
     * @param boardVo
     * @return String
     */
    // 게시글 추가
    @PostMapping("/create/data")
    public String createData(BoardVo boardVo) {
        boardService.createData(boardVo);
        return "redirect:/";
    }

    // 댓글 수정


}
