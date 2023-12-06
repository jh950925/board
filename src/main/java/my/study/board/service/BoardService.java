package my.study.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.study.board.dto.BoardVo;
import my.study.board.entity.BoardEntity;
import my.study.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    
    // 게시글 목록
    public List<BoardEntity> selectList() {
        List<BoardEntity> list = new ArrayList<>();

        list = boardRepository.findAll();

        for (BoardEntity boardEntity : list) {
            log.info("list : " + boardEntity);
        }

        return list;
    }

    // 데이터 상세 정보
    public BoardEntity detailData(Long boardId) {

        return boardRepository.findById(boardId).get();
    }

    // 게시글 등록
    public BoardEntity createData(BoardVo boardVo) {
        log.info("Service createData");
        log.info("vo2 : " + boardVo.toString());
        // 받아온 form 데이터 Entity로 변환
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardVo.getTitle());
        boardEntity.setCont(boardVo.getCont());

        return boardRepository.save(boardEntity);
    }

    // 게시글 수정

    // 게시글 삭제
    public void deleteData(Long boardId) {
        log.info("Service deleteData");
        log.info("boardId : " + boardId);

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardId(boardId);

        boardRepository.deleteById(boardId);
    }

}
