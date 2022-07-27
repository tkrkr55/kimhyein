package com.sparta.week03;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.service.MemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week03Application {

    public static void main(String[] args) {
        SpringApplication.run(Week03Application.class, args);
    }

    @Bean //  싱글톤..? ||유지하기위해 의존성 주입을 한다. demo메소드를 계속불러서
    public CommandLineRunner demo(MemoRepository memoRepository, MemoService memoService) {
        return (args) -> {
//            memoRepository.save( new Memo("김혜인", "재밌땅.","스프링" ,"1234"));
//            System.out.println("데이터 인쇄");
        };
    }
}
