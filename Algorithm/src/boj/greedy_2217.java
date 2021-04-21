package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * ��¥: 2021/04/21
 * ����: ���� �˰��� 2217��_����
 * ����: �׸���
 */

public class greedy_2217 {
	static int n; //������ ����
	static int[] rope; //�� ������ �� �� �ִ� ���� �迭
	static int w = 0; //�ִ��߷�
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		rope = new int[n];
		
		for(int i=0; i<n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		
		int tmpW;
		for(int i=0; i<n; i++) {
			tmpW = rope[i] * (n-i);
			if( w < tmpW )
				w = tmpW;
		}

		System.out.println(w);
		
	}

}
