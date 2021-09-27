package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/08/10
 * 문제: 인프런 SortingSearching 06-01 선택 정렬
 */

public class SortingSearching_06_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//Arrays.sort(arr);
		int idx;
		for(int i=0; i<n-1; i++) {
			//한 포문을 돌면 가장 작은 숫자의 인덱스의 값과 교환한다. 가장 작은 숫자가 맨 앞에 온다.
			idx = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[idx]) idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
