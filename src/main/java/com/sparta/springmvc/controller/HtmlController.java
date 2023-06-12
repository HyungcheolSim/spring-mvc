package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    private static long visitCount=0;
    @GetMapping("/static-hello")
    public String hello(){
        return "hello.html";
    }

    @GetMapping("/html/redirect")
    public String htmlStatic(){
        return "redirect:/hello.html";
    }
    @GetMapping("/html/templates") //템플릿 내 파일은 이믐만 return에 적어주면 된다
    public String htmlTemplates(){
        return "hello";
    }
    @GetMapping("html/dynamic")
    public String htmlDynamic(Model model){
        visitCount++;
        model.addAttribute("visits",visitCount);
        return "hello-visit";
    }
}