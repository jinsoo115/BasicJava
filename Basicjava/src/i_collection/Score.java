package i_collection;

import java.util.ArrayList;

import org.omg.CORBA.ARG_IN;

public class Score {

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
		String[] s ={"정지수", "이현기", "윤지혜", "정이삭", "박세현", "오세일", "장병길", "배수진", "김지훈", "임태준",
				"최희수", "전형섭", "김혜정", "송수미", "진예은", "양지수", "김도윤", "김보현", "원정훈", "문선준",
				"진유리", "김동익", "이진수", "박초원", "김보미"};
		String[] sub = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};

		ArrayList<String> studentList = new ArrayList<>();
		ArrayList<String> subjectList = new ArrayList<>();
		for(int i = 0; i < s.length; i++){
			studentList.add(s[i]);
		}
		for(int i = 0; i < sub.length; i++){
			subjectList.add(sub[i]);
		}
		ArrayList<ArrayList<Integer>> scoreList = new ArrayList<>();
		ArrayList<Integer> _scoreList = new ArrayList<>();
		ArrayList<Integer> studentSum = new ArrayList<>();
		ArrayList<Double> studentAvg = new ArrayList<>();
		for(int i = 0; i < studentList.size(); i++){
			_scoreList = new ArrayList<>();
			for(int j = 0; j < subjectList.size(); j++){
				_scoreList.add((int)(Math.random() * 101));
			}
			scoreList.add(_scoreList);
		}

		for(int i = 0; i < scoreList.size(); i++){
			int sum=0;
			for(int j = 0; j < _scoreList.size(); j++){
				sum += scoreList.get(i).get(j);
			}
			studentSum.add(sum);
			studentAvg.add(Math.round((double)studentSum.get(i) / subjectList.size() * 100) / 100.0);
		}
		ArrayList<Integer> studentRank = new ArrayList<>();
		for(int i = 0; i < studentAvg.size(); i++){
			int rank =1;;
			for(int j = 0; j < studentAvg.size(); j++){
				if(studentAvg.get(i)<studentAvg.get(j)){
					rank++;
				}
			}
			studentRank.add(rank);
		}

		ArrayList<Integer> subSum = new ArrayList<>();
		ArrayList<Double> subAvg = new ArrayList<>();
		for(int i = 0; i < _scoreList.size(); i++){
			int sum=0;
			for(int j = 0; j < scoreList.size(); j++){
				sum += scoreList.get(j).get(i);
			}
			subSum.add(sum);
			subAvg.add(Math.round((double)subSum.get(i) / studentList.size() * 100) / 100.0);
		}
		for(int i = 0; i<studentRank.size()-1; i++){
			int max=i;
			for(int j = i+1; j<studentRank.size(); j++){
				if(studentRank.get(max) > studentRank.get(j)){
					max = j;
				}
			}
			String name = studentList.set(i, studentList.get(max));
			studentList.set(max, name);

			ArrayList<Integer> tempList = scoreList.set(i, scoreList.get(max));
			scoreList.set(max, tempList);

			int sum = studentSum.set(i, studentSum.get(max));
			studentSum.set(max, sum);

			double avg = studentAvg.set(i,studentAvg.get(max));
			studentAvg.set(max, avg);

			int rank = 	studentRank.set(i, studentRank.get(max));
			studentRank.set(max, rank);

		}
		for(int i = 0; i < subjectList.size(); i++){
			System.out.print("\t"+subjectList.get(i));
		}
		System.out.println("\t합계"+"\t평균"+"\t석차");

		for(int i = 0; i < studentList.size(); i++){
			System.out.print(studentList.get(i));
			for(int j = 0; j < subjectList.size(); j++){
				System.out.print("\t"+scoreList.get(i).get(j));
			}
			System.out.print("\t"+studentSum.get(i));
			System.out.print("\t"+studentAvg.get(i));
			System.out.println("\t"+studentRank.get(i));
		}
		System.out.print("과목합계"); //과목합계 출력
		for(int i = 0; i < subSum.size(); i++){
			System.out.print("\t"+subSum.get(i));
		}
		System.out.print("\n과목평균"); //과목평균 출력
		for(int i = 0; i < subAvg.size(); i++){
			System.out.print("\t"+subAvg.get(i));
		}
	}

}
