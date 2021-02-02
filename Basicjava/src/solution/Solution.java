package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution {


	/* public int[] solution(int[] numbers) {//두개 뽑아서 더하기
		 	ArrayList<Integer> list = new ArrayList<>();
	        int[] answer = {};
	        int count = 0;
	        for(int i = 0; i < numbers.length-1; i++){
	    		for(int j = i+1; j < numbers.length; j++){
	    			int sum = numbers[i] + numbers[j];
	    			if(list.indexOf(sum)<0){
	    				list.add(sum);
	    			}
	    		}
	    	}

	        answer = new int[list.size()];

	        for(int i = 0; i < list.size(); i++){
	        	answer[i] = list.get(i);
	        }
	        Arrays.sort(answer);
	        return answer;
	    }*/

	/*public int[] solution(int []arr) {//같은숫자는 싫어
	        ArrayList list = new ArrayList<>();
	        int[] answer = {};
	        list.add(arr[0]);
	        for(int i =1; i<arr.length; i++){
	            	if(arr[i-1] != arr[i]){
	                list.add(arr[i]);
	            }
	        }
	        answer = new int[list.size()];

	        for(int i = 0; i < list.size(); i++){
	            answer[i] = (int) list.get(i);
	        }

	        return answer;
	    }*/

	/*public String solution(int a, int b) {// 2016년 요일 맞추기
        String answer = "";
        int temp=0;

        for(int i = 1; i<a;i++){
        	if(i==2){
            	temp+=29;
            }else if(i==4||i==6||i==9||i==11){
            	temp+=30;
            }else{
            	temp+=31;
            }	
        }
        temp+=b;


        switch (temp%7) {
        case 0:
        	answer="THU";
			break;
		case 1:
			answer="FRI";
			break;
		case 2:
			answer="SAT";
			break;
		case 3:
			answer="SUN";
			break;
		case 4:
			answer="MON";
			break;
		case 5:
			answer="TUE";
			break;
		case 6:
			answer="WED";
			break;

		}

        return answer;
    }*/
//	public String solution(String[] participant, String[] completion) {// 완주
//		String answer = "";
//		Arrays.sort(participant);
//		Arrays.sort(completion);
//		for(int i=0; i < completion.length; i++){
//			if(!participant[i].equals(completion[i])){
//				answer = participant[i];
//				break;
//			}else if(i==completion.length-1){
//				answer = participant[completion.length];
//				break;
//			}
//		}
//		return answer;
//	}
	/*public int[] solution(int[] array, int[][] commands) {//k번째수
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i < commands.length; i++){
        	int[] temp = {0,0,0}; 
        	for(int j = 0; j < commands[i].length; j++){
        		list = new ArrayList<>();
        		temp[j] = commands[i][j];
        		for(int k = temp[0]-1; k <= temp[1]-1; k++ ){
        			list.add(array[k]);
        		}
        		
        	}
        	Collections.sort(list);
        	answerList.add(list.get(commands[i][2]-1));
        }
        
        answer = new int[commands.length];
        for(int i =0; i< commands.length; i++){
        	System.out.println(answerList.get(i));
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	*/
	
	
	 /*public int solution(int n, int[] lost, int[] reserve) {//체육복
	        int answer = 0;
	        answer = n-lost.length;
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        for(int i = 0; i < lost.length; i++){
	        	for(int j = 0; j < reserve.length; j++){
	        		if(lost[i]==reserve[j]){
	        			lost[i] = -1;
	        			reserve[j] = -1;
	        			answer++;
	        		}
	        	}
	        }
	        for(int i = 0; i < lost.length; i++){
	        	for(int j = 0; j < reserve.length; j++){
	        		if(lost[i]-reserve[j]==1||reserve[j]-lost[i]==1){
	        			lost[i] = -1;
	        			reserve[j] = -1;
	        			answer++;
	        		}
	        	}
	        }
	        return answer;
	    }*/
	
	/*public long solution(int a, int b) {//두 정수 사이의 합
        long answer = 0;
        if(a==b){
            answer=a;
        }else{
          if(a>b){
              answer=((a+b)*(a-b+1))/2;
          }else if(b>a){
              answer=((a+b)*(b-a+1))/2;
          }  
        } 
        return answer;
    }*/
	/*public int[] solution(int[] answers) {//모의고사 수포자
        int[] answer = {};
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] temp = {0,0,0};
        for(int i=0; i< answers.length; i++){//채점
        	if(answers[i] == student1[i%student1.length]){
        		temp[0]++;
        	}
        	if(answers[i] == student2[i%student2.length]){
        		temp[1]++;
        	}
        	if(answers[i] == student3[i%student3.length]){
        		temp[2]++;
        	}
        }
        //가장 많이 맞춘사람
        if(temp[0] == temp[1] && temp[1] == temp[2]) {
        	answer = new int[3];
        	answer[0] = 1;
        	answer[1] = 2;
        	answer[2] = 3;
        }else if (temp[0] > temp[1] && temp[0] > temp[2]) {
        	answer = new int[1];
        	answer[0] = 1;
        }else if (temp[1] > temp[0] && temp[1] > temp[2]) {
        	answer = new int[1];
        	answer[0] = 2;
        }else if (temp[2] > temp[1] && temp[2] > temp[0]) {
        	answer = new int[1];
        	answer[0] = 3;
        }else if (temp[0] == temp[1] && temp[0] != temp[2]) {
        	answer = new int[2];
        	answer[0] = 1;
        	answer[1] = 2;
        }else if(temp[0] == temp[2] && temp[0] != temp[1]){
        	answer = new int[2];
        	answer[0] = 1;
        	answer[1] = 3;
        }else if(temp[1] == temp[2] && temp[0] != temp[2]){
        	answer = new int[2];
        	answer[0] = 2;
        	answer[1] = 3;
        }else if(temp[1] == temp[2] && temp[0] != temp[1]){
        	answer = new int[2];
        	answer[0] = 2;
        	answer[1] = 3;
        }

        	return answer;
	}*/
	/*public String solution(String s) {String의 중간 문자
        String answer = "";
        if(s.length()%2==1){
        	return Character.toString(s.charAt(s.length()/2));
        }else{
        	return s.substring(s.length()/2-1, s.length()/2+1);
        }
    }*/
	
	
	/*public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
        	if(arr[i] % divisor == 0){
        		list.add(arr[i]);
        	}
        }
        if(list.size()==0){
        	answer = new int[1];
        	answer[0] = -1;
        }else{
        	answer = new int[list.size()];
        	for(int i = 0; i < list.size(); i++){
        		answer[i] = list.get(i);
        	}
        }
        Arrays.sort(answer);
        return answer;
    }*/
	
	/*boolean solution(String s) {
        boolean answer = true;
        int a = 0;
        int b = 0;
        for(int i = 0; i < s.length(); i++){
        	if(Character.toString(s.charAt(i)).equals("p")||Character.toString(s.charAt(i)).equals("P")){
        		a++;
        	}else if(Character.toString(s.charAt(i)).equals("y")||Character.toString(s.charAt(i)).equals("Y")){
        		b++;
        	}
        }
        if(a!=b){
        	answer = false;
        }
        return answer;
    }*/
	/*public String solution(String s) {
		String[] array = s.split("");
        Arrays.sort(array,  Collections.reverseOrder());

        return String.join("", array);//join은 자바8에서 가능
    }*/
	
	public boolean solution(String s) {
        boolean answer = true;
        for(int i = 0; i < s.length(); i++){
        	char a = s.charAt(i);
        	if(a!=0 &&a!=1 &&a!=2 &&a!=3 &&a!=4 &&a!=5 &&a!=6 &&a!=7 &&a!=8 &&a!=9){
        		answer = false;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "Zbcdefg";
		String s = "1234";
		boolean answer = solution.solution(s);
		System.out.println(answer);
		/*int[] answers = {1,2,3,4,5};*/
		/*String s = "abcde";*/
//		int[] arr = {5, 9, 7, 10};
//		int divisor = 5;
//		String s ="pPoooyY";
//		boolean answer = solution.solution(s);
		/*int a=3;
		int b=5;
		long answer = s.solution(a, b);*/
//		for(int i = 0; i < answer.length; i++){
//			System.out.println(answer[i]);
//		}
		/*int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,2,5};
		int answer = s.solution(n, lost, reserve);*/
		
		/*int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = s.solution(array, commands);
		for(int i = 0; i < answer.length; i++){
			System.out.println(answer[i]);
		}*/
		/*int a = 5;
		int b =24;
		int[] numbers = {1,1,3,3,0,1,1};*/
		/*String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String answer = s.solution(participant, completion);*/
		
		/*String answer = s.solution(a, b);
		System.out.println(answer);*/
		
		/*int [] answer = s.solution(numbers);
		for(int i = 0; i < answer.length; i++){
			System.out.println(answer[i]);
		}*/

	}

	


}
