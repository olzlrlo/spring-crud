package olzlrlo.springcrud.controller;


import olzlrlo.springcrud.domain.BoardVO;
import olzlrlo.springcrud.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping(value="/")
public class BoardController {

    @Inject // 주입(심부름꾼) 명시
    private BoardService service; // Service 호출을 위한 객체 생성

    @RequestMapping(value="/listAll", method = RequestMethod.GET) // 주소 호출 명시
    public void listAll(Model model) throws Exception{ // 메소드의 인자 값은 model 인터페이스
        model.addAttribute("list", service.listAll()); // jsp에 심부름할 내역(서비스 호출)
    }

    @RequestMapping(value="/register", method = RequestMethod.GET) // GET 방식으로 페이지 호출
    public String registerGET(Model model) throws Exception{
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST) // POST 방식으로 데이터 전송
    public String registerPOST(BoardVO board) throws Exception {
        service.register(board); // 글 작성 서비스 호출
        return "redirect:/listAll"; // 작성이 완료된 후, 목록 페이지로 리턴
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET) // GET 방식으로 페이지 호출
    public void read(@RequestParam("bno")int bno, Model model) throws Exception{ // 기본 키인 글 번호를 기준으로 모델을 사용하여 불러옴
        model.addAttribute(service.read(bno)); // read 서비스 호출
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET) // GET 방식으로 페이지 호출
    public void modifyGET(int bno, Model model) throws Exception {
        model.addAttribute(service.read(bno)); // 수정을 위한 글 읽기 서비스 호출
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)// POST 방식으로 데이터 전송
    public String modifyPOST(BoardVO board) throws Exception {
        service.modify(board); // 글 수정 서비스 호출
        return "redirect:/listAll"; // 수정이 완료된 후, 목록 페이지로 리턴
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)// POST 방식으로 데이터 전송
    public String removePOST(@RequestParam("bno") int bno) throws Exception{
        service.remove(bno); // 글 삭제 서비스 호출
        return "redirect:/listAll"; // 삭제가 완료된 후, 목록 페이지로 리턴
    }

}
