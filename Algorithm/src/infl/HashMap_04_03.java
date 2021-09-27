package infl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 날짜: 2021/08/08
 * 문제: 인프런 HashMap 04-03 매출액의 종류
 */

public class HashMap_04_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<n-k+1; i++) {
			if(i == 0) {
				for(int j=0; j<k; j++) {
					map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
				}
			} else {
				if(map.get(arr[i-1]) > 1) {
					map.put(arr[i-1], map.get(arr[i-1]) - 1);
				} else if(map.get(arr[i-1]) == 1) {
					map.remove(arr[i-1]);
				}
				map.put(arr[i+k-1], map.getOrDefault(arr[i+k-1], 0) + 1);
			}
			System.out.print(map.size() + " ");
		}
		
		/* two pointers 사용
		for(int i=0; i<k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int lt = 0;
		for(int rt=k-1; rt<n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			System.out.print(map.size() + " ");
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
			lt++;
		}
		*/
	}

}
