package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/09/17
 * ����: ������ ������ȹ�� 10-05 ������ȯ(���� �˰���)
 */

public class Dynamic_10_05 {
	static int n,m;
	static int[] dy;
	
	public static int solution(int[] coin) {
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=m; j++) {
				dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
			}
		}
		return dy[m];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		m = sc.nextInt();
		dy = new int[m+1];
		System.out.print(solution(arr));
	}

}
