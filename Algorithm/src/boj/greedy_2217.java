package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 날짜: 2021/04/21
 * 문제: 백준 알고리즘 2217번_로프
 * 설명: 그리디
 */

public class greedy_2217 {
	static int n; //로프의 개수
	static int[] rope; //각 로프가 들 수 있는 무게 배열
	static int w = 0; //최대중량
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		rope = new int[n];
		
		for(int i=0; i<n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		
		int tmpW;
		for(int i=0; i<n; i++) {
			tmpW = rope[i] * (n-i);
			if( w < tmpW )
				w = tmpW;
		}

		System.out.println(w);
		
	}

}
