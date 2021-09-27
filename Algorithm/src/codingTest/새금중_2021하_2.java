package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 새금중_2021하_2 {
	static class Score implements Comparable<Score>{
		int math, eng;
		Score(int math, int eng) {
			this.math = math;
			this.eng = eng;
		}
		
		@Override
		public int compareTo(Score s) {
			return s.math - this.math;
		}
	}
	public static void main(String[] args) {
		int[] math = {80, 90, 70, 65, 50};
		int[] eng = {60, 30, 40, 20, 50};
		List<Score> list = new ArrayList();
		for(int i=0; i<math.length; i++) {
			list.add(new Score(math[i], eng[i]));
		}
		
		Collections.sort(list);
		
		int myEng = Integer.MIN_VALUE;
		int answer = 0;
		for(int i=0; i<list.size()-1; i++) {
			myEng = list.get(i).eng;
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(j).eng > myEng) answer++;
			}
			
		}
		
		System.out.println(answer);
	}

}
