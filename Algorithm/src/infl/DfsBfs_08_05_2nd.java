package infl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * ��¥: 2021/11/06
 * ����: ������ DFSBFS 08-05 ������ȯ
 */

public class DfsBfs_08_05_2nd {
	
	static int N,M;
	static Integer[] arr;
	static int answer = Integer.MAX_VALUE;
	
	static void DFS(int L, int sum) {
		
		if (sum > M) return;
		//�ð��ʰ� ����, �̹� �ּ� ������ �Ѿ�� �� �ʿ� ����.
		if( L > answer ) return;
		
		if ( sum == M ) {
			answer = Math.min(L, answer);
		} else {
			for(int i : arr) {
				DFS(L+1, sum + i);
			}
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //���� ���� ����
		arr = new Integer[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		M = sc.nextInt(); //�Ž����� �ݾ�
		
		//�ð��ʰ����� �������� ���� ����
		Arrays.sort(arr, Collections.reverseOrder());
		DFS(0, 0);
		
		System.out.println(answer);
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

}
