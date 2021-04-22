package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/22
 * ����: ���� �˰��� 11047��_���� 0
 * ����: �׸���
 */

public class greedy_11047 {
	static int n; //���� ����
	static int k; //�ʿ� �ݾ�
	static int[] coins; //���� ��ġ �迭
	static int minCoin = 0; //�ʿ��� �ּ� ���� ��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=n-1; i>=0; i--) {
			if(coins[i] <= k) {
				minCoin += k/coins[i];
				k = k%coins[i];
			} else if(k == 0) {
				break;
			}
		}
		
		System.out.println(minCoin);
	}

}
