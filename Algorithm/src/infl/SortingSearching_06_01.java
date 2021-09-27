package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/08/10
 * ����: ������ SortingSearching 06-01 ���� ����
 */

public class SortingSearching_06_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//Arrays.sort(arr);
		int idx;
		for(int i=0; i<n-1; i++) {
			//�� ������ ���� ���� ���� ������ �ε����� ���� ��ȯ�Ѵ�. ���� ���� ���ڰ� �� �տ� �´�.
			idx = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[idx]) idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
