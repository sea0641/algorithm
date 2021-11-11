package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 날짜: 2021/11/10
 * 문제: 인프런 그리디 09-04 최대 수입 스케쥴(PriorityQueue 응용문제)
 */

/*
 * 돈이 비싼 강의가 우선순위..
 * 1. 강의를 일차 내림차순으로 정렬한 다음
 * 2. 우선순위 큐에 해당 일자에 가능한 강의들중 비싼 강의우선순위로 뽑는다.
 */

class Lecture implements Comparable<Lecture>{
	int money;
	int time;
	
	Lecture(int money, int time) {
		this.money = money;
		this.time = time;
	}
	
	@Override
	public int compareTo(Lecture o) {
		return o.time - this.time; //일자 내림차순
	}
}

public class Greedy_09_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //강의 수
		List<Lecture> list = new ArrayList<Lecture>();
		int maxDay = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			int m = sc.nextInt();
			int t = sc.nextInt();
			
			list.add(new Lecture(m, t));
			
			maxDay = Math.max(maxDay, t);
		}
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int answer = 0;
		int j = 0;
		for(int i=maxDay; i>0; i--) {
			for( ; j<N; j++) {
				//i일차에 가능한 강의들만 큐에 넣는다.
				if(list.get(j).time < i) break;
				pq.offer(list.get(j).money);
			}
			
			if(!pq.isEmpty()) answer += pq.poll();
		}
		
		System.out.println(answer);
	}

}
