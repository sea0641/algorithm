package infl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 날짜: 2021/08/11
 * 문제: 인프런 SortingSearching 06-05 중복 확인
 */

public class SortingSearching_06_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}
		
		System.out.println(n == set.size() ? "U" : "D");
		
		/* 정렬 후 연속된 같은 숫자 확인
		String answer = "U";
		Arrays.sort(arr);
		for(int i=0; i<n-1; i++) {
			if(arr[i] == arr[i+1]) {
				answer="D";
				break;
			}
		}
		
		System.out.println(answer);
		*/
	}

}
