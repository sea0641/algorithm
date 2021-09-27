package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/05
 * ����: ������ Array 02-12 ���丵
 */

public class Array_02_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //�л� �� 
		int m = sc.nextInt(); //�׽�Ʈ ����
		int[][] arr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		//���� ��ȣ
		for(int i=1; i<=n; i++) {
			//��Ƽ ��ȣ
			for(int j=1; j<=n; j++) {
				int cnt = 0;
				//��� �׽�Ʈ Ȯ��
				for(int k=0; k<m; k++) {
					int pi=0, pj=0;
					//��� Ȯ��, ��
					for(int s=0; s<n; s++) {
						if(arr[k][s] == i) pi = s;
						if(arr[k][s] == j) pj = s;
					}
					
					if(pi<pj) cnt++;
				}
				
				if(cnt == m) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
