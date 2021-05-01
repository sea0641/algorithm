package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/05/01
 * 문제: 백준 알고리즘 2141번_우체국
 * 설명: 그리디.. 문제 이해 어려움...인구수 더해가며 중간값:(총인원수+1)/2 와 근접한 마을 찾기
 */

public class greedy_2141 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = stoi(br.readLine());
		int[][] arrX = new int[n][2];
		long totPeople = 0; //총인원수
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			 arrX[i][0] = stoi(st.nextToken());
			 arrX[i][1] = stoi(st.nextToken());
			 totPeople += arrX[i][1];
		}
		
		Arrays.sort(arrX, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		long tmpTotPeople = 0;
		for(int i=0; i<n; i++) {
			tmpTotPeople += arrX[i][1];
			if( tmpTotPeople >= (totPeople+1)/2 ) {
				System.out.println(arrX[i][0]);
				break;
			}
		}

	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
