package date_time_formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class java1102_parsing {

	public static void main(String[] args) {
		// 파싱과 포맷 , 날짜와 시간의 형식화와 관련된 클래스들 중 DateTimeFormatter가 핵심
		
		LocalDate date = LocalDate.of(2022, 11, 2);
		String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
		System.out.println(yyyymmdd); // 2022-11-02
		System.out.println(date);	  // 2022-11-02
		
		//DateTimeFormatter의 ofPattern()으로 원하는 출력형식을 직접 작성할 수도 있다.
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 자주 사용될 만한 패턴
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",
				"''yy년 MMM dd일 E요일",
				"yyyy-MM-dd HH:mm:ss.SSS Z VV",
				"yyyy-MM-dd hh:mm:ss a",
				"오늘은 올 해의 D번째 날입니다.",
				"오늘은 이 달의 d번째 날입니다.",
				"오늘은 올 해의 w번째 주입니다.",
				"오늘은 이 달의 W번째 E요일입니다."
		};
		
		for(String p : patternArr) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));
		}
		
		
		//자주 사용되는 기본적인 형식의 문자열은 ISO_LOCAL_DATE와 같은 형식화 상수를 사용하지 않고 파싱 가능
		LocalDate newDate = LocalDate.parse("2001-01-01");
		LocalTime newTime = LocalTime.parse("23:59:59");
		LocalDateTime newDateTime = LocalDateTime.parse("2001-01-01T23:59:59");
		
		System.out.println(newDateTime);
		
		
		
		
	}

}
