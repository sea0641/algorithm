package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/13
 * ����: ���� �˰��� 2606��_���̷���
 * ����: DFS�� ���, BFS�� Queue ���
 */

public class bfsdfs_2606 {
	static int com; //��ǻ���� ��
	static int n; // ��Ʈ��ũ(��ǻ�� ��) ��
	static List<Integer>[] list; //�� ��ǻ�ͺ� ����Ǿ��ִ� �迭����Ʈ
	static boolean[] visit; //�湮���
	static int v; //���̷��� ��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		com = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());;
		
		list = new ArrayList[com+1];
		for(int i=1; i<=com; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visit = new boolean[com+1];
		
		int a;
		int b;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		//dfs(1);
		bfs(1);
		System.out.println(v);
	}
	
	static void dfs(int s) {
		visit[s] = true;
		
		for(int i : list[s]) {
			if(!visit[i]) {
				v++;
				dfs(i);
			}
		}
	}
	
	static void bfs(int s) {
		Queue<Integer> qu = new LinkedList<>();
		
		qu.add(s);
		visit[s] = true;
		
		while(!qu.isEmpty()) {
			int q = qu.poll();
			for(int i : list[q]) {
				if(!visit[i]) {
					v++;
					visit[i] = true;
					qu.add(i);
				}	
			}
		}
	}

}
