package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/06
 * 문제: 인프런 TwoPointers 03-01 두 배열 합치기
 */

public class TwoPointers_03_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		
		int[] answer = new int[n+m];
		int p1 = 0;
		int p2 = 0;
		for(int i=0; i<n+m; i++) {
			if(p1 == n) {
				answer[i] = arr2[p2++];
			} else if(p2 == m) {
				answer[i] = arr1[p1++];
			} else if(arr1[p1] < arr2[p2] && p1 < n) {
				answer[i] = arr1[p1++];
			} else if(arr1[p1] >= arr2[p2] && p2 < m){
				answer[i] = arr2[p2++];
			}
		}
		
		/*
		 * while 사용
		 * List<Integer> list = new ArrayList<Integer>();
		 * while(p1<n && p2<m) {
		 * 	if(arr1[p1] < arr2[p2]) list.add(arr1[p1++]);
		 * 	else list.add(arr2[p2++]);
		 * }
		 * while(p1<n) list.add(arr1[p1++]);
		 * while(p2<m) list.add(arr2[p2++]);
		 */

		for(int i : answer) {
			System.out.print(i + " ");
		}
	}

}
