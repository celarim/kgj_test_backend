package com.example.kgj_test_backend.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

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
}
