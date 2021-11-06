package infl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * ��¥: 2021/11/06
 * ����: ������ DFSBFS 08-02 �ٵ��� ����(DFS)
 */

/*
 * Ʈ���� Cų�α׷� �Ѱ� �¿� �� ����. �ٵ��� N���� �� ���� ���̰� �¿� �� ���Դ�?
 * �� �迭�� �κ����� DFS
 * �ٵ��� ���� �������� ��, C�� �ȳѴ� ���� ���� �� max ��ü
 */
public class DfsBfs_08_02_2nd {
	static int C,N;
	static Integer[] arr;
	static int answer = 0;
	
	static void DFS(int L, int sum) {
		//C ���� ������ �Ұ��� ���̽� return;
		if( sum > C) return;
		
		if( L == N ) {
			//C���� ���� ���� �ش� �κ����յ� �� ���� ���ſ� �� ���ϱ�
			answer = Math.max(answer, sum);
		} else {
			DFS(L+1, sum + arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt(); //Ʈ�� �ִ� ����
		N = sc.nextInt(); //�ٵ��� ������
		 arr = new Integer[N]; //�ٵ��� ���Ե�
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		DFS(0, 0);
		
		System.out.println(answer);
	}

}
