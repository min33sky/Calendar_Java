package mingtype.calendar;

public class Calendar {
	public static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**
	 * 해당 월의 마지막 날을 구한다.
	 * @param year		년도
	 * @param month		월
	 * @return lastDay	월의 마지막 날
	 */
	public int getMaxDaysOfMonth(int year, int month){		
		if(isLeapYear(year))
			return LEAP_MAX_DAYS[month - 1];
		else
			return MAX_DAYS[month - 1];
	}

	/**
	 * 달력 출력
	 * @param year	    년도
	 * @param month   월	
	 * @param weekday 요일
	 */
	public void printCalendar(int year, int month) {
		
		int lastDay = getMaxDaysOfMonth(year, month);
		System.out.printf("***** %d년 %d월 *****\n", year, month);
		System.out.println("SU MO TU WE TH FR SA");
		
		// 시작 요일 계산
		int dayOfWeek = getDayOfWeek(year, month);
				
		// 공백 출력
		for(int i=0; i<dayOfWeek; i++){
			System.out.print("   ");
		}
		
		// 날짜 출력
		for(int i=1; i<=lastDay; i++){
			System.out.printf("%2d ", i);
			// line change
			if((i + dayOfWeek) % 7 == 0)
				System.out.println();
		}
		System.out.println("\n---------------------------");
	}
	
	/**
	 * 윤년 계산 메서드
	 * @param year	년도
	 * @return true: 윤년, false: 평년
	 */
	public boolean isLeapYear(int year){
		/*
		 * 윤년 계산
		 * 1. 4로 나누어 떨어지면 윤년
		 * 2. 100으로 나누어 떨어지면 평년
		 * 3. 100으로 나누어 떨어지고 400으로도 나우어 떨어지면 윤년
		 */
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	/**
	 * 해당 월의 시작 요일을 구한다.
	 * @param year 년도
	 * @param month	달
	 * @return int 요일(0:Sunday ~ 6:Saturday)
	 */
	public int getDayOfWeek(int year, int month){
		int sYear = 1970;				// 기준 년도
										// 일요일 : 0 ~ 토요일 : 6
		final int STANDARD_DAY = 4; 	// 1970.1.1 = Thursday
		int count = 0;					// 기준일로부터 원하는 날짜까지의 일 수
		
		// 기준일(1970.1.1)로 부터 날짜를 계산 : 구하려는 년도 전까지만 계산
		for(int i=sYear; i<year; i++){
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		// 해당년도 1월 1일부터 구하려는 월전까지 계산
		for(int i=1; i<month; i++){
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
	
		// 해당 요일 계산
		int dayOfWeek = (count + STANDARD_DAY) % 7;
		
		return dayOfWeek;
	}
	
}
