package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/10/26
 * ����: ������ SortingSearching 06-10 ������ ���ϱ�(�����˰���)
 */

public class SortingSearching_06_10_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //������ ����
		int c = sc.nextInt(); //���� ��
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt(); //������ ��ǥ
		Arrays.sort(arr);

		int answer = 0;

		int lt = 1, rt=arr[n-1]-arr[0];
		while(lt <= rt) {
			int mid = (lt + rt)/2;
			//mid�������� ���� ��ġ���� �� ��� ��ġ�� �� �ִ��� ��
			//���� ���� ����ϴٸ� ������ �� �÷�����
			if(count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			} else rt = mid -1;
		}
		
		System.out.println(answer);
	}
	
	public static int count(int[] arr, int dist) {
		int cnt = 1; //���� ��
		int cur = arr[0]; //���� ���� ��ġ
		
		for( int i=1; i<arr.length; i++ ) {
			if(arr[i] >= (cur + dist)) {
				cnt++;
				cur = arr[i];
			}
		}
		
		return cnt;
	}

}
