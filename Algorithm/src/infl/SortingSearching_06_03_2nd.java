package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/10/21
 * ����: ������ SortingSearching 06-03 ���� ����
 */

public class SortingSearching_06_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		/*
		 * 1. �ι�° ���ں��� ���� ���ڵ��� ������ ������ �����Ѵ�.
		 * 2. �ٷ� �������ں��� ù��° ���ڱ��� Ȯ���Ѵ�. �̶� �ٷ� ���� ���ڵ��� ���ĵǾ� �ִ� �����̴�.
		 * 3. ������ ���ڸ� ����س��� ������ ��ġ���� ���ڸ� �ڷ� �̷��.
		 * 4. ������ �ڸ��� ����س� ���ڸ� �Է��� ���ĵ� ���¸� �����.
		 */
		for(int i=1; i<n; i++) {
			int tmp = arr[i];
			
			int j;
			for(j=i-1; j>=0; j--) {
				if(tmp < arr[j]) arr[j+1] = arr[j]; //�ڷ� �̷��
				else break; //�̹� �� ���� ���ĵǾ� �����Ƿ� �� ���ʿ� X
			}
			
			//������ �ڸ��� ����
			arr[j+1] = tmp;
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
