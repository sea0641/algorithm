package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/11/12
 * 문제: 인프런 동적계획법 10-05 동전교환(냅색 알고리즘)
 */

public class Dynamic_10_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //동전의 종류 개수
		int[] coin = new int[N];
		for(int i=0; i<N; i++) coin[i] = sc.nextInt();
		int m = sc.nextInt();
		
		//dy[i] : i금액을 만드는데 최소 동전 개수
		//각 동전별로 만들수 있는 개수를 업데이트하며 최소개수를 찾는다.
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
