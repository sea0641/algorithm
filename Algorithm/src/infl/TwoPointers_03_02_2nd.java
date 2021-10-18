package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/09/27
 * 문제: 인프런 TwoPointers 03-02 공통원소 구하기
 */

public class TwoPointers_03_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++) arr1[i] = sc.nextInt();
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<m; i++) arr2[i] = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int p1=0, p2=0;
		while(p1 < n && p2 < m) {
			if(arr1[p1] < arr2[p2]) p1++;
			else if(arr1[p1] > arr2[p2]) p2++;
			else {
				list.add(arr1[p1]);
				p1++;
				p2++;
			}
		}
		
		for(int i : list) System.out.print(i + " ");
	}

}
