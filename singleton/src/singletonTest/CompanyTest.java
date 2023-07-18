package singletonTest;

public class CompanyTest {
	
	public static void main(String[] args) {
		Company cp1 = Company.getInstance();
		Company cp2 = Company.getInstance();
		System.out.println(cp1);
		System.out.println(cp2);
	}
}
