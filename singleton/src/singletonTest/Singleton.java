package singletonTest;

public class Singleton {
	// static은 공유를 해야하기 때문에 붙여준다. 
	private static Singleton singleton;
	
	// 생성자 접근 제어자는 private : 외부 클래스에서는 생성자 호출 불
	private Singleton() {
		System.out.println("생성자 호출");
	}
	
	// 	외부에서 객체를 사용할 수 있게 public 접근제어자로 getInstance()만들어 준다 
//	public static Singleton getInstance() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
	
	//동기화 --> 임계영역 생 : 하나의 스레드가 자원을 사용할 때 다른 스레드의 접근을 차
	public static synchronized Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
}
