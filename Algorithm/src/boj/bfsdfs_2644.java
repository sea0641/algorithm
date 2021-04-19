package boj;

/*
 * ��¥: 2021/04/14
 * ����: ���� �˰��� 2644��_�̼����
 * ����: DFS�� ���, BFS�� Queue ���
 * 		��Ʈ��ŷ, ����Լ� ���� ����.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bfsdfs_2644 {
	static int n; //��ü ����� ��
	static int m; //�θ� �ڽĵ鰣�� ������ ����
	static List<Integer>[] list;
	static boolean[] visit;
	static int c = 0; //�̼�
	static int p1;
	static int p2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visit = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		int c1;
		int c2;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			
			list[c1].add(c2);
			list[c2].add(c1);
		}
		
		dfs(p1);
		
		System.out.println(-1);
		
	}
	
	static void dfs(int now) {
		visit[now] = true; //�湮ó��
		
		c++; //�̼� ����
		
		for(int next : list[now]) {
			if(!visit[next]) {
				//�湮�� ���� ���� ��ǥ�� �ٴٸ��� ���ߴٸ� dfs���ȣ���Ѵ�
				if(next != p2) {
					dfs(next);
				}
				//�湮�� ���� ���� ��ǥ�� �̸����ٸ� ����Լ� ��� ����
				else if(next == p2) {
					System.out.println(c);
					System.exit(0);
				}
			}
		}
		
		c--; //��Ʈ��ŷ
	}
}
