package infl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 날짜: 2021/08/11
 * 문제: 인프런 SortingSearching 06-07 좌표 정렬
 */

public class SortingSearching_06_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1] );
		}
	}

}
