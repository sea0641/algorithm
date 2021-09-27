package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-09 격자판 최대합
 */

public class Array_02_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int max = Integer.MIN_VALUE;
		int rowSum, colSum;
		for(int i=0; i<n; i++) {
			rowSum = 0;
			colSum = 0;
			for(int j=0; j<n; j++) {
				rowSum += arr[i][j];
				colSum += arr[j][i];
			}
			
			max = Math.max(max, rowSum > colSum ? rowSum : colSum);
		}
		
		int diagSum1 = 0, diagSum2 = 0;
		for(int i=0; i<n; i++) {
			diagSum1 += arr[i][i];
			diagSum2 += arr[i][n-1-i];
		}
		max = Math.max(max, diagSum1 > diagSum2 ? diagSum1 : diagSum2);
		
		System.out.println(max);
	}

}
