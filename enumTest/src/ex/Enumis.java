package ex;

public class Enumis {
	// enum(enumeration) 
	// - 서로 연관있는 상수들을 모아 놓은 객체 
	
	// enum의 정의방법 
	// enum enum명 (상수명1, 상수명2.....}
	
	// enum 용도 
	// 상수 정의시 알기 쉽게 상수를 선언하고자 할 때 사용(상수가 너무 많으면 가독성이 떨어진다)
	// 특정값의 범위를 지정시 많이 사용 
	
	// 상수선언
	public static final int AA = 100; 
	public static final int BB = 200; 
	
	// 요일 상수선언 
	public static final int SUNDAY = 0;
	
	// 인터페이스를 이용한 상수선언 
	interface Day{
		int MONDAY =1;
		int TUESDAY =2;
	}
	
	interface DeviceState{
		String ON = "켜짐";
		String OFF = "꺼짐";
		String PAUSE ="일시정지";
	}
	
	// 위와 같은 상수 선언은 인터페이스의 고유 목적에 벗어난 방법이기에 새로운 문법이 필요하게 됨 ==> enum
}
