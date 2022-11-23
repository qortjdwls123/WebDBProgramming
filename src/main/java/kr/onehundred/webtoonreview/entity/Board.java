package kr.onehundred.webtoonreview.entity;

import kr.onehundred.webtoonreview.dto.BoardDto;
import lombok.*;

import javax.persistence.*;

//엔티티를 지정함
@Entity
//테이블 명을 설정
@Table(name="tb_post")
@Getter
@Setter
@ToString
//기본(파라미터 없는) 생성자의 권한 설정(Protected)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    
    //보통 엔티티 객체의 식별자 역할
    @Id
    //컬럼명 지정
    @Column(name="id")
    //값 자동 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        //id, PK
    @Column(length = 100, nullable = false)
    private String title;   //제목
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; //내용
    @Column(length = 30, nullable = false)
    private String writer;  //작성자

    //파라미터 있는 생성자.
    @Builder
    public Board(Long id, String title, String content, String writer) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
