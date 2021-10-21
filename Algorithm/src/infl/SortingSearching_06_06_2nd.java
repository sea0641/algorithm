package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/10/21
 * 문제: 인프런 SortingSearching 06-06 장난꾸러기
 */

public class SortingSearching_06_06_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //학생수
		int[] arr = new int[n]; //학생들의 키
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();

		int[] arrSort = arr.clone();
		Arrays.sort(arrSort);
		int a=0, b=0;
		for(int i=0; i<n; i++) {
			if(arr[i] != arrSort[i]) {
				if(a == 0) a = i+1;
				else b = i+1;
			}
		}
		
		System.out.println(a + " " + b);
	}

}
