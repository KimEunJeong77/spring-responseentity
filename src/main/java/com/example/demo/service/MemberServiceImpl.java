package com.example.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;

	@Override
	public MemberDTO findMemberDetail(String id) {
		// TODO Auto-generated method stub
		MemberDTO dto=memberMapper.selectMemberDetail(id);
		if(dto==null) throw new IdNotFoundException("존재하지않는ID");
		return dto;
	}
}