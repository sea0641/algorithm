package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/10
 * 문제: 인프런 그리디 09-06 친구인가(Disjoint-Set: Union&Find)
 */

public class Greedy_09_06_2nd {
	static int[] unf; //union&find 소속 집합 배열
	
	//v가 어디 속한 집한인지 + 경로 압축
	public static int Find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	
	//합친다.. a와 b 연결
	public static void Union(int a, int b) {
		int fa = Find(a); //a가 속한 집합
		int fb = Find(b); //b가 속한 집합
		if(fa != fb) unf[fa] = fb;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n+1];
		
		//집합 자기자신으로 초기화
		for(int i=1; i<=n; i++) unf[i] = i;
		
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Union(a, b);
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		
		if(fa == fb) System.out.println("YES");
		else System.out.println("NO");
	}

}
