package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/04/20
 * 문제: 백준 알고리즘 4796번_캠핑
 * 설명: 그리디
 */

public class greedy_4796 {
	static int v; //휴가일수
	static int p; //연속하는 일수
	static int l; //사용 가능 일수
	static int c; //캠핑 사용 일수
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true) {
			c = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			if( l == 0 && p == 0 && v == 0 ) break;
			
			//휴가일수 % 연속하는일수 > 사용가능일수 인 경우 주의!
			c = c + l*(v/p) + (v%p > l ? l : v%p);
			sb.append("Case ").append(cnt++).append(": ").append(c).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
