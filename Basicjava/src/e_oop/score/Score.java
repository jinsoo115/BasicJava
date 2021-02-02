package e_oop.score;

import e_oop.ScanUtil;

public class Score {

	public static void main(String[] args) {
		//성적관리 프로그램을 완성해주세요.
		Student[] students = new Student[10];

		for(int i = 0; i < students.length; i++){
			Student student = new Student();

			student.name= "학생" + (i + 1);
			student.rank= 1;
			student.kor = (int)(Math.random() * 101);
			student.eng = (int)(Math.random() * 101);
			student.math = (int)(Math.random() * 101);


			students[i] = student;
		}
		for(int i = 0; i <students.length; i++){
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round((double)students[i].sum / 3.0 * 100) / 100.0;
		}

		for(int i = 0; i<students.length; i++){
			for(int j = 0; j < students.length; j++){
				if(students[i].sum < students[j].sum)
					students[i].rank++;
			}
		}

		//정렬
		int max=0;
		for(int i = 0; i<students.length; i++){
			max=i;
			for(int j = 0; j<students.length; j++){
				if(students[max].rank < students[j].rank){
					max = j;
				}
				Student temp = students[i];
				students[i] = students[max];
				students[max] = temp;
			}
		}
		int[] subSum = new int[3];
		double[] subAvg = new double[subSum.length];
		for(int i = 0; i< students.length; i++){
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}
		for(int i = 0; i < subSum.length; i++){
			subAvg[i] = Math.round((double)subSum[i] / students.length *100) / 100.0; 
		}
		System.out.println("\t국어\t영어\t수학\t합계\t평균\t석차");
		for(int i = 0; i<students.length; i++){
			System.out.println(students[i].name +"\t"+students[i].kor +"\t"+students[i].eng +"\t"+students[i].math
					+"\t"+students[i].sum +"\t"+students[i].avg +"\t"+students[i].rank);
		}
		System.out.print("과목합계\t"); //과목합계 출력
		for(int i = 0; i < subSum.length; i++){
			System.out.print(subSum[i] + "\t");
		}
		System.out.print("\n과목평균\t"); //과목평균 출력
		for(int i = 0; i < subAvg.length; i++){
			System.out.print(subAvg[i] + "\t");
		}
	}
}
