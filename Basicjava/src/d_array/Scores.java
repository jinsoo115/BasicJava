package d_array;

import java.util.Arrays;

public class Scores {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 			국어		영어		수학		사회		과학		Oracle		Java		합계		평균		석차
		 * 홍길동		90		90		90		90		90		90			90			630		90		1		
		 * 홍길동		90		90		90		90		90		90			90			630		90		1		
		 * 홍길동 		90	    90		90		90		90		90			90			630		90		1		
		 * 홍길동 		90		90		90		90		90		90			90			630		90		1		
		 * 과목합계	458		458		458		458		458		458			458
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00		90.00				 	
		 */
		String[] students ={"정지수", "이현기", "윤지혜", "정이삭", "박세현", "오세일", "장병길", "배수진", "김지훈", "임태준",
				"최희수", "전형섭", "김혜정", "송수미", "진예은", "양지수", "김도윤", "김보현", "원정훈", "문선준",
				"진유리", "김동익", "이진수", "박초원", "김보미"};
		String[] subject = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java", " 합계", "석차"};
		int scores[][] = new int[students.length][subject.length];
		double[] avg = new double[students.length];
		int[] totalSum = new int[subject.length-2];
		double[] totalAvg = new double[subject.length-2];

		for(int i = 0; i < scores.length; i++){ //랜덤 점수 넣기
			for(int j = 0; j < scores[i].length; j++){
				scores[i][j] = (int)(Math.random() * 101);
				scores[i][subject.length-2] += scores[i][j];  // 합계구하기
				if(subject[j].equals("Java")){
					break;
				}
			}
			avg[i] = Math.round((double)scores[i][subject.length-2] / totalSum.length * 100) / 100.0; //평균구하기 소숫점 2번째 자리까지
		}	

		for(int i = 0; i< scores.length; i++){ //석차구하기전에 1로 초기화
			scores[i][subject.length-1] = 1;
		}
		for(int i = 0; i < scores.length; i++){ //석차구하기
			for(int j = 0; j < scores.length; j++){
				if(scores[i][subject.length-2] < scores[j][subject.length-2]){
					scores[i][subject.length-1]++;
				}
			}

		}

		for(int i = 0; i < totalSum.length; i++){ //과목합계 및 과목평균 구하기
			for(int j = 0; j < scores.length; j++){
				totalSum[i] += scores[j][i];
			}
			totalAvg[i] = Math.round((double)totalSum[i] / scores.length * 10) / 10.0;  //과목평균 소숫점 1자리까지 나오기(소숫점 2자리에서 반올림)
		}

		//정렬
		for(int i = 0; i< scores.length; i++){
			int max = i;
			for(int j = i+1; j < scores.length; j++){
				if(scores[max][subject.length-1] > scores[j][subject.length-1]){
					max = j;
				}
			}
			int[] temp = scores[i];
			scores[i] = scores[max];
			scores[max] = temp;

			String temp2 = students[i];
			students[i] = students[max];
			students[max] = temp2;

			double temp3 = avg[i];
			avg[i] = avg[max];
			avg[max]=temp3;	
		}

		//출력
		for(int i = 0; i < subject.length; i++){ // 과목출력
			if(i == subject.length-1){
				System.out.print("\t평균" + "\t" + subject[i]);	
			}else {
				System.out.print("\t" + subject[i]);
			}
		}

		System.out.print("\n"); //점수 및 합계 석차 출력
		for(int i = 0; i < scores.length; i++){
			System.out.print(students[i] + "\t");//이름출력
			for(int j = 0; j < scores[i].length; j++){
				if(j == scores[i].length-1){
					System.out.print(avg[i] + "\t" + scores[i][j]);
				}else{
					System.out.print(scores[i][j] + "\t");
				}				
			}
			System.out.print("\n");
		}

		System.out.print("과목합계\t"); //과목합계 출력
		for(int i = 0; i < totalSum.length; i++){
			System.out.print(totalSum[i] + "\t");
		}
		System.out.print("\n과목평균\t"); //과목평균 출력
		for(int i = 0; i < totalSum.length; i++){
			System.out.print(totalAvg[i] + "\t");
		}
	}
}