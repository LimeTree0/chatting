package websocket.chating.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Service
@ServerEndpoint(value="/chatt")
public class WebSocketChatt {
    private static Set<Session> clients =
            Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage // 	메시지가 수신되었을 때
    public void onMessage(String msg, Session session) throws Exception{
        System.out.println("receive message : " + msg);
        for(Session s : clients) {
            System.out.println("send data : " + msg);
            s.getBasicRemote().sendText(msg);

        }
    }

    @OnOpen // 클라이어트가 접속할 때 발생하는 이벤트
    public void onOpen(Session s) {
        System.out.println("open session : " + s.toString());
        if(!clients.contains(s)) {
            clients.add(s);
            System.out.println("session open : " + s);
        }else {
            System.out.println("이미 연결된 session 임!!!");
        }
    }

    @OnClose // 클라이언트가 브라우저를 끄거나 다른 경로로 이동할 때
    public void onClose(Session s) {
        System.out.println("session close : " + s);
        clients.remove(s);


    }
}
