package infl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/10/21
 * 문제: 인프런 SortingSearching 06-04 Least Recently Used
 */

public class SortingSearching_06_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //캐시의 크기
		int n = sc.nextInt(); //작업의 개수
		List<Integer> cache = new ArrayList<Integer>();
		
		Integer work;
		for(int i=0; i<n; i++) {
			work = sc.nextInt();
			
			//Cache Hit
			if(cache.contains(work))
				cache.remove(work);

			//가장 최근에 작업한 것
			cache.add(0, work);
			
			//캐시 사이즈 넘으면 뒤에 짜르기
			int size = cache.size();
			if( size > s ) cache.remove(cache.get(size-1));
		}
		
		for(int i : cache) System.out.print(i + " ");

	}

}
