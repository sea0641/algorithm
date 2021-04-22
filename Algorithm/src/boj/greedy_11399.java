package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/04/22
 * 문제: 백준 알고리즘 11399번_ATM
 * 설명: 그리디
 */

public class greedy_11399 {
	static int n; //사람의 수
	static int[] pTime; //각 사람이 돈을 인출하는데 걸리는 시간 배열
	static long totTime = 0; //총 소요시간
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		pTime = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i=0; i<n; i++ ) {
			pTime[i] = Integer.parseInt(st.nextToken());
		}
		
		//시간이 적게걸리는게 앞에 와야한다.
		Arrays.sort(pTime);
		
		for(int i=n; i>0; i--) {
			totTime = totTime + pTime[n-i] * i;
		}
		
		System.out.println(totTime);
		
	}

}
