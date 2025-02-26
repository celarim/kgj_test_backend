package com.example.kgj_test_backend.board.model;

public class BoardDto {
    public static class BoardRegisterReq {
        private String title;
        private String content;
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
