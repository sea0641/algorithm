package infl;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * 날짜: 2021/10/11
 * 문제: 인프런 HashMap 04-05 K번째 큰 수
 */

public class HashMap_04_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //카드의 개수
		int k = sc.nextInt(); //뽑을 개수
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder()); //k개 카드의 합, 내림차순
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int m=j+1; m<n; m++) {
					set.add(arr[i] + arr[j] + arr[m]);
				}
			}
		}
		
		int cnt = 0;
		for(int i : set) {
			cnt++;
			if(cnt == k) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
