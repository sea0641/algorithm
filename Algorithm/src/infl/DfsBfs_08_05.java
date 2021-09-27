package infl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * ��¥: 2021/08/29
 * ����: ������ DFSBFS 08-05 ������ȯ
 */

public class DfsBfs_08_05 {
	static int n;
	static Integer[] arr;
	static int m;
	static int answer = Integer.MAX_VALUE;
	
	static void DFS(int L, int sum) {
		if(sum > m) return;
		if(L >= answer) return; //�̹� �ּҰ��� �Ѿ�� ���̻� �� �ʿ� ����
		if(sum == m) answer = Math.min(answer, L);
		else {
			for(int i=0; i<n; i++) {
				DFS(L+1, sum + arr[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new Integer[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		m = sc.nextInt();
		Arrays.sort(arr, Collections.reverseOrder());
		
		DFS(0, 0);
		System.out.println(answer);
	}

}
