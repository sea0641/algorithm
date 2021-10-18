package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueue_05_08_2nd {
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
		
		int answer = 0;
		
		Queue<Person> qu = new LinkedList<>();
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
		
		/*
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				if ( p1.priority != p2.priority ) 
					return p2.priority - p1.priority;
				else return p1.id - p2.id;
			}
		});
		for(int i=0; i<n; i++) {
			pq.offer(new Person(i, sc.nextInt()));
		}

		while(!pq.isEmpty()) {
			answer++;
			if ( pq.poll().id == m ) break;
		}
		*/
	}

}
