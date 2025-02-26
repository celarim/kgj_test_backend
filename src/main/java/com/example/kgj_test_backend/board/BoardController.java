package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import com.example.kgj_test_backend.board.model.BoardDto;
import com.example.kgj_test_backend.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "게시글 작성", description = "제목, 내용, 작성자를 입력받아 게시글을 DB에 저장")
    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Long>> createBoard(@RequestBody BoardDto.BoardRegisterReq dto) {
        Long idx = boardService.addBoard(dto);
        return ResponseEntity.ok(BaseResponse.success(idx));
    }
}
