package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor

public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);

    }

    @PostMapping("/api/memos/{id}")
    public boolean createMemos(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.checkPassword(id,requestDto.getPassword());

    }


    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("api/memos/{id}")
   public Optional<Memo> getMemo(@PathVariable Long id){
        return memoRepository.findById(id);

   }

    @PutMapping("api/memos/{id}")
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){
        return memoService.update(id,requestDto);
    }



    @DeleteMapping("api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }


}
