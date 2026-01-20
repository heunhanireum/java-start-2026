package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //직접 bean을 등록해도 controller는 component scan 해야 함
public class MemberController {

//    @Autowired private MemberService; //필드주입
/*
    private MemberService memberService; //setter주입

    @Autowired //setter주입->public 하게 노출이 되어야 하기 때문에 잘못 바뀔 위험이 있음
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
*/
    private final MemberService memberService; //생성자주입

    // 생성자주입
    @Autowired //controller가 component scan 하기 때문에 service도 autowired로 연결 -> bean에 직접 등록한 service 연결됨
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
