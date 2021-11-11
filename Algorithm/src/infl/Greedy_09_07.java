package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 날짜: 2021/09/17
 * 문제: 인프런 그리디 09-07 원더랜드(최소스패닝트리: 크루스칼, Disjoint-Set: Union&Find 활용)
 */

public class Greedy_09_07 {
	static int[] unf; //union&find 소속 집합 배열
	
	static class Edge implements Comparable<Edge> {
		public int v1, v2, cost;
		
		Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}
	
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
		ArrayList<Edge> arr = new ArrayList<>();
		
		//집합 자기자신으로 초기화
		for(int i=1; i<=n; i++) unf[i] = i;
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr.add(new Edge(a, b, c));
		}
		
		int answer = 0;
		//비용 오름차순 정렬
		Collections.sort(arr);
		
		for(Edge ob : arr) {
			int fv1 = Find(ob.v1);
			int fv2 = Find(ob.v2);
			//같은 집합이 아닐때만. 같은 집합이라면 이미 트리의 원소라 연결하면 회로가 되버림
			if(fv1 != fv2) {
				answer += ob.cost;
				Union(ob.v1, ob.v2); //한 집합으로 만들기
			}
		}
		
		System.out.println(answer);
	}

}
