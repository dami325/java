package socket_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * [ URLEncoder, URLDecoder 클래스 ]
		 * - java.net 패키지
		 * - 문자열을 MIME 형식으로 변환(또는 그 반대)하기 위한 클래스
		 * - 주로, 한글로 표시되는 쿼리 문자열 등이 웹 서버에 전송될 떄의 형태로
		 *   특정 규칙에 따라 변환되어짐
		 *   1) 아스키 코드(영문 대문자, 소문자, 숫자, 몇 개의 특수문자 등)는 그대로 표기
		 *   2) 공백은 + 기호로 변환
		 *   3) 기타 문자(한글, 한자 등)은 %XX 형태의(XX 는 16진수 2자리) 문자로 변환됨
		 * 
		 * ex) 네이버 검색창에 "ITWILL 부산교육센터" 검색 시
		 *     https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=
		 *     ITWILL+%EB%B6%80%EC%82%B0%EA%B5%90%EC%9C%A1%EC%84%BC%ED%84%B0
		 *     => ITWILL 과 공백(+) 뒤의 한글 부분이 다른 형태의 문자로 표시됨(인코딩 된 문자열)
		 */
		
		try {
			String originalStr = "[Java Programming : 아이티윌]";
			System.out.println("원본 문자열 : " + originalStr);
			
			// URLEncoder 클래스의 static 메서드인 encode() 메서드를 호출하여
			// 원본 문자열을 MIME 형식으로 변환(= 인코딩)
			String encodeStr = URLEncoder.encode(originalStr, "UTF-8"); // 문자열을 UTF-8 형식으로 인코딩
			System.out.println("MIME 형식으로 인코딩 후 : " + encodeStr);
			// %5BJava+Programming+%3A+%EC%95%84%EC%9D%B4%ED%8B%B0%EC%9C%8C%5D
			
			// URLDecoder 클래스의 static 메서드인 decode() 메서드를 호출하여
			// MIME 형식 문자열을 원본 문자열로 변환(= 디코딩)
			String decodeStr = URLDecoder.decode(encodeStr, "UTF-8");
			System.out.println("원본 문자열로 디코딩 후 : " + decodeStr);
			// [Java Programming : 아이티윌]
		} catch (UnsupportedEncodingException e) {
			// 지정된 인코딩 타입("UTF-8" 등)이 지원되지 않는 타입일 경우 발생하는 예외
			e.printStackTrace();
		}
		
	}

}















