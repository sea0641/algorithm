package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * ��¥: 2021/11/10
 * ����: ������ �׸��� 09-05 ���ͽ�Ʈ�� �˰���
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
		return this.cost - o.cost; //��� ��������
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
		
		int[] dis = new int[n+1];  //1�� �������� �� �������� �ִܰŸ� �迭
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		//�׷��� ��������Ʈ ��� �����
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); //��� ����
			int b = sc.nextInt(); //���� ����
			int c = sc.nextInt(); //�Ÿ� ���
			graph.get(a).add(new Edge(b, c));
		}
		
		//�ִܰŸ� ���ϱ�
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); //Edge ���ı����� ��� ��������
		//������
		pq.offer(new Edge(1, 0));
		dis[1] = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll(); //��� ���� ������ ������.
			int now = tmp.vex;
			int nowCost = tmp.cost;
			
			//���� ����� �̹� �ּҺ�뺸�� ũ�ٸ� �ش� ������ ����� �������� �� ���ʿ����.
			if(nowCost > dis[now]) continue;
			
			//�ش� ������ ����� ���� ���鼭 �ּҺ�� ����,�Ÿ� ã��
			for(Edge ne : graph.get(now)) {
				if(dis[ne.vex] > nowCost + ne.cost) {
					dis[ne.vex] = nowCost + ne.cost; //���� �ּҺ�� ����
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
