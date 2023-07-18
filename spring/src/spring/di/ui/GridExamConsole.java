package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {

private Exam exam;		
	
	public GridExamConsole(Exam exam) {		
		this.exam = exam;
	}
	@Override
	public void print() {
		System.out.println("忙式式式式式式式式式式成式式式式式式式式式式忖");
		System.out.println("弛   total  弛    avg   弛");
		System.out.println("戍式式式式式式式式式式托式式式式式式式式式式扣");
		 System.out.printf("弛   %3d  弛    %3.2f   弛\n", exam.total(), exam.avg());
		System.out.println("戌式式式式式式式式式式扛式式式式式式式式式式戎");
	}

}
