package socket_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Ex {

	public static void main(String[] args) {
		/*
		 * [ java.net.URL 클래스 ]
		 * - URL(Uniform Resource Locator) 이란?
		 *   => 웹(www) 상의 자원들의 위치를 가리키는 포인터(= 주소)이자, 해당 리소스 접근 방법
		 * - URL 형식
		 *   ex) http://www.itwillbs.co.kr:8080/index.jsp
		 *       1) http : 프로토콜(Protocol)
		 *       2) www.itwillbs.co.kr : 호스트명(주소 = 도메인)
		 *       3) 8080 : 서비스 포트 번호
		 *       4) index.jsp : 자원(경로(Path) 및 파일(File))  
		 *       
		 * [ URL vs URI ]
		 * http://localhost:8080/MVC_Board/BoardList.bo 는 URL(또는 URI) 이다!
		 * http://localhost:8080/MVC_Board/BoardList.bo?pageNum=1 는 URI 이다!
		 * => URL 은 자원의 위치를 나타내는 것(= Locator)
		 * => URI 는 자원의 위치와 함께 식별자를 나타내는 것(= Identifier) = 파라미터
		 */
		
		// URL 을 다루기 위한 클래스 : java.net.URL
		URL url = null;
		
		try {
			// URL 객체를 생성하여 접근하고자 하는 리소스의 URL 을 생성자에 전달
			url = new URL("https://itwillbs.co.kr/css/wvtex/img/wvUser/busan/logo.png");
			
			// 생성된 URL 객체로부터 메타데이터를 얻어오기
			// => 기본적인 메타데이터는 실제 대상에 연결하지 않고 얻어올 수 있음
			//    (즉, 대상 URL 이 실제 존재하지 않아도 무관함)
			System.out.println("프로토콜(url.getProtocol()) : " + url.getProtocol());
			System.out.println("호스트명(url.getHost()) : " + url.getHost());
			System.out.println("포트번호(url.getDefaultPort()) : " + url.getDefaultPort());
			System.out.println("파일명(url.getFile()) : " + url.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("URL 형식에 맞지 않음!");
		} 
		
		
		// ----------------------------------------------------------------------------------------
		// 지정된 URL 을 사용하여 연결을 수행하고, 연결 정보를 관리하는 
		// java.net.URLConnection 객체 사용하기
		try {
			// URL 객체의 openConnection() 메서드를 호출하여 대상 URL 연결 준비
			URLConnection con = url.openConnection();
			// URLConnection 객체의 connect() 메서드를 호출하여 대상 URL 에 접속(연결) 수행
			con.connect();
			// => 연결 성공 시 대상 URL 의 연결 정보를 URLConnection 객체로 관리함
			System.out.println("문서 타입 : " + con.getContentType());
			System.out.println("문서 크기 : " + con.getContentLength() + " Byte");
			System.out.println("문서 최종 수정일자 : " + new Date(con.getLastModified()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("===================================================================");
		
		// 아이티윌 부산교육센터 홈페이지(index.jsp 페이지) 소스코드 읽어오기
		try {
			url = new URL("http://www.itwillbs.co.kr/index.jsp");
			
			System.out.println("프로토콜(url.getProtocol()) : " + url.getProtocol());
			System.out.println("호스트명(url.getHost()) : " + url.getHost());
			System.out.println("포트번호(url.getDefaultPort()) : " + url.getDefaultPort());
			System.out.println("파일명(url.getFile()) : " + url.getFile());
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------");
		
//		BufferedReader buffer = null;
//		
//		try {
//			// URL 객체의 openStream() 메서드를 호출하여 입력스트림으로 대상 URL 연결
//			// => 대상 URL 에 접근하여 입력되는 정보를 읽어와서 InputStream 객체로 관리
////			InputStream is = url.openStream();
//			
//			// InputStream 객체를 char 단위로 관리하기 위해 InputStreamReader 객체로 변환
////			InputStreamReader reader = new InputStreamReader(is);
//			
//			// InputStreamReader 객체를 String 단위로 관리하기 위해 BufferedReader 객체로 변환
////			buffer = new BufferedReader(reader);
//			
//			// 위의 세 문장을 한 문장으로 결합
//			buffer = new BufferedReader(new InputStreamReader(url.openStream()));
//			
//			
//			// 버퍼로부터 입력되는 입력스트림을 한 문장 읽어서 변수에 저장
//			String str = buffer.readLine();
//			
//			// 읽어온 한 문장이 null 이 아닐 동안 반복해서 읽어오기
//			// => 읽어온 문장 출력 후 새로운 다음 문장 읽어오기
//			while(str != null) {
//				System.out.println(str);
//				str = buffer.readLine();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 사용 종료 후 자원 반환(최종 객체인 BufferedReader 만 반환하면 됨)
//			try {
//				buffer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// ===========================================================================
		// 위의 작업과 동일한 작업을 try ~ resources 구문으로 변경
		// => 스트림 객체(close 해야하는 대상) 생성 관련 코드들을 try 블록의 괄호() 안으로 집어 넣으면
		//    객체 사용이 완료되거나 예외 발생 시 자동으로 해당 객체들을 close() 해준다!
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()))) {
			// 버퍼로부터 입력되는 입력스트림을 한 문장 읽어서 변수에 저장
			String str = buffer.readLine();
			
			// 읽어온 한 문장이 null 이 아닐 동안 반복해서 읽어오기
			// => 읽어온 문장 출력 후 새로운 다음 문장 읽어오기
			while(str != null) {
				System.out.println(str);
				str = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// => close() 메서드를 직접 호출하지 않아도 된다!
		
		
	}

}










