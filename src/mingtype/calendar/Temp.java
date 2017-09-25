package mingtype.calendar;

import java.util.Scanner;

public class Temp {
	public static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] leapMaxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final String PROMPT = "> ";
	public static int maxDaysOfMonth(int year, int month){		
		if(isLeapYear(year)){
			return leapMaxDays[month - 1];
		}else{
			return maxDays[month - 1];
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("년도와 월을 입력하세요 : ex) 2017 2");
			System.out.print(PROMPT);
			String date = scanner.nextLine();
			System.out.println("첫째 날의 요일을 입력하세요(su, mo, tu, we, th, fr, sa)");
			String str_weekday = scanner.nextLine();
			
			int year = Integer.parseInt(date.split(" ")[0]);
			int month = Integer.parseInt(date.split(" ")[1]);
			int weekday = parseDay(str_weekday);
			
			if(month == -1){
				System.out.println("Bye~~");
				break;
			}
			
			printCalendar(year, month, weekday);
		}
		scanner.close();
	}

	/**
	 * 달력 출력
	 * @param year
	 * @param month
	 * @param weekday
	 */
	public static void printCalendar(int year, int month, int weekday) {
		
		int lastDay = maxDaysOfMonth(year, month);
		System.out.printf("***** %4d년 %2d월 *****\n", year, month);
		System.out.println("SU MO TU WE TH FR SA");
		
		// print black space
		for(int i=0; i<weekday; i++){
			System.out.print("   ");
		}
		
		for(int i=1; i<=lastDay; i++){
			System.out.printf("%2d ", i);
			// line change
			if((i + weekday) % 7 == 0)
				System.out.println();
		}
		System.out.println("\n---------------------------");
	}
	
	/**
	 * 윤년 계산 메서드
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year){
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
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = sunday ~ 6 = saturday)
	 */
	public static int parseDay(String week){
		if(week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else return 0;
	}
}
