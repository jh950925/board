package my.study.board.entity;


import javax.persistence.*;

@Entity
@Table(name = "COMMENT_STUDY")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private BoardEntity board;

    @Column
    private String nickname;

    @Column
    private String comment;

}
