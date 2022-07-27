package com.sparta.week03.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@Data

public class MemoRequestDto {
    private final String contents;
    private final String username;
    private final String title;
    private final String password;



}
