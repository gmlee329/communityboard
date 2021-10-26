package com.example.backend.board.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.backend.board.model.BoardDto;
import com.example.backend.board.model.OptionDto;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList(OptionDto optionDto) throws Exception;

    int selectBoardListCount(OptionDto optionDto) throws Exception;

    BoardDto selectBoardById(BoardDto boardDto) throws Exception;

    int insertBoard(BoardDto boardDto) throws Exception;

    int updateBoard(BoardDto boardDto) throws Exception;

    int deleteBoard(BoardDto boardDto) throws Exception;

    void updateBoardViewCount(BoardDto boardDto) throws Exception;

}
