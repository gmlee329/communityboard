package com.example.backend.board.service;

import com.example.backend.board.model.ReplyDto;
import com.example.backend.board.repository.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    public List<ReplyDto> selectReplyList(ReplyDto replyDto) throws Exception {
        return replyMapper.selectReplyList(replyDto);
    }

    public int insertReply(ReplyDto replyDto) throws Exception {
        return replyMapper.insertReply(replyDto);
    }

    public int updateReply(ReplyDto replyDto) throws Exception {
        return replyMapper.updateReply(replyDto);
    }

    public int deleteReply(ReplyDto replyDto) throws Exception {
        return replyMapper.deleteReply(replyDto);
    }
}
