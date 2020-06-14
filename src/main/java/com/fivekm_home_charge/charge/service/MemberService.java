package com.fivekm_home_charge.charge.service;

import com.fivekm_home_charge.charge.mapper.MemberMapper;
import com.fivekm_home_charge.charge.web.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class MemberService {
    @Autowired(required=false)
    MemberMapper memberMapper;

    public ArrayList<MemberDto> getMembers() throws Exception {
        return memberMapper.getMembers();
    }

    public void insertMembers(MemberDto memberDto) throws Exception {
        memberMapper.insertMembers(memberDto);
    }
}
