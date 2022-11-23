package kr.onehundred.webtoonreview.repository;

import kr.onehundred.webtoonreview.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    
    //제목을 통해 게시글을 찾는 검색기능 구현시 사용할 예정
    /*Board findByTitle(String title);*/
}