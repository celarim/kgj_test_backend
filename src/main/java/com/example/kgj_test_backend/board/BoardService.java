package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import com.example.kgj_test_backend.board.model.BoardDto;
import com.example.kgj_test_backend.board.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public Long addBoard(BoardDto.BoardRegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return board.getIdx();
    }

    public Long addComment(BoardDto.CommentRegisterReq dto, Long boardIdx) {
        Comment comment = commentRepository.save(dto.toEntity(boardIdx));
        return comment.getIdx();
    }

    public BoardDto.BoardDetailResp getBoard(Long idx) {
        Board board = boardRepository.findById(idx).orElseThrow();
        return BoardDto.BoardDetailResp.from(board);
    }
}
