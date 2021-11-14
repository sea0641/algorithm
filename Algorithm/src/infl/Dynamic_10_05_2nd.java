package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/11/12
 * ����: ������ ������ȹ�� 10-05 ������ȯ(���� �˰���)
 */

public class Dynamic_10_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //������ ���� ����
		int[] coin = new int[N];
		for(int i=0; i<N; i++) coin[i] = sc.nextInt();
		int m = sc.nextInt();
		
		//dy[i] : i�ݾ��� ����µ� �ּ� ���� ����
		//�� �������� ����� �ִ� ������ ������Ʈ�ϸ� �ּҰ����� ã�´�.
 		int[] dy = new int[m+1];
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for(int i=0; i<N; i++) {
			for(int j=coin[i]; j<=m; j++) {
				dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
			}
		}
		
		System.out.println(dy[m]);
	}

}
