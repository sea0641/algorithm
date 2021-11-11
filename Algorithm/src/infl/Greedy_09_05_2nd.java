package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 날짜: 2021/11/10
 * 문제: 인프런 그리디 09-05 다익스트라 알고리즘
 */
class Edge implements Comparable<Edge>{
	public int vex;
	public int cost;
	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost; //비용 오름차순
	}
}

public class Greedy_09_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		int[] dis = new int[n+1];  //1번 정점부터 각 정점까지 최단거리 배열
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		//그래프 인접리스트 행렬 만들기
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); //출발 정점
			int b = sc.nextInt(); //도착 정점
			int c = sc.nextInt(); //거리 비용
			graph.get(a).add(new Edge(b, c));
		}
		
		//최단거리 구하기
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); //Edge 정렬기준인 비용 오름차순
		//시작점
		pq.offer(new Edge(1, 0));
		dis[1] = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll(); //비용 낮은 순으로 뽑힌다.
			int now = tmp.vex;
			int nowCost = tmp.cost;
			
			//현재 비용이 이미 최소비용보다 크다면 해당 정점과 연결된 정점들은 더 볼필요없다.
			if(nowCost > dis[now]) continue;
			
			//해당 정점과 연결된 정점 돌면서 최소비용 정점,거리 찾기
			for(Edge ne : graph.get(now)) {
				if(dis[ne.vex] > nowCost + ne.cost) {
					dis[ne.vex] = nowCost + ne.cost; //낮은 최소비용 갱신
					pq.offer(new Edge(ne.vex, nowCost + ne.cost));
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
			else System.out.println(i + " : impossible");
		}
	}

}
