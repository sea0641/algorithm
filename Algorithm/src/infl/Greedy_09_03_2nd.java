package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/10
 * 문제: 인프런 그리디 09-03 결혼식
 */

/*
 * 들어올 때, 나갈 때 분리하여 들어올때마다 카운트 +1, 나갈때 -1하여 최대 카운트 기록
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
		//시간 오름차순, 시간 같으면 상태 오름차순
		if(this.time == o.time) return this.state - o.state;
		else return this.time - o.time;
	}
}

public class Greedy_09_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //인원 수
		
		List<Time> list = new ArrayList<Time>();
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			list.add(new Time(s,'s'));
			list.add(new Time(e,'e'));
		}
		
		Collections.sort(list);
		
		int cnt = 0; //사람 수 카운팅
		int maxCnt = Integer.MIN_VALUE;
		for(Time t : list) {
			if(t.state == 's') cnt++;
			else cnt--;
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}

}
