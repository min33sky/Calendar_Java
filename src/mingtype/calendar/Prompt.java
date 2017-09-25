package mingtype.calendar;

import java.util.HashMap;
import java.util.Scanner;

public class Prompt {
	final static Calendar calendar = new Calendar();
	final static Scanner scanner = new Scanner(System.in);
	final static HashMap<String, String> schedule = new HashMap<>();

	public static void main(String[] args) {
		
		while(true){
			
			printMenu();
			String cmd = scanner.nextLine();

			if(cmd.equals("1")){			// 일정 등록
				cmdRegister();
			}else if(cmd.equals("2")){		// 일정 검색
				cmdSearch();
			}else if(cmd.equals("3")){		// 달력 보기
				printCalendar();
			}else if(cmd.equals("h")){		// 도움말
				printMenu();
			}else if(cmd.equals("q")){		// 종료
				break;
			}else{
				System.out.println("해당 메뉴가 없습니다.");
			}
		}
		System.out.println("Bye~!");
	} // main
	
	/**
	 * menu 
	 */
	public static void printMenu(){
		System.out.println("*-----------------------*");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 ");
		System.out.println("| q. 종료 ");
		System.out.println("*-----------------------*");
		System.out.println("명령 (1, 2, 3, h, q)");
		System.out.print("> ");
	}
	
	/**
	 * 일정 검색
	 */
	public static void cmdSearch(){
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.print("> ");
		String date = scanner.nextLine();
		if(schedule.containsKey(date)){
			System.out.println("1개의 일정이 있습니다.");
			System.out.println(schedule.get(date));
		}else{
			System.out.println("해당 날짜에 스케쥴이 없습니다.");
		}
	}
	
	/**
	 * 일정 등록
	 */
	public static void cmdRegister(){
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.print("> ");
		String date = scanner.nextLine();
		System.out.println("일정을 입력하세요.");
		System.out.print("> ");
		String toDo = scanner.nextLine();
		schedule.put(date, toDo);
		
		System.out.println("일정이 등록되었습니다.");
	}
	
	/**
	 * 달력 출력
	 */
	public static void printCalendar(){
		System.out.println("년도와 월을 입력하세요 : ex) 2017 2  (종료 : -1)");
		String date = scanner.nextLine();
		
		int year = Integer.parseInt(date.split(" ")[0]);
		int month = Integer.parseInt(date.split(" ")[1]);
		
		new Calendar().printCalendar(year, month);
	}
	
	
	
	
}
