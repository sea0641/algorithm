package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/11/06
 * ����: ������ DFSBFS 08-01 ���� ���� �κ�����(DFS: �Ƹ��� ���ͺ�)
 */

/*
 * �� �迭�� �� ���� �κ��������� �������� �� �� �κ������� ������ ���� ���� ��찡 �����ϸ� YES, �ƴϸ� NO ��� -> ����Ʈ�� DFS 2���� ȣ��
 * �� �� �κ������� ���� �� �迭�� ���� �����̾�� �Ѵ�.
 * �� ���Ҹ� �������� �� ������ �� sum���� �������� Ȯ��
 * ������ ���ұ��� �����Ѵ�/���Ѵ� Ȯ�� �� �� �κ������� ���� ��ġ�ϴ��� Ȯ��
 */
public class DfsBfs_08_01_2nd {
	
	static int n;
	static int[] arr;
	static int halfSum;
	static boolean bExitYn = false;
	static String answer = "NO";
	
	public static void DFS(int L, int sum) {
		//�κκ������� ���� ���� ��찡 �����ϸ� �ٸ� ���̽� �� �ʿ���� ���� return
		if(bExitYn) return;
		//�� �κ������� ���� ����ġ�� �Ѿ������ �ش����̽��� �Ұ����ϹǷ� return�ϰ� �ٸ� ���̽� Ž��
		if (sum > halfSum) return;
		
		//�� �κ������� �� ������ Ȯ��
		if(L == n) {
			if( sum == halfSum) {
				answer = "YES";
				bExitYn = true;
			}
		} else {
			//arr[L]������ �� ���� �� �б�
			DFS(L+1, sum+arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //N���� ���ҷ� ����
		arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int sum = Arrays.stream(arr).sum();
		if( sum % 2 != 0) {
			System.out.println("NO");
			return;
		}
		
		halfSum = sum/2;
		DFS(0, 0);
		
		System.out.println(answer);
	}

}
