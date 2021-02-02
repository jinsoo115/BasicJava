package d_array;

public class Scores2 {

	public static void main(String[] args) {
		String[] students ={"정지수", "이현기", "윤지혜", "정이삭", "박세현", "오세일", "장병길", "배수진", "김지훈", "임태준",
				"최희수", "전형섭", "김혜정", "송수미", "진예은", "양지수", "김도윤", "김보현", "원정훈", "문선준",
				"진유리", "김동익", "이진수", "박초원", "김보미"};
		String[] subject = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] scores = new int[students.length][subject.length];
		int[] studentSum = new int[students.length];
		double[] studentAvg = new double[students.length];
		for(int i = 0; i < scores.length;i++){
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
			}
			for(int k = 0; k < scores[i].length; k++){
				studentSum[i] += scores[i][k];
			}
			studentAvg[i] = Math.round((double)studentSum[i] / subject.length * 100) / 100.0; 
		}

		int[] rank = new int[scores.length];
		for(int i = 0; i < scores.length; i++){
			rank[i] = 1;
			for(int j = 0; j<scores.length; j++){
				if(studentSum[i]<studentSum[j]){
					rank[i]++;
				}
			}
		}
		int[] subSum = new int[subject.length];
		double[] subAvg = new double[subject.length];
		for(int i = 0; i < subject.length;i++){
			for(int j = 0; j < students.length; j++){
				subSum[i] += scores[j][i];
			}
			subAvg[i] = Math.round((double)studentSum[i] / subject.length * 100) / 100.0; 
		}

		//정렬
		int max=0;
		for(int i = 0; i<students.length; i++){
			max=i;
			for(int j = i+1; j<students.length; j++){
				if(rank[max]> rank[j]){
					max = j;
				}
				int[] temp = scores[i];
				scores[i] = scores[max];
				scores[max] = temp;

				String temp2 = students[i];
				students[i] = students[max];
				students[max] = temp2;

				int temp3 = studentSum[i];
				studentSum[i] = studentSum[max];
				studentSum[max] = temp3;

				double temp4 = studentAvg[i];
				studentAvg[i] = studentAvg[max];
				studentAvg[max] = temp4;

				int temp5 = rank[i];
				rank[i] = rank[max];
				rank[max] = temp5;
			}
		}
		//출력
		for(int i = 0; i<subject.length; i++){
			System.out.print("\t"+subject[i]);
		}
		System.out.println("\t합계"+"\t평균"+"\t석차");
		for(int i = 0; i<students.length; i++){
			System.out.print(students[i]);
			for(int j = 0; j<subject.length; j++){
				System.out.print("\t"+scores[i][j]);
			}
			System.out.println("\t"+studentSum[i] + "\t"+studentAvg[i] + "\t"+rank[i]);
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
