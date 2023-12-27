package com.example.demo.mapper;


import com.example.demo.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MemberMapper {
	MemberDTO selectMemberDetail(@Param("paramId") String id);
}
