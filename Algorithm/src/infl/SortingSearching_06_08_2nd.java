package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/10/25
 * 문제: 인프런 SortingSearching 06-08 이분검색
 */

public class SortingSearching_06_08_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); //찾을 숫자
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int lt=0, rt=n-1;
		int mid = 0;
		while(lt <= rt) {
			mid = (lt+rt)/2;
			if(m < arr[mid]) rt = mid-1;
			else if(m > arr[mid]) lt = mid+1;
			else break;
		}
		
		System.out.println(mid+1);
	}

}
