package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import com.example.kgj_test_backend.board.model.BoardDto;
import com.example.kgj_test_backend.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Long>> createBoard(@RequestBody BoardDto.BoardRegisterReq dto) {
        Long idx = boardService.addBoard(dto);
        return ResponseEntity.ok(BaseResponse.success(idx));
    }
}
