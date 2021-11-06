package infl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��¥: 2021/11/04
 * ����: ������ DFSBFS���� 07-14 �׷��� �ִܰŸ�(BFS)
 */

public class DfsBfsB_07_14_2nd {
	
	static List<ArrayList<Integer>> graph;
	static int[] dis; //1�� ��忡�� �� ��庰 �ִܰŸ� ��
	static boolean[] visited;
	
	public static void BFS(int v) {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(v);
		visited[v] = true;
		
		while(!qu.isEmpty()) {
			int tmp = qu.poll();
			
			//���� qu���� �� �� �ִ� ���� ����
			for(int nv : graph.get(tmp)) {
				//�ѹ� �ԷµǸ� �湮�Ǹ� �н�
				if(!visited[nv]) {
					visited[nv] = true;
					qu.offer(nv);
					
					dis[nv] = dis[v] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //������ ����
		int m = sc.nextInt(); //������ ����
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		dis = new int[n+1];
		visited = new boolean[n+1];
		
		BFS(1);
		
		for(int i=2; i<=n; i++) {
			System.out.println(i + " : " + dis[i]);
		} 
	}

}
