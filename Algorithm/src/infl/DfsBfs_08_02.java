package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/29
 * ����: ������ DFSBFS 08-02 �ٵ��� ����(DFS)
 */

public class DfsBfs_08_02 {
	static int C;
	static int N;
	static int w;
	static int[] arr;
	
	public static void DFS(int L, int sum) {
		if(sum > C ) return;
		
		if(L == N) w = Math.max(w, sum);
		else {
			DFS(L+1, sum + arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt(); //Ʈ���� �ִ� ų�α׷�
		N = sc.nextInt(); // �ٵ��� ��
		arr = new int[N]; // �ٵ��� ����
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		DFS(0, 0);
		
		System.out.println(w);
	}

}
