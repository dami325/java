package date_time_formatting;

import java.time.*;
import java.time.temporal.*;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

public class java1102_TemporalAdjusters {
	
	public static void main(String[] args) {
		
		//자주 쓰일만한 날짜 계산들을 대신 해주는 메서드를 정의해놓은 클래스 TemporalAdjusters
		
		LocalDate today = LocalDate.now();
//		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		// 다음주 월요일의 날짜 계산
//		System.out.println(nextMonday); // 2022-11-07
		
		LocalDate date = today.with(new DayAfterTomorrow());
//		System.out.println(date); // 2022- 11- 04
		p(date);								//2022-11-04
		p(today);								//2022-11-02
		p(today.with(firstDayOfNextMonth()));	//2022-12-01
		p(today.with(firstDayOfMonth()));		//2022-11-01
		p(today.with(lastDayOfMonth()));		//2022-11-30
		p(today.with(firstInMonth(TUESDAY)));   //이 달의 첫번째 화요일
	}
	static void p(Object obj) { // 라인의 길이를 줄이기 위한 메서드
		System.out.println(obj);
	}
}

// TemporalAdjuster 직접 구현하기
// TemporalAdjuster인터페이스는 다음과 같이 추상 메서드 하나만 정의되어 있으며, 이 메서드만 구현하면됨
class DayAfterTomorrow implements TemporalAdjuster{
	@Override
	public Temporal adjustInto(Temporal temporal) {
		return temporal.plus(2, ChronoUnit.DAYS); // 2일을 더한다.
	}
}

