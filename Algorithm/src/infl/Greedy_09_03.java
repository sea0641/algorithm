package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/09/01
 * 문제: 인프런 그리디 09-03 결혼식
 */

class Time implements Comparable<Time>{
	public int time;
	public char state; //들어올때:s, 나갈떄:e
	
	Time(int time, char state) {
		this.time = time;
		this.state = state;
	}
	
	@Override
	public int compareTo(Time o) {
		if(this.time == o.time) return this.state - o.state;
		else return this.time - o.time;
	}
}

public class Greedy_09_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Time> list = new ArrayList<Time>();
		for(int i=0; i<n; i++) {
			int sT = sc.nextInt();
			int eT = sc.nextInt();
			list.add(new Time(sT, 's'));
			list.add(new Time(eT, 'e'));
		}
		
		Collections.sort(list);
		int answer = Integer.MIN_VALUE;
		int cnt = 0;
		for(Time t : list) {
			if(t.state == 's') cnt++; //들어올때마다 1증가
			else cnt--; //나갈때마다 1감소
			
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}

}
