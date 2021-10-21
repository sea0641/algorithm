package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/10/21
 * ����: ������ SortingSearching 06-02 ���� ����
 */

public class SortingSearching_06_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		/*
		 * 1. ù��° ���ڿ� �״ٿ���ڸ� ���� ���� ���� �� ũ�� SWAP�Ѵ�.
		 * 2. ������ ��ġ�� �� ���ڸ� ���� �� ����Ŭ�� ����.
		 * 3. �ι�° ����Ŭ�� �����ϰ� �����ϳ� �̹� ���� ū ���ڰ� �ڷ� �з��������Ƿ� ���������� �����Ѵ�.
		 * 4. ���ӵ� �� ���� ���ϸ� ū ���� �з����� �����̴�.
		 */
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				//���� ���ڰ� �� ũ�ٸ� SWAP
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(int i : arr) System.out.print(i + " ");
	}

}
