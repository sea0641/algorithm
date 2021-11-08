package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/07
 * 문제: 인프런 DFSBFS 08-09 조합 구하기
 */

/*
 * 조합은 순서를 상관하지 않는다. 그렇기 때문에 맨 앞에서 부터 탐색할 필요 X
 * 동일한 숫자를 탐색하지 않기때문에 visited 배열도 필요 X
 */
public class DfsBfs_08_09_2nd {
	static int N, M;
	static int[] combi;
	
	static void DFS(int L, int s) {
		if ( L == M ) {
			for(int c : combi) System.out.print(c + " ");
			System.out.println();
		} else {
			for(int i=s; i<=N; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
				//DFS(L+1, i); 중복조합
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //전체 구슬 개수
		M = sc.nextInt(); //뽑는 개수
		combi = new int[M];
		
		DFS(0, 1);
	}

}
