package com.example.kgj_test_backend.board.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String content;
    private String writer;
    @ManyToOne
    @JoinColumn(name="board_idx")
    private Board board;
}
