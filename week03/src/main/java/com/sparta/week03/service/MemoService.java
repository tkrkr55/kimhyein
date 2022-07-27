package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final과 함께 움직임
@Service // 서비스 라는걸 스프링에게 알려줘
@Transactional // 업데이트를 할때 DB에 진짜 반영돼야 한다고 한번더 해주는 기능
public class MemoService {


    private final MemoRepository memoRepository;

    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 없습니다.")
        );
        memo.update(requestDto);
        return id;
    }

    public boolean checkPassword(Long id, String password){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("패스워드가 없습니다.")

        );
        return memo.getPassword().equals(password);
    }



//    public Long idUpdate(Long id ,MemoRequestDto requestDto){
//        Memo memo = memoRepository.findById(id).orElseThrow(
//                () -> new NullPointerException("아이디가 없습니다.")
//        );
//        memo.update(requestDto);
//      return id;
//    }
}
