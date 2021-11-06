package infl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/11/04
 * ����: ������ DFSBFS���� 07-13 ���Ž��(��������Ʈ, ArrayList)
 */

public class DfsBfsB_07_13_2nd {

	static int n;
	static List<ArrayList<Integer>> graph;
	static boolean[] visited; //���� �湮���� üũ
	static int answer = 0;
	
	public static void DFS(int v) {
		//��������
		if( v == n ) {
			answer++;
			return;
		}
		
		//�� �� �ִ� ���� ��� �湮
		for(int nv : graph.get(v)) {
			//������ �ְ� �湮���� �ʾ��� ��
			if( nv == 1 && !visited[nv] ) {
				visited[nv] = true;
				DFS(nv);
				
				//��Ʈ��ŷ, ���� ��Ž�� ���� �湮���� Ǯ�� ����
				visited[nv] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //����
		int m = sc.nextInt(); //������ ��
		visited = new boolean[n+1];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		//ù ��� �湮 üũ
		visited[1] = true;
		DFS(1);
		
		System.out.println(answer);
	}

}
