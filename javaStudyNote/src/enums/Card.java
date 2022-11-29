package enums;

public class Card {

	static final int CLOVER = 0;
	static final int HEART = 1;
	static final int DIAMOND = 2;
	static final int SPADE = 3;
	
	static final int TWO = 0;
	static final int THREE = 1;
	static final int FOUR = 2;
	
//	final int kind;
//	final int num;

	enum Kind  { CLOVER, HEART, DIAMOND, SPADE} // 열거형 kind를 정의
	enum Value { TWO, THREE, FOUR } 		   // 열거형 Value를 정의
	
	final Kind kind = null;
	final Value value = null;
	
	public static void main(String[] args) {
		/*
		 * 	열거형이란?
		 * 	서로 관련된 상수를 편리하게 선언하기 위한 것, 여러 상수를 정의할때 사용하면 유용
		 * 	JDK1.5부터 추가 C언어의 열거형보다 더 향상된것 -> 자바의 열거형은 타입도 관리 -> 논리적 오류 줄임
		 * 	자바의 열거형은 '타입에 안전한 열거형(typesafe enum)' 이라서 실제 값이 같아도 타입이 다르면 컴파일 에러 발생
		 *  => 타입에 안전하다는 이유
		 *  
		 * */
		
		
		
	}

}
