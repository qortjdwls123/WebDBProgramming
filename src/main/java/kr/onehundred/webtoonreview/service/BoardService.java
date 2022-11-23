package kr.onehundred.webtoonreview.service;

import kr.onehundred.webtoonreview.dto.BoardDto;
import kr.onehundred.webtoonreview.repository.BoardRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor

//서비스임을 지정
@Service

//DB 작업중 오류시 롤백
//DB와 직접 작용하는 서비스단에 필요.
@Transactional
@RequiredArgsConstructor //bean 주입방법 생성자 final member, @NonNull member 생성자 생성함

public class BoardService {

    private BoardRepository boardRepository;

    //게시판 관련 메서드, 오류로 인해 주석처리, 차후 해결예정
    /*@Transactional
    public List<BoardDto> getBoardlist() {
        List<Board> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( Board boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }*/

    //게시물 DTO 객체를 엔티티로 변환후 reposutory로 저장
    public Long saveBoard(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}