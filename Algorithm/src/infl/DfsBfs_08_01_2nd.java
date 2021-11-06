package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/11/06
 * 문제: 인프런 DFSBFS 08-01 합이 같은 부분집합(DFS: 아마존 인터뷰)
 */

/*
 * 한 배열을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 같은 경우가 존재하면 YES, 아니면 NO 출력 -> 이진트리 DFS 2갈래 호출
 * 각 두 부분집합의 합은 한 배열의 합의 절반이어야 한다.
 * 각 원소를 포함했을 때 안했을 때 sum으로 구분지어 확인
 * 마지막 원소까지 포함한다/안한다 확인 후 각 부분집합의 합이 일치하는지 확인
 */
public class DfsBfs_08_01_2nd {
	
	static int n;
	static int[] arr;
	static int halfSum;
	static boolean bExitYn = false;
	static String answer = "NO";
	
	public static void DFS(int L, int sum) {
		//두부분집합의 합이 같은 경우가 존재하면 다른 케이스 볼 필요없이 전부 return
		if(bExitYn) return;
		//한 부분집합의 합이 기준치를 넘어버리면 해당케이스는 불가능하므로 return하고 다른 케이스 탐색
		if (sum > halfSum) return;
		
		//두 부분집합의 합 같은지 확인
		if(L == n) {
			if( sum == halfSum) {
				answer = "YES";
				bExitYn = true;
			}
		} else {
			//arr[L]포함할 때 안할 때 분기
			DFS(L+1, sum+arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //N개의 원소로 구성
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
