package infl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * ��¥: 2021/10/21
 * ����: ������ SortingSearching 06-05 �ߺ� Ȯ��
 */

public class SortingSearching_06_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //�л��� ��
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) set.add(sc.nextInt());
		
		if(set.size() == n) System.out.println("U");
		else System.out.println("D");
	}

}
