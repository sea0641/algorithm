package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-03 가위 바위 보
 */

public class Array_02_03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrA[i] = stoi(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrB[i] = stoi(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			if((arrA[i] == 1 && arrB[i] == 3) || arrA[i] == 3 && arrB[i] == 1) {
				System.out.println(arrA[i] < arrB[i] ? "A" : "B");
				continue;
			}
			System.out.println(arrA[i] > arrB[i] ? "A" : arrA[i] < arrB[i] ? "B" : "D");
		}
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
