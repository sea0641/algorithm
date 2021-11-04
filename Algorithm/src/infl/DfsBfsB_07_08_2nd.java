package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��¥: 2021/11/03
 * ����: ������ DFSBFS���� 07-08 �۾��� ã�� 1(BFS: ����Ʈ��Ž��)
 */

/*
 * ������ �ּ� Ƚ��(�ִܰŸ�) -> BFS
 * 1, -1, 5 �б�
 */
public class DfsBfsB_07_08_2nd {

	static int e;
	
	static void BFS(int dis) {
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean[] visited = new boolean[10001];
		visited[dis] = true;
		qu.offer(dis);
		
		int level = 0;
		while(!qu.isEmpty()) {
			int len = qu.size();
			//qu�� ���� ������ŭ ������ �������.
			for(int i=0; i<len; i++) {
				int x = qu.poll();
				
				if( x == e ) {
					System.out.println(level);
					return;
				}
				
				if(x < e) {
					if(!visited[x+1]) {
						qu.offer(x+1);
						visited[x+1] = true;
					}
					if(!visited[x+5]) {
						qu.offer(x+5);
						visited[x+5] = true;
					}
				} else {
					if(!visited[x-1]) {
						qu.offer(x-1);
						visited[x-1] = true;
					}
				}
			}
			
			level++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //������ ��ġ
		e = sc.nextInt(); //�۾����� ��ġ
		
		BFS(s);
	}

}
