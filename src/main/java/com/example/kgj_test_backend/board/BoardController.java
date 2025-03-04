package com.example.kgj_test_backend.board;

import com.example.kgj_test_backend.board.model.Board;
import com.example.kgj_test_backend.board.model.BoardDto;
import com.example.kgj_test_backend.common.BaseResponse;
import com.example.kgj_test_backend.common.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "게시판 기능")
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

    @Operation(summary = "게시글 목록 조회", description = "페이지와 페이지 크기를 입력받아 번호, 제목, 작성자, 댓글 수를 출력")
    @GetMapping("/list")
    public ResponseEntity<BaseResponse<PageResponse<BoardDto.BoardListInstanceResp>>> getList(Integer page, Integer size) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (size == null || size < 1) {
            size = 10;
        }
        PageResponse<BoardDto.BoardListInstanceResp> dto = boardService.getAllBoards(page, size);
        return ResponseEntity.ok(BaseResponse.success(dto));
    }

}
