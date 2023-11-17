package websocket.chating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    // ModelAndView를 이용한 채팅 컨트롤서
//    @RequestMapping("/chat")
    public ModelAndView chatModelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatting");
        return mv;
    }

    // appication.properties에 suffix, prefix 설정되어 있음
    @RequestMapping("/chat")
    public String chatString() {
        return "chatting";
    }

}