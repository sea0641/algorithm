package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/10/21
 * ����: ������ SortingSearching 06-06 �峭�ٷ���
 */

public class SortingSearching_06_06_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //�л���
		int[] arr = new int[n]; //�л����� Ű
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();

		int[] arrSort = arr.clone();
		Arrays.sort(arrSort);
		int a=0, b=0;
		for(int i=0; i<n; i++) {
			if(arr[i] != arrSort[i]) {
				if(a == 0) a = i+1;
				else b = i+1;
			}
		}
		
		System.out.println(a + " " + b);
	}

}
