package infl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/08/10
 * 문제: 인프런 SortingSearching 06-04 Least Recently Used
 */

public class SortingSearching_06_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		List<Integer> cash = new ArrayList<Integer>();
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			
			if(cash.contains(tmp)) {
				cash.remove((Integer)tmp);
			} else {
				if(cash.size() >= s) {
					cash.remove(cash.get(cash.size()-1));
				}
			}
			
			cash.add(0, tmp);
		}
		
		for(int i : cash) {
			System.out.print(i + " ");
		}
		
		/* List사용 X, Array로 구현
		Integer[] cache = new Integer[s];
		int[] work = new int[n];
		for(int i=0; i<n; i++) {
			work[i] = sc.nextInt();
		}
		
		for(int w : work) {
			int pos = Arrays.asList(cache).indexOf((Integer)w);
					
			//Cache Miss
			if(pos == -1) {
				//한칸씩 뒤로 미루기
				for(int i=s-1; i>=1; i--) {
					cache[i] = cache[i-1];
				}
			}
			//Cache Hit
			else {
				for(int i=pos; i>=1; i--) {
					cache[i] = cache[i-1];
				}
			}
			
			cache[0] = w;
		}
		
		for(int i : cache) {
			System.out.print(i + " ");
		}
		*/
	}

}
