package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/08/11
 * ����: ������ SortingSearching 06-06 �峭�ٷ���
 */

public class SortingSearching_06_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] sortArr = arr.clone();
		Arrays.sort(sortArr);
		int a = 0;
		int b = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] != sortArr[i]) {
				if(a == 0) a = i+1;
				else b = i+1;
			}
			
			if(a != 0 && b != 0) break;
		}
		
		System.out.println(a + " " + b);
	}

}
