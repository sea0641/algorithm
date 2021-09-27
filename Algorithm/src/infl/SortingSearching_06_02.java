package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/10
 * 문제: 인프런 SortingSearching 06-02 버블 정렬
 */

public class SortingSearching_06_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//Arrays.sort(arr);
		for(int i=0; i<n-1; i++) {
			//큰 숫자를 뒤로 보낸다 한 for문이 끝나면 가장 큰 숫자가 맨 뒤로 간다.
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
