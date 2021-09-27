package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/17
 * 문제: 인프런 동적계획법 10-03 최대부분증가수열(LIS)
 */

public class Dynamic_10_03 {
	static int[] dy;
	
	public static int solution(int[] arr) {
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;
		for(int i=1; i<arr.length; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
			}
			dy[i] = max+1;
			answer = Math.max(answer, dy[i]);
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		System.out.println(solution(arr));
	}

}
