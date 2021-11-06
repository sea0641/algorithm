package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/03
 * 문제: 인프런 DFSBFS기초 07-06 부분집합 구하기(DFS)
 */

/*
 * 자연수 N의 부분집합을 전부 출력하시오.(공집합 제외)
 * 1) 1부터 사용한다 안한다 일때 두갈래로 DFS 뻗어나가기
 * 2) 종료조건: n을 넘어가면 종료, 사용하는 것들만 원소 출력하기
 */

public class DfsBfsB_07_06_2nd {
	static int n;
	static boolean[] arrUse;
			
	public static void DFS(int L) {
		if( L == n+1 ) {
			StringBuffer sb = new StringBuffer();
			for(int i=1; i<=n; i++) {
				if(arrUse[i]) sb.append(i).append(" ");
			}
			//공집합 출력 X -> 모든 원소 사용하지 않는다.
			if(sb.length() > 0) System.out.println(sb.toString());
		} else {
			//사용한다
			arrUse[L] = true;
			DFS(L+1);
			//사용하지 않는다.
			arrUse[L] = false;
			DFS(L+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arrUse = new boolean[n+1];
		
		DFS(1);
	}

}
