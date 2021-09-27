package infl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/09/26
 * 문제: 인프런 Array 02-12 멘토링
 */

public class TwoPointers_03_01_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //첫번째 배열의 크기
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++) arr1[i] = sc.nextInt();
		int m = sc.nextInt(); //두번째 배열의 크기
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++) arr2[i] = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		int p1=0, p2=0;
		while(p1<n && p2<m) {
			if(arr1[p1] <= arr2[p2]) list.add(arr1[p1++]);
			else list.add(arr2[p2++]);
		}
		while(p1 < n) list.add(arr1[p1++]);
		while(p2 < m) list.add(arr2[p2++]);
		
		for(int i : list) System.out.print(i + " ");

	}

}
