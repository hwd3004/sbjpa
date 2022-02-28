package com.example.sbjpa.dto;

import java.util.List;
import java.util.Optional;

import com.example.sbjpa.model.Board;
import com.example.sbjpa.model.Storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {

    List<Board> boards;

    Optional<Board> board;

    List<Storage> storages;
}
