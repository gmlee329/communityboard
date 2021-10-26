package com.example.backend.board.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.backend.board.model.ReplyDto;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<ReplyDto> selectReplyList(ReplyDto replyDto) throws Exception;

    int insertReply(ReplyDto replyDto) throws Exception;

    int updateReply(ReplyDto replyDto) throws Exception;

    int deleteReply(ReplyDto replyDto) throws Exception;
}
