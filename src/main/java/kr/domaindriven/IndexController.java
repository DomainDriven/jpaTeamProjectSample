package kr.domaindriven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO 새로운 index가 추가될 경우 패키지 변경할 것.
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "redirect:/comments";
    }
}
