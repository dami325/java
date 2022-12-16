package networking;

import java.io.IOException;
import java.net.Socket;

public class TcpIpClient3 {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 7777);

            System.out.println("서버에 연결되었습니다.");
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
