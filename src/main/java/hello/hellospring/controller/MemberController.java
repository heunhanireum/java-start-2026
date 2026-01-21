package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList.html";
    }
}
