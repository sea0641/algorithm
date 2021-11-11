package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * ��¥: 2021/09/01
 * ����: ������ �׸��� 09-05 ���ͽ�Ʈ�� �˰���
 */

//class Edge implements Comparable<Edge>{
//	public int vex;
//	public int cost;
//	Edge(int vex, int cost) {
//		this.vex = vex;
//		this.cost = cost;
//	}
//	
//	@Override
//	public int compareTo(Edge o) {
//		return this.cost - o.cost;
//	}
//}
public class Greedy_09_05 {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	
	public static void solution(int v) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(v, 0));
		dis[v] = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll(); //cost�� ���� ���� �� ����
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost > dis[now]) continue;
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pq.offer(new Edge(ob.vex, nowCost + ob.cost)); //now������ ����� �������� ť�� �ֱ�
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		dis = new int[n+1];
		Arrays.fill(dis,  Integer.MAX_VALUE);
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
		}
		
		solution(1); //1�� �������� ���
		
		for(int i=2; i<=n; i++) {
			if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
			else System.out.println(i + " : impossible");
		}
	}

}
