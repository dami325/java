package date_time_formatting;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class java1102_Period_Duration {

	public static void main(String[] args) {
		// Period는 날짜의 차이 Duration은 시간의 차이를 계산하기 위한것
		// 날짜 - 날짜 Period
		// 시간 - 시간 Duration
		// between() 두 날짜의 차이를 얻을수 있음
		
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);
		System.out.println(pe); // P1Y11M30D
		// date1이 date2보다 이전이면 양수, 이후면 음수로 저장됨
		// Duration도 동일한 방식으로 가능
		
		// 특정 필드의 값을 얻을땐 get() 메서드 사용
		long year = pe.get(ChronoUnit.YEARS);
		System.out.println(year); // 1
		
		//LocalDate의 toEpochDay() 라는 메서드는 Epoch Day인 '1970-01-01'부터 날짜를 세어서 반환함
		//Period를 사용하지 않고도 두 날짜간의 일수를 편리하게 계산 가능 단, 두 날짜 모두 Epoch Day 이후의 것이어야함
		LocalDate date3 = LocalDate.of(2022, 10, 30);
		LocalDate date4 = LocalDate.of(2022, 11, 30);
		
		long period = date3.toEpochDay() - date4.toEpochDay();
		System.out.println(period);  // -31
		
		//LocalTime에도 int toSecondOfDay() , long toNanoOfDay() 가 있어 뺄셈으로 시간차이 계산 가능 
		
		
	}

}
