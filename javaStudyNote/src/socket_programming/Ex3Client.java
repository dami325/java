package socket_programming;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex3Client {

	public static void main(String[] args) {
		// 클라이언트측에서 사용할 java.net 패키지의 Socket 클래스 타입 변수 선언
		Socket socket = null;
		
		// 접속할 서버의 주소와 서비스 포트번호를 갖는 Socket 객체 생성
		String host = "localhost"; // 서버의 IP 주소 또는 도메인(localhost 지정 시 현재 PC 지정)
		int port = 59876; // 서버의 포트번호
		
		try {
			socket = new Socket(host, port);
			System.out.println("서버 접속(소켓 생성) 완료!");
			
			// 서버로부터 전송되는 데이터(문자열)를 입력스트림을 통해 전달받아 출력
			// => DataOutputStream 으로 전송된 데이터는 반드시 DataInputStream 으로 읽어야하며
			//    writeUTF() 메서드로 출력한 데이터는 반드시 readUTF() 메서드로 읽어야한다!
			// => DataInputStream 도 Socket 객체로부터 가져오기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String str = dis.readUTF();
			System.out.println("서버 : " + str);
			
			// DataInputStream 자원 반환
			dis.close();
		} catch (UnknownHostException e) {
			// 호스트명(IP 주소)이 틀렸을 경우 발생할 수 있는 예외
			e.printStackTrace();
		} catch (ConnectException e) {
			e.printStackTrace();
			System.out.println("서버와의 연결이 실패했습니다!");
		} catch (IOException e) {
			// 포트번호가 잘못됐을 경우 발생할 수 있는 예외
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
		
	}

}















