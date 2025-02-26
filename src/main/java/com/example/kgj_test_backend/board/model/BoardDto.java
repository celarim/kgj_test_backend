package com.example.kgj_test_backend.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
    @Getter
    public static class BoardRegisterReq {
        @Schema(example = "게시글 1")
        private String title;
        @Schema(example = "게시글 내용")
        private String content;
        @Schema(example = "작성자 1")
        private String writer;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter
    public static class CommentRegisterReq {
        @Schema(example = "댓글 내용 1")
        private String content;
        @Schema(example = "댓글 작성자 1")
        private String writer;
        public Comment toEntity(Long boardIdx) {
            return Comment.builder()
                    .content(content)
                    .writer(writer)
                    .board(Board.builder().idx(boardIdx).build())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardDetailResp {
        private String title;
        private String content;
        private String writer;
        private List<CommentResp> commentList;

        public static BoardDetailResp from(Board board) {
            return BoardDetailResp.builder()
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentList(CommentResp.from(board.getComments()))
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CommentResp {
        private Long idx;
        private String content;
        private String writer;

        public static CommentResp from (Comment comment) {
            return CommentResp.builder()
                    .idx(comment.getIdx())
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .build();
        }

        public static List<CommentResp> from (List<Comment> comments) {
            return comments.stream().map(CommentResp::from).collect(Collectors.toList());
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardListInstanceResp {
        private Long idx;
        private String title;
        private String writer;
        private Integer commentCount;
        public static BoardListInstanceResp from(Board board) {
            return BoardListInstanceResp.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .commentCount(board.getComments().size())
                    .build();
        }
        public static List<BoardListInstanceResp> from (List<Board> boards) {
            return boards.stream().map(BoardListInstanceResp::from).collect(Collectors.toList());
        }
    }
}
