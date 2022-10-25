package com.ddit.board.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {

    @GetMapping("/test")
    @ResponseBody
    public String asdf(HttpServletRequest request, HttpServletResponse response){
        return "asdf";
    }

}
