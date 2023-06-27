package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.Message;
import com.example.demo.dto.StatusEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.Charset;

@RestController
public class MemberController {
    @GetMapping(value = "/member/{id}")
    public ResponseEntity<Message> findById(@PathVariable int id) {
        MemberDTO member=new MemberDTO();
        member.setId(id+"");
        member.setPw("bb");
        member.setAddr("cc");
        member.setTel("dd");
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        message.setStatus(StatusEnum.OK);
        message.setMessage("성공 코드");
        message.setData(member);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
}