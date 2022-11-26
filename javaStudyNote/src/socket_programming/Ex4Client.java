package socket_programming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex4Client {

	public static void main(String[] args) {
		// 클라이언트측에서 사용할 java.net 패키지의 Socket 클래스 타입 변수 선언
		Socket socket = null;
		
		// 접속할 서버의 주소와 서비스 포트번호를 갖는 Socket 객체 생성
		String host = "localhost"; // 서버의 IP 주소 또는 도메인(localhost 지정 시 현재 PC 지정)
		int port = 59876; // 서버의 포트번호
		
		try {
			socket = new Socket(host, port);
			System.out.println("서버 접속(소켓 생성) 완료!");
			
			// 서버로부터 전송되는 데이터(객체)를 입력스트림을 통해 전달받기
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Object o = ois.readObject();
			
			// 전달받은 Object 객체(실제로는 Person 객체)에 접근하여 데이터 출력하기
			// => Object -> Person 다운캐스팅 필요
			// => 다운캐스팅 전 캐스팅 가능 여부 판별하기 위해 instanceof 연산자 활용
			if(o instanceof Ex4Person) { // o 는 Ex4Person 입니까? 를 판별하는 코드
				// true 일 경우 무조건 형변환이 가능한 관계(업캐스팅 or 다운캐스팅)
				Ex4Person p = (Ex4Person) o;
				System.out.println("이름 : " + p.getName());
				System.out.println("나이 : " + p.getAge());
				System.out.println("주민번호 : " + p.getJumin());
			}
			
			// ObjectInputStream 자원 반환
			ois.close();
		} catch (UnknownHostException e) {
			// 호스트명(IP 주소)이 틀렸을 경우 발생할 수 있는 예외
			e.printStackTrace();
		} catch (ConnectException e) {
			e.printStackTrace();
			System.out.println("서버와의 연결이 실패했습니다!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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















