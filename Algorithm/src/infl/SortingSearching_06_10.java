package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/08/16
 * 문제: 인프런 SortingSearching 06-10 마구간 정하기(결정알고리즘)
 */

public class SortingSearching_06_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = 0;
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[n-1];
		while(lt <= rt) {
			int mid = (lt+rt) / 2;
			if(count(arr, mid) >= c) {
				answer = mid;
				lt=mid+1;
			} else rt = mid - 1;
		}
		
		System.out.println(answer);
	}
	
	public static int count(int[] arr, int dist) {
		int cnt = 1;
		int ep = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] - ep >= dist) {
				cnt++;
				ep = arr[i];
			}
		}
		
		return cnt;
	}
}
