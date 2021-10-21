package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/10/21
 * 문제: 인프런 SortingSearching 06-01 선택 정렬
 */

public class SortingSearching_06_01_2nd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		/*
		 * 1. 첫번째 숫자를 기준으로 그 뒤의 숫자들 중 제일 작은 숫자를 찾는다.
		 * 2. 첫번째 숫자와 제일 작은 숫자를 교환한다.
		 * 3. 두번째 숫자부터 1~2 구간을 반복한다.
		 * 4. 제일 작은 숫자들이 앞순서부터 세워진다.
		 */
		int idx; //바꿀 제일 작은 숫자
		for(int i=0; i<n-1; i++) {
			idx = i;
			
			//제일 작은 숫자 위치 탐색
			for(int j=i+1; j<n; j++) {
				if(arr[idx] > arr[j]) idx = j;
			}
			
			//SWAP
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		for(int i : arr) System.out.print(i + " ");
	}
}
