package socket_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex4Server {

	public static void main(String[] args) {
		// 서버측에서 사용할 java.net 패키지의 ServerSocket 과 Socket 클래스 타입 변수 선언
		Socket socket = null;
		
		int port = 59876;
		
		// ServerSocket 객체 생성
		// => 생성자 파라미터로 사용할 포트번호(0 ~ 65535) 전달
		//    (단, 0 ~ 1023번까지는 well-known port 번호이므로, 그 외의 번호 사용(주로 5자리 사용))
		// => 또한, 지정한 포트가 이미 사용중일 경우 IOException 발생할 수 있음
		// => try ~ resources 구문을 활용하여 자원을 자동으로 반환하도록 구현
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("서버 소켓 생성 완료!");
//			System.out.println("getLocalPort() : " + serverSocket.getLocalPort());
//			System.out.println("getInetAddress() : " + serverSocket.getInetAddress());
			
			try {
				// while 문 무한루프
				while(true) {
					// 서버측에서 생성한 ServerSocket 객체의 accept() 메서드를 호출하여
					// 클라이언트로부터의 연결 요청을 대기하도록 지정
					// => 클라이언트로부터 연결 요청을 받아 수락하면 Socket 객체가 리턴됨
					socket = serverSocket.accept();
					System.out.println("클라이언트와 소켓 연결 완료!");
					System.out.println("클라이언트 IP : " + socket.getInetAddress());
					
					// Ex4Person 객체 생성하여 이름, 나이, 주민번호 저장
					Ex4Person p = new Ex4Person("홍길동", 20, "901010-1234567");
					
					// 자바에서 객체를 입출력하려면 ObjectXXXStream 클래스 활용
					// => ObjectXXXStream 객체 생성 시 socket 객체로부터 XXXStream 객체 얻어서 전달
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					// ObjectOutputStream 객체의 writeObject() 메서드를 호출하여 객체 출력
					oos.writeObject(p);
					// => 주의! 객체를 출력스트림으로 내보내기 위해서는 직렬화(Serialization) 필수!
					//    따라서, 해당 클래스 선언부에 java.io.Serializable 인터페이스 implements 필수!
					
					// 사용 완료된 객체 반환
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 생성된 소켓은 사용 완료 후 반환 필수!
				if(socket != null) { // 소켓이 비어있지 않을 경우
					try {
						socket.close(); // 소켓 반환
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
















