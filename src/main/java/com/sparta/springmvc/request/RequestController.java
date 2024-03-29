package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }
    // [Request sample]
// GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    @GetMapping("/form/param")
    @ResponseBody
    //RequestParam 생략 가능, 하지만 데이터를 보내지 않으면 오류 발생+ requied=false 를 사용해서 안와도 오류가 발생하지 않도록 할 수 있다. default는 true
    public String helloGetRequestParam(@RequestParam(required = false) String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/param
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/model
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {//ModelAttribute 를 사용하면
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }


    // [Request sample]
// GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) { //객체의 생성자나 setter가 있어야 한다.
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/json
// Header
//  Content type: application/json
// Body
//  {"name":"Robbie","age":"95"}
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}