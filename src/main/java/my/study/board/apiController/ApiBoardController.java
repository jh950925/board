package my.study.board.apiController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.study.board.service.BoardService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Board Api Controller
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class ApiBoardController {

    private final BoardService boardService;

    /**
     * 게시글 삭제
     * @param boardId 
     * @return
     */
    @DeleteMapping("/delete/data/{boardId}")
    public ResponseEntity deleteData(@PathVariable Long boardId) {
        log.info("delete Controller");
        boardService.deleteData(boardId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
