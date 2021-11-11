package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/08
 * 문제: 인프런 그리디 09-01 씨름 선수
 */
class Body implements Comparable<Body> {
	public int h, w;
	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	public int compareTo(Body o) {
		return o.h - this.h; //키 내림차순
	};
}

/*
 * 키 내림차순하여, for문을 돌때 키가 작으면 해당 키까지의 최대 몸무게보다 많이 나가야 선발이 된다.
 * 몸무게 최대값 갱신될 때마다 count
 */
public class Greedy_09_01_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //인원 수
		
		List<Body> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			list.add(new Body(h, w));
		}
		Collections.sort(list);
		
		int answer = 0;
		int maxWg = Integer.MIN_VALUE;
		for(Body b : list) {
			if(maxWg < b.w) {
				answer++;
				maxWg = b.w;
			}
		}
		
		System.out.println(answer);
	}

}
