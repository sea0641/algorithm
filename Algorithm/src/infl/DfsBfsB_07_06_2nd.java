package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/03
 * ����: ������ DFSBFS���� 07-06 �κ����� ���ϱ�(DFS)
 */

/*
 * �ڿ��� N�� �κ������� ���� ����Ͻÿ�.(������ ����)
 * 1) 1���� ����Ѵ� ���Ѵ� �϶� �ΰ����� DFS �������
 * 2) ��������: n�� �Ѿ�� ����, ����ϴ� �͵鸸 ���� ����ϱ�
 */

public class DfsBfsB_07_06_2nd {
	static int n;
	static boolean[] arrUse;
			
	public static void DFS(int L) {
		if( L == n+1 ) {
			StringBuffer sb = new StringBuffer();
			for(int i=1; i<=n; i++) {
				if(arrUse[i]) sb.append(i).append(" ");
			}
			//������ ��� X -> ��� ���� ������� �ʴ´�.
			if(sb.length() > 0) System.out.println(sb.toString());
		} else {
			//����Ѵ�
			arrUse[L] = true;
			DFS(L+1);
			//������� �ʴ´�.
			arrUse[L] = false;
			DFS(L+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arrUse = new boolean[n+1];
		
		DFS(1);
	}

}
