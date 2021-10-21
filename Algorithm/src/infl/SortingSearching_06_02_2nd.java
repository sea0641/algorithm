package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/10/21
 * 문제: 인프런 SortingSearching 06-02 버블 정렬
 */

public class SortingSearching_06_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		/*
		 * 1. 첫번째 숫자와 그다움숫자를 비교해 앞의 수가 더 크면 SWAP한다.
		 * 2. 연속한 위치의 두 숫자를 비교해 한 싸이클을 돈다.
		 * 3. 두번째 싸이클도 동일하게 진행하나 이미 가장 큰 숫자가 뒤로 밀려나있으므로 그전까지만 수행한다.
		 * 4. 연속된 두 수를 비교하며 큰 수가 밀려나는 구조이다.
		 */
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				//앞의 숫자가 더 크다면 SWAP
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(int i : arr) System.out.print(i + " ");
	}

}
