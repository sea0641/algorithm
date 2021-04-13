package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/12
 * ����: ���� �˰��� 1012��_����� ����
 * ����: DFS�� ���, BFS�� Queue ���
 * 		+ https://1-7171771.tistory.com/59
 */

public class bfsdfs_1012 {
	static int T; //�׽�Ʈ ���̽��� ����
	static int M; //���߹� ���α���(1~50)
	static int N; //���߹� ���α���(1~50)
	static int K; //���� ��ġ�� ����
	static int[][] cabbage; //���߹�
	static boolean[][] visit;
	static int count; //���� �������� �ʿ� ����
	//��, ��, ��, �� �̵� �迭
	static int[] dx = {0, 1, 0, -1}; 
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cabbage = new int[M][N];
			visit = new boolean[M][N];
			
			//���� ��ġ �迭�� ǥ��
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				
				cabbage[p1][p2] = 1;
			}
			
			count = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(cabbage[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {x, y});
		
		while(!qu.isEmpty()) {
			x = qu.peek()[0];
			y = qu.peek()[1];
			
			visit[x][y] = true;
			qu.poll();
			
			//top, right, bottom, left �� ���� Ž��
			for(int i=0; i<4; i++) {
				int x1 = x + dx[i];
				int y1 = y + dy[i];
				
				if(x1 >= 0 && y1 >= 0 && x1 < M && y1 < N) {
					if(!visit[x1][y1] && cabbage[x1][y1] == 1) {
						qu.add(new int[] {x1, y1});
						visit[x1][y1] = true;
					}
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int x1 = x + dx[i];
			int y1 = y + dy[i];
			
			if(x1 >= 0 && y1 >= 0 && x1 < M & y1 < N) {
				if(!visit[x1][y1] && cabbage[x1][y1] == 1) {
					dfs(x1, y1);
				}
			}
		}
	}

}
