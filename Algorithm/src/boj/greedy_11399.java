package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/04/22
 * ����: ���� �˰��� 11399��_ATM
 * ����: �׸���
 */

public class greedy_11399 {
	static int n; //����� ��
	static int[] pTime; //�� ����� ���� �����ϴµ� �ɸ��� �ð� �迭
	static long totTime = 0; //�� �ҿ�ð�
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		pTime = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i=0; i<n; i++ ) {
			pTime[i] = Integer.parseInt(st.nextToken());
		}
		
		//�ð��� ���԰ɸ��°� �տ� �;��Ѵ�.
		Arrays.sort(pTime);
		
		for(int i=n; i>0; i--) {
			totTime = totTime + pTime[n-i] * i;
		}
		
		System.out.println(totTime);
		
	}

}
