package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/11/11
 * 문제: 인프런 동적계획법 10-03 최대부분증가수열(LIS)
 */

public class Dynamic_10_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		//각 index별까지 올 수 있는 가장 긴 수열 수
		int[] dy = new int[N];
		dy[0] = 1;
		
		for(int i=1; i<N; i++) {
			//이룰 수열이 없으면 0 초기화
			int max = 0;
			
			//앞의 수열 중 다음에 올 수 있는 가장 긴 수열 수 찾기
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dy[j]);
				}
			}
			
			//앞의 이룬 수열 + 1
			dy[i] = max + 1;
		}

		System.out.println(Arrays.stream(dy).max().getAsInt());
	}

}
