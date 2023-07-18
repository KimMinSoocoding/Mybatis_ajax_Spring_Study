package ex;

import java.util.Scanner;

// Enum 클래스를 상속받아서 생성된다.
public class EnumDeviceTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// values() : Enum의 모든 상수값을 선언된 순서대로 배열로 반환
		EnumDeviceState[] esArr = EnumDeviceState.values();
		for(EnumDeviceState es : esArr) {
			// name(), ordinal() ... Enum 클래스의 메소드
			System.out.println(es.name() + "," +es.ordinal() + "," + es.getState() + "," + es.valueOf(es.name()));
		}
		
		while(true) {
			System.out.println("시스템의 상태 입력 => ");
			String strNext = scan.next();
			
			if(strNext.equals(EnumDeviceState.ON.getState())) {
				System.out.println("시스템시작!");
			}else if(strNext.equals(EnumDeviceState.OFF.getState())) {
				System.out.println("시스템종료!");
			}else if(strNext.equals(EnumDeviceState.PAUSE.getState())) {
				System.out.println("시스템 일시정지!");
			}else if(strNext.equals(EnumDeviceState.STOP.getState())) {
				System.out.println("시스템 정지!");
			}else if(strNext.equals(EnumDeviceState.PLAY.getState())) {
				System.out.println("시스템가동중!");
			}
		}
	}
}
