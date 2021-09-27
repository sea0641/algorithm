package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/08/11
 * 문제: 인프런 SortingSearching 06-08 이분검색
 */

public class SortingSearching_06_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		/*
		int answer = Arrays.asList(arr).indexOf((Integer)m);
		System.out.println(answer+1);
		*/
		//이분검색 사용
		int answer = 0;
		int lt=0, rt=n-1;
		while(lt <= rt) {
			int mid = (lt+rt)/2;
			if(arr[mid] == m) {
				answer = mid+1;
				break;
			}
			if(arr[mid] > m) rt = mid-1;
			else lt = mid+1;
		}
		
		System.out.println(answer);
	}

}
