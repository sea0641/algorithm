package infl;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/08/09
 * 문제: 인프런 StackQueue 05-08 응급실
 */
public class StackQueue_05_08 {
	public static class Person {
		int id; //들어온 순서(0부터 시작)
		int priority; //위험도
		
		public Person(int id, int priority) {
			this.id = id;
			this.priority = priority;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		/*
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			//우선순위 1.위험도 높은 순위 2.먼저 들어온 순서
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1] == o1[1]) { //위험도 같다면 들어온 순서 오름차순
					return o1[0] - o2[0];
				} else { //위험도 내림차순
					return o2[1] - o1[1];
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			pq.offer(new int[] {i, tmp});
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			answer++;
			if(pq.poll()[0] == m) break;
		}
		*/
		
		int answer = 0;
		Queue<Person> qu = new LinkedList<>();
		for(int i=0; i<n; i++) {
			qu.offer(new Person(i, sc.nextInt()));
		}
		
		while(!qu.isEmpty()) {
			Person tmp = qu.poll();
			for(Person p : qu) {
				if(p.priority > tmp.priority) {
					qu.offer(tmp);
					tmp = null;
					break;
				}
			}
			
			if(tmp != null) {
				answer++;;
				if(tmp.id == m) break;
			}
		}
		
		System.out.println(answer);
	}

}
