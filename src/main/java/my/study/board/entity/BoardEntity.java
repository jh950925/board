package my.study.board.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOARD_STUDY")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long boardId;

    @Column
    private String title;

    @Column
    private String cont;

}
