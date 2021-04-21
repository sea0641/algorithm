package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 날짜: 2021/04/21
 * 문제: 백준 알고리즘 13305번_주유소
 * 설명: 그리디
 */

public class greedy_13305 {
	static int n; //도시개수
	static int[] len; //도시간 거리 배열
	static int[] price; //도시당 리터별 주유가격
	static long minCost = 0; //최소비용
	static long sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		len = new int[n-1];
		price = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		minCost = price[0];
		for(int i=0; i<n-1; i++) {
			if(price[i] < minCost)
				minCost = price[i];
			
			sum = sum + minCost*len[i];
		}
		
		System.out.println(sum);
	}

}
