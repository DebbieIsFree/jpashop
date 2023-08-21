package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){   // Model에 data를 실어서 Controller에서 View로 넘길 수 있다.
        model.addAttribute("data", "hello!!!");

        // 스프링 부트 thymeleaf viewName 매핑
        // resources:templates/+ {ViewName} + .html
        // templates : 렌더링 파일, static : 렌더링 없는 순수 html 파일
        return "hello";     // 화면 이름으로 렌더링, (== hello.html)
    }
}
