package kr.onehundred.webtoonreview.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//로거 관련된 어노테이션, 로그는 차후에 추가예정
@Slf4j

//컨트롤러를 지정함.
@Controller
public class MainController {
    //get메서드만 매핑
    @GetMapping("/")
    
    //메인
    public String index(){

        //기본 경로는 templates 폴더 아래
        return "main";
    }
}
