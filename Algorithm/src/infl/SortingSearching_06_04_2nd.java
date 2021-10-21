package infl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/10/21
 * ����: ������ SortingSearching 06-04 Least Recently Used
 */

public class SortingSearching_06_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //ĳ���� ũ��
		int n = sc.nextInt(); //�۾��� ����
		List<Integer> cache = new ArrayList<Integer>();
		
		Integer work;
		for(int i=0; i<n; i++) {
			work = sc.nextInt();
			
			//Cache Hit
			if(cache.contains(work))
				cache.remove(work);

			//���� �ֱٿ� �۾��� ��
			cache.add(0, work);
			
			//ĳ�� ������ ������ �ڿ� ¥����
			int size = cache.size();
			if( size > s ) cache.remove(cache.get(size-1));
		}
		
		for(int i : cache) System.out.print(i + " ");

	}

}
