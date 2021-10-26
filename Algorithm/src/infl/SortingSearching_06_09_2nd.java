package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/10/25
 * ����: ������ SortingSearching 06-09 ��������(�����˰���)
 */

public class SortingSearching_06_09_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //�� ���� ��
		int m = sc.nextInt(); //������ ���� DVD ��
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		//�̺�Ž��, DVD ���忡 ���� �� �ִ� �ּ� ũ�� ���ϱ�. �ּ�:�迭�� ���� ū��, �ִ�:�迭�� ��
		int answer = 0;
		while(lt <= rt) {
			int mid = (lt+rt)/2; //DVD ���忡 ���� �뷮
			//mid �뷮���� ����� �� ���� ������ �ִٸ� ���� �뷮 ����ϰ� �뷮 ���̱�
			if(count(arr, mid) <= m) {
				answer = mid;
				rt = mid-1;
			}
			//mid �뷮���� ����� �� DVD ����� m���� ũ�ٸ� �뷮 �ø���
			else lt = mid+1;
		}
		
		System.out.println(answer);
	}
	
	public static int count(int[] arr, int capacity) {
		int cnt=1; //DVD ���
		int sum=0; //DVD�� ���� �� ������ ��
		
		for(int x : arr) {
			//����DVD�� �뷮�� �ʰ��Ѵٸ� ���� DVD�忡 ��´�.
			if( sum+x > capacity ) {
				cnt++;
				sum = x;
			} else sum += x; //���� DVD�� �� ���� ���ϱ�
		}
		
		return cnt;
	}

}
