package infl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 날짜: 2021/10/21
 * 문제: 인프런 SortingSearching 06-05 중복 확인
 */

public class SortingSearching_06_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //학생들 수
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) set.add(sc.nextInt());
		
		if(set.size() == n) System.out.println("U");
		else System.out.println("D");
	}

}
