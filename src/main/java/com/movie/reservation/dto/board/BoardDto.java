package com.movie.reservation.dto.board;

import com.movie.reservation.domain.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    private String title;
    private String content;

    public static BoardDto toBoardDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(board.getTitle());
        boardDto.setContent(board.getContent());

        return boardDto;
    }
}
