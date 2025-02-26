package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import com.example.kgj_test_backend.board.model.BoardDto;
import com.example.kgj_test_backend.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @Operation(summary = "댓글 작성", description = "내용, 작성자, 게시글 idx를 입력받아 댓글을 DB에 저장")
    @PostMapping("comment/{boardIdx}")
    public ResponseEntity<BaseResponse<Long>> createComment(@RequestBody BoardDto.CommentRegisterReq dto,
                                                            @PathVariable Long boardIdx) {
        Long idx = boardService.addComment(dto, boardIdx);
        return ResponseEntity.ok(BaseResponse.success(idx));
    }

    @Operation(summary = "게시글 상세 조회", description = "게시글 idx를 입력받아 제목, 내용, 작성자, 댓글 목록을 출력")
    @GetMapping("/read/{idx}")
    public ResponseEntity<BaseResponse<BoardDto.BoardDetailResp>> getBoard(@PathVariable Long idx) {
        BoardDto.BoardDetailResp dto = boardService.getBoard(idx);
        return ResponseEntity.ok(BaseResponse.success(dto));
    }
}
