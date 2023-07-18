package singletonTest;

public class SingletonTest extends Thread {
	public void run() {
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1);
	}
	
	public static void main(String[] args) {
//		Singleton s1 = Singleton.getInstance();
//		Singleton s2 = Singleton.getInstance();
//		Singleton s3 = Singleton.getInstance();
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		
		new SingletonTest().start();
		new SingletonTest().start();
		new SingletonTest().start();
		new SingletonTest().start();
//		
	}
	
	
}
