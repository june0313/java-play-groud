package me.jun.modularapplication.web;

import lombok.RequiredArgsConstructor;
import me.jun.module.a.pub.PublicModuleA;
import me.jun.module.member.api.MemberApi;
import me.jun.module.member.api.model.MemberDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ModularController {
    private final PublicModuleA publicModuleA;
    private final MemberApi memberApi;


    @GetMapping("/")
    public String index() {
        publicModuleA.run();
        return "ok";
    }

    @GetMapping("/member/{id}")
    public MemberDTO member(@PathVariable Long id) {
        return memberApi.findMemberById(id);
    }
}
