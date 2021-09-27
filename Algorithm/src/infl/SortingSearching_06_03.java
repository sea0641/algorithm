package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/10
 * ����: ������ SortingSearching 06-03 ���� ����
 */

public class SortingSearching_06_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//Arrays.sort(arr);
		for(int i=1; i<n; i++) {
			int tmp = arr[i];
			int j;
			for(j=i-1; j>=0; j--) {
				if(arr[j] > tmp) arr[j+1] = arr[j];
				else break;
			}
			
			arr[j+1] = tmp;
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
