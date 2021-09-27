package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/05/11
 * ����: ���� �˰��� 14888��_������ �����ֱ�
 * ����: https://st-lab.tistory.com/121
 */

public class permutation_14888 {
	static int n;
	static int[] arrNum;
	static int[] operator = new int[4]; //������(+, -, *, /)
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = stoi(br.readLine());
		arrNum = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrNum[i] = stoi(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = stoi(st.nextToken());
		}
		
		dfs(arrNum[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int num, int idx) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			// ������ ������ 1�� �̻��� ���
			if (operator[i] > 0) {
 
				// �ش� �����ڸ� 1 ���ҽ�Ų��.
				operator[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + arrNum[idx], idx + 1);	break;
				case 1:	dfs(num - arrNum[idx], idx + 1);	break;
				case 2:	dfs(num * arrNum[idx], idx + 1);	break;
				case 3:	dfs(num / arrNum[idx], idx + 1);	break;
 
				}
				// ���ȣ���� ����Ǹ� �ٽ� �ش� ������ ������ �����Ѵ�.
				operator[i]++;
			}
		}
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
