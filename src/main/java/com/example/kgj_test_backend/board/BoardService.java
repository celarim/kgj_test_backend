package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import com.example.kgj_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long addBoard(BoardDto.BoardRegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return board.getIdx();
    }
}
