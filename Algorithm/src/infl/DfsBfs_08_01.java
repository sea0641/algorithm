package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/25
 * ����: ������ DFSBFS 08-01 ���� ���� �κ�����(DFS: �Ƹ��� ���ͺ�)
 */

public class DfsBfs_08_01 {
	static int n;
	static int[] arr;
	static int num = 0;
	static boolean flag = false;
	static String answer = "NP";
	public static void main(String[] args) {
		DfsBfs_08_01 main = new DfsBfs_08_01();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			num += arr[i];
		}
		
		if(num % 2 != 0) {
			System.out.println("NO");
			return;
		}
		num /= 2; // �� �κ������� ���� ��
		
		main.DFS(0, 0);

		System.out.println(answer);
	}
	
	public void DFS(int l, int sum) {
		if(flag) return;
		if(sum > num) return;
		if ( l == n ) {
			if(sum == num) {
				answer = "YES";
				flag = true;
			}
		} else {
			DFS(l+1, sum + arr[l]); //��� O
			DFS(l+1, sum); //��� X
		}
	}

}
