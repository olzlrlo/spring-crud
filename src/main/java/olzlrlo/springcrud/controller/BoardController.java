package olzlrlo.springcrud.controller;


import olzlrlo.springcrud.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping(value="/")
public class BoardController {
    @Inject // 주입(심부름꾼) 명시
    private BoardService service; // Service 호출을 위한 객체 생성

    @RequestMapping(value="/listAll", method = RequestMethod.GET) // 주소 호출 명시
    public void listAll(Model model)throws Exception{ // 메소드의 인자 값은 model 인터페이스
        model.addAttribute("list", service.listAll()); // jsp에 심부름할 내역(서비스 호출)
    }

}
