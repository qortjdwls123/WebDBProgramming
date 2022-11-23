package kr.onehundred.webtoonreview.controller;

import kr.onehundred.webtoonreview.dto.MemberFormDto;
import kr.onehundred.webtoonreview.entity.Member;
import kr.onehundred.webtoonreview.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
    
    //멤버에 관련된 service 클래스
    private final MemberService memberService;
    
    //패스워드 인코더
    private final PasswordEncoder passwordEncoder;


    @GetMapping(value = "/new")
    //회원가입
    public String memberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping(value = "/new")
    //@Valid는 DTO 객체에서 정의해 둔 검증사항을 검증
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

        //@Valid에서 검증에 실패하면 에러
        //에러나면, 다시 member/memberForm 으로
        if(bindingResult.hasErrors()){
            return "member/memberForm";
        }

        try {
            //멤버 DTO의 정보로 멤버 엔티티를 만든다.(passwordEncoder로 패스워드 암호화)
            Member member = Member.createMember(memberFormDto, passwordEncoder);

            //엔티티를 서비스로 보낸다.
            //컨트롤러에서 서비스로 객체를 보낼 때는 DTO를 보내는 것이 일반적
            memberService.saveMember(member);
        } catch (IllegalStateException e){

            //예외 발생시, 에러 메시지를 뷰에 보낸다.
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }

        return "main";
    }

    @GetMapping(value = "/login")
    //로그인
    public String loginMember(){
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    //로그인 에러 처리
    public String loginError(Model model){
        //로그인 에러 발생시 경고 문구를 뷰에 보낸다.
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/member/memberLoginForm";
    }
}