package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/10/26
 * 문제: 인프런 SortingSearching 06-10 마구간 정하기(결정알고리즘)
 */

public class SortingSearching_06_10_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //마구간 개수
		int c = sc.nextInt(); //말의 수
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt(); //마구간 좌표
		Arrays.sort(arr);

		int answer = 0;

		int lt = 1, rt=arr[n-1]-arr[0];
		while(lt <= rt) {
			int mid = (lt + rt)/2;
			//mid간격으로 말을 배치했을 때 몇마리 배치할 수 있는지 비교
			//말의 수가 충분하다면 간격을 더 늘려보기
			if(count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			} else rt = mid -1;
		}
		
		System.out.println(answer);
	}
	
	public static int count(int[] arr, int dist) {
		int cnt = 1; //말의 수
		int cur = arr[0]; //말의 현재 위치
		
		for( int i=1; i<arr.length; i++ ) {
			if(arr[i] >= (cur + dist)) {
				cnt++;
				cur = arr[i];
			}
		}
		
		return cnt;
	}

}
