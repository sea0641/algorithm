package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/10/21
 * ����: ������ SortingSearching 06-01 ���� ����
 */

public class SortingSearching_06_01_2nd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		/*
		 * 1. ù��° ���ڸ� �������� �� ���� ���ڵ� �� ���� ���� ���ڸ� ã�´�.
		 * 2. ù��° ���ڿ� ���� ���� ���ڸ� ��ȯ�Ѵ�.
		 * 3. �ι�° ���ں��� 1~2 ������ �ݺ��Ѵ�.
		 * 4. ���� ���� ���ڵ��� �ռ������� ��������.
		 */
		int idx; //�ٲ� ���� ���� ����
		for(int i=0; i<n-1; i++) {
			idx = i;
			
			//���� ���� ���� ��ġ Ž��
			for(int j=i+1; j<n; j++) {
				if(arr[idx] > arr[j]) idx = j;
			}
			
			//SWAP
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		for(int i : arr) System.out.print(i + " ");
	}
}
