package kr.onehundred.webtoonreview.dto;

import kr.onehundred.webtoonreview.entity.Board;
import lombok.*;

//getter와 setter 메서드를 자동으로 생성해주는 Lombok 어노테이션
@Getter
@Setter

//toString 메서드를 자동으로 생성해주는 Lombok 어노테이션
@ToString

//파라미터가 없는 기본 생성자를 자동 생성
@NoArgsConstructor
public class BoardDto {

    private Long id;             // id, PK
    private String title;        // 제목
    private String content;      // 내용
    private String writer;       // 작성자
    
    //작성시간, 조회수, 추천수 등 차후 추가 예정


    //DTO에서 엔티티로
    public Board toEntity(){
        //생성자는 가독성이 떨어지므로 빌더 사용.
        Board board = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return board;
    }

    /*
    //게시판 관련 메서드, 오류로 인해 주석처리, 차후 해결예정
    //파라미터 있는 생성자
    @Builder
    public BoardDto(Long id, String title, String content, String writer) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    */
}
