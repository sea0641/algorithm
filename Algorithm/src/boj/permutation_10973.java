package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/05/06
 * 문제: 백준 알고리즘 10973번_이전순열
 * 설명: 
 */

public class permutation_10973 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		if(prevPermutation(arr)) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("-1");
		}
		
		
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static boolean prevPermutation(int[] arr) {
		int i = arr.length-1;
		while(i > 0 && arr[i-1] <= arr[i]) i--;
		if(i<=0) return false;
		
		int j = arr.length-1;
		//나보다 다음뻔째 큰수 찾기
		while(arr[j] >= arr[i-1]) j--;
		//arr[j] < arr[i-1]

		swap(arr, i-1, j);
		j = arr.length - 1;
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		return true;
	}

}
