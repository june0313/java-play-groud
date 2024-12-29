package me.jun.module.member.api;

import me.jun.module.member.api.model.MemberDTO;

public class MemberApi {
    public MemberDTO findMemberById(Long id) {
        return new MemberDTO(id, "member" + id);
    }
}
