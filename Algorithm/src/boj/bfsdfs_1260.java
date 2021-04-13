package boj;

/*
 * 날짜: 2021/04/11
 * 문제: 백준 알고리즘 1260번_DFS와 BFS
 * 설명: DFS는 재귀, BFS는 Queue 사용
 * 		+ https://developer-mac.tistory.com/63
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bfsdfs_1260 {
	static int iN; //정점개수
	static int iM; //간선개수
	static int iV; //시작번호
	static ArrayList<Integer>[] list; //각 정점별로 간선이 연결되어있는 정점번호를 담을 배열리스트
	static boolean[] check; //정점 방문여부
	
	public static void main(String[] args) throws IOException {
//		System.out.println("정점개수, 간선개수, 시작번호");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			iN = Integer.parseInt(st.nextToken());
			iM = Integer.parseInt(st.nextToken());
			iV = Integer.parseInt(st.nextToken());
		}
			
		list = new ArrayList[iN+1];
		for ( int i=0; i<iN+1; i++ ) {
			list[i] = new ArrayList<Integer>();
		}
		
		//간선이 연결되어있는 정점을 입력받으면서 배열리스트에 추가한다.
		for ( int i=0; i<iM; i++ ) {
			st = new StringTokenizer(br.readLine());
			int iA = Integer.parseInt(st.nextToken());
			int iB = Integer.parseInt(st.nextToken());
			
			list[iA].add(iB);
			list[iB].add(iA);
		}
		
		//작은 번호부터 방문하기 위한 정렬
		for ( int i=1; i<iN+1; i++ ) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[iN+1];
		dfs(iV);
		System.out.println();
		
		check = new boolean[iN + 1];
        bfs(iV);
        System.out.println();
		
		br.close();
		}
		
	private static void dfs(int x) {
        if (check[x]) {
            return;
        }

        check[x] = true;
        System.out.print(x + " ");
        
        for (int y : list[x]) {
        	if(!check[y])
        		dfs(y);
        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int y : list[x]) {
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
