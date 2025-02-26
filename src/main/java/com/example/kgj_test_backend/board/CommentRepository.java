package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
