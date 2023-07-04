package hello.servelet.web.frontcontroller.v4.controller;

import hello.servelet.domain.Member.Member;
import hello.servelet.domain.Member.MemberRepository;
import hello.servelet.web.frontcontroller.ModelView;
import hello.servelet.web.frontcontroller.v3.ControllerV3;
import hello.servelet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        model.put("members",members);
        return "members";
    }
}
