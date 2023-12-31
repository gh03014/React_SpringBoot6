package com.jaehwan.jaehwanback.service;

import com.jaehwan.jaehwanback.exception.ResourceNotFoundException;
import com.jaehwan.jaehwanback.model.Board;
import com.jaehwan.jaehwanback.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시판 목록 출력
    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    //글 작성하기
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    //글 상세보기
    public ResponseEntity<Board> getBoard(Integer no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));
        return ResponseEntity.ok(board);
    }
}