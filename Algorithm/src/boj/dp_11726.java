package boj;

import java.util.Scanner;

/*
 * ��¥: 2021/05/21
 * ����: ���� �˰��� 11726��_2xn Ÿ�ϸ�
 * ����: 
 */

public class dp_11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1001];

		dp[1] = 1;
		dp[2] = 2;
		//d[n] = d[n-1] + d[n-2]
		//���� Ÿ�Ͽ� ���ι� 1�� �߰� + �δܰ� ���� Ÿ�Ͽ� ���ι� 2�� �߰�
		for( int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}

}
