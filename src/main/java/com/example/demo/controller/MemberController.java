package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.Message;
import com.example.demo.dto.StatusEnum;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/member/{id}")
    public ResponseEntity<Message> findById(@PathVariable String id) {
        MemberDTO member=memberService.findMemberDetail(id);

        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        message.setStatus(StatusEnum.OK);
        message.setMessage("성공 코드");
        message.setData(member);

        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }
    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<Message> handleException(Exception e) {
        Message message = new Message();
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        message.setStatus(StatusEnum.BAD_REQUEST);
        message.setMessage("존재하지 않는 ID");

        return new ResponseEntity<>(message, headers, HttpStatus.BAD_REQUEST);
    }
}