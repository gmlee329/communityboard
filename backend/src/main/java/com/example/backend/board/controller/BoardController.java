package com.example.backend.board.controller;

import com.example.backend.board.model.BoardDto;
import com.example.backend.board.model.OptionDto;
import com.example.backend.board.model.ReplyDto;
import com.example.backend.board.service.BoardService;
import com.example.backend.board.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;

    @GetMapping("")
    public HashMap<String, Object> selectBoardList(@RequestParam Map<String, String> params) throws Exception {
        String schType = params.get("schType");
        String schVal = params.get("schVal");
        int rows = Integer.parseInt(params.get("rows"));
        int page = Integer.parseInt(params.get("page"));
        String[] sort = URLDecoder.decode(params.get("sort"), "UTF-8").split(",");
        int endNo = page * rows;
        int startNo = ((endNo) - rows) + 1;

        OptionDto optionDto = new OptionDto();
        optionDto.setSchType(schType);
        optionDto.setSchVal(schVal);
        optionDto.setStartNo(startNo);
        optionDto.setEndNo(endNo);
        optionDto.setSort(sort);

        return boardService.selectBoardList(optionDto);
    }

    @GetMapping("/{docNo}")
    public BoardDto selectBoardById(@PathVariable int docNo) throws Exception {
        BoardDto boardDto = new BoardDto();
        boardDto.setDocNo(docNo);

        return boardService.selectBoardById(boardDto);
    }

    @PostMapping("")
    public int insertBoard(@RequestBody BoardDto boardDto) throws Exception {
        String writer = "admin";
        boardDto.setWriter(writer);

        return boardService.insertBoard(boardDto);
    }

    @PatchMapping("/{docNo}")
    public int updateBoard(@PathVariable int docNo, @RequestBody BoardDto boardDto) throws Exception {
        boardDto.setDocNo(docNo);

        return boardService.updateBoard(boardDto);
    }

    @DeleteMapping("/{docNo}")
    public int deleteBoard(@PathVariable int docNo) throws Exception {
        BoardDto boardDto = new BoardDto();
        boardDto.setDocNo(docNo);

        return boardService.deleteBoard(boardDto);
    }

    @GetMapping("/{docNo}/replies")
    public List<ReplyDto> selectReplyList(@PathVariable int docNo) throws Exception {
        ReplyDto replyDto = new ReplyDto();
        replyDto.setDocNo(docNo);

        return replyService.selectReplyList(replyDto);
    }

    @PostMapping("/{docNo}/replies")
    public int insertReply(@PathVariable int docNo, @RequestBody ReplyDto replyDto) throws Exception {
        String writer = "admin";

        replyDto.setDocNo(docNo);
        replyDto.setWriter(writer);

        return replyService.insertReply(replyDto);
    }

    @PatchMapping("{docNo}/replies/{replyNo}")
    public int updateReply(@PathVariable int docNo, @PathVariable int replyNo, @RequestBody ReplyDto replyDto) throws Exception {
        replyDto.setDocNo(docNo);
        replyDto.setReplyNo(replyNo);

        return replyService.updateReply(replyDto);
    }

    @DeleteMapping("{docNo}/replies/{replyNo}")
    public int deleteReply(@PathVariable int docNo, @PathVariable int replyNo) throws Exception {
        ReplyDto replyDto = new ReplyDto();
        replyDto.setDocNo(docNo);
        replyDto.setReplyNo(replyNo);

        return replyService.deleteReply(replyDto);
    }
}
