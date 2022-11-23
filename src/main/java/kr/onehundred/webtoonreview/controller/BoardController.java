package kr.onehundred.webtoonreview.controller;

import kr.onehundred.webtoonreview.dto.BoardDto;
import kr.onehundred.webtoonreview.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//요청을 (ULR을 통해)특정 컨트롤러와 매핑
@RequestMapping("/board")

@Controller

//final이나 @NotNull이 붙은 필드의 생성자를 자동 생성해주는 Lombok 어노테이션(@Autowired 필요 없음)
@RequiredArgsConstructor
public class BoardController {

    //누군가 서비스 객체를 바꿔치지 못하도록? service에 final을 붙임.
    private final BoardService boardService;


    @GetMapping("")
    //게시판 리스트
    public String list(Model model){

        //게시판 및 리뷰(DTO)를 받아오기 위한 변수
        //현재 서비스 클래스의 getBoardlist()의 에러를 해결하지 못해 주석처리, 차후 해결예정
        /*List<BoardDto> boardList = boardService.getBoardlist();

        //받은 DTO 객체를 뷰에 모델로 전달. ("boardList"은 name)
        model.addAttribute("boardList", boardList);*/
        return "board/list";
    }

    //새 포스트 작성
    @GetMapping(value = "/newBoard")
    public String newBoard(){
        return "/board/newBoard";
    }

    //새 포스트 작성 완료
    //포스트 메서드만 매핑
    @PostMapping(value = "/newBoard")
    //새 포스트의 제목과 내용, 작성자를 담은 DTO를 받아서 엔티티로 repository에 넘겨줌
    //검증사항을 정의해 두지 않아 @Valid는 주석처리 차후 추가예정
    public String newBoard(/*@Valid */BoardDto boardDto){

        //DTO 엔티티로 repository에 넘겨줌
        boardService.saveBoard(boardDto);

        //리다이렉트:URL -> URL로 다시 요청
        return "redirect:/";
    }
}
