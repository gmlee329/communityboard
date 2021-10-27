package com.example.backend.board.service;

import com.example.backend.board.model.ReplyDto;
import com.example.backend.board.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.board.model.BoardDto;
import com.example.backend.board.model.OptionDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    ReplyService replyService;

    public HashMap<String, Object> selectBoardList(OptionDto optionDto) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<BoardDto> result = boardMapper.selectBoardList(optionDto);
        int total = 0;

        if (result.size() > 0) {
            total = boardMapper.selectBoardListCount(optionDto);
        }

        hashMap.put("data", result);
        hashMap.put("total", total);

        return hashMap;
    }

    @Transactional(rollbackFor = Exception.class)
    public BoardDto selectBoardById(BoardDto boardDto) throws Exception {
        boardMapper.updateBoardViewCount(boardDto);

        return boardMapper.selectBoardById(boardDto);
    }

    public int insertBoard(BoardDto boardDto) throws Exception {
        int result = 0;

        if (boardMapper.insertBoard(boardDto) > 0) {
            result = boardDto.getDocNo();
        }

        return result;
    }

    public int updateBoard(BoardDto boardDto) throws Exception {
        return boardMapper.updateBoard(boardDto);
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteBoard(BoardDto boardDto) throws Exception {
        ReplyDto replyDto = new ReplyDto();
        replyDto.setDocNo(boardDto.getDocNo());

        if (replyService.selectReplyList(replyDto).size() > 0) {
            replyService.deleteReply(replyDto);
        }

        return boardMapper.deleteBoard(boardDto);
    }
}
