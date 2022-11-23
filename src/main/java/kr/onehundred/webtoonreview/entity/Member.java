package kr.onehundred.webtoonreview.entity;

import kr.onehundred.webtoonreview.constant.Role;
import kr.onehundred.webtoonreview.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        //id, PK

    private String name;    //이름

    @Column(unique = true)
    private String email;   //email

    private String password;//비밀번호

    private String address;//주소

    //enum(열거형) 타입을 엔티티 클래스의 속성으로 사용.
    @Enumerated(EnumType.STRING)
    private Role role;      //역할(권한)

    //DTO로 엔티티 생성하는 메서드
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        
        //패스워드를 인코딩해서 저장
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        
        //일단 모든 사용자를 관리자로 지정, 차후에 USER로 나눌 예정
        member.setRole(Role.ADMIN);
        return member;
    }
}