package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
