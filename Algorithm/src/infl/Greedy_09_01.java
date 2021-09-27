package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 그리디 09-01 씨름 선수
 */

class Body implements Comparable<Body> {
	public int h, w;
	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	public int compareTo(Body o) {
		return o.h - this.h; //내림차순
	};
}

public class Greedy_09_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Body> arr = new ArrayList<Body>();
		for(int i=0; i<n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			arr.add(new Body(h, w));
		}
		
		int answer = 0;
		Collections.sort(arr); //키 내림차순
		int max = Integer.MIN_VALUE;
		//시간복잡도: O(n)
		for(Body ob : arr) {
			if(ob.w > max) { // 몸무게 커질수록 카운트
				max = ob.w;
				answer++;
			}
		}
		
		
		System.out.println(answer);
	}

}
