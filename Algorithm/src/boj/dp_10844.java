package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
 * ��¥: 2021/05/21
 * ����: ���� �˰��� 10844��_���� ��� ��
 * ����: https://st-lab.tistory.com/134
 */	
 
public class dp_10844 {
	
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N + 1][10];
		
		// ù ��° �ڸ����� ������ �� ���� �ڸ����̹Ƿ� ����� ���� 1���ۿ� ���� 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
		
		// �� ��° �ڸ������� N���� Ž�� 
		for(int i = 2; i <= N; i++) {
			
			// i��° �ڸ����� �ڸ������� Ž�� (0~9) 
			for(int j = 0; j < 10; j++) {
				
				// j=0, �� �ڸ����� 0�̶�� ���� �ڸ����� ù��° �ڸ����� ���� 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// j=9��� ���� �ڸ����� 8�� ����
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// �� ���� ��� ���� �ڸ����� �ڸ��� +1, -1 �� ���� �� 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long result = 0;
		
		// �� �ڸ��������� ����� ���� ��� �����ش�. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
	}
 
}