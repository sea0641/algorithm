package infl;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 날짜: 2021/09/17
 * 문제: 인프런 그리디 09-08 원더랜드(최소스패닝트리: 프림, PriorityQueue)
 */

public class Greedy_09_08 {
	static class Edge implements Comparable<Edge> {
		public int vex, cost;
		
		Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		int[] ch = new int[n+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c)); //무방향이기 때문에 반대로도 갈 수있다..
		}
		
		int answer = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int ev = tmp.vex;
			//트리에 포함되지 않았다면 포함
			if(ch[ev] == 0) {
				ch[ev] = 1;
				answer += tmp.cost;
				//해당 정점과 연결된 다른 정점 큐에 추가
				for(Edge ob : graph.get(ev)) {
					if(ch[ob.vex] == 0) pq.offer(new Edge(ob.vex, ob.cost));
				}
			}
		}
		
		System.out.println(answer);
	}

}
