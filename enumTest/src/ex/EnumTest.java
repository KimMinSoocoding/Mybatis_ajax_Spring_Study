package ex;

enum Day{
	SUN, MON, TUE, WED, THU, FRI, SAT;
}

public class EnumTest {
	public static void main(String[] args) {
		Day day = Day.THU;
		
		// ordinal()열거형 상수의 순서를 리턴(0부터 시작)
		System.out.println(day.ordinal());
		switch(day) {
		case SUN:
			System.out.println("일요일"); break;
		case MON:
			System.out.println("월요일"); break;
		case TUE:
			System.out.println("화요일"); break;
		case WED:
			System.out.println("수요일"); break;
		case THU:
			System.out.println("목요일"); break;
		case FRI:
			System.out.println("금요일"); break;
		case SAT:
			System.out.println("토요일"); break;
		}
	}
}
