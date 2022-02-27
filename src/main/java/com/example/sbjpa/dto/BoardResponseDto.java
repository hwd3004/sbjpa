package com.example.sbjpa.dto;

import java.util.List;

import com.example.sbjpa.model.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {

    List<Board> boards;
}
